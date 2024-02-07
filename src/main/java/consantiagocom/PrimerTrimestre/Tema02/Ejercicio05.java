package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Map;
import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int altura,ancho,perimetro,area;

        System.out.println("Ingresa la altura del rectangulo");
        altura = scanner.nextInt();
        System.out.println("Ingresa el ancho del rectangulo");
        ancho = scanner.nextInt();

        perimetro = (int) Math.pow(altura,2) + (int)Math.pow(ancho,2);
        area = altura * ancho;

        System.out.println("El alto del rectangulo es: " +altura + "cm");
        System.out.println("El ancho del rectangulo es: " +ancho + "cm");
        System.out.println("El perimetro es: "+ perimetro + "cm");
        System.out.println("El area es: " + area + "cm");
    }
}
