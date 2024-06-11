package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        char letra;
        int alto, ancho;
        System.out.println("*** RECTÁNGULO ***");
        System.out.print("Indica la letra: ");
        letra = lector.nextLine().charAt(0);
        System.out.print("Ancho: ");
        ancho = Integer.parseInt(lector.nextLine());
        System.out.print("Alto: ");
        alto = Integer.parseInt(lector.nextLine());
        // imprimeRectangulo(ancho, alto, letra);
        System.out.println(generaRectangulo(ancho, alto, letra));
        lector.close();
    }

    /**
     * Imprime en la salida estándar un rectángulo de dimensiones ancho
     * y alto utilizando el carácter c
     *
     * @param ancho Ancho del rectángulo
     * @param alto Alto del rectángulo
     * @param c Carácter que se utilizará
     */
    public static void imprimeRectangulo(int ancho, int alto, char c) {
        for(int i = 1; i <= alto; i++) {
            for(int j = 1; j <= ancho; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    /**
     * Genera un rectángulo de dimensiones ancho y alto utilizando
     * el carácter c
     *
     * @param ancho Ancho del rectángulo
     * @param alto Alto del rectángulo
     * @param c Carácter que se utilizará
     * @return El rectángulo generado
     */
    public static String generaRectangulo(int ancho, int alto, char c) {
        String result = "";
        for(int i = 1; i <= alto; i++) {
            for(int j = 1; j <= ancho; j++) {
                result += c;
            }
            result += "\n";
        }
        return result;
    }
}
