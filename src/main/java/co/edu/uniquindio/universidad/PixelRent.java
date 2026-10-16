package co.edu.uniquindio.universidad;

import java.util.ArrayList;
import java.util.List;

public class PixelRent {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Operador> operadores = new ArrayList<>();
    private List<Equipo> equipos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Sede> sedes = new ArrayList<>();

    public boolean registrarSede(Sede s) {
        if (buscarSedePorCodigo(s.getCodigo()) != null) return false;
        sedes.add(s);
        return true;
    }

    public boolean registrarCliente(Cliente c) {
        if (buscarClientePorId(c.getIdentificacion()) != null) return false;
        clientes.add(c);
        return true;
    }

    public boolean registrarOperador(Operador o) {
        if (buscarOperadorPorId(o.getIdentificacion()) != null) return false;
        operadores.add(o);
        return true;
    }

    public boolean registrarEquipo(Equipo e) {
        if (buscarEquipoPorCodigo(e.getCodigo()) != null) return false;
        equipos.add(e);
        return true;
    }

    public boolean registrarReserva(Reserva r) {
        if (buscarReservaPorCodigo(r.getCodigo()) != null) return false;
        reservas.add(r);
        return true;
    }

    // Métodos de búsqueda
    public Cliente buscarClientePorId(String id) {
        return clientes.stream().filter(c -> c.getIdentificacion().equals(id)).findFirst().orElse(null);
    }

    public Operador buscarOperadorPorId(String id) {
        return operadores.stream().filter(o -> o.getIdentificacion().equals(id)).findFirst().orElse(null);
    }

    public Equipo buscarEquipoPorCodigo(String codigo) {
        return equipos.stream().filter(e -> e.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public Reserva buscarReservaPorCodigo(String codigo) {
        return reservas.stream().filter(r -> r.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public Sede buscarSedePorCodigo(String codigo) {
        return sedes.stream().filter(s -> s.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
