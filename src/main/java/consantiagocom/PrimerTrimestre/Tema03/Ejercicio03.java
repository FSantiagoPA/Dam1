package consantiagocom.PrimerTrimestre.Tema03;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int edad;

        System.out.println("Ingresa una edad");
        edad = s.nextInt();

        if (edad >= 18){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
    }
}
