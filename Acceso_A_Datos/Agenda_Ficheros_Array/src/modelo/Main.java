package modelo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Agenda agendaBorrador = new Agenda();

        ObjectInputStream leer;
        ObjectOutputStream guardar;

        try {
            leer = new ObjectInputStream(new FileInputStream("Ejercicio4.dat"));
            Cliente[] listaCargada = (Cliente[]) leer.readObject();
            agendaBorrador.cargarAgenda(listaCargada);

        } catch (Exception ex) {
            System.out.println("Fichero no leído");
        }

        boolean apagar = false;
        while (!apagar) {
            System.out.print("Elige la acción que deseas realizar: \n");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Modificar datos cliente");
            System.out.println("4. Listar los clientes");
            System.out.println("5. Guardar");
            System.out.println("6. Salir");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Indica los datos del cliente");
                    System.out.println("Nombre: ");
                    String nombreInsertar = sc.next();
                    System.out.println("Teléfono: ");
                    String telefono = sc.next();
                    System.out.println("Email: ");
                    String email = sc.next();

                    agendaBorrador.anadirCliente(nombreInsertar, telefono, email);

                    break;

                case 2:
                    System.out.println("Indica el nombre del cliente que deseas eliminar");
                    String nombreEliminar = sc.next();

                    try {
                        agendaBorrador.eliminarCliente(nombreEliminar);
                    } catch (NoExisteCliente ex) {
                        System.err.println(ex.msjError());
                    }
                    break;

                case 3:
                    System.out.println("Indica el nombre del cliente que deseas modificar");
                    String nombreModif = sc.next();

                    System.out.println("Indica el nuevo nombre");
                    String nombreNuevo = sc.next();

                    try {
                        agendaBorrador.modificarCliente(nombreModif, nombreNuevo);
                    } catch (NoExisteCliente ex) {
                        System.err.println(ex.msjError());
                    }
                    break;

                case 4:
                    System.out.println("Estos son los clientes en la agenda");
                    System.out.println(agendaBorrador.toString());
                    break;

                case 5:
                    try {
                        guardar = new ObjectOutputStream(new FileOutputStream("Ejercicio4.dat"));
                        guardar.writeObject(agendaBorrador.getListaclientes());
                        guardar.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 6:
                    apagar = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
