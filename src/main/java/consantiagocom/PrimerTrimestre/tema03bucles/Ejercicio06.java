package consantiagocom.PrimerTrimestre.tema03bucles;

/*
Escribe un programa que muestre la tabla de multiplicar del número [1-10] que indique el usuario.
Validar la entrada.
*/

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Tabla de multiplicar");
        do {
            System.out.println("Ingresa un numero del [1-10]");
            number = Integer.parseInt(scanner.nextLine());

            if (number >= 1 && number <= 10){
                for (int i = 1; i < 10; i++) {
                    System.out.println(number + "*" + i + " = " + number * i);
                }
            }else{
                System.out.println("Introduzca un numero en ele rango de [1-10]");
            }
        }while (number < 1 || number > 10);
        scanner.close();
    }
}
