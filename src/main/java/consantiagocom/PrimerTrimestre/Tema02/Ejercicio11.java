package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign  variables
        int minuend;
        int subtrahend;

        //We ask for the data
        System.out.println("Give me one minuend, Please");
        minuend = scanner.nextInt();
        System.out.println("Give me one subtrahend, Please");
        subtrahend = scanner.nextInt();
        scanner.close();

        //operation
        int subtraction = minuend - subtrahend;

        //Print the result
        System.out.println("The result of " + minuend + "-" + subtrahend + " is = " +subtraction);
    }
}
