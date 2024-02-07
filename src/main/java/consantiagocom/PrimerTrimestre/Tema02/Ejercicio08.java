package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int edad,aniosVividos;

        System.out.println("Ingresa una edad");
        edad = scanner.nextInt();

        aniosVividos = edad * 365;
        System.out.println("con " + edad + " anios" + " haz vivido un total de " + aniosVividos + " dias");
        scanner.close();
    }
}
