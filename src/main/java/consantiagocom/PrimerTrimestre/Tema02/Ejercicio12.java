package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {

        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign  variables
        double dividend;
        double divisor;

        //We ask for the data
        System.out.println("Give me one dividend, Please");
        dividend = scanner.nextInt();
        System.out.println("Give me one divisor, Please");
        divisor = scanner.nextInt();
        scanner.close();

        //operation
        double division = dividend / divisor;

        //Print the result
        System.out.println("The result of " + dividend + "/" + divisor + " is = " +division);
    }
}
