package co.edu.uniquindio.universidad;

import java.util.ArrayList;
import java.util.List;

public class Sede {
    String codigo;
    String nombre;
    String direccion;
    List<Equipo> equipos;

    public Sede(String codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.equipos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo e) {
        equipos.add(e);
    }

    public String getCodigo() { return codigo; }
    public List<Equipo> getEquipos() { return equipos; }
}

