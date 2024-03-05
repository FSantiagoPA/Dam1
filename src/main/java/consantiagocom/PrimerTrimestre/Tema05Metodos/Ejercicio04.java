package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Variables
        int a,b,c,d;
        //Pedimos lo datos

        System.out.println("Ingresa 4 numeros");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        // llamamos al metodo
        System.out.println("el numero mayor es: " + mayor(a,b,c,d));
    }
    public static int mayor(int n1, int n2, int n3, int n4){
        int m1 = n1 > n2 ? n1 : n2;
        int m2 = n3 > n4 ? n3 : n4;
        return m1 > m2 ? m1 : m2;
    }
}
