package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char a;
        int n;
        int l;

        System.out.println("Ingresa un caracter");
        a = scanner.nextLine().charAt(0);
        System.out.println("Ingresa el numero de columnas que abra");
        n = scanner.nextInt();
        System.out.println("Ingresa el numero que se repetira el caracter");
        l = scanner.nextInt();

        //
        repetirletra(a,n,l);
    }

    /**
     * Imprime una matriz con el caracter c de filas x columnas
     * @param a Carácter a imprimir
     * @param filas Número de filas
     * @param columnas Número de columnas
     */
    public static void repetirletra(char a, int filas, int columnas){
        for (int i = 0; i <filas; i++) {
            for (int j = 0; j <columnas ; j++) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
    //forma string
  /*  public static String strRepiteLetraMatriz(char c, int filas, int columnas) {
        String s = "";
        for(int i = 1; i <= filas; i++) {
            s += Ejercicio05.strRepiteLetra(c, columnas) + "\n";
        }
        return s;
    }*/

}
