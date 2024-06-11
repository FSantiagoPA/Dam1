package consantiagocom.PrimerTrimestre.tema03bucles.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign the variables
        float num1;
        float num2;

        //We ask for the data
        System.out.println("Give me a number");
        num1 = scanner.nextFloat();
        System.out.println("Give me another number");
        num2 = scanner.nextFloat();
        scanner.close();

        //We do the condition
        if (num1 > num2){
            System.out.println(num2 + " , " + num1);
        }else System.out.println(num1 + " , " + num2);
    }
}
