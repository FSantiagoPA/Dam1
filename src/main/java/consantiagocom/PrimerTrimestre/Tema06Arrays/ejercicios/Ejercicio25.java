package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Random;

public class Ejercicio25 {
    public static void execute() {
        final int N_ELEMENTOS = 10;
        int[] v = new int[N_ELEMENTOS];
        int[] p;
        // Utilizamos el método {@link Ejercicio24#rellenarArray(int[], int, int)} del {@link Ejercicio24} para rellenar el array
        Ejercicio24.rellenarArray(v, 0, 50);
        // Utilizamos el método {@link Ejercicio13#arrayToString(int[])} del {@link Ejercicio13} para mostrar el array
        System.out.println(Ejercicio13.arrayToString(v));
        p = obtenerPares(v);
        if (p != null) {
            System.out.println(Ejercicio13.arrayToString(p));
        } else {
            System.out.println("El vector v no tiene elementos pares");
        }
    }

    /**
     * Genera un número entero aleatorio entre min y max
     *
     * @param min Número mínimo a ser generado
     * @param max Número máximo a ser generado
     * @return Número entero aleatorio generado
     */
    public static int alea(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Genera un vector con los elementos pares presentes en el array v
     *
     * @param v Array origen
     * @return Array con los elementos pares del array v
     */
    public static int[] obtenerPares(final int[] v) {
        int[] resultado = null;
        int paresCount = 0;
        int j = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                paresCount++;
            }
        }
        if (paresCount > 0) {
            resultado = new int[paresCount];
            for (int i = 0; i < v.length; i++) {
                if (v[i] % 2 == 0) {
                    resultado[j] = v[i];
                    j++;
                }
            }
        }
        return resultado;
    }
}
