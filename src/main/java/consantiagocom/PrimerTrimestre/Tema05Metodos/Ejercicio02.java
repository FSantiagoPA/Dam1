package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Variables
        double radio;

        //pedir el radio
        System.out.println("Ingrea el raido del circulo");
        radio = scanner.nextDouble();

        //Llamamos los metodos

        System.out.println("El area el circulo es: " + area(radio));
        System.out.println("La longitud del circulo es: " + longitud(radio));
    }
    public static double area(double radio){
        return Math.PI * Math.pow(radio,2);
    }
    public static double longitud(double radio){
        return 2 * Math.PI * radio;
    }
}
