import java.util.ArrayList;
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
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    // Lógica para modificar datos de partidos
                    System.out.println("Menú para Modificar Datos de Partidos:");
                    break;
                case 2:
                    // Menú para ejecutar cambios en los datos del club
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
                                gestionarJugador(scanner);
                                break;
                            case 2:
                            	gestionarDirectivos(scanner);
                                break;
                            case 3:
                            	gestionarEquipo(scanner);
                                break;
                            case 4:
                            	gestionarEntrenador(scanner);
                                break;
                            case 5:
                                System.out.println("Volviendo al Menú Inicial.");
                                break;
                            default:
                                System.out.println("\nOpción no válida. Intente de nuevo con otro número que esté en la lista.");
                                break;
                        }

                    } while (opcionCrud != 5);

                    break;
                case 3:
                    // Menú para Visualizar Datos este lo utilizaré para acceder a los ficheros cuando los cree
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
                                break;
                            case 2:
                                // Lógica para visualizar estadísticas de jugadores
                                break;
                            case 3:
                                // Lógica para visualizar estadísticas de un equipo
                                break;
                            case 4:
                                // Lógica para visualizar estadísticas de un entrenador
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
    
    
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
/*----------------------------------------------------------------------METODOS PARA JUGADORES DEL MENU DE DATOS CLUB----------------------------------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////

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
                    if (jugadorDAO.guardar_en_BD(nuevoJugador)) {
                        System.out.println("Jugador creado exitosamente.");
                        int idGenerado = nuevoJugador.getIdJugador();
                        System.out.println("Nuevo Jugador creado con ID: " + idGenerado);
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

        Jugador jugadorLeido = jugadorDAO.leer_datos_BD(idJugador);// desde read record se recuperan los datos y nos devuelve un Jugador

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

        Jugador jugadorExistente = jugadorDAO.leer_datos_BD(idJugador);

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
            if (jugadorDAO.actualizar_datos_BD(jugadorExistente, idJugador)) {
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
        Jugador jugadorExistente = jugadorDAO.leer_datos_BD(idJugador);

        if (jugadorExistente != null) {
            // Confirmar con el usuario antes de eliminar / confirmacion si no es nul0
            System.out.println("¿Está seguro de que desea eliminar este jugador? (S/N)");
            String confirmacion = scanner.nextLine().trim().toLowerCase();

            if (confirmacion.equals("s")) {
                // Eliminar el jugador
                if (jugadorDAO.borrar_datos_BD(idJugador)) {
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
    
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
/*----------------------------------------------------------------------METODOS PARA DIRECTIVOS----------------------------------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////


    
    
    private static void gestionarDirectivos(Scanner scanner) {
        DirectivoDAO directivoDAO = new DirectivoDAO();

        int opcionCrudDirectivo;

        do {
            System.out.println("Menú para Gestionar Datos de Directivos:");
            System.out.println("1. Crear Directivo");
            System.out.println("2. Leer Directivo");
            System.out.println("3. Actualizar Directivo");
            System.out.println("4. Eliminar Directivo");
            System.out.println("5. Listar Directivos");
            System.out.println("6. Volver al Menú Anterior");
            System.out.print("Ingrese la opción deseada: ");

            opcionCrudDirectivo = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcionCrudDirectivo) {
                case 1:
                    // Crear Directivo
                    Directivo nuevoDirectivo = crearDirectivo(scanner);
                    if (directivoDAO.guardar_en_BD(nuevoDirectivo)) {
                        System.out.println("Directivo creado exitosamente.");
                        int idGenerado = nuevoDirectivo.getId();
                        System.out.println("Nuevo directivo creado con ID: " + idGenerado);
                    } else {
                        System.out.println("Error al crear el directivo.");
                    }
                    break;
                case 2:
                    // Leer Directivo
                    leerDirectivo(scanner, directivoDAO);
                    break;
                case 3:
                    // Actualizar Directivo
                    actualizarDirectivo(scanner, directivoDAO);
                    break;
                case 4:
                    // Eliminar Directivo
                    eliminarDirectivo(scanner, directivoDAO);
                    break;
                case 5:
                    // Listar Directivos
                    listarDirectivos(directivoDAO);
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Anterior.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcionCrudDirectivo != 6);
    }

    // Métodos adicionales para gestionar directivos

    private static Directivo crearDirectivo(Scanner scanner) {
        System.out.println("Ingrese los datos del nuevo directivo:");

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        // Crear un nuevo objeto Directivo con los datos proporcionados
        return new Directivo(dni, nombre, apellidos, cargo);
    }

    private static void leerDirectivo(Scanner scanner, DirectivoDAO directivoDAO) {
        System.out.print("Ingrese el ID del directivo a leer: ");
        int idDirectivo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        Directivo directivoLeido = directivoDAO.leer_datos_BD(idDirectivo);

        if (directivoLeido != null) {
            System.out.println("Directivo encontrado:");
            System.out.println("ID: " + directivoLeido.getId());
            System.out.println("DNI: " + directivoLeido.getDni());
            System.out.println("Nombre: " + directivoLeido.getNombre());
            System.out.println("Apellidos: " + directivoLeido.getApellidos());
            System.out.println("Cargo: " + directivoLeido.getCargo());
        } else {
            System.out.println("No se encontró ningún directivo con el ID proporcionado.");
        }
    }



private static void actualizarDirectivo(Scanner scanner, DirectivoDAO directivoDAO) {
    System.out.print("Ingrese el ID del directivo a actualizar: ");
    int idDirectivo = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea pendiente

    Directivo directivoExistente = directivoDAO.leer_datos_BD(idDirectivo);

    if (directivoExistente != null) {
        // Mostrar los datos actuales del directivo
        System.out.println("Datos actuales del directivo:");
        System.out.println("ID: " + directivoExistente.getId());
        System.out.println("DNI: " + directivoExistente.getDni());
        System.out.println("Nombre: " + directivoExistente.getNombre());
        System.out.println("Apellidos: " + directivoExistente.getApellidos());
        System.out.println("Cargo: " + directivoExistente.getCargo());

        // Menú para seleccionar el dato a actualizar
        int opcion;
        do {
            System.out.println("\nSeleccione el dato a actualizar:");
            System.out.println("1. DNI");
            System.out.println("2. Nombre");
            System.out.println("3. Apellidos");
            System.out.println("4. Cargo");
            System.out.println("5. Volver");
            System.out.print("Ingrese el número correspondiente al dato a actualizar: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo DNI: ");
                    String nuevoDni = scanner.nextLine();
                    directivoExistente.setDni(nuevoDni);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    directivoExistente.setNombre(nuevoNombre);
                    break;
                case 3:
                    System.out.print("Ingrese los nuevos apellidos: ");
                    String nuevosApellidos = scanner.nextLine();
                    directivoExistente.setApellidos(nuevosApellidos);
                    break;
                case 4:
                    System.out.print("Ingrese el nuevo cargo: ");
                    String nuevoCargo = scanner.nextLine();
                    directivoExistente.setCargo(nuevoCargo);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal.");
                    return;
                default:
                    System.out.println("Opción no válida. Elija otra opción por favor.");
                    break;
            }

        } while (opcion != 5);

        // Actualizar el directivo en la base de datos
        if (directivoDAO.actualizar_datos_BD(directivoExistente, idDirectivo)) {
            System.out.println("Directivo actualizado exitosamente.");
        } else {
            System.out.println("Error al actualizar el directivo.");
        }
    } else {
        System.out.println("No se encontró ningún directivo con el ID proporcionado.");
    }
}
	private static void eliminarDirectivo(Scanner scanner, DirectivoDAO directivoDAO) {
	    // Lógica para eliminar un directivo
	    System.out.print("Ingrese el ID del directivo a eliminar: ");
	    int idDirectivo = scanner.nextInt();
	    scanner.nextLine(); // Consumir el salto de línea pendiente
	
	    // Verificar si el directivo existe antes de intentar eliminarlo usando leer_datos_BD
	    Directivo directivoExistente = directivoDAO.leer_datos_BD(idDirectivo);
	
	    if (directivoExistente != null) {
	        // Confirmar con el usuario antes de eliminar
	        System.out.println("¿Está seguro de que desea eliminar este directivo? (S/N)");
	        String confirmacion = scanner.nextLine().trim().toLowerCase();
	
	        if (confirmacion.equals("s")) {
	            // Eliminar el directivo
	            if (directivoDAO.borrar_datos_BD(idDirectivo)) {
	                System.out.println("Directivo eliminado exitosamente.");
	            } else {
	                System.out.println("Error al eliminar el directivo.");
	            }
	        } else {
	            System.out.println("Operación de eliminación cancelada.");
	        }
	    } else {
	        System.out.println("No se encontró ningún directivo con el ID proporcionado.");
	    }
	}

	private static void listarDirectivos(DirectivoDAO directivoDAO) {
	    // Lógica para listar todos los directivos
	    List<Directivo> directivos = directivoDAO.readRecords();

	    if (!directivos.isEmpty()) {
	        System.out.println("Listado de Directivos:");
	        for (Directivo directivo : directivos) {
	            System.out.println("ID: " + directivo.getId());
	            System.out.println("DNI: " + directivo.getDni());
	            System.out.println("Nombre: " + directivo.getNombre());
	            System.out.println("Apellidos: " + directivo.getApellidos());
	            System.out.println("Cargo: " + directivo.getCargo());
	            System.out.println("---------------------------");
	        }
	    } else {
	        System.out.println("No hay directivos registrados.");
	    }
	}

	
	
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
/*----------------------------------------------------------------------METODOS PARA EQUIPOS  ----------------------------------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////


	
	
	private static void gestionarEquipo(Scanner scanner) {
	    int opcionCrudEquipo;
	    EquipoDAO equipoDAO = new EquipoDAO();
	    do {
	        System.out.println("\nMenú para Modificar Datos del Equipo:");
	        System.out.println("1. Crear Equipo");
	        System.out.println("2. Leer Equipo");
	        System.out.println("3. Actualizar Equipo");
	        System.out.println("4. Eliminar Equipo");
	        System.out.println("5. Listar Equipos");
	        System.out.println("6. Volver al Menú Anterior");
	        System.out.print("Ingrese la opción deseada: ");

	        opcionCrudEquipo = scanner.nextInt();
	        scanner.nextLine(); 
	        switch (opcionCrudEquipo) {
	            case 1:
	                
	                Equipo nuevoEquipo = crearEquipo(scanner);
	                if (equipoDAO.guardar_en_BD(nuevoEquipo)) {
	                    System.out.println("Equipo creado exitosamente.");
	                    int idGenerado = nuevoEquipo.getCodEquipo();
                        System.out.println("Nuevo equipo creado con ID: " + idGenerado);
	                } else {
	                    System.out.println("\nError al crear el equipo.");
	                }
	                break;
	            case 2:
	               
	                leerEquipo(scanner, equipoDAO);
	                break;
	            case 3:
	                
	                actualizarEquipo(scanner, equipoDAO);
	                break;
	            case 4:
	                
	                eliminarEquipo(scanner, equipoDAO);
	                break;
	            case 5:
	               
	                listarEquipos(equipoDAO);
	                break;
	            case 6:
	                System.out.println("Volviendo al Menú Anterior.");
	                break;
	            default:
	                System.out.println("Opción no válida. Intente de nuevo.");
	                break;
	        }

	    } while (opcionCrudEquipo != 6);
	}
		
	private static Equipo crearEquipo(Scanner scanner) {
	    System.out.println("Ingrese los datos del nuevo equipo:");

	    System.out.print("Estadio: ");
	    String estadio = scanner.nextLine();

	    

	    System.out.print("Categoría: ");
	    String categoria = scanner.nextLine();
	    
	    System.out.print("El entrenador de este equipo lo debe asignar despúes\n** Recuerde que un equipo solo tiene un entrenador**");
	    int entrenador = 0;

	    // Crear un nuevo objeto Equipo con los datos proporcionados
	    return new Equipo(estadio, entrenador, categoria);
	}

	private static void actualizarEquipo(Scanner scanner, EquipoDAO equipoDAO) {
	    System.out.print("\nIngrese el código del equipo a actualizar: ");
	    int codigoEquipo = scanner.nextInt();
	    scanner.nextLine(); // Consumir el salto de línea pendiente

	    // Verificar si el equipo existe antes de intentar actualizarlo
	    Equipo equipoExistente = equipoDAO.leer_datos_BD(codigoEquipo);

	    if (equipoExistente != null) {
	        // Mostrar los datos actuales del equipo
	        System.out.println("	Datos actuales del equipo:");
	        System.out.println("	Código: " + equipoExistente.getCodEquipo());
	        System.out.println("	Estadio: " + equipoExistente.getEstadio());
	        System.out.println("	ID Entrenador: " + equipoExistente.getEntrenador());
	        System.out.println("	Categoría: " + equipoExistente.getCategoria());
	        System.out.println("	---------------------------");

	        // Menú para seleccionar el campo a actualizar
	        int opcion;
	        do {
	            System.out.println("\nSeleccione el campo a actualizar:");
	            System.out.println("1. Estadio");
	            System.out.println("2. Intercambiar Entrenador");
	            System.out.println("3. Categoría");
	            System.out.println("4. Volver");
	            System.out.print("Ingrese el número correspondiente al campo a actualizar: ");
	            opcion = scanner.nextInt();
	            scanner.nextLine(); // Consumir el salto de línea pendiente

	          
				switch (opcion) {
	                case 1:
	                    System.out.print("Ingrese el nuevo estadio: ");
	                    String nuevoEstadio = scanner.nextLine();
	                    equipoExistente.setEstadio(nuevoEstadio);
	                    break;
	                case 2:
	                	System.out.println("\nLista de entrenadores disponibles:");
	                	EntrenadorDAO entrenadorDAO = new EntrenadorDAO();
	                    List<Entrenador> entrenadores = entrenadorDAO.readRecords();
	                    for (Entrenador entrenador : entrenadores) {
	                        System.out.println("	id entrenador:"+entrenador.getIdEntrenador() + "	" + entrenador.getNombre()  + " " + entrenador.getApellidos()+ "		Id de Equipo:"+
	                        entrenador.getIdEquipo() + "		Meses de experiencia : " +entrenador.getMesesExp() ) ;
	                    }

	                    // Solicitar al usuario que elija un entrenador
	                    System.out.print("Recuerde que un se intercambiaran los equipos de cada entrenador ");
	                    System.out.print("Seleccione el ID del nuevo entrenador: ");
	                    
	                    int idNuevoEntrenador = scanner.nextInt();
	                    scanner.nextLine(); 

	                    // Validar que el ID del entrenador seleccionado esté en la lista de entrenadores
	                    if (!validarIdEntrenador(idNuevoEntrenador, entrenadores)) {
	                        System.out.println("Error: El ID del entrenador seleccionado no es válido.");
	                        break; // Salir del switch si la elección no es válida
	                    }
/***************************************************************lo que mas tiempo me ha tomado *///////////////////////////////////////
	                 // Obtener el nuevo entrenador
	                    Entrenador nuevoEntrenador = obtenerEntrenadorPorId(idNuevoEntrenador, entrenadores);

	                    // Obtener el entrenador antiguo antes del intercambio
	                    Entrenador entrenadorAntiguo = obtenerEntrenadorPorId(equipoExistente.getEntrenador(), entrenadores);
	                    
	                    // Intercambiar equipos entre los dos entrenadores
	                    
	                    equipoDAO.actualizarEntrenadorEnEquipo(equipoExistente.getCodEquipo(), nuevoEntrenador.getIdEntrenador());
	                    if (entrenadorAntiguo != null || entrenadorAntiguo.getIdEquipo() != 0) {
	                    	System.out.println("Error: El ID del entrenador seleccionado no es válido"
	                    			+ "\nNose pueden intercambiar 2 entrenadores si uno de ellos no tiene asignado un entrenador.");
	                    	break;
	                    	
	                    }else {
	                    	equipoDAO.actualizarEntrenadorEnEquipo(entrenadorAntiguo.getIdEquipo(), 0);
						}
	                    // Actualizar id_equipo en la tabla Entrenador
	                    entrenadorDAO.actualizarEquipoEnEntrenador(equipoExistente.getCodEquipo(), nuevoEntrenador.getIdEntrenador());
	                    if (entrenadorAntiguo != null && entrenadorAntiguo.getIdEquipo() != 0) {
	                        // Actualizar id_equipo en el entrenador antiguo (ponerlo como no asignado)
	                    	 entrenadorDAO.actualizarEquipoEnEntrenador(entrenadorAntiguo.getIdEquipo(), entrenadorAntiguo.getIdEntrenador());
	                        
	                    }
	                    // Mostrar los datos actualizados del equipo y entrenadores intercambiados
	                    System.out.println("Datos actualizados del equipo:");
	                    System.out.println("Código: " + equipoExistente.getCodEquipo());
	                    System.out.println("Estadio: " + equipoExistente.getEstadio());
	                    System.out.println("Entrenador: " + nuevoEntrenador.getIdEntrenador()); // Aquí mostramos el nuevo entrenador
	                    System.out.println("Categoría: " + equipoExistente.getCategoria());
	                    System.out.println("---------------------------");
	                    System.out.println("Equipos intercambiados exitosamente.");
	                    System.out.println("Entrenadores actualizados exitosamente.");

	                    // Verificar si el entrenador antiguo tenía un equipo asignado (id_equipo = 0 significa que no tiene equipo)
	                    if (entrenadorAntiguo.getIdEquipo() != 0) {
	                        // Actualizar id_equipo en el entrenador antiguo (ponerlo como no asignado)
	                        entrenadorDAO.actualizarEquipoEnEntrenador(entrenadorAntiguo.getIdEquipo(), 0);
	                    }


	                    break;
	                case 3:
	                    System.out.print("Ingrese la nueva categoría: ");
	                    String nuevaCategoria = scanner.nextLine();
	                    equipoExistente.setCategoria(nuevaCategoria);
	                    break;
	                case 4:
	                    System.out.println("Volviendo al menú principal.");
	                    return;
	                default:
	                    System.out.println("Opción no válida. Por favor, elija otra opción.");
	                    break;
	            }

	        } while (opcion != 4);

	        // Actualizar el equipo en la base de datos
	        if (equipoDAO.actualizar_datos_BD(equipoExistente, codigoEquipo)) {
	            System.out.println("Equipo actualizado exitosamente.");
	        } else {
	            System.out.println("Error al actualizar el equipo.");
	        }
	    } else {
	        System.out.println("No se encontró ningún equipo con el código proporcionado.");
	    }
	}
	/*********************************Logica para verificar el entrenador elegido existe en la lista como pre requisito*********************/
	private static boolean validarIdEntrenador(int idEntrenador, List<Entrenador> listaEntrenadores) {
	    for (Entrenador entrenador : listaEntrenadores) {
	        if (entrenador.getIdEntrenador() == idEntrenador) {
	            return true; // El ID del entrenador es válido
	        }
	    }
	    return false; // El ID del entrenador no es válido
	}
	
	private static Entrenador obtenerEntrenadorPorId(int idEntrenador, List<Entrenador> listaEntrenadores) {
	    for (Entrenador entrenador : listaEntrenadores) {
	        if (entrenador.getIdEntrenador() == idEntrenador) {
	            return entrenador; // Retorna el entrenador si encuentra el ID
	        }
	    }
	    return null; // Retorna null si no encuentra el ID
	}
	private static void leerEquipo(Scanner scanner, EquipoDAO equipoDAO) {
	    System.out.print("Ingrese el código del equipo a leer: ");
	    int codigoEquipo = scanner.nextInt();
	    scanner.nextLine(); // Consumir el salto de línea pendiente

	    // Obtener el equipo desde la base de datos
	    Equipo equipoLeido = equipoDAO.leer_datos_BD(codigoEquipo);

	    if (equipoLeido != null) {
	        // Mostrar los datos del equipo
	        System.out.println("Datos del equipo:");
	        System.out.println("Código: " + equipoLeido.getCodEquipo());
	        System.out.println("Estadio: " + equipoLeido.getEstadio());
	        System.out.println("Entrenador: " + equipoLeido.getEntrenador());
	        System.out.println("Categoría: " + equipoLeido.getCategoria());
	    } else {
	        System.out.println("No se encontró ningún equipo con el código proporcionado.");
	    }
	}

	private static void eliminarEquipo(Scanner scanner, EquipoDAO equipoDAO) {
	    System.out.print("Ingrese el código del equipo a eliminar: ");
	    int codigoEquipo = scanner.nextInt();
	    scanner.nextLine(); // Consumir el salto de línea pendiente
	
	    // Verificar si el equipo existe antes de intentar eliminarlo
	    Equipo equipoExistente = equipoDAO.leer_datos_BD(codigoEquipo);
	
	    if (equipoExistente != null) {
	        // Mostrar los datos actuales del equipo
	        System.out.println("Datos actuales del equipo:");
	        System.out.println("Código: " + equipoExistente.getCodEquipo());
	        System.out.println("Estadio: " + equipoExistente.getEstadio());
	        System.out.println("Entrenador: " + equipoExistente.getEntrenador());
	        System.out.println("Categoría: " + equipoExistente.getCategoria());
	        System.out.println("---------------------------");
	
	        // Confirmar con el usuario antes de eliminar
	        System.out.println("¿Está seguro de que desea eliminar este equipo? (S/N)");
	        String confirmacion = scanner.nextLine().trim().toLowerCase();
	
	        if (confirmacion.equals("s")) {
	            // Eliminar el equipo
	            if (equipoDAO.borrar_datos_BD(codigoEquipo)) {
	                System.out.println("Equipo eliminado exitosamente.");
	            } else {
	                System.out.println("Error al eliminar el equipo.");
	            }
	        } else {
	            System.out.println("Operación de eliminación cancelada.");
	        }
	    } else {
	        System.out.println("No se encontró ningún equipo con el código proporcionado.");
	    }
	}

	private static void listarEquipos(EquipoDAO equipoDAO) {
	    // Listar todos los equipos
	    List<Equipo> equipos = equipoDAO.readRecords();
	
	    if (!equipos.isEmpty()) {
	        System.out.println("Listado de Equipos:");
	        for (Equipo equipo : equipos) {
	            System.out.println("Código: " + equipo.getCodEquipo());
	            System.out.println("Estadio: " + equipo.getEstadio());
	            System.out.println("Entrenador: " + equipo.getEntrenador());
	            System.out.println("Categoría: " + equipo.getCategoria());
	            System.out.println("---------------------------");
	        }
	    } else {
	        System.out.println("No hay equipos registrados.");
	    }
	}

	
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
/*----------------------------------------------------------------------METODOS PARA Entrenadores----------------------------------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////*****************************************************************////////////////////////////////////////////////////////////////////////////

	private static void gestionarEntrenador(Scanner scanner) {
	    EntrenadorDAO entrenadorDAO = new EntrenadorDAO();
	    EquipoDAO equipoDAO = new EquipoDAO();

	    int opcionCrudEntrenador;

	    do {
	        System.out.println("\nMenú para Modificar Datos del Entrenador:");
	        System.out.println("1. Crear Entrenador");
	        System.out.println("2. Leer Entrenador");
	        System.out.println("3. Actualizar Entrenador");
	        System.out.println("4. Eliminar Entrenador");
	        System.out.println("5. Listar Entrenadores");
	        System.out.println("6. Volver al Menú Anterior");
	        System.out.print("Ingrese la opción deseada: ");

	        opcionCrudEntrenador = scanner.nextInt();
	        scanner.nextLine(); 

	        switch (opcionCrudEntrenador) {
	            case 1:
	                // Crear Entrenador
	                Entrenador nuevoEntrenador = crearEntrenador(scanner, equipoDAO);
	                if (nuevoEntrenador != null) {
	                	System.out.println("Entrenador creado exitosamente.");
	                	System.out.println("Id del entrenador creado: " + nuevoEntrenador.getIdEntrenador());
	                }
	    	        
	               
	                
	                break;
	            case 2:
	                // Leer Entrenador
	                leerEntrenador(scanner, entrenadorDAO);
	                break;
	            case 3:
	                // Actualizar Entrenador
	                actualizarEntrenador(scanner, entrenadorDAO, equipoDAO);
	                break;
	            case 4:
	                // Eliminar Entrenador
	                eliminarEntrenador(scanner, entrenadorDAO, equipoDAO);
	                break;
	            case 5:
	                // Listar Entrenadores
	                listarEntrenadores(entrenadorDAO);
	                break;
	            case 6:
	                System.out.println("Volviendo al Menú Anterior.");
	                break;
	            default:
	                System.out.println("Opción no válida. Intente de nuevo.");
	                break;
	        }

	    } while (opcionCrudEntrenador != 6);
	}

	private static Entrenador crearEntrenador(Scanner scanner, EquipoDAO equipoDAO) {
	    System.out.println("Ingrese los datos del nuevo entrenador:");

	    // Solicitar información del entrenador
	    System.out.print("Nombre: ");
	    String nombre = scanner.nextLine();

	    System.out.print("Apellidos: ");
	    String apellidos = scanner.nextLine();

	    System.out.print("Meses de experiencia: ");
	    int mesesExp = scanner.nextInt();
	    scanner.nextLine();

	    // Obtener la lista de equipos sin entrenador, llamando al metodo que nos devolvera la lista completa.
	    List<Equipo> equiposSinEntrenador = obtenerEquiposSinEntrenador(equipoDAO);

	    // Validar que haya equipos sin entrenador
	    if (equiposSinEntrenador.isEmpty()) {
	        System.out.println("No hay equipos sin entrenador. Cada equipo solo puede tener un entrenador.\n debe existir un equipo sin entrenador.");
	        return null;
	    }

	    // Mostrar la lista de equipos sin entrenador
	    System.out.println("Equipos disponibles:");
	    for (Equipo equipo : equiposSinEntrenador) {
	        System.out.println(equipo);
	    }

	    // Solicitar al usuario que elija un equipo
	    System.out.print("Seleccione el ID del equipo para el nuevo entrenador: \n");
	    int idEquipo = scanner.nextInt();
	    scanner.nextLine(); // Consumir el salto de línea pendiente

	    // Validar que el ID del equipo seleccionado esté en la lista de equipos sin entrenador
	    if (!validarIdEquipo(idEquipo, equiposSinEntrenador)) {
	        System.out.println("Error: El ID del equipo seleccionado no es válido.");
	        return null; // devuel null si el ID del equipo no es uno de la lista que se ha mostrado antes :(
	    }

	    // Crear un nuevo objeto Entrenador con los datos proporcionados
	    Entrenador nuevoEntrenador = new Entrenador(nombre, apellidos, mesesExp, idEquipo);
	    nuevoEntrenador.setIdEquipo(idEquipo);// actualizar id de equipo del entrenador
	    // Guardar el nuevo entrenador en la base de datos
	    EntrenadorDAO entrenadorDAO = new EntrenadorDAO();
	    
	    if (entrenadorDAO.guardar_en_BD(nuevoEntrenador)) {
	        
	        // Actualizar el equipo con el nuevo ID de entrenador
	        equipoDAO.actualizarEntrenadorEnEquipo(idEquipo, nuevoEntrenador.getIdEntrenador());
	        
	    } else {
	        System.out.println("Error al crear el entrenador.");
	    }

	    return nuevoEntrenador;
	}

