package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que solicite un n�mero entero e indique si se trata de un n�mero primo o no
*/

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int n;
        int contador = 2;
        boolean esPrimo = true;
        System.out.println("*** IDENTIFICACI�N N�MERO PRIMO ***");
        System.out.print("Indica un n�mero: ");
        n = Integer.parseInt(lector.nextLine());
        while(esPrimo && contador < n) {
            if(n % contador == 0) {
                esPrimo = false;
            } else {
                contador++;
            }
        }
        System.out.print("El n�mero " + n);
        if(esPrimo) {
            System.out.println(" es primo");
        } else {
            System.out.println(" no es primo. Por ejemplo es divisible entre " + contador);
        }
        lector.close();
    }
}
