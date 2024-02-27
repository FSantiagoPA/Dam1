package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num;
        int sum = 0;
        do {
            System.out.println("Ingresa un numero y si quieres para ingresa [0]");
            num = scanner.nextInt();
            sum += num;
        }while (num != 0);
        System.out.println("Suma de los digios ingresados hasta digitar el numero [0] \n" + sum);
    }
}
