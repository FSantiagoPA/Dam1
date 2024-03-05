package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int num1,num2,num3,num4;
        boolean validado;

        System.out.println("*** CAPICUA ***");
        do {

            System.out.print("Número 1: ");
            num1 = Integer.parseInt(lector.nextLine());
            validado = num1 >= 0;
            if(!validado) {
                System.out.println("Sólo números positivos");
            }
        } while(!validado);

        do {
            System.out.print("Número 2: ");
            num2 = Integer.parseInt(lector.nextLine());
            validado = num2 >= 0;
            if(!validado) {
                System.out.println("Sólo números positivos");
            }
        } while(!validado);

        do {
            System.out.print("Número 3: ");
            num3 = Integer.parseInt(lector.nextLine());
            validado = num3 >= 0;
            if(!validado) {
                System.out.println("Sólo números positivos");
            }
        } while(!validado);

        do {
            System.out.print("Número 4: ");
            num4 = Integer.parseInt(lector.nextLine());
            validado = num4 >= 0;
            if(!validado) {
                System.out.println("Sólo números positivos");
            }
        } while(!validado);

        if(capicua(num1, num2, num3, num4)) {
            System.out.println("La secuencia " + num1 + "" + num2 + "" + num3 + "" + num4 + " es capicua");
        } else {
            System.out.println("La secuencia " + num1 + "" + num2 + "" + num3 + "" + num4 + " no es capicua");
        }

        lector.close();
    }

    /**
     * Determina si la secuencia de números n1n2n3n4 es capicúa
     * @param n1 Primer número
     * @param n2 Segundo número
     * @param n3 Tercer número
     * @param n4 Cuarto número
     * @return true si la secuencia es capicúa, false en caso contrario
     */
    public static boolean capicua(int n1, int n2, int n3, int n4) {
        String strNumero = String.valueOf(n1) + String.valueOf(n2) +
                String.valueOf(n3) + String.valueOf(n4);
        String strReverse = "";
        for(int i = strNumero.length() - 1; i >= 0; i--) {
            strReverse += strNumero.charAt(i);
        }
        return strNumero.equals(strReverse);
    }

    /**
     * Determina si el número introducido es capicúa
     * @param num Número a comprobar
     * @return true si el número es capicúa, false en caso contrario
     */
    public static boolean capicua(int num) {
        String strNumero = String.valueOf(num);
        String strReverse = "";
        for (int i = strNumero.length() - 1; i >= 0; i--) {
            strReverse += strNumero.charAt(i);
        }
        return strNumero.equals(strReverse);
    }
}
