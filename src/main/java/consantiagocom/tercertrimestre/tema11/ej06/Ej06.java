package consantiagocom.tercertrimestre.tema11.ej06;

import java.util.Scanner;

public class Ej06 {
    public Ej06() {

        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Altas");
            System.out.println("2. Listados");
            System.out.println("3. Alquilar multimedia a socio");
            System.out.println("4. Devolver multimedia");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Alta de una nueva Película");
                    System.out.println("2. Alta de un nuevo Videojuego");
                    System.out.println("3. Alta de un nuevo socio");
                    System.out.print("Seleccione una opcion: ");
                    int altaOption = scanner.nextInt();
                    switch (altaOption) {
                        case 1:

                            break;
                        case 2:
                            // Llamar al método para alta de videojuego
                            break;
                        case 3:
                            // Llamar al método para alta de socio
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, intente de nuevo.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Listado de todos los objetos multimedia");
                    System.out.println("2. Listado de todas las películas ordenadas por título");
                    System.out.println("3. Listado de todos los videojuegos ordenados por año");
                    System.out.println("4. Listado del histórico de alquileres de un socio ordenados por fecha de alquiler");
                    System.out.println("5. Listado de los alquileres actuales de un socio");
                    System.out.println("6. Listado de los socios con recargos pendientes");
                    System.out.print("Seleccione una opción: ");
                    int listadoOption = scanner.nextInt();
                    switch (listadoOption) {
                        case 1:
                            // Llamar al método para listar todos los objetos multimedia
                            break;
                        case 2:
                            // Llamar al método para listar todas las películas ordenadas por título
                            break;
                        case 3:
                            // Llamar al método para listar todos los videojuegos ordenados por año
                            break;
                        case 4:
                            // Llamar al método para listar el histórico de alquileres de un socio ordenados por fecha de alquiler
                            break;
                        case 5:
                            // Llamar al método para listar los alquileres actuales de un socio
                            break;
                        case 6:
                            // Llamar al método para listar los socios con recargos pendientes
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, intente de nuevo.");
                            break;
                    }
                    break;
                case 3:
                    // Llamar al método para alquilar multimedia a socio
                    break;
                case 4:
                    // Llamar al método para devolver multimedia
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } while (option != 0);
    }
}