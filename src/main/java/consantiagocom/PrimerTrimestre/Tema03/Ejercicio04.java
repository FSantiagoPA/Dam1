package consantiagocom.PrimerTrimestre.Tema03;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
         float num1;
         float num2;

        System.out.println("Ingresa un valor real");
        num1 = s.nextFloat();
        System.out.println("Ingresa un segundo valor real");
        num2 = s.nextFloat();

        if (num2 > num1){
            System.out.print(num1 + " , " + num2);
        }else {
            System.out.print(num2 + " , " + num1);
        }
    }
}