/*----------------------------*/
	private static List<Equipo> obtenerEquiposSinEntrenador(EquipoDAO equipoDAO) {
	    // Lógica para obtener la lista de equipos sin entrenador
	    List<Equipo> equipos = equipoDAO.readRecords();
	    List<Equipo> equiposSinEntrenador = new ArrayList<>();

	    for (Equipo equipo : equipos) {
	        if (equipo.getEntrenador() == 0) {
	            equiposSinEntrenador.add(equipo);
	        }
	    }

	    return equiposSinEntrenador;
	}

	private static boolean validarIdEquipo(int idEquipo, List<Equipo> equipos) {
	    // Verificar que el ID del equipo seleccionado esté en la lista de equipos sin entrenador
	    for (Equipo equipo : equipos) {
	        if (equipo.getCodEquipo() == idEquipo) {
	            return true;
	        }
	    }
	    return false;
	}
	
	/*----------------------------*/
	
	

	private static void leerEntrenador(Scanner scanner, EntrenadorDAO entrenadorDAO) {
	    System.out.print("Ingrese el ID del entrenador a leer: ");
	    int idEntrenador = scanner.nextInt();
	    scanner.nextLine(); // Consumir el salto de línea pendiente

	    Entrenador entrenadorLeido = entrenadorDAO.leer_datos_BD(idEntrenador);

	    if (entrenadorLeido != null) {
	        System.out.println("Entrenador encontrado:");
	        System.out.println(entrenadorLeido);
	    } else {
	        System.out.println("No se encontró ningún entrenador con el ID proporcionado.");
	    }
	}

	/*----------------------------*/
	
	
	private static void actualizarEntrenador(Scanner scanner, EntrenadorDAO entrenadorDAO, EquipoDAO equipoDAO) {
	    System.out.print("Ingrese el ID del entrenador a actualizar: ");
	    int idEntrenador = scanner.nextInt();
	    scanner.nextLine(); // Consumir el salto de línea pendiente

	    Entrenador entrenadorExistente = entrenadorDAO.leer_datos_BD(idEntrenador);

	    if (entrenadorExistente != null) {
	        // Mostrar los datos actuales del entrenador
	        System.out.println("Datos actuales del entrenador:");
	        System.out.println(entrenadorExistente);

	        // Menú para seleccionar el dato a actualizar
	        int opcion;
	        do {
	            System.out.println("\nSeleccione el dato a actualizar:");
	            System.out.println("1. Nombre");
	            System.out.println("2. Apellidos");
	            System.out.println("3. Volver");
	            System.out.print("Ingrese el número correspondiente al dato a actualizar: ");
	            opcion = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (opcion) {
	                case 1:
	                    System.out.print("Ingrese el nuevo nombre: ");
	                    String nuevoNombre = scanner.nextLine();
	                    entrenadorExistente.setNombre(nuevoNombre);
	                    break;
	                case 2:
	                    System.out.print("Ingrese los nuevos apellidos: ");
	                    String nuevosApellidos = scanner.nextLine();
	                    entrenadorExistente.setApellidos(nuevosApellidos);
	                    break;
	                case 3:
	                    System.out.println("Volviendo al menú principal.");
	                    return;
	                default:
	                    System.out.println("Opción no válida. Elija otra opción por favor.");
	                    break;
	            }

	        } while (opcion != 3);

	        // Actualizar el entrenador en la base de datos
	        if (entrenadorDAO.actualizar_datos_BD(entrenadorExistente, idEntrenador)) {
	            System.out.println("Entrenador actualizado exitosamente.");
	        } else {
	            System.out.println("Error al actualizar el entrenador.");
	        }
	    } else {
	        System.out.println("No se encontró ningún entrenador con el ID proporcionado.");
	    }
	}

	
	
	
	private static void eliminarEntrenador(Scanner scanner, EntrenadorDAO entrenadorDAO, EquipoDAO equipoDAO) {
	    System.out.print("Ingrese el ID del entrenador a eliminar: ");
	    int idEntrenador = scanner.nextInt();
	    scanner.nextLine(); // Consumir el salto de línea pendiente

	    Entrenador entrenadorExistente = entrenadorDAO.leer_datos_BD(idEntrenador);

	    if (entrenadorExistente != null) {
	        // Mostrar los datos actuales del entrenador
	        System.out.println("Datos del entrenador a eliminar:");
	        System.out.println(entrenadorExistente);

	        // Confirmar la eliminación
	        System.out.print("¿Está seguro de que desea eliminar este entrenador? (S/N): ");
	        String confirmacion = scanner.nextLine().trim().toUpperCase();

	        if (confirmacion.equals("S")) {
	            // Actualizar el equipo al que pertenecía asignándole "Sin Asignar"
	            int idEquipo = entrenadorExistente.getIdEquipo();
	            Equipo equipo = equipoDAO.leer_datos_BD(idEquipo);

	            if (equipo != null) {
	                /* 
	                 * Actualizar el campo entrenador a 0
	                 */
	                equipo.setEntrenador(0);
	                equipoDAO.actualizarEntrenadorEnEquipo(idEquipo, 0);
	            }

	            // Eliminar el entrenador de la base de datos
	            if (entrenadorDAO.borrar_datos_BD(idEntrenador)) {
	                System.out.println("Entrenador eliminado exitosamente.");
	            } else {
	                System.out.println("Error al eliminar el entrenador.");
	            }
	        } else {
	            System.out.println("Operación de eliminación cancelada.");
	        }
	    } else {
	        System.out.println("No se encontró ningún entrenador con el ID proporcionado.");
	    }
	}
	
	private static void listarEntrenadores(EntrenadorDAO entrenadorDAO) {
	    List<Entrenador> entrenadores = entrenadorDAO.readRecords();

	    if (!entrenadores.isEmpty()) {
	        System.out.println("Lista de Entrenadores:");
	        for (Entrenador entrenador : entrenadores) {
	            System.out.println(entrenador);
	        }
	    } else {
	        System.out.println("No hay entrenadores registrados.");
	    }
	}




}







