 package consantiagocom.PrimerTrimestre.Tema03Bucles;

public class Ejercicio05 {
    public static void main(String[] args) {

        int sumaPares = 0;
        int sumaImpares = 0;
        int sumaMultiplosDeCinco = 0;
        int numeroPares = 0;
        int numeroImpares = 0;
        int numeroMultiplosDeCinco = 0;

        for (int i = 1; i <=100; i++) {
            if (i %2 == 0){
                numeroPares++;
                sumaPares += i;
                System.out.println("Numero pares: " + i);
                System.out.println();
            }else {
                numeroImpares++;
                sumaImpares +=i;
                System.out.println("Numero impares: " + i);
                System.out.println();
            }
            if (i %5 ==0){
                numeroMultiplosDeCinco++;
                sumaMultiplosDeCinco +=i;
                System.out.println("Numeros multiplos de cinco: " + i);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Numero total de pares: " + numeroPares);
        System.out.println("Suma numero pares: " + sumaPares);
        System.out.println("Numero total de impares: " + numeroImpares);
        System.out.println("Suma numero impares: " + sumaImpares);
        System.out.println("Numero total de multiplos de cinco: " + numeroMultiplosDeCinco);
        System.out.println("Suma de multiplos de cinco: " + sumaMultiplosDeCinco);


    }
}
