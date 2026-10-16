package co.edu.uniquindio.universidad;

public class KitIluminacion extends Equipo {
    private int cantidadLuces;
    private boolean controlInalambrico;

    public KitIluminacion(String codigo, String marca, String modelo, CondicionEquipo condicion, int cantidadLuces, boolean controlInalambrico) {
        super(codigo, marca, modelo, condicion);
        this.cantidadLuces = cantidadLuces;
        this.controlInalambrico = controlInalambrico;
    }

    @Override
    public double calcularCosto(int horas) {
        double costo = horas * 10000;
        if (controlInalambrico) costo += 12000;
        return costo;
    }
}