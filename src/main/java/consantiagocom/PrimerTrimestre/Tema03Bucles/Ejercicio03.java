package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num1;
        int num2;
        int resultado = 0;

        System.out.println("Digita un numero");
        num1 = s.nextInt();
        System.out.println("Digita otro numero");
        num2 = s.nextInt();

        for (int i = 1; i <= num1; i++) {
            resultado = resultado + num2;
        }
        System.out.print(num1 + " x " + num2 + " = " + resultado + ". ");
        System.out.println("Calculado sumando " + num1 + " veces " + num2);
        s.close();
    }
}
