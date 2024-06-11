package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Random;

public class Ejercicio16 {
    public static void execute() {
        final int N_NOTAS = 30;
        double[] v = new double[N_NOTAS];
        double num;
        double sumaCinco = 0, sumaTotal = 0;
        int numCinco = 0;

        // Generamos las notas aleatorias de los alumnos
        for (int i = 0; i < N_NOTAS; i++) {
            num = alea(0, 10);
            v[i] = num;
            // Acumulamos los que suman m�s de 5 para calcular la media de los mayores que 5
            if (num >= 5) {
                sumaCinco += num;
                numCinco++;
            }
            // Acumulados todos para la media general
            sumaTotal += num;
        }
        // Calculamos y mostramos las medias
        System.out.printf("Media de notas >= 5: %.2f\n", sumaCinco / numCinco);
        System.out.printf("Media total: %.2f\n", sumaTotal / N_NOTAS);
    }

    /**
     * Genera un n�mero real aleatorio entre min y max
     *
     * @param min Valor m�nimo generado
     * @param max Valor m�ximo generado
     * @return N�mero real aleatorio
     */
    public static double alea(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
}
