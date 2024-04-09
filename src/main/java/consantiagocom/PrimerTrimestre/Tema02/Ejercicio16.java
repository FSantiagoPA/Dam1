package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {
        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign the variables
        double euro;

        //We ask for the data
        System.out.println("Give me an Euro");
        euro = scanner.nextDouble();
        scanner.close();

        //Operation
        double dollar = euro * 1.08;
        double pound  = euro * 0.86;

        //Print the result
        System.out.println("Our euro: "+ euro + "€");
        System.out.println("Our euro to dollar: " + dollar + "$");
        System.out.println("Our euro to pound: " + pound + "£");
    }
}
