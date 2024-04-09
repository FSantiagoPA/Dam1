package consantiagocom.PrimerTrimestre.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        // We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign the variables
        final float BASE_FEE = 500f;
        float discount = 0;
        int edad;
        char partners;
        float finalFEE;

        //Wea ask for the data
        System.out.print("Indicate your age: ");
        edad = scanner.nextInt();

        //We do the condition
        if (edad > 65){
            discount = 50;
        } else if (edad < 18) {
            discount = 25;
            System.out.println("Are the parents partners? (Y/N): ");
            partners = scanner.nextLine().toLowerCase().charAt(0);
            if (partners == 's') {
                discount = 35;
            }
        }
        finalFEE = BASE_FEE - (BASE_FEE * discount)/100;
        System.out.println("The final fee to be paid by the golf club is " + finalFEE + " €");
        scanner.close();

    }
}
