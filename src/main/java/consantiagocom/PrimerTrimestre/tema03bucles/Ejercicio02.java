package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que calcule la suma de los números comprendidos entre 1 y 1000
*/

public class Ejercicio02 {
    public static void main(String[] args) {

        int suma = 0;

        for (int i = 1; i <= 1000; i++){
            suma += i;
        }
        System.out.println("La suma comprendida entre 1 y 1000 es: " + suma);
    }
}
