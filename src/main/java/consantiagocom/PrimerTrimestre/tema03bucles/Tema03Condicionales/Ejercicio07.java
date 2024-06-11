package consantiagocom.PrimerTrimestre.tema03bucles.Tema03Condicionales;

import java.util.Scanner;

/*Escribe un programa que calcule la cuota que debe abonarse en el club de golf. La cuota base es
de 500 €. Tendrán un 50% de descuento las personas mayores de 65 años y un 25% los menores
de 18 años si los padres no son socios y el 35% si los padres son socios.*/

public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int CUOTA_BASE = 500;
        char socio;
        int edad;
        float total;
        float descuento = 0;

        System.out.println("Que edad tienes?");
        edad = Integer.parseInt(scanner.nextLine());
        if (edad >= 65){
            descuento = 0.50F;
        } else if (edad < 18) {
            descuento  = 0.25F;
            System.out.print("¿Son socios los padres? (S/N): ");
            socio = scanner.nextLine().toLowerCase().charAt(0);
            if (socio == 's'){
                descuento = 0.35F;
            }
        }
        total = CUOTA_BASE * descuento;
        System.out.println("La cuota a pagar en total es de: " + total);
        scanner.close();
    }
}
