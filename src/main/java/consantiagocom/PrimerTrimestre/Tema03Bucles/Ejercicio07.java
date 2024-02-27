package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base;
        int exponente;
        boolean potenciaNegativo = false;
        double potencia = 1;

        System.out.println("Indica la base");
        base = scanner.nextDouble();
        System.out.print("Indica el exponente: ");
        exponente = scanner.nextInt();
        scanner.close();

        if (exponente < 0){
            potenciaNegativo = true;
            exponente = exponente * (-1);
        }
        for(int i = 1; i <= exponente; i++) {
            potencia = potencia * base;
        }
        if(potenciaNegativo) {
            potencia = 1 / potencia;
        }
        System.out.println("El resultado de " + base + " elevado a " + exponente + " es " + potencia);
    }
}
