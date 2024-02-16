package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numMultiplicador;

        System.out.print("Ingrese un numero: ");
        numMultiplicador = scanner.nextInt();
        System.out.println("*** Tabla de multiplicar del " + numMultiplicador + " ***");
        if (numMultiplicador >= 0) {
            for (int i = 1; i <= 10; i++) {
                int resultado = numMultiplicador * i;
                System.out.println(numMultiplicador + " * " + i + " = " + resultado);
            }
        }else {
            System.err.println("El numero ingresado no es valido!");
        }

    }
}
