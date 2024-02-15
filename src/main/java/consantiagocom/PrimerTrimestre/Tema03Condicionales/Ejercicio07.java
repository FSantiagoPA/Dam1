package consantiagocom.PrimerTrimestre.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        final float CUOTABASE = 500f;
        int descuento = 0;
        int edad;
        char socios;
        float cuotaFinal;


        System.out.println("Ingresa un edad");
        edad = Integer.parseInt(s.nextLine());

        if (edad >= 65){
            descuento = 50;
        } else if (edad > 18) {
            descuento = 25;
        }
        System.out.println("Eres socio del club? (Y/N): ");
        socios = s.nextLine().toLowerCase().charAt(0);
        if (socios == 'y'){
            descuento = 35;
        }
        cuotaFinal = CUOTABASE - (CUOTABASE * descuento)/100;
        System.out.println("La cuota final a pagar del club de golf es de " + cuotaFinal + " €");
        s.close();
    }
}
