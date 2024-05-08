package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que muestre los números impares de 1 a 100 indicando al final cuántos hay
en total.
*/

public class Ejercicio04 {
    public static void main(String[] args) {

        int counter = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            if (i % 2 == 0){
                counter++;
            }
        }
        System.out.println("---------------");
        System.out.println("El numero de impares total es: " + counter);
    }
}
