package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio04;

import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Lib;
import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Log;

import java.util.Arrays;

public class Ejercicio04 {
    public Ejercicio04() {
        int[] v = null;
        // Una tercera parte de las veces (en promedio) provocamos que se produzca un NullPointerException
        int alea = Lib.aleatorio(0,2);
        if (alea > 0) {
            v = new int[5];
        }
        try {
            solicitarNumeros(v);
            // Este tipo de Exceptions no deberían ser capturadas
            // Son errores del programador y deberían ser visibles
        } catch (ArrayIndexOutOfBoundsException ioobe) {
            Log.e("No hay suficiente espacio en el array");
            System.out.println(Arrays.toString(v));
        } catch (NullPointerException npe) {
            Log.e("El array no ha sido inicializado");
        }
    }

    public void solicitarNumeros(int[] array) throws ArrayIndexOutOfBoundsException, NullPointerException {
        String s = "";
        // Provocamos el ArrayIndexOutOfBoundsException llegando hasta la longitud del array
        for (int i = 0; i <= array.length; i++) {
            try {
                System.out.print("Introduzca el número " + (i+1) + ": ");
                int x = Integer.parseInt(Lib.lector.nextLine());
                array[i] = x;
            } catch (NumberFormatException nfe) {
                Log.e(s + " no es un número válido");
            }
        }
    }
}
