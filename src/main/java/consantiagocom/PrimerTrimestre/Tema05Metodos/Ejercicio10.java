package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int tabla;
        do {
            System.out.println("*** TABLAS DE MULTIPLICAR ***");
            System.out.print("Tabla del número: ");
            tabla = Integer.parseInt(lector.nextLine());
            if(tabla >= 0) {
                System.out.println(obtenerTabla(tabla));
                // imprimeTabla(tabla);
                System.out.print("Pulsa INTRO para continuar ...");
                lector.nextLine();
                borrarPantalla();
            }
        } while(tabla >= 0);
        System.out.println("Hasta pronto!");
        lector.close();
    }

    /**
     * Obtiene la tabla de multiplicar del número indicado como parámetro
     * Versión reutilizable
     * @param n Tabla a mostrar
     * @return String que contiene la tabla de multiplicar solicitada
     */
    public static String obtenerTabla(int n) {
        String tabla = "";
        for(int i = 0; i <= 9; i++) {
            tabla += n + " x " + i + " = " + n*i + "\n";
        }
        return tabla;
    }

    /**
     * Muestra la tabla de multiplicar del número indicado como parámetro
     * @param n Tabla a mostrar
     */
    public static void imprimeTabla(int n) {
        for(int i = 0; i <= 9; i++) {
            System.out.println(n + " x " + i + " = " + n*i);
        }
    }

    /**
     * Borra la pantalla
     */
    public static void borrarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();;
    }
}