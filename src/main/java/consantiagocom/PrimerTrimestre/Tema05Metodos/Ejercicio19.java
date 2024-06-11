package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio19 {
    public static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        String nif = solicitarNIF();
        System.out.println("El NIF " + nif + " es " + (compruebaNIF(nif) ? "correcto" : "incorrecto"));
    }

    /**
     * Solicita el NIF al usuario
     *
     * @return El NIF introducido por el usuario
     */
    public static String solicitarNIF() {
        System.out.println("*** COMPRUEBA TU NIF ***");
        System.out.print("Indica tu NIF (sin espacios ni guiones): ");
        return lector.nextLine();
    }

    /**
     * Comprueba si el NIF indicado es válido
     *
     * @param nif NIF a comprobar
     * @return true si es un NIF válido, false en caso contrario
     */
    public static boolean compruebaNIF(String nif) {
        String dniString = "";
        // Cogemos como letra el último caracter del NIF
        char letra = nif.charAt(nif.length()-1);
        char c;
        for(int i = 0; i < nif.length(); i++) {
            // Si es un dígito lo añadimos a dniString
            c = nif.charAt(i);
            if(Character.isDigit(c)) {
                dniString = dniString + c;
            }
        }
        return letra == Ejercicio18.obtenerLetraDNI(Integer.parseInt(dniString));
    }
}
