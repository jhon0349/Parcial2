package co.edu.uniquindio.universidad;

public class Operador {
    String identificacion;
    String nombre;
    String certificacion;
    int aniosExperiencia;

    public Operador(String identificacion, String nombre, String certificacion, int aniosExperiencia) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.certificacion = certificacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getIdentificacion() { return identificacion; }
}
