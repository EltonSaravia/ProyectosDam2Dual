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
            System.out.println("3. Ver Datos Estadisticos");
            System.out.println("5. Listar Ficheros");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    // Lógica para modificar datos de partidos
                    System.out.println("Menú para Modificar Datos de Partidos:");
                    break;
                case 2:
                    // Menú para ejecutar cambios eno los datos del club
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
                            	 gestionarJugador(scanner); // esto esta mas abajo en la linea 127
                                 break;
                                
                            case 2:
                                // Lógica CRUD para Directivo
                                
                                break;
                            case 3:
                                // Lógica CRUD para Equipo
                                
                                break;
                            case 4:
                                // Lógica CRUD para Entrenador
                               
                                break;
                            case 5:
                                System.out.println("Volviendo al Menú Inicial.");
                                break;
                            default:
                                System.out.println("\nOpción no válida. Intente de nuevo cono otro numero que este  en la lista.");
                                break;
                        }

                    } while (opcionCrud != 5);

                    break;
                case 3:
                    // Menú para Visualizar Datos este lo utilizare para acceder a los ficheros cuando los cree
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
                                
                                break;
                            case 2:
                                
                                break;
                            case 3:
                               
                                break;
                            case 4:
                               
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
    private static void gestionarJugador(Scanner scanner) {
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
                    if (jugadorDAO.guardarJugadorBD(nuevoJugador)) {
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

        Jugador jugadorLeido = jugadorDAO.leerJugadorBD(idJugador);// desde read record se recuperan los datos y nos devuelve un Jugador

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

        Jugador jugadorExistente = jugadorDAO.leerJugadorBD(idJugador);

        if (jugadorExistente != null) {
            // Mostrar los datos actuales del jugador
            System.out.println("Datos actuales del jugador:");
            System.out.println(jugadorExistente);

            // Menú para seleccionar el dato a actualizar
            int opcion;
            do {
                System.out.println("\nSeleccione el dato a actualizar:");
                System.out.println("1. Nombre");
                System.out.println("2. Apellidos");
                System.out.println("3. Edad");
                System.out.println("4. Dorsal");
                System.out.println("5. Posición");
                System.out.println("6. Partidos Jugados");
                System.out.println("7. Equipo");
                System.out.println("8. Volver");
                System.out.print("Ingrese el número correspondiente al dato a actualizar: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        jugadorExistente.setNombre(nuevoNombre);
                        break;
                    case 2:
                        System.out.print("Ingrese los nuevos apellidos: ");
                        String nuevosApellidos = scanner.nextLine();
                        jugadorExistente.setApellidos(nuevosApellidos);
                        break;
                    case 3:
                        System.out.print("Ingrese la nueva edad: ");
                        int nuevaEdad = scanner.nextInt();
                        jugadorExistente.setEdad(nuevaEdad);
                        break;
                    case 4:
                        System.out.print("Ingrese el nuevo dorsal: ");
                        int nuevoDorsal = scanner.nextInt();
                        jugadorExistente.setDorsal(nuevoDorsal);
                        break;
                    case 5:
                        System.out.print("Ingrese la nueva posición: ");
                        String nuevaPosicion = scanner.nextLine();
                        jugadorExistente.setPosicion(nuevaPosicion);
                        break;
                    case 6:
                        System.out.print("Ingrese la nueva cantidad de partidos jugados: ");
                        int nuevosPartidosJugados = scanner.nextInt();
                        jugadorExistente.setPartidosJugados(nuevosPartidosJugados);
                        break;
                    case 7:
                        System.out.print("Ingrese la nueva categoria: ");
                        String nuevaCategoria = scanner.nextLine();
                        jugadorExistente.setCategoria(nuevaCategoria);
                        break;
                    case 8:
                        System.out.println("Volviendo al menú principal.");
                        return;
                    default:
                        System.out.println("Opción no válida. elija otra opcion por favor");
                        break;
                }

            } while (opcion != 8);

            // Actualizar el jugador en la base de datos
            if (jugadorDAO.actualizarJugadorBD(jugadorExistente, idJugador)) {
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
        scanner.nextLine(); 

        // Verificar si el jugador existe antes de intentar eliminarlo usando readRecord de nuevo
        Jugador jugadorExistente = jugadorDAO.leerJugadorBD(idJugador);

        if (jugadorExistente != null) {
            // Confirmar con el usuario antes de eliminar / confirmacion si no es nul0
            System.out.println("¿Está seguro de que desea eliminar este jugador? (S/N)");
            String confirmacion = scanner.nextLine().trim().toLowerCase();

            if (confirmacion.equals("s")) {
                // Eliminar el jugador
                if (jugadorDAO.borrarJugadorBD(idJugador)) {
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
        // listar tods los jugadores
        // Utilizar el método readRecords de JugadorDAO
    	//de momenito asi pero hay que ver si es mejor ocon tostring
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
