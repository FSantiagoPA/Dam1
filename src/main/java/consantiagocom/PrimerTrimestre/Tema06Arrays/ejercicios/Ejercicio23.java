package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Random;

public class Ejercicio23 {
    public static void execute() {
        final int N_ELEMENTOS = 10;
        final double MIN_NUM = 0.0;
        final double MAX_NUM = 50.0;
        double[] v = new double[N_ELEMENTOS];
        double[] p;
        rellenarArray(v, MIN_NUM, MAX_NUM);
        // Utilizamos el método {@link Ejercicio22#arrayToString(double[])} del {@link Ejercicio22} para mostrar el array
        System.out.println(Ejercicio22.arrayToString(v));
        p = ordenInverso(v);
        System.out.println(Ejercicio22.arrayToString(p));
    }

    /**
     * Rellena el array vector con números reales aleatorios
     *
     * @param vector Array a rellenar
     * @param minValue valor aleatorio mínimo
     * @param maxValue valor aleatorio mínimo
     */
    public static void rellenarArray(double[] vector, double minValue, double maxValue) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = alea(minValue, maxValue);
        }
    }

    /**
     * Genera un array a partir del contenido del array vector cuyo
     * contenido es el mismo que vector pero en orden inverso
     *
     * @param vector Array original
     * @return Array invertido
     */
    public static double[] ordenInverso(final double[] vector) {
        int j = 0;
        double[] p = new double[vector.length];
        for (int i = vector.length - 1; i >= 0; i--) {
            p[j] = vector[i];
            j++;
        }
        return p;
    }

    /**
     * Genera un número aleatorio real entre min y max
     *
     * @param min Número mínimo a generar
     * @param max Número máximo a generar
     * @return Número aleatorio generado
     */
    public static double alea(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
}