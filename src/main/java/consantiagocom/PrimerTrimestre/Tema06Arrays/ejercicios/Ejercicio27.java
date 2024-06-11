package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Random;

public class Ejercicio27 {
    public static void execute() {
        final int N_ELEMENTOS_V = 50;
        final int N_ELEMENTOS_P = 20;
        int[] v = new int[N_ELEMENTOS_V];
        int[] p = new int[N_ELEMENTOS_P];
        int[][] m;
        Ejercicio24.rellenarArray(v, 1, 10);
        Ejercicio24.rellenarArray(p, 1, 10);
        System.out.println(Ejercicio13.arrayToString(v));
        System.out.println(Ejercicio13.arrayToString(p));
        m = multiplica(v, p);
        System.out.println(Ejercicio26.matrizToString(m));
    }

    /**
     * Genera un nuevo vector cuyo contenido es el resultado de multiplicar
     * cada elemento del vector v con su correspondiente del vector p
     * @param v Primer array
     * @param p Segundo array
     * @return Array con la multiplicación de v y p
     */
    public static int[][] multiplica(final int[] v, final int[] p) {
        int[][] m = new int[v.length][p.length];
        for(int i = 0; i < v.length;i++) {
            for(int j = 0; j < p.length; j++) {
                m[i][j] = v[i]*p[j];
            }
        }
        return m;
    }

    /**
     * Genera un número entero aleatorio entre min y max
     * @param min Número mínimo a ser generado
     * @param max Número máximo a ser generado
     * @return Número entero aleatorio generado
     */
    public static int alea(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
