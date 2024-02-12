package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double libras = 0.85;
        double dolar = 1.08;
        System.out.println("Ingrese la cantidad de euros que quiere convertir!");
        double euros = s.nextDouble();

        double conversionLibras = (euros * libras);
        double conversionDolar = (euros * dolar);

        System.out.println("Euro a cambiar: " + euros + "€");
        System.out.printf("Euro a libras: %.2f£\n",conversionLibras);
        System.out.printf("Euro a dolar: %.2f$\n",conversionDolar);
    }
}
