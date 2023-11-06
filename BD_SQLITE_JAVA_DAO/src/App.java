import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import Implementacion_DAOS.DepartamentoDAO;
import tablas.Departamento;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

        DepartamentoDAO departamentoDAO = new DepartamentoDAO(cn);
        // Crea instancias de EmpleadoDAO, ClienteDAO y ProyectoDAO de manera similar

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. CRUD Departamento");
            System.out.println("2. CRUD Empleado");
            System.out.println("3. CRUD Cliente");
            System.out.println("4. CRUD Proyecto");
            System.out.println("5. Salir");

            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Aquí puedes implementar las opciones de CRUD para Departamento
                    // Ejemplo:
                    System.out.println("1. Crear Departamento");
                    System.out.println("2. Leer Departamento");
                    System.out.println("3. Actualizar Departamento");
                    System.out.println("4. Borrar Departamento");
                    System.out.println("5. Listar Departamentos");
                    System.out.println("6. Volver al menú principal");

                    int opcionDepartamento = scanner.nextInt();

                    switch (opcionDepartamento) {
                        case 1:
                            // Crear Departamento
                            System.out.print("Ingrese el nombre del departamento: ");
                            String nombre = scanner.next();
                            System.out.print("Ingrese la ubicación del departamento: ");
                            String ubicacion = scanner.next();

                            Departamento nuevoDepartamento = new Departamento(0, nombre, ubicacion);

                            if (departamentoDAO.createRecord(nuevoDepartamento)) {
                                System.out.println("Departamento creado con éxito.");
                            } else {
                                System.out.println("Error al crear el departamento.");
                            }
                            break;

                        case 2:
                            // Leer Departamento
                            System.out.print("Ingrese el ID del departamento a consultar: ");
                            int idDepartamento = scanner.nextInt();

                            Departamento departamentoConsultado = departamentoDAO.readRecord(idDepartamento);

                            if (departamentoConsultado != null) {
                                System.out.println("Departamento encontrado:");
                                System.out.println("ID: " + departamentoConsultado.getIdDepartamento());
                                System.out.println("Nombre: " + departamentoConsultado.getNombre());
                                System.out.println("Ubicación: " + departamentoConsultado.getUbicacion());
                            } else {
                                System.out.println("Departamento no encontrado.");
                            }
                            break;

                        case 3:
                            // Actualizar Departamento
                            System.out.print("Ingrese el ID del departamento a actualizar: ");
                            int idDepartamentoActualizar = scanner.nextInt();

                            Departamento departamentoExistente = departamentoDAO.readRecord(idDepartamentoActualizar);

                            if (departamentoExistente != null) {
                                System.out.print("Ingrese el nuevo nombre del departamento: ");
                                nombre = scanner.next();
                                System.out.print("Ingrese la nueva ubicación del departamento: ");
                                ubicacion = scanner.next();

                                departamentoExistente.setNombre(nombre);
                                departamentoExistente.setUbicacion(ubicacion);

                                if (departamentoDAO.updateRecord(departamentoExistente, idDepartamentoActualizar)) {
                                    System.out.println("Departamento actualizado con éxito.");
                                } else {
                                    System.out.println("Error al actualizar el departamento.");
                                }
                            } else {
                                System.out.println("Departamento no encontrado.");
                            }
                            break;

                        case 4:
                            // Borrar Departamento
                            System.out.print("Ingrese el ID del departamento a borrar: ");
                            int idDepartamentoBorrar = scanner.nextInt();

                            if (departamentoDAO.deleteRecord(idDepartamentoBorrar)) {
                                System.out.println("Departamento eliminado con éxito.");
                            } else {
                                System.out.println("Error al eliminar el departamento.");
                            }
                            break;

                        case 5:
                            // Listar Departamentos
                            List<Departamento> departamentos = departamentoDAO.readRecords();

                            if (!departamentos.isEmpty()) {
                                System.out.println("Listado de departamentos:");
                                for (Departamento dep : departamentos) {
                                    System.out.println("ID: " + dep.getIdDepartamento());
                                    System.out.println("Nombre: " + dep.getNombre());
                                    System.out.println("Ubicación: " + dep.getUbicacion());
                                    System.out.println("---------------");
                                }
                            } else {
                                System.out.println("No hay departamentos registrados.");
                            }
                            break;
                        case 6:
                            // Vuelve al menú principal
                            break;
                    }
                    break;
                case 2:
                    // Opciones para CRUD Empleado
                    break;
                case 3:
                    // Opciones para CRUD Cliente
                    break;
                case 4:
                    // Opciones para CRUD Proyecto
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 5);

        // Cierra la conexión a la base de datos al salir del programa
        cn.close();
    }
}
