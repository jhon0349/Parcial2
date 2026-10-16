package co.edu.uniquindio.universidad;

public class Cliente {
    String nombre;
    String identificacion;
    String telefono;
    String correo;

    public Cliente(String nombre, String identificacion, String telefono, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getIdentificacion() { return identificacion; }
}

