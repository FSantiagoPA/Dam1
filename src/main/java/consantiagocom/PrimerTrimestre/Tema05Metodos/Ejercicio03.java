package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Variables
        int x,y;

        //Pedimos los datos
        System.out.println("Ingresa un digito");
        x = scanner.nextInt();
        System.out.println("Ingresa otro digito");
        y = scanner.nextInt();

        //llamamos el metodo
        System.out.println("El numero mayor entre los 2 es: " + maximo(x,y));
    }
    public static int maximo(int n1, int n2){
        return n1 > n2 ? n1 : n2;
    }
}

