package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio18 {
    public static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        int dni = solicitarDNI();
        System.out.println("El NIF es " + calcularNIF(dni));
        lector.close();
    }

    /**
     * Solicita el dni al usuario
     *
     * @return El dni introducido por el usuario
     */
    public static int solicitarDNI() {
        System.out.print("Indica tu DNI: ");
        return Integer.parseInt(lector.nextLine());
    }

    /**
     * Calcula el NIF a partir del dni recibido como parámetro
     *
     * @param dni El dni a calcular
     * @return
     */
    public static String calcularNIF(int dni) {
        return String.valueOf(dni) + obtenerLetraDNI(dni);
    }

    /**
     * Obtiene la letra del NIF que le corresponde al dni indicado
     *
     * @param dni El dni
     * @return La letra que le corresponde al dni indicado
     */
    public static char obtenerLetraDNI(int dni) {
        String tabla = new String("TRWAGMYFPDXBNJZSQVHLCKE");
        int posLetra = dni % 23;
        return tabla.charAt(posLetra);
    }
}
