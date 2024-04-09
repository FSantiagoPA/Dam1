package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {

        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign variables
        int age;
        int daysOfYear = 365;

        //we ask for the data
        System.out.println("Give me your ages, Please");
        age = scanner.nextInt();
        scanner.close();

        //Operation
        int total = age * daysOfYear;

        //Print the result

        System.out.println("A person with " + age + " years " + "have " + total
                + " days of life");

    }
}
