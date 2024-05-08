package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que solicite un número entero e indique si se trata de un número primo o no
*/

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int n;
        int contador = 2;
        boolean esPrimo = true;
        System.out.println("*** IDENTIFICACIÓN NÚMERO PRIMO ***");
        System.out.print("Indica un número: ");
        n = Integer.parseInt(lector.nextLine());
        while(esPrimo && contador < n) {
            if(n % contador == 0) {
                esPrimo = false;
            } else {
                contador++;
            }
        }
        System.out.print("El número " + n);
        if(esPrimo) {
            System.out.println(" es primo");
        } else {
            System.out.println(" no es primo. Por ejemplo es divisible entre " + contador);
        }
        lector.close();
    }
}
