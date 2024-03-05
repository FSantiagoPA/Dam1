package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Definimos variables
        int a;
        int b;

        //
        System.out.println("Dame un digito");
        a = scanner.nextInt();
        System.out.println("Dame otro digito");
        b = scanner.nextInt();

        System.out.println("El resultado de la suma es: " + suma(a,b));
    }
    public static int suma(int x, int y){
        return x + y;
    }
}
