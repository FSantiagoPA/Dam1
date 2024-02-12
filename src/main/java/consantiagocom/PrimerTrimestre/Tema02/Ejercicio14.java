package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingresa el radio del la circuferencia: ");
        double radio = s.nextDouble();

        double longitud = 2 * Math.PI * radio;
        double area = Math.PI * Math.pow(radio,2);

        System.out.println();
        System.out.println("El radio de la circuferencia es: " + radio);
        System.out.printf("La longitud de la circuferencia es: %.2f \n",longitud);
        System.out.printf("El area del circulo es: %.2f ",area);
    }
}
