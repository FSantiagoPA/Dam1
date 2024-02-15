package consantiagocom.PrimerTrimestre.Tema03Bucles;

public class Ejercicio04 {
    public static void main(String[] args) {

        int numeroPares = 0;
        for (int i = 1; i <=100; i++) {
            if (i %2==0){
                numeroPares++;
                System.out.println("Numero par " + i);
            }
        }
        System.out.println("el total de pares son " + numeroPares);
    }
}
