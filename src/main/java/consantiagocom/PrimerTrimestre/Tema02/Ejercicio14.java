package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign variables
        float radius;
        final float PI = (float) Math.PI;

        //we ask for the data
        System.out.println("Give me the radius of the circle");
        radius = scanner.nextFloat();
        scanner.close();

        //Operations
        float area = (float) (PI * Math.pow(radius,2));
        float length = (float) (2*PI*radius);

        //Print the result
        System.out.println("Area of the circle is = " + area + " cm^2");
        System.out.println("Length of the circle is = " + length + " cm");
    }
}
