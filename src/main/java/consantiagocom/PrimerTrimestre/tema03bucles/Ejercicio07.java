package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que calcule la potencia de un número real (a) elevado a un número entero (b)
utilizando multiplicaciones. Debes tener en cuenta que tanto (a) como (b) pueden valer 0 o pueden
ser números negativos.
*/

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float base;
        int exponente;
        float potencia = 1f;
        boolean potenciaNegativa = false;


        System.out.println("Ingresa la base");
        base = Float.parseFloat(scanner.nextLine());

        System.out.println("Ingresa la potencia");
        exponente = Integer.parseInt(scanner.nextLine());

        if (exponente < 0 ){
            potenciaNegativa = true;
            exponente = exponente * (-1);
        }

        for (int i = 1; i <=exponente; i++) {
            potencia = potencia * base;
        }

        if(potenciaNegativa) {
            potencia = 1 / potencia;
        }

        System.out.println("El resultado de " + base + " elevado a " + exponente + " es " + potencia);
    }
}
