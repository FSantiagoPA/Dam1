package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que muestre los números de 1 a 100 e indique a su lado:
a) En todos los casos: si es par o impar
b) Indicar aquellos que sean múltiplos de 5
Al final se se tiene que mostrar un resumen donde aparezca, cuantos números pares hay y su
suma, cuantos números impares hay y su suma y cuantos números múltiplos de 5 hay y su suma.
*/

public class Ejercicio05 {
    public static void main(String[] args) {

        int counterPar = 0;
        int counteruUnpair = 0;
        int counterMulCinco = 0;
        int sumPar = 0;
        int sumUnpair = 0;
        int sumMulCinco = 0;


        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println("Es un numero par: " + i);
                System.out.println();
                counterPar++;
            }else{
                System.out.println("Es un numero impar: " + i);
                System.out.println();
                counteruUnpair++;
            }
            if (i % 5 == 0){
                System.out.println("Multiplos de 5: " + i);
                System.out.println();
                counterMulCinco++;
            }
            sumPar = i + counterPar;
            sumUnpair = i + counteruUnpair;
            sumMulCinco = i + counterMulCinco;
        }
        System.out.println();
        System.out.println("El numero de pares son: " + counterPar);
        System.out.println("El numero de impares son: " + counteruUnpair);
        System.out.println("El numero de multiplo de 5 son: " + counterMulCinco);
        System.out.println();
        System.out.println("La suma de todos los pares son: " + sumPar);
        System.out.println("La suma de todos los impares son: " + sumUnpair);
        System.out.println("La suma de todos los multiplo de 5 son: " + sumMulCinco);

    }
}
