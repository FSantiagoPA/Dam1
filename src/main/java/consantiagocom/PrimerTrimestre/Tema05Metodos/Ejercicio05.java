package consantiagocom.PrimerTrimestre.Tema05Metodos;

/*
Escribe un método que acepte dos argumentos: el carácter que se desea imprimir y el número a
veces que se imprime.
*/

import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter;
        int repetitions;

        System.out.println("Que letra desea repetir");
        letter = scanner.nextLine().charAt(0);
        System.out.println("Ingrese el numeo de veces que lo quiere repetir");
        repetitions = Integer.parseInt(scanner.nextLine());
        repetidor(letter,repetitions);
        scanner.close();
    }
    public static void repetidor (char letter , int repetitions){
        for(int i = 1; i <= repetitions; i++){
            System.out.println(letter);
        }

    }
}
