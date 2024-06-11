package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio13 {
    public static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        String nombre;
        char opcion;
        boolean error;
        System.out.println("*** TE SALUDO EN VARIOS IDIOMAS ***");
        System.out.print("�C�mo te llamas?: ");
        nombre = lector.nextLine();
        do {
            opcion = mostrarMenu();
            error = opcion != 'a' && opcion != 'b' && opcion != 'c';
            if(error) {
                System.out.println(opcion + " no es una opci�n v�lida.");
                System.out.println("Por favor, elija una opci�n del men�");
            }
        } while (error);
        System.out.println(obtenerSaludo(nombre, opcion));
        lector.close();
    }

    /**
     * Muestra el men� de selecci�n de idioma y solicita una opci�n
     * @return char con la opci�n elegida por el usuario
     */
    public static char mostrarMenu() {
        System.out.println("a) Valenciano");
        System.out.println("b) Castellano");
        System.out.println("c) Ingl�s");
        System.out.print("Elige una opci�n: ");
        return lector.nextLine().charAt(0);
    }

    public static String obtenerSaludo(String nombre, char opcion) {
        String saludo = "";
        switch(opcion) {
            //Valenci�
            case 'a':
                saludo = "Bon dia ";
                break;
            //Castell�
            case 'b':
                saludo = "Buenos d�as ";
                break;
            //Angl�s
            case 'c':
                saludo = "Good morning ";
                break;
        }
        saludo += nombre;
        return saludo;
    }
}
