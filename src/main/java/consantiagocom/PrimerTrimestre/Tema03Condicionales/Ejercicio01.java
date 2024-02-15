package consantiagocom.PrimerTrimestre.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int num;
        System.out.println("ingrese un numero entero");
        num = s.nextInt();

        if(num % 2 == 0){
            System.out.println("El " + num + " es par");
        }else{
            System.out.println("El " + num + " es impar");
        }
        s.close();
    }
}
