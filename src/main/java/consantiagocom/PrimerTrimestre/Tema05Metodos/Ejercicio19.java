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
     * Comprueba si el NIF indicado es v�lido
     *
     * @param nif NIF a comprobar
     * @return true si es un NIF v�lido, false en caso contrario
     */
    public static boolean compruebaNIF(String nif) {
        String dniString = "";
        // Cogemos como letra el �ltimo caracter del NIF
        char letra = nif.charAt(nif.length()-1);
        char c;
        for(int i = 0; i < nif.length(); i++) {
            // Si es un d�gito lo a�adimos a dniString
            c = nif.charAt(i);
            if(Character.isDigit(c)) {
                dniString = dniString + c;
            }
        }
        return letra == Ejercicio18.obtenerLetraDNI(Integer.parseInt(dniString));
    }
}
