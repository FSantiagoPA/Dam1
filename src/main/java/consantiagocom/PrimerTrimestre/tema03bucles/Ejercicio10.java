package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que solicite números hasta que se teclee un 0, mostrar la suma de todos los números introducidos
*/

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        int num;

        do {
            System.out.println("Ingresa un numero");
            num = Integer.parseInt(scanner.nextLine());
            total += num;

        }while (num != 0);

        System.out.println("La suma de todo los numeros ingresado es: " + total);
    }
}
