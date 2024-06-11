package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int numero;
        System.out.println("*** FACTORIAL ***");
        System.out.print("Número: ");
        numero = Integer.parseInt(lector.nextLine());
        System.out.println("El factorial de " + numero + " es " + factorial(numero));
        lector.close();
    }

    /**
     * Calcula el factorial de un número entero mayor o igual que 0.
     * @param n Número a calcular
     * @return Factorial de n
     */
    public static long factorial(int n) {
        // Utilizamos un long porque la función factorial crece rápidamente
        long factorial = 1;
        for(int i = n; i >= 1; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
