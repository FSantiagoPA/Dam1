package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int m,n;
        System.out.println("*** CÁLCULO NÚMERO COMBINATORIO ***");
        System.out.print("Introduce el valor de n: ");
        n = Integer.parseInt(lector.nextLine());
        System.out.print("Introduce el valor de m: ");
        m = Integer.parseInt(lector.nextLine());
        System.out.println("El número combinatorio de " + n + " sobre " + m + " es " + numeroCobinatorio(n, m));
        lector.close();
    }

    /**
     * Obtiene el número combinatorio de n sobre m
     * Cantidad de combinaciones que podemos hacer con n elementos tomados de m en m muestras
     * @param n
     * @param m
     * @return long con el número combinatorio obtenido
     */
    public static long numeroCobinatorio(int n, int m) {
        return Ejercicio07.factorial(n) / (Ejercicio07.factorial(m) * Ejercicio07.factorial(n - m));
    }
}
