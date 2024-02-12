package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el minuendo");
        int minuendo = s.nextInt();
        System.out.println("Ingresa el sustraendo");
        int sustraendo = s.nextInt();

        int resultado = minuendo - sustraendo;

        System.out.println("el minuendo: " + minuendo + " es restado por sustraendo " + sustraendo + " asi que el resultado es = " + resultado);
    }
}
