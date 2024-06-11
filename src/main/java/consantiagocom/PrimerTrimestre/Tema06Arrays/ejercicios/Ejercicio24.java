package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Random;

public class Ejercicio24 {
    public static void execute() {
        final int N_ELEMENTOS = 10;
        int[] v = new int[N_ELEMENTOS];
        int[] p;
        rellenarArray(v, 0, 50);
        // Utilizamos el m�todo {@link Ejercicio13#arrayToString(int[])} del {@link Ejercicio13} para mostrar el array
        System.out.println(Ejercicio13.arrayToString(v));
        p = generarSumatorio(v);
        System.out.println(Ejercicio13.arrayToString(p));
    }

    /**
     * Rellena el array vector con n�meros enteros aleatorios entre minValue y maxValue
     *
     * @param vector Array a rellenar
     * @param minValue valor aleatorio m�nimo
     * @param maxValue valor aleatorio m�ximo
     */
    public static void rellenarArray(int[] vector, int minValue, int maxValue) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = alea(minValue, maxValue);
        }
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
     * Genera un array de la forma
     * v[0] = v[0]
     * v[1] = v[0] + v[1]
     * v[2] = v[0] + v[1] + v[2]
     * ...
     * v[n] = v[0] + v[1] + v[2] + ... + v[n]
     *
     * @param v Array origen
     * @return Array con los sumatorios
     */
    public static int[] generarSumatorio(final int[] v) {
        int suma = 0;
        int[] w = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            suma += v[i];
            w[i] = suma;
        }
        return w;
    }
}
