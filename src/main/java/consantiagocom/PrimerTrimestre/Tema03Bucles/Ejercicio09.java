package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a;

        System.out.println("Ingrese un numero entero");
        a = scanner.nextInt();

        if (a >= 0){
            if (a == 2){
                System.out.println("Es un numero primo");
            } else if (a %1 == 0) {
                System.out.println("Es un numero primo");
            }else {
                System.out.println("No es un numero primo");
            }
        }else {
            System.out.println("No es un numero entero");
        }
        System.out.println(a);
    }
}
