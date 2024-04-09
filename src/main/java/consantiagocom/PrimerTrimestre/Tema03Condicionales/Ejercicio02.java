package consantiagocom.PrimerTrimestre.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign the variables
        int num1;
        int num2;

        //we ask for the data
        System.out.println("Give me a number");
        num1 = scanner.nextInt();
        System.out.println("Give me another number");
        num2 = scanner.nextInt();
        scanner.close();

        //We do the condition
        if (num1 > num2)
            System.out.println("The number 1 is higher than number 2");
        if (num1 < num2)
            System.out.println("The number 1 is lower than number 2");
        if (num1 == num2)
            System.out.println("The 2 number are the same");
    }
}
