package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el dividiendo");
        double dividendo = s.nextDouble();
        System.out.println("Ingresa el divisor");
        double divisor = s.nextDouble();

        double resultado = dividendo / divisor;

        System.out.println("el dividiendo: " + dividendo + " es dividido por divisor " + divisor + " asi que el resultado es = " + resultado);
    }
}
