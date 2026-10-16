package co.edu.uniquindio.universidad;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    String codigo;
    Cliente cliente;
    String fecha;
    Turno turno;
    EstadoReserva estado;
    Operador operador;
    List<Equipo> equipos;
    List<Integer> horasUso;

    public Reserva(String codigo, Cliente cliente, String fecha, Turno turno) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.turno = turno;
        this.estado = EstadoReserva.SOLICITADA;
        this.equipos = new ArrayList<>();
        this.horasUso = new ArrayList<>();
    }

    public boolean agregarEquipo(Equipo equipo, int horas) {
        if (equipo.estaDisponible() && !equipos.contains(equipo)) {
            equipos.add(equipo);
            horasUso.add(horas);
            return true;
        }
        return false;
    }

    public void asignarOperador(Operador operador) {
        this.operador = operador;
    }

    public boolean confirmar(List<Reserva> reservasExistentes) {
        if (equipos.isEmpty()) return false;
        for (Equipo e : equipos) {
            if (e instanceof Dron && operador == null) return false;
        }
        for (Reserva r : reservasExistentes) {
            if (r.estado == EstadoReserva.CONFIRMADA && r.fecha.equals(this.fecha) && r.turno == this.turno) {
                for (Equipo e : r.equipos) {
                    if (equipos.contains(e)) return false;
                }
            }
        }
        if (estado == EstadoReserva.CANCELADA || estado == EstadoReserva.FINALIZADA) return false;
        estado = EstadoReserva.CONFIRMADA;
        return true;
    }

    public double calcularValor() {
        double total = 0;
        for (int i = 0; i < equipos.size(); i++) {
            total += equipos.get(i).calcularCosto(horasUso.get(i));
        }
        return total;
    }

    public String getCodigo() { return codigo; }
    public Cliente getCliente() { return cliente; }
    public String getFecha() { return fecha; }
    public Turno getTurno() { return turno; }
    public EstadoReserva getEstado() { return estado; }
}