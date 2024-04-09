package consantiagocom.PrimerTrimestre.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {

        //We initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //We assign  variables
        int num;

        //We ask for the data
        System.out.println("Give me a number");
        num = scanner.nextInt();
        scanner.close();

        //Now we do the condition
        if (num % 2 == 0){
            System.out.println("This number is pair");
        }else{
            System.out.println("This number is unpair");
        }
    }
}
