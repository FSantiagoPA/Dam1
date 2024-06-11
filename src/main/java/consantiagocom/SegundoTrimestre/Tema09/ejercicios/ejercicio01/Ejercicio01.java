package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio01;



import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Lib;
import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Log;

import java.util.Arrays;

public class Ejercicio01 {
    private final static int MAX_CAPACITY = 10;
    public Ejercicio01() {
        int[] a = leerNumeros();
        System.out.println(Arrays.toString(a));
    }

    public int[] leerNumeros() {
        int cont = 0;
        int x;
        boolean salir = false;
        // Creamos el array
        int[] a = new int[MAX_CAPACITY];
        // Inicializamos a -1 los elementos del array
        for (int i = 0; i < a.length; i++) {
            a[i] = -1;
        }
        // Leemos mientras tengamos capacidad y no se haya introducido un número negativo
        do {
            try {
                System.out.println("Indica el número " + (cont+1) + ": ");
                x = Integer.parseInt(Lib.lector.nextLine());
                if (x < 0) {
                    salir = true;
                } else {
                    a[cont] = x;
                    cont++;
                }
            } catch (NumberFormatException nfe) {
                Log.e(nfe.getMessage());
            }
        } while (!salir && cont < a.length);
        return a;
    }
}
