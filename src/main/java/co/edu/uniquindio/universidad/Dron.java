package co.edu.uniquindio.universidad;

public class Dron extends Equipo {
    private int autonomiaVuelo;
    private boolean bateriaExtra;

    public Dron(String codigo, String marca, String modelo, CondicionEquipo condicion, int autonomiaVuelo, boolean bateriaExtra) {
        super(codigo, marca, modelo, condicion);
        this.autonomiaVuelo = autonomiaVuelo;
        this.bateriaExtra = bateriaExtra;
    }

    @Override
    public double calcularCosto(int horas) {
        double costo = horas * 18000;
        if (bateriaExtra) costo += 20000;
        return costo;
    }
}
