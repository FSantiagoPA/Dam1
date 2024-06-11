package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio13 {
    public static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        String nombre;
        char opcion;
        boolean error;
        System.out.println("*** TE SALUDO EN VARIOS IDIOMAS ***");
        System.out.print("¿Cómo te llamas?: ");
        nombre = lector.nextLine();
        do {
            opcion = mostrarMenu();
            error = opcion != 'a' && opcion != 'b' && opcion != 'c';
            if(error) {
                System.out.println(opcion + " no es una opción válida.");
                System.out.println("Por favor, elija una opción del menú");
            }
        } while (error);
        System.out.println(obtenerSaludo(nombre, opcion));
        lector.close();
    }

    /**
     * Muestra el menú de selección de idioma y solicita una opción
     * @return char con la opción elegida por el usuario
     */
    public static char mostrarMenu() {
        System.out.println("a) Valenciano");
        System.out.println("b) Castellano");
        System.out.println("c) Inglés");
        System.out.print("Elige una opción: ");
        return lector.nextLine().charAt(0);
    }

    public static String obtenerSaludo(String nombre, char opcion) {
        String saludo = "";
        switch(opcion) {
            //Valencià
            case 'a':
                saludo = "Bon dia ";
                break;
            //Castellà
            case 'b':
                saludo = "Buenos días ";
                break;
            //Anglés
            case 'c':
                saludo = "Good morning ";
                break;
        }
        saludo += nombre;
        return saludo;
    }
}
