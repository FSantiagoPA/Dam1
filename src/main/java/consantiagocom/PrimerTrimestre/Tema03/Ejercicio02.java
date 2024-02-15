package consantiagocom.PrimerTrimestre.Tema03;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num1;
        int num2;

        System.out.println("Introduzca el primer numero");
        num1 = s.nextInt();
        System.out.println("Introduzca un segundo numero");
        num2 = s.nextInt();

        if (num1 > num2){
            System.out.println("num1 es mayor que num2 = " + num1);
        } else if (num1 < num2) {
            System.out.println("num1 es menor que num1 = " + num1);
        } else if (num1 == num2) {
            System.out.println("num1 y num2 son iguales = " + num1);
        }
        s.close();
    }
    
}
