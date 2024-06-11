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
                    System.out.println("La palabra más larga de " + s1 + ", " + s2 + " y " + s3 + " es " + masLarga(s1,s2,s3));
                    break;
                case 2:
                    s1 = solicitarString("Primera palabra", 1, 50);
                    s2 = solicitarString("Segunda palabra", 1, 50);
                    s3 = solicitarString("Tercera palabra", 1, 50);
                    System.out.println("La palabra más corta de " + s1 + ", " + s2 + " y " + s3 + " es " + masCorta(s1,s2,s3));
                    break;
                case 3:
                    s1 = solicitarString("Palabra", 1, 50);
                    System.out.println("La palabra " + s1 + " tiene " + cuentaVocales(s1) + " vocales");
                    break;
                case 0:
                    break;

                default:
                    System.out.println(opcion + " no es una opción del menú válida");
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
     * Solicita una cadena de caracteres con un tamaño mínimo de minCaracteres y un tamaño máximo de maxCaracteres
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
                System.out.println("Debe tener entre " + minCaracteres + " y " + maxCaracteres + " carácteres");
        } while (!valido);
        return s;
    }

    /**
     * Muestra las opciones del menú principal y solicita una opción
     * @return La opción seleccionada por el usuario
     */
    public static int mostrarMenu() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("==============");
        System.out.println("1. Palabra más larga");
        System.out.println("2. Palabra más corta");
        System.out.println("3. Número de vocales");
        System.out.println("--------------------------------");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
        return Integer.parseInt(lector.nextLine());
    }

    /**
     * Determina cual es la palabra más larga de las 3 introducidas como parámetro
     * @param s1 Primera palabra
     * @param s2 Segunda palabra
     * @param s3 Tercera palabra
     * @return String con la palabra más larga
     */
    public static String masLarga(String s1, String s2, String s3) {
        String m1 = masLarga(s1,s2);
        return masLarga(m1, s3);
    }

    /**
     * Determina cual es la palabra más larga de las 2 introducidas como parámetro
     * @param s1 Primera palabra
     * @param s2 Segunda palabra
     * @return String con la palabra más larga
     */
    public static String masLarga(String s1, String s2) {
        return s1.length() > s2.length() ? s1 : s2;
    }


    /**
     * Determina cual es la palabra más corta de las 3 introducidas como parámetro
     * @param s1 Primera palabra
     * @param s2 Segunda palabra
     * @param s3 Tercera palabra
     * @return String con la palabra más corta
     */
    public static String masCorta(String s1, String s2, String s3) {
        String m1 = masCorta(s1, s2);
        return masCorta(m1, s3);
    }

    /**
     * Determina cual es la palabra más corta de las 2 introducidas como parámetro
     * @param s1 Primera palabra
     * @param s2 Segunda palabra
     * @return String con la palabra más corta
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
        String vocales = "aáàäåeéèëiíìïoóòöuúùü";
        c = Character.toLowerCase(c);
        return vocales.indexOf(c) >= 0;
    }

    /**
     * Cuenta las vocales que contiene la cadena de carácteres pasada como parámetro
     * @param s Cadena de carácteres a contar los carácteres
     * @return int Número de vocales que tiene la cadena de carácteres introducida
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
