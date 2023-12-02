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
                                // Lógica CRUD para Jugador
                                System.out.println("Implementar lógica CRUD para Jugador.");
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
}
