package co.edu.uniquindio.universidad;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        PixelRent sistema = new PixelRent();
        int opcion = -1;

        do {
            try {
                String menu = "=== MENU PIXELRENT ===\n"
                        + "1. Registrar cliente\n"
                        + "2. Registrar operador\n"
                        + "3. Registrar equipo\n"
                        + "4. Registrar reserva\n"
                        + "5. Agregar equipo a reserva\n"
                        + "6. Asignar operador a reserva\n"
                        + "7. Confirmar reserva\n"
                        + "8. Consultar equipos disponibles\n"
                        + "9. Consultar reservas por cliente\n"
                        + "10. Consultar valor de reserva\n"
                        + "11. Registrar sede\n"
                        + "12. Asignar equipo a sede\n"
                        + "0. Salir\n";
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcion) {
                    case 1:
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String id = JOptionPane.showInputDialog("Identificación:");
                        String tel = JOptionPane.showInputDialog("Teléfono:");
                        String correo = JOptionPane.showInputDialog("Correo:");
                        JOptionPane.showMessageDialog(null,
                                sistema.registrarCliente(new Cliente(nombre, id, tel, correo)) ?
                                        "Cliente registrado" : "Ya existe un cliente con ese ID");
                        break;






    }
}