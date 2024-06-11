package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio19 {
    public static void execute() {
        final int N_NUMEROS = 100;
        int[] v = new int[N_NUMEROS];
        int num;
        // Generamos el array de 100 n�meros aleatorios
        for (int i = 0; i < N_NUMEROS; i++) {
            num = alea(0, 100);
            v[i] = num;
        }
        // Imprimimos el array
        System.out.println(Arrays.toString(v));
        // Mostramos los que son m�ltiplos de 5
        System.out.println("M�ltiplos de 5");
        System.out.println(Arrays.toString(multiplosDeCinco(v)));
        // Mostramos los que son m�ltiplos de 10
        System.out.println("M�ltiplos de 10");
        System.out.println(Arrays.toString(multiplosDeDiez(v)));
        // Mostramos los que son 0
        System.out.println("Son igual a 0 las siguientes posiciones");
        System.out.println(obtenerValoresCero(v));
    }

    /**
     * Genera un n�mero entero aleatorio entre min y max
     *
     * @param min N�mero m�nimo a ser generado
     * @param max N�mero m�ximo a ser generado
     * @return N�mero entero aleatorio generado
     */
    public static int alea(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Obtiene un String indicando las posiciones del array v que son igual a 0
     *
     * @param v Array que contiene los valores a buscar
     * @result String indicando las posiciones de v que son 0
     */
    public static String obtenerValoresCero(final int[] v) {
        StringBuilder sb = new StringBuilder();
        sb.append("Son 0 = ");
        for (int i = 0; i < v.length; i++) {
            if (v[i] == 0) {
                sb.append("v[").append(i).append("] ");
            }
        }
        return sb.toString();
    }

    /**
     * Obtiene un array con los elementos del array v que son m�ltiplos de 5
     *
     * @param v Array que contiene los valores a buscar
     * @return array con los elementos de v que son m�ltiplos de 5
     */
    public static int[] multiplosDeCinco(final int[] v) {
        return multiplosDe(v, 5);
    }

    /**
     * Obtiene un array con los elementos del array v que son m�ltiplos del valor indicado
     *
     * @param v Array que contiene los valores a buscar
     * @param multiplo El m�ltiplo
     * @return array con los elementos de v que son m�ltiplos de multiplo
     */
    public static int[] multiplosDe(final int[] v, int multiplo) {
        int[] resultado;
        int multiplosCount = 0;

        for (int i = 0; i < v.length; i++) {
            if (v[i] % multiplo == 0) {
                multiplosCount++;
            }
        }
        resultado = new int[multiplosCount];
        int j = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] % multiplo == 0) {
                resultado[j] = v[i];
                j++;
            }
        }
        return resultado;
    }

    // Lo ideal hubiera sido un m�todo que le pas�ramos como par�metro
    // el m�ltiplo a buscar, de esta forma con un m�todo valdr�a para
    // los m�ltiplos de 5 y de 10. Pero el ejercicio lo pide expresamente
    // en m�todos separados.
    /**
     * Obtiene un array con los elementos del array v que son m�ltiplos de 10
     *
     * @param v Array que contiene los valores a buscar
     * @return array con los elementos de v que son m�ltiplos de 10
     */
    public static int[] multiplosDeDiez(final int[] v) {
        return multiplosDe(v, 10);
    }
}
