package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que calcule el producto de dos números utilizando sumas.
*/

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a;
        int b;
        int total = 0;

        System.out.println("Ingresa un numero");
        a = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingresa otro numero");
        b = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= a; i++) {
            total = total + b;
        }
        System.out.println(a + " x " + b + " = " + total + ". ");
    }
}
