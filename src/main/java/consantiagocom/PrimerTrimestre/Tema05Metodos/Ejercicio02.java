package consantiagocom.PrimerTrimestre.Tema05Metodos;

/*
Escribe un programa que calcule el área y la longitud de una circunferencia en función del radio
(leído desde teclado). Hay que escribir un método para calcular el área y otro para la longitud
*/

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radio;
        double num;

        System.out.println("Ingresa el radio de la circuferencia");
        radio = scanner.nextDouble();

        System.out.println("Ingresa el diametro de la circuferencia");
        num = scanner.nextDouble();

        System.out.println("El area del circulo sera: " + areaCirculo(radio));
        System.out.println("La longitud del circulo es: " + longitudCirculo(num));

        scanner.close();
    }
    public static double areaCirculo(double radio){
        double operation;
        operation = Math.PI * Math.pow(radio,2);
        return operation;
    }
    public static double longitudCirculo(double num){
        double operation;
        operation = num * Math.PI;
        return operation;
    }

}
