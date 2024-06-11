package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Arrays;

public class Ejercicio17 {
    public static void execute() {
        float[] v;
        int n;
        float estatura;
        float suma = 0;
        float media;
        System.out.print("Cantidad de estaturas: ");
        n = Main.lector.nextInt();
        Main.lector.nextLine();
        v = new float[n];
        // Solicitamos las estaturas
        for (int i = 1; i <= n; i++) {
            System.out.print("Estatura " + i + ": ");
            estatura = Main.lector.nextFloat();
            Main.lector.nextLine();
            /*
             * Como el bucle empieza en 1, tenemos que restarle 1
             * ya que el vector empieza en 0.
             */
            v[i - 1] = estatura;
            suma += estatura;
        }
        // Calculamos la media
        media = suma / n;

        System.out.println("Media: " + media);
        System.out.println(Arrays.toString(mayoresQue(v, media)));
    }

    /**
     * Obtiene los elementos del Array v que son mayores que x
     * devolviéndolos en un nuevo array
     *
     * @param v Array a buscar
     * @param x valor a partir del cual se mostrarán
     * @return array con los elementos de v mayores que x
     */
    public static float[] mayoresQue(final float[] v, float x) {
        float[] resultado;
        int mayoresCont = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > x) {
                mayoresCont++;
            }
        }
        resultado = new float[mayoresCont];
        int i = 0;
        for (float elem : v) {
            if (elem > x) {
                resultado[i] = elem;
                i++;
            }
        }
        return resultado;
    }
}
