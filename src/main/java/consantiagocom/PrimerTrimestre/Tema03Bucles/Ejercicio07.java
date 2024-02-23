package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base;
        int exponente;
        boolean exponenteNegativo = false;
        double potencia = 1;

        System.out.println("Indica la base");
        base = scanner.nextDouble();
        System.out.print("Indica el exponente: ");
        exponente = scanner.nextInt();
        scanner.close();
    }
}
