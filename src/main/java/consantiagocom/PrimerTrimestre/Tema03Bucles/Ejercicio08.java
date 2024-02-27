package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un numero");
        int num = scanner.nextInt();
        long factorial = 1;

        if (num >= 0) {
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
            }
            System.out.println("El factorial de " + num + " es "+ factorial);
        }

    }
}
