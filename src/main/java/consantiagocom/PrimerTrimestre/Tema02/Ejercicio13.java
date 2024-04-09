package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        //We initialize the scanner
        Scanner scanner= new Scanner(System.in);

        //We assign variables
        int sec;

        //We ask for the data
        System.out.println("Give me a number of seconds");
        sec = scanner.nextInt();
        scanner.close();

        //Operations
        int minute = sec/60;
        int hour = (int) (sec/3.600);
        int days = (int) (sec/86.400);

        //Print the result
        System.out.println(sec + " seconds");
        System.out.println("The converse of sec to min is: " + minute + " minute");
        System.out.println("The converse of sec to hours is: " + hour + " hour");
        System.out.println("The converse of sec to days is: " + days + " days");
    }
}
