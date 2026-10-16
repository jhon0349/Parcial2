package co.edu.uniquindio.universidad;

public abstract class Equipo {

    protected String codigo;
    protected String marca;
    protected String modelo;
    protected CondicionEquipo condicion;

    public Equipo(String codigo, String marca, String modelo, CondicionEquipo condicion) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.condicion = condicion;
    }

    // Método abstracto: cada subclase lo implementa
    public abstract double calcularCosto(int horas);

    public boolean estaDisponible() {
        return condicion == CondicionEquipo.DISPONIBLE;
    }

    public String getCodigo() { return codigo; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
}