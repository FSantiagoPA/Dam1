package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

/*
Escribe un método que acepte tres argumentos: un carácter y dos enteros. El carácter se debe
imprimir. El primer entero indica el número a veces que se imprimirá el carácter en la línea y el
segundo entero indica el número de líneas que debe de imprimirse.
*/


public class Ejercicio06 {

    public Ejercicio06(){
        as('c',5,5);
    }
    public static void as(char c, int row, int colum){
        for (int i = 0; i <= row; i++){
            for (int j = 0; j <= colum ; j++){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
