package consantiagocom.PrimerTrimestre.tema03bucles.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        float dinero;
        int restante;
        // Monedas de 2 euros (200 c�ntimos)
        int monedas200 = 0;
        // Monedas de 1 euro (100 c�ntimos)
        int monedas100 = 0;
        // Monedas de 50 c�ntimos
        int monedas50 = 0;
        // Monedas de 20 c�ntimos
        int monedas20 = 0;
        // Monedas de 10 c�ntimos
        int monedas10 = 0;
        // Monedas de 5 c�ntimos
        int monedas5 = 0;
        // Monedas de 2 c�ntimos
        int monedas2 = 0;
        // Monedas de 1 c�ntimo
        int monedas1 = 0;
        System.out.print("Introduce la cantidad de euros: ");
        dinero = Float.parseFloat(lector.nextLine());
        // Cerramos el Scanner ya que no lo vamos a usar m�s
        lector.close();
        //Para eliminar los decimales que pueda tener
        restante = (int) (dinero * 100);
        if(restante >= 200) {
            monedas200 = restante / 200;
            restante = restante % 200;
        }

        if(restante >= 100) {
            monedas100 = restante / 100;
            restante = restante % 100;
        }

        if(restante >= 50) {
            monedas50 = restante / 50;
            restante = restante % 50;
        }

        if(restante >= 20) {
            monedas20 = restante / 20;
            restante = restante % 20;
        }

        if(restante >= 10) {
            monedas10 = restante / 10;
            restante = restante % 10;
        }

        if(restante >= 5 ) {
            monedas5 = restante / 5;
            restante = restante % 5;
        }

        if(restante >= 2) {
            monedas2 = restante / 2;
            restante = restante % 2;
        }

        if(restante >= 1) {
            monedas1 = restante;
            restante = 0;
        }

        System.out.println("El m�nimo cambio con monedas de " + dinero + " � son: ");
        System.out.println(monedas200 + " monedas de 2 euros");
        System.out.println(monedas100 + " monedas de 1 euro");
        System.out.println(monedas50 + " monedas de 50 c�ntimos");
        System.out.println(monedas20 + " monedas de 20 c�ntimos");
        System.out.println(monedas10 + " monedas de 10 c�ntimos");
        System.out.println(monedas5 + " monedas de 5 c�ntimos");
        System.out.println(monedas2 + " monedas de 2 c�ntimos");
        System.out.println(monedas1 + " monedas de 1 c�ntimo.");
    }
}
