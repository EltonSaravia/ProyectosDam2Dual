import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import Implementacion_DAOS.ClienteDAO;
import Implementacion_DAOS.DepartamentoDAO;
import Implementacion_DAOS.EmpleadoDAO;
import Implementacion_DAOS.ProyectoDAO;
import tablas.Cliente;
import tablas.Departamento;
import tablas.Empleado;
import tablas.Proyecto;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hola, Muchachos!");
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

        /*
         * Crea instancias de EmpleadoDAO, ClienteDAO y ProyectoDAO de manera igual
         * para cada Implementacion daos
         */

        ClienteDAO clienteDAO = new ClienteDAO(cn);
        ProyectoDAO proyectoDAO = new ProyectoDAO(cn);
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(cn);

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
                    /*
                     * inicio la conexion con la tabla departamento mediante la implementacion DAO
                     */
                    DepartamentoDAO departamentoDAO = new DepartamentoDAO(cn);
                    // menu para la opcion 1 CRUD departamento
                    System.out.println("1. Crear Departamento");
                    System.out.println("2. Leer Departamento");
                    System.out.println("3. Actualizar Departamento");
                    System.out.println("4. Borrar Departamento");
                    System.out.println("5. Listar Departamentos");
                    System.out.println("6. Volver al menú principal");

                    /* nuevo switch para seleccionar una opcion del CRUD */
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

                    System.out.println("CRUD Empleado:");
                    System.out.println("1. Crear Empleado");
                    System.out.println("2. Leer Empleado");
                    System.out.println("3. Actualizar Empleado");
                    System.out.println("4. Borrar Empleado");
                    System.out.println("5. Listar Empleados");
                    System.out.println("6. Volver al menú principal");

                    int opcionEmpleado = scanner.nextInt();
                    switch (opcionEmpleado) {
                        case 1:
                            // Crear Empleado
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();
                            System.out.print("Apellidos: ");
                            String apellidos = scanner.next();
                            System.out.print("DNI: ");
                            String dni = scanner.next();
                            System.out.print("Salario: ");
                            double salario = scanner.nextDouble();
                            System.out.print("ID Departamento: ");
                            int idDepartamento = scanner.nextInt();

                            Empleado nuevoEmpleado = new Empleado(0, nombre, apellidos, dni, salario, idDepartamento);
                            boolean creado = empleadoDAO.createRecord(nuevoEmpleado);

                            if (creado) {
                                System.out.println("Empleado creado con éxito.");
                            } else {
                                System.out.println("Error al crear el empleado.");
                            }
                            break;
                        case 2:
                            // Leer Empleado
                            System.out.print("ID del Empleado a leer: ");
                            int idEmpleadoLeer = scanner.nextInt();
                            Empleado empleadoLeido = empleadoDAO.readRecord(idEmpleadoLeer);

                            if (empleadoLeido != null) {
                                System.out.println("Empleado leído: " + empleadoLeido.toString());
                            } else {
                                System.out.println("Empleado no encontrado.");
                            }
                            break;
                        case 3:
                            // Actualizar Empleado
                            System.out.print("ID del Empleado a actualizar: ");
                            int idEmpleadoActualizar = scanner.nextInt();
                            Empleado empleadoActualizar = empleadoDAO.readRecord(idEmpleadoActualizar);

                            if (empleadoActualizar != null) {
                                System.out.print("Nuevo nombre: ");
                                String nuevoNombre = scanner.next();
                                System.out.print("Nuevos apellidos: ");
                                String nuevosApellidos = scanner.next();
                                System.out.print("Nuevo DNI: ");
                                String nuevoDNI = scanner.next();
                                System.out.print("Nuevo salario: ");
                                double nuevoSalario = scanner.nextDouble();
                                System.out.print("Nuevo ID Departamento: ");
                                int nuevoIdDepartamento = scanner.nextInt();

                                empleadoActualizar.setNombre(nuevoNombre);
                                empleadoActualizar.setApellidos(nuevosApellidos);
                                empleadoActualizar.setDNI(nuevoDNI);
                                empleadoActualizar.setSalario(nuevoSalario);
                                empleadoActualizar.setIdDepartamento(nuevoIdDepartamento);

                                boolean actualizado = empleadoDAO.updateRecord(empleadoActualizar,
                                        idEmpleadoActualizar);

                                if (actualizado) {
                                    System.out.println("Empleado actualizado con éxito.");
                                } else {
                                    System.out.println("Error al actualizar el empleado.");
                                }
                            } else {
                                System.out.println("Empleado no encontrado.");
                            }
                            break;
                        case 4:
                            // Borrar Empleado
                            System.out.print("ID del Empleado a borrar: ");
                            int idEmpleadoBorrar = scanner.nextInt();
                            boolean borrado = empleadoDAO.deleteRecord(idEmpleadoBorrar);

                            if (borrado) {
                                System.out.println("Empleado eliminado con éxito.");
                            } else {
                                System.out.println("Error al eliminar el empleado.");
                            }
                            break;
                        case 5:
                            // Listar Empleados
                            List<Empleado> empleados = empleadoDAO.readRecords();
                            System.out.println("Lista de Empleados:");
                            for (Empleado empleado : empleados) {
                                System.out.println(empleado.toString());
                            }
                            break;
                        case 6:
                            // Volver al menú principal
                            break;
                    }
                    break;

                case 3:
                    // Opciones para CRUD Cliente
                    System.out.println("CRUD Cliente:");
                    System.out.println("1. Crear Cliente");
                    System.out.println("2. Leer Cliente");
                    System.out.println("3. Actualizar Cliente");
                    System.out.println("4. Borrar Cliente");
                    System.out.println("5. Listar Clientes");
                    System.out.println("6. Volver al menú principal");

                    int opcionCliente = scanner.nextInt();

                    switch (opcionCliente) {
                        case 1:
                            // Crear Cliente
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();
                            System.out.print("Persona de contacto: ");
                            String personaContacto = scanner.next();
                            System.out.print("Teléfono de contacto: ");
                            String tfnoContacto = scanner.next();
                            System.out.print("CIF: ");
                            String cif = scanner.next();
                            System.out.print("Ubicación: ");
                            String ubicacion = scanner.next();

                            Cliente nuevoCliente = new Cliente(0, nombre, personaContacto, tfnoContacto, cif,
                                    ubicacion);
                            boolean creado = clienteDAO.createRecord(nuevoCliente);

                            if (creado) {
                                System.out.println("Cliente creado con éxito.");
                            } else {
                                System.out.println("Error al crear el cliente.");
                            }
                            break;
                        case 2:
                            // Leer Cliente
                            System.out.print("ID del Cliente a leer: ");
                            int idClienteLeer = scanner.nextInt();
                            Cliente clienteLeido = clienteDAO.readRecord(idClienteLeer);

                            if (clienteLeido != null) {
                                System.out.println("Cliente leído: " + clienteLeido.toString());
                            } else {
                                System.out.println("Cliente no encontrado.");
                            }
                            break;
                        case 3:
                            // Actualizar Cliente
                            System.out.print("ID del Cliente a actualizar: ");
                            int idClienteActualizar = scanner.nextInt();
                            Cliente clienteActualizar = clienteDAO.readRecord(idClienteActualizar);

                            if (clienteActualizar != null) {
                                System.out.print("Nuevo nombre: ");
                                String nuevoNombre = scanner.next();
                                System.out.print("Nueva persona de contacto: ");
                                String nuevaPersonaContacto = scanner.next();
                                System.out.print("Nuevo teléfono de contacto: ");
                                String nuevoTfnoContacto = scanner.next();
                                System.out.print("Nuevo CIF: ");
                                String nuevoCIF = scanner.next();
                                System.out.print("Nueva ubicación: ");
                                String nuevaUbicacion = scanner.next();

                                clienteActualizar.setNombre(nuevoNombre);
                                clienteActualizar.setPersonaContacto(nuevaPersonaContacto);
                                clienteActualizar.setTfnoContacto(nuevoTfnoContacto);
                                clienteActualizar.setCIF(nuevoCIF);
                                clienteActualizar.setUbicacion(nuevaUbicacion);

                                boolean actualizado = clienteDAO.updateRecord(clienteActualizar, idClienteActualizar);

                                if (actualizado) {
                                    System.out.println("Cliente actualizado con éxito.");
                                } else {
                                    System.out.println("Error al actualizar el cliente.");
                                }
                            } else {
                                System.out.println("Cliente no encontrado.");
                            }
                            break;
                        case 4:
                            // Borrar Cliente
                            System.out.print("ID del Cliente a borrar: ");
                            int idClienteBorrar = scanner.nextInt();
                            boolean borrado = clienteDAO.deleteRecord(idClienteBorrar);

                            if (borrado) {
                                System.out.println("Cliente eliminado con éxito.");
                            } else {
                                System.out.println("Error al eliminar el cliente.");
                            }
                            break;
                        case 5:
                            // Listar Clientes
                            List<Cliente> clientes = clienteDAO.readRecords();
                            System.out.println("Lista de Clientes:");
                            for (Cliente cliente : clientes) {
                                System.out.println(cliente.toString());
                            }
                            break;
                        case 6:
                            // Volver al menú principal
                            break;
                    }
                    break;

                case 4:
                    // Opciones para CRUD Proyecto
                    System.out.println("CRUD Proyecto:");
                    System.out.println("1. Crear Proyecto");
                    System.out.println("2. Leer Proyecto");
                    System.out.println("3. Actualizar Proyecto");
                    System.out.println("4. Borrar Proyecto");
                    System.out.println("5. Listar Proyectos");
                    System.out.println("6. Volver al menú principal");

                    int opcionProyecto = scanner.nextInt();

                    switch (opcionProyecto) {
                        case 1:
                            // Crear Proyecto
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();
                            System.out.print("ID Departamento: ");
                            int idDepartamento = scanner.nextInt();

                            Proyecto nuevoProyecto = new Proyecto(0, nombre, idDepartamento);
                            boolean creado = proyectoDAO.createRecord(nuevoProyecto);

                            if (creado) {
                                System.out.println("Proyecto creado con éxito.");
                            } else {
                                System.out.println("Error al crear el proyecto.");
                            }
                            break;
                        case 2:
                            // Leer Proyecto
                            System.out.print("ID del Proyecto a leer: ");
                            int idProyectoLeer = scanner.nextInt();
                            Proyecto proyectoLeido = proyectoDAO.readRecord(idProyectoLeer);

                            if (proyectoLeido != null) {
                                System.out.println("Proyecto leído: " + proyectoLeido.toString());
                            } else {
                                System.out.println("Proyecto no encontrado.");
                            }
                            break;
                        case 3:
                            // Actualizar Proyecto
                            System.out.print("ID del Proyecto a actualizar: ");
                            int idProyectoActualizar = scanner.nextInt();
                            Proyecto proyectoActualizar = proyectoDAO.readRecord(idProyectoActualizar);

                            if (proyectoActualizar != null) {
                                System.out.print("Nuevo nombre: ");
                                String nuevoNombre = scanner.next();
                                System.out.print("Nuevo ID Departamento: ");
                                int nuevoIdDepartamento = scanner.nextInt();

                                proyectoActualizar.setNombre(nuevoNombre);
                                proyectoActualizar.setIdDepartamento(nuevoIdDepartamento);

                                boolean actualizado = proyectoDAO.updateRecord(proyectoActualizar,
                                        idProyectoActualizar);

                                if (actualizado) {
                                    System.out.println("Proyecto actualizado con éxito.");
                                } else {
                                    System.out.println("Error al actualizar el proyecto.");
                                }
                            } else {
                                System.out.println("Proyecto no encontrado.");
                            }
                            break;
                        case 4:
                            // Borrar Proyecto
                            System.out.print("ID del Proyecto a borrar: ");
                            int idProyectoBorrar = scanner.nextInt();
                            boolean borrado = proyectoDAO.deleteRecord(idProyectoBorrar);

                            if (borrado) {
                                System.out.println("Proyecto eliminado con éxito.");
                            } else {
                                System.out.println("Error al eliminar el proyecto.");
                            }
                            break;
                        case 5:
                            // Listar Proyectos
                            List<Proyecto> proyectos = proyectoDAO.readRecords();
                            System.out.println("Lista de Proyectos:");
                            for (Proyecto proyecto : proyectos) {
                                System.out.println(proyecto.toString());
                            }
                            break;
                        case 6:
                            // Volver al menú principal
                            break;
                    }
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
