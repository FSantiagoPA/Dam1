package consantiagocom.PrimerTrimestre.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign the variables
        int edad;

        //We ask for the data
        System.out.println("Give me your age, Please");
        edad = scanner.nextInt();
        scanner.close();

        //We do the condition
        if (edad >= 18){
            System.out.println("The person is of legal age");
        }else {
            System.out.println("The person is a minor");
        }
    }
}
