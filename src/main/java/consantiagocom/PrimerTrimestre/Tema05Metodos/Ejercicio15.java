package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio15 {
    public static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        String s1, s2, s3;
        do {
            opcion = mostrarMenu();
            switch(opcion) {
                case 1:
                    s1 = solicitarString("Primera palabra", 1, 50);
                    s2 = solicitarString("Segunda palabra", 1, 50);
                    s3 = solicitarString("Tercera palabra", 1, 50);
                    System.out.println("La palabra m�s larga de " + s1 + ", " + s2 + " y " + s3 + " es " + masLarga(s1,s2,s3));
                    break;
                case 2:
                    s1 = solicitarString("Primera palabra", 1, 50);
                    s2 = solicitarString("Segunda palabra", 1, 50);
                    s3 = solicitarString("Tercera palabra", 1, 50);
                    System.out.println("La palabra m�s corta de " + s1 + ", " + s2 + " y " + s3 + " es " + masCorta(s1,s2,s3));
                    break;
                case 3:
                    s1 = solicitarString("Palabra", 1, 50);
                    System.out.println("La palabra " + s1 + " tiene " + cuentaVocales(s1) + " vocales");
                    break;
                case 0:
                    break;

                default:
                    System.out.println(opcion + " no es una opci�n del men� v�lida");
                    break;
            }
            if(opcion != 0) {
                System.out.println("Pulsa INTRO para continuar ...");
                lector.nextLine();
            }
            Ejercicio10.borrarPantalla();
        } while(opcion != 0);
        System.out.println("Hasta pronto!");
    }

    /**
     * Solicita una cadena de caracteres con un tama�o m�nimo de minCaracteres y un tama�o m�ximo de maxCaracteres
     * @param mensaje
     * @param minCaracteres
     * @param maxCaracteres
     * @return
     */
    public static String solicitarString(String mensaje, int minCaracteres, int maxCaracteres) {
        String s;
        boolean valido;
        do {
            System.out.println(mensaje);
            s = lector.nextLine();
            valido = s.length() >= minCaracteres && s.length() <= maxCaracteres;
            if (!valido)
                System.out.println("Debe tener entre " + minCaracteres + " y " + maxCaracteres + " car�cteres");
        } while (!valido);
        return s;
    }

    /**
     * Muestra las opciones del men� principal y solicita una opci�n
     * @return La opci�n seleccionada por el usuario
     */
    public static int mostrarMenu() {
        System.out.println("MEN� PRINCIPAL");
        System.out.println("==============");
        System.out.println("1. Palabra m�s larga");
        System.out.println("2. Palabra m�s corta");
        System.out.println("3. N�mero de vocales");
        System.out.println("--------------------------------");
        System.out.println("0. Salir");
        System.out.print("Elige una opci�n: ");
        return Integer.parseInt(lector.nextLine());
    }

    /**
     * Determina cual es la palabra m�s larga de las 3 introducidas como par�metro
     * @param s1 Primera palabra
     * @param s2 Segunda palabra
     * @param s3 Tercera palabra
     * @return String con la palabra m�s larga
     */
    public static String masLarga(String s1, String s2, String s3) {
        String m1 = masLarga(s1,s2);
        return masLarga(m1, s3);
    }

    /**
     * Determina cual es la palabra m�s larga de las 2 introducidas como par�metro
     * @param s1 Primera palabra
     * @param s2 Segunda palabra
     * @return String con la palabra m�s larga
     */
    public static String masLarga(String s1, String s2) {
        return s1.length() > s2.length() ? s1 : s2;
    }


    /**
     * Determina cual es la palabra m�s corta de las 3 introducidas como par�metro
     * @param s1 Primera palabra
     * @param s2 Segunda palabra
     * @param s3 Tercera palabra
     * @return String con la palabra m�s corta
     */
    public static String masCorta(String s1, String s2, String s3) {
        String m1 = masCorta(s1, s2);
        return masCorta(m1, s3);
    }

    /**
     * Determina cual es la palabra m�s corta de las 2 introducidas como par�metro
     * @param s1 Primera palabra
     * @param s2 Segunda palabra
     * @return String con la palabra m�s corta
     */
    public static String masCorta(String s1, String s2) {
        return s1.length() < s2.length() ? s1 : s2;
    }


    /**
     * Determina si el caracter c es una vocal
     * @param c
     * @return true si es una vocal, false en caso contrario
     */
    public static boolean esVocal(char c) {
        String vocales = "a����e���i���o���u���";
        c = Character.toLowerCase(c);
        return vocales.indexOf(c) >= 0;
    }

    /**
     * Cuenta las vocales que contiene la cadena de car�cteres pasada como par�metro
     * @param s Cadena de car�cteres a contar los car�cteres
     * @return int N�mero de vocales que tiene la cadena de car�cteres introducida
     */
    public static int cuentaVocales(String s) {
        int vocales = 0;
        String aux = s.toLowerCase();
        for(int i = 0; i < aux.length(); i++) {
            char c = aux.charAt(i);
            if (esVocal(c)) {
                vocales++;
            }
        }
        return vocales;
    }
}
