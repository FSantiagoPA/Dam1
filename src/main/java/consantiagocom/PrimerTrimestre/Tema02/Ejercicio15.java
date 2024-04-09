package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);
        
        //We assign the variables
        double celsius;

        //We ask for the data
        System.out.println("Give me temperatures in celsius");
        celsius = scanner.nextDouble();
        scanner.close();

        //Operation
        double kelvin = 273.15 + celsius;
        double fahrenheit = celsius * ((double) 9 /5) + 32;

        //Print the result
        System.out.println("Our degrees celcius: " + celsius);
        System.out.println("Our degrees celcius to kelvin: " + kelvin);
        System.out.println("Our degrees celcius to fahrenheit: " + fahrenheit);
    }
}
