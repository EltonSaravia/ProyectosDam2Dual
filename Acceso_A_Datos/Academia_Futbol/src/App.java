import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        do {
            System.out.println("Menú Inicial:");
            System.out.println("1. Modificar Datos de Partidos");
            System.out.println("2. Modificar Datos del Club");
            System.out.println("3. Visualizar Datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    // Lógica para modificar datos de partidos
                    System.out.println("Implementar lógica para modificar datos de partidos.");
                    break;
                case 2:
                    // Menú CRUD para Datos del Club
                    int opcionCrud;

                    do {
                        System.out.println("Menú para Modificar Datos del Club:");
                        System.out.println("1. Jugador");
                        System.out.println("2. Directivo");
                        System.out.println("3. Equipo");
                        System.out.println("4. Entrenador");
                        System.out.println("5. Volver al Menú Inicial");
                        System.out.print("Ingrese la opción deseada: ");

                        opcionCrud = scanner.nextInt();

                        switch (opcionCrud) {
                            case 1:
                            	 gestionarCrudJugador(scanner); // esto esta mas abajo en la linea 127
                                 break;
                                
                            case 2:
                                // Lógica CRUD para Directivo
                                System.out.println("Implementar lógica CRUD para Directivo.");
                                break;
                            case 3:
                                // Lógica CRUD para Equipo
                                System.out.println("Implementar lógica CRUD para Equipo.");
                                break;
                            case 4:
                                // Lógica CRUD para Entrenador
                                System.out.println("Implementar lógica CRUD para Entrenador.");
                                break;
                            case 5:
                                System.out.println("Volviendo al Menú Inicial.");
                                break;
                            default:
                                System.out.println("Opción no válida. Intente de nuevo.");
                                break;
                        }

                    } while (opcionCrud != 5);

                    break;
                case 3:
                    // Menú para Visualizar Datos
                    int opcionVisualizar;

                    do {
                        System.out.println("Menú para Visualizar Datos:");
                        System.out.println("1. Datos de un Partido");
                        System.out.println("2. Estadísticas de Jugadores");
                        System.out.println("3. Estadísticas de un Equipo");
                        System.out.println("4. Estadísticas de un Entrenador");
                        System.out.println("5. Volver al Menú Inicial");
                        System.out.print("Ingrese la opción deseada: ");

                        opcionVisualizar = scanner.nextInt();

                        switch (opcionVisualizar) {
                            case 1:
                                // Lógica para visualizar datos de un partido
                                System.out.println("Implementar lógica para visualizar datos de un partido.");
                                break;
                            case 2:
                                // Lógica para visualizar estadísticas de jugadores
                                System.out.println("Implementar lógica para visualizar estadísticas de jugadores.");
                                break;
                            case 3:
                                // Lógica para visualizar estadísticas de un equipo
                                System.out.println("Implementar lógica para visualizar estadísticas de un equipo.");
                                break;
                            case 4:
                                // Lógica para visualizar estadísticas de un entrenador
                                System.out.println("Implementar lógica para visualizar estadísticas de un entrenador.");
                                break;
                            case 5:
                                System.out.println("Volviendo al Menú Inicial.");
                                break;
                            default:
                                System.out.println("Opción no válida. Intente de nuevo.");
                                break;
                        }

                    } while (opcionVisualizar != 5);

                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcionPrincipal != 4);

        scanner.close();
        Conexion_DB.cerrarConexion();
    }
    
    
    ///////////////////////metodos para el apartado del menu modificar datos club --> Jgador/////////////////
    private static void gestionarCrudJugador(Scanner scanner) {
        JugadorDAO jugadorDAO = new JugadorDAO();

        int opcionCrudJugador;

        do {
            System.out.println("Que desaeas hacer:");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Leer Jugador");
            System.out.println("3. Actualizar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Listar Jugadores");
            System.out.println("6. Volver al Menú Anterior");
            System.out.print("Ingrese la opción deseada: ");

            opcionCrudJugador = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcionCrudJugador) {
                case 1:
                    // Crear Jugador
                    Jugador nuevoJugador = crearJugador(scanner);
                    if (jugadorDAO.createRecord(nuevoJugador)) {
                        System.out.println("Jugador creado exitosamente.");
                    } else {
                        System.out.println("Error al crear el jugador.");
                    }
                    break;
                case 2:
                    // Leer Jugador
                    leerJugador(scanner, jugadorDAO);
                    break;
                case 3:
                    // Actualizar Jugador
                    actualizarJugador(scanner, jugadorDAO);
                    break;
                case 4:
                    // Eliminar Jugador
                    eliminarJugador(scanner, jugadorDAO);
                    break;
                case 5:
                    // Listar Jugadores
                    listarJugadores(jugadorDAO);
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Anterior.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcionCrudJugador != 6);
    }

    private static Jugador crearJugador(Scanner scanner) {
    	  System.out.println("Ingrese los datos del nuevo jugador:");

    	    System.out.print("Nombre: ");
    	    String nombre = scanner.nextLine();

    	    System.out.print("Apellidos: ");
    	    String apellidos = scanner.nextLine();

    	    System.out.print("Edad: ");
    	    int edad = scanner.nextInt();
    	    scanner.nextLine(); // Consumir el salto de línea pendiente

    	    System.out.print("Dorsal: ");
    	    int dorsal = scanner.nextInt();
    	    scanner.nextLine();

    	    System.out.print("Posición: ");
    	    String posicion = scanner.nextLine();




    	    // Crear un nuevo objeto Jugador con los datos proporcionados no se le envian más porque el id lo obtenemos en la base de datos
    	    return new Jugador( nombre, apellidos, edad, dorsal, posicion);
    }

    private static void leerJugador(Scanner scanner, JugadorDAO jugadorDAO) {
        //  solicitar el ID al usuario mediante el scanner
        // y luego usar el método readRecord de JugadorDAO

        System.out.print("Ingrese el ID del jugador a leer: ");
        int idJugador = scanner.nextInt();
        scanner.nextLine(); 

        Jugador jugadorLeido = jugadorDAO.readRecord(idJugador);// desde read record se recuperan los datos y nos devuelve un Jugador

        if (jugadorLeido != null) {
            System.out.println("Jugador encontrado:");
            System.out.println(jugadorLeido);
        } else {
            System.out.println("No se encontró ningún jugador con el ID proporcionado.");
        }
    }

    private static void actualizarJugador(Scanner scanner, JugadorDAO jugadorDAO) {
        System.out.print("Ingrese el ID del jugador a actualizar: ");
        int idJugador = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        Jugador jugadorExistente = jugadorDAO.readRecord(idJugador);

        if (jugadorExistente != null) {
            // Mostrar los datos actuales del jugador
            System.out.println("Datos actuales del jugador:");
            System.out.println(jugadorExistente);

            // Solicitar al usuario qué dato desea actualizar
            System.out.println("Seleccione el dato a actualizar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Edad");
            // Agregar más opciones según los atributos que desees actualizar

            System.out.print("Ingrese el número correspondiente al dato a actualizar: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            // Solicitar el nuevo valor al usuario
            System.out.print("Ingrese el nuevo valor: ");
            String nuevoValor = scanner.nextLine();

            // Crear un nuevo objeto Jugador con los datos actualizados
            Jugador jugadorActualizado = new Jugador(jugadorExistente.getIdJugador(),
                    jugadorExistente.getNombre(), jugadorExistente.getApellidos(),
                    jugadorExistente.getEdad(), jugadorExistente.getDorsal(),
                    jugadorExistente.getPosicion(), jugadorExistente.getPartidosJugados());

            // Actualizar el atributo correspondiente
            switch (opcion) {
                case 1:
                    jugadorActualizado.setNombre(nuevoValor);
                    break;
                case 2:
                    jugadorActualizado.setApellidos(nuevoValor);
                    break;
                case 3:
                    // Actualizar más atributos según la opción seleccionada
                    // ...
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            // Actualizar el jugador en la base de datos
            if (jugadorDAO.updateRecord(jugadorActualizado, idJugador)) {
                System.out.println("Jugador actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el jugador.");
            }
        } else {
            System.out.println("No se encontró ningún jugador con el ID proporcionado.");
        }
    }


    private static void eliminarJugador(Scanner scanner, JugadorDAO jugadorDAO) {
        // Lógica para eliminar un jugador
        // Puedes solicitar el ID al usuario mediante el scanner
        // y luego usar el método deleteRecord de JugadorDAO

        System.out.print("Ingrese el ID del jugador a eliminar: ");
        int idJugador = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        // Verificar si el jugador existe antes de intentar eliminarlo
        Jugador jugadorExistente = jugadorDAO.readRecord(idJugador);

        if (jugadorExistente != null) {
            // Confirmar con el usuario antes de eliminar
            System.out.println("¿Está seguro de que desea eliminar este jugador? (S/N)");
            String confirmacion = scanner.nextLine().trim().toLowerCase();

            if (confirmacion.equals("s")) {
                // Eliminar el jugador
                if (jugadorDAO.deleteRecord(idJugador)) {
                    System.out.println("Jugador eliminado exitosamente.");
                } else {
                    System.out.println("Error al eliminar el jugador.");
                }
            } else {
                System.out.println("Operación de eliminación cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún jugador con el ID proporcionado.");
        }
    }

    private static void listarJugadores(JugadorDAO jugadorDAO) {
        // Lógica para listar todos los jugadores
        // Utilizar el método readRecords de JugadorDAO
        List<Jugador> jugadores = jugadorDAO.readRecords();

        if (!jugadores.isEmpty()) {
            System.out.println("Listado de Jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        } else {
            System.out.println("No hay jugadores registrados.");
        }
    }
}
