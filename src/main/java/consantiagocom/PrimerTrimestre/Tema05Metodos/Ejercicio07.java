package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1;

        System.out.println("Ingrese un numero");
        n1 = scanner.nextInt();

        System.out.println(factorial(n1));
    }
    public static int factorial(int n){
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }
}
