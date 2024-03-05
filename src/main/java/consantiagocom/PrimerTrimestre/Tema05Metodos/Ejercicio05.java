package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letra;
        int n;
        System.out.println("*** REPITE LETRA ***");
        System.out.print("Indica la letra: ");
        letra = scanner.nextLine().charAt(0);
        System.out.print("Número de repeticiones: ");
        n = Integer.parseInt(scanner.nextLine());
        repetirLetra(letra, n);
        //System.out.println(strRepiteLetra(letra, n));
        scanner.close();
    }

    /**
     * Imprime por pantalla el caracter tantas veces como valga el parámetro veces.
     * @param a Carácter a imprimir
     * @param veces Número de veces a imprimir
     */
    public static void repetirLetra(char a , int veces){
        for (int i = 0; i <veces; i++) {
            System.out.println(a);
        }
        System.out.println();
    }
    /**
     * Esta versión, al devolver un String, es más reutilizable desde el punto de vista del programador.
     * @param c Carácter a imprimir
     * @param veces Número de veces a imprimir
     */
    public static String strRepiteLetra(char c, int veces) {
        String s = "";
        for(int i = 1; i <= veces; i++) {
            s += c;
        }
        return s;
    }


}
