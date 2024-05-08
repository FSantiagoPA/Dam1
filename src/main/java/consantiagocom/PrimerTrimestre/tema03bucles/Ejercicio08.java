package consantiagocom.PrimerTrimestre.tema03bucles;

/* Escribe un programa que calcule el factorial de un número. Ejemplo: 5! = 5 * 4 * 3 * 2 * 1 = 120 */


public class Ejercicio08 {
    public static void main(String[] args) {

        int total = 1;

        for (int i = 5; i >= 1; i--) {
            total *= i;
        }
        System.out.println("El factorial de 5! es: " + total);
    }
}
