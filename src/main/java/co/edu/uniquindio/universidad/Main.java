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

                    case 2:
                        String idOp = JOptionPane.showInputDialog("Identificación:");
                        String nombreOp = JOptionPane.showInputDialog("Nombre:");
                        String cert = JOptionPane.showInputDialog("Certificación:");
                        int exp = Integer.parseInt(JOptionPane.showInputDialog("Años de experiencia:"));
                        JOptionPane.showMessageDialog(null,
                                sistema.registrarOperador(new Operador(idOp, nombreOp, cert, exp)) ?
                                        "Operador registrado" : "Ya existe un operador con ese ID");
                        break;

                    case 3:
                        String tipo = JOptionPane.showInputDialog("Tipo de equipo (camara/dron/kit):");
                        String cod = JOptionPane.showInputDialog("Código:");
                        String marca = JOptionPane.showInputDialog("Marca:");
                        String modelo = JOptionPane.showInputDialog("Modelo:");
                        CondicionEquipo cond = CondicionEquipo.valueOf(
                                JOptionPane.showInputDialog("Condición (DISPONIBLE/MANTENIMIENTO/FUERA_SERVICIO)").toUpperCase());

                        if (tipo.equalsIgnoreCase("camara")) {
                            String res = JOptionPane.showInputDialog("Resolución:");
                            boolean est = JOptionPane.showConfirmDialog(null, "¿Tiene estabilizador?") == JOptionPane.YES_OPTION;
                            sistema.registrarEquipo(new Camara(cod, marca, modelo, cond, res, est));
                        } else if (tipo.equalsIgnoreCase("dron")) {
                            int auto = Integer.parseInt(JOptionPane.showInputDialog("Autonomía de vuelo (minutos):"));
                            boolean bat = JOptionPane.showConfirmDialog(null, "¿Tiene batería extra?") == JOptionPane.YES_OPTION;
                            sistema.registrarEquipo(new Dron(cod, marca, modelo, cond, auto, bat));
                        } else {
                            int luces = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de luces:"));
                            boolean ctrl = JOptionPane.showConfirmDialog(null, "¿Tiene control inalámbrico?") == JOptionPane.YES_OPTION;
                            sistema.registrarEquipo(new KitIluminacion(cod, marca, modelo, cond, luces, ctrl));
                        }
                        JOptionPane.showMessageDialog(null, "Equipo registrado");
                        break;

                    case 4:
                        String codRes = JOptionPane.showInputDialog("Código de reserva:");
                        String idCliente = JOptionPane.showInputDialog("ID del cliente:");
                        String fecha = JOptionPane.showInputDialog("Fecha (YYYY-MM-DD):");
                        Turno turno = Turno.valueOf(JOptionPane.showInputDialog("Turno (MAÑANA/TARDE/NOCHE)").toUpperCase());
                        Cliente cliente = sistema.buscarClientePorId(idCliente);
                        JOptionPane.showMessageDialog(null,
                                cliente != null && sistema.registrarReserva(new Reserva(codRes, cliente, fecha, turno)) ?
                                        "Reserva registrada" : "Error: cliente no encontrado o código duplicado");
                        break;

                    case 5:
                        String codResEq = JOptionPane.showInputDialog("Código de reserva:");
                        String codEq = JOptionPane.showInputDialog("Código de equipo:");
                        int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas de uso:"));
                        Reserva resEq = sistema.buscarReservaPorCodigo(codResEq);
                        Equipo eq = sistema.buscarEquipoPorCodigo(codEq);
                        JOptionPane.showMessageDialog(null,
                                resEq != null && eq != null && resEq.agregarEquipo(eq, horas) ?
                                        "Equipo agregado" : "No se pudo agregar");
                        break;

                    case 6:
                        String codResOp = JOptionPane.showInputDialog("Código de reserva:");
                        String idOpRes = JOptionPane.showInputDialog("ID del operador:");
                        Reserva resOp = sistema.buscarReservaPorCodigo(codResOp);
                        Operador op = sistema.buscarOperadorPorId(idOpRes);
                        if (resOp != null && op != null) {
                            resOp.asignarOperador(op);
                            JOptionPane.showMessageDialog(null, "Operador asignado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: reserva u operador no encontrados");
                        }
                        break;

                    case 7:
                        String codResConf = JOptionPane.showInputDialog("Código de reserva:");
                        Reserva resConf = sistema.buscarReservaPorCodigo(codResConf);
                        JOptionPane.showMessageDialog(null,
                                resConf != null && resConf.confirmar(sistema.reservas) ?
                                        "Reserva confirmada" : "No se pudo confirmar");
                        break;

                    case 8:
                        String fechaDisp = JOptionPane.showInputDialog("Fecha (YYYY-MM-DD):");
                        Turno turnoDisp = Turno.valueOf(JOptionPane.showInputDialog("Turno (MAÑANA/TARDE/NOCHE)").toUpperCase());
                        StringBuilder sb = new StringBuilder("Equipos disponibles:\n");
                        for (Equipo e : sistema.equiposDisponibles(fechaDisp, turnoDisp)) {
                            sb.append(e.getCodigo()).append(" - ").append(e.getMarca()).append(" ").append(e.getModelo()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                        break;

                    case 9:
                        String idCliRes = JOptionPane.showInputDialog("ID del cliente:");
                        StringBuilder sbRes = new StringBuilder("Reservas confirmadas:\n");
                        for (Reserva r : sistema.reservasPorCliente(idCliRes)) {
                            sbRes.append(r.getCodigo()).append(" - ").append(r.getFecha()).append(" ").append(r.getTurno()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sbRes.toString());
                        break;

                    case 10:
                        String codResVal = JOptionPane.showInputDialog("Código de reserva:");
                        double valor = sistema.valorReserva(codResVal);
                        JOptionPane.showMessageDialog(null, "Valor total: $" + valor);
                        break;

                    case 11:
                        String codSede = JOptionPane.showInputDialog("Código de sede:");
                        String nomSede = JOptionPane.showInputDialog("Nombre de sede:");
                        String dirSede = JOptionPane.showInputDialog("Dirección:");
                        JOptionPane.showMessageDialog(null,
                                sistema.registrarSede(new Sede(codSede, nomSede, dirSede)) ?
                                        "Sede registrada" : "Ya existe una sede con ese código");
                        break;

                    case 12:
                        String codSedeEq = JOptionPane.showInputDialog("Código de sede:");
                        String codEqSede = JOptionPane.showInputDialog("Código de equipo:");
                        Sede sede = sistema.buscarSedePorCodigo(codSedeEq);
                        Equipo eqSede = sistema.buscarEquipoPorCodigo(codEqSede);
                        if (sede != null && eqSede != null) {
                            sede.agregarEquipo(eqSede);
                            JOptionPane.showMessageDialog(null, "Equipo asignado a sede");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: sede o equipo no encontrados");
                        }
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida, intenta de nuevo.");
            }
        } while (opcion != 0);
    }
}






