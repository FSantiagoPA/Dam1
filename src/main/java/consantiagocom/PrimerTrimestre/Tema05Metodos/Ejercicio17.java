package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        char letra;
        int alto, ancho;
        System.out.println("*** RECT�NGULO ***");
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
     * Imprime en la salida est�ndar un rect�ngulo de dimensiones ancho
     * y alto utilizando el car�cter c
     *
     * @param ancho Ancho del rect�ngulo
     * @param alto Alto del rect�ngulo
     * @param c Car�cter que se utilizar�
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
     * Genera un rect�ngulo de dimensiones ancho y alto utilizando
     * el car�cter c
     *
     * @param ancho Ancho del rect�ngulo
     * @param alto Alto del rect�ngulo
     * @param c Car�cter que se utilizar�
     * @return El rect�ngulo generado
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
