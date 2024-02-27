package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num;
        int sum = 0;
        int contador = 0;
        double avg;

        do {
            System.out.println("Ingresa un numero y si quieres para ingresa [-num]");
            num = scanner.nextInt();
            if (num >= 0){
                sum += num;
                contador++;
            }
        }while (num >= 0);
        avg = ((double) sum /2);
        System.out.println("Media de los digios ingresados hasta digitar un numero negativo");
        System.out.println(avg);
    }
}
