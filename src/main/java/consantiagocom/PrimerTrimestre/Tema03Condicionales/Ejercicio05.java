package consantiagocom.PrimerTrimestre.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int calificacion;

        System.out.println("Ingresa una nota a evaluar!");
        calificacion = s.nextInt();
        
        if (calificacion >= 0 && calificacion <= 5){
            System.out.println("Insuficiente");
        } else if (calificacion >= 5 && calificacion <= 6) {
            System.out.println("Suficiente");
        } else if (calificacion >= 6 && calificacion <= 7) {
            System.out.println("Bien");
        } else if (calificacion >= 7 && calificacion <= 9) {
            System.out.println("Notanble");
        } else if (calificacion >= 9 && calificacion <= 10) {
            System.out.println("Sobresaliente");
        } else if (calificacion != 10) {
            System.err.println("ERROR");
        }
    }
}
