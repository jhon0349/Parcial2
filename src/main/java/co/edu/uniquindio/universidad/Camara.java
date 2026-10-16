package co.edu.uniquindio.universidad;
public class Camara extends Equipo {
    private String resolucion;
    private boolean estabilizador;

    public Camara(String codigo, String marca, String modelo, CondicionEquipo condicion, String resolucion, boolean estabilizador) {
        super(codigo, marca, modelo, condicion);
        this.resolucion = resolucion;
        this.estabilizador = estabilizador;
    }

    @Override
    public double calcularCosto(int horas) {
        double costo = horas * 12000;
        if (estabilizador) costo += 15000;
        return costo;
    }
}