package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio22 {
    public static void execute() {
        final int N_ELEMENTOS = 10;
        double[] p = new double[N_ELEMENTOS];

        solicitarArray(p);
        double[] s = mayoresQue(p, 10);
        System.out.println(arrayToString(s));
    }

    /**
     * Solicita al usuario que introduza números reales para el array v
     *
     * @param v Array en el que se guardarán los datos introducidos por el usuario
     */
    public static void solicitarArray(double[] v) {
        System.out.println("Introduce los " + v.length + " elementos del vector");
        for (int i = 0; i < v.length; i++) {
            System.out.print("v[" + i + "] = ");
            v[i] = Main.lector.nextDouble();
            Main.lector.nextLine();
        }
    }

    /**
     * Genera un array s con los valores de p que son mayores que num
     *
     * @param p   Array en el que se buscan los valores
     * @param num Número que marca el valor a partir del cual se guardaran los
     *            valores en el array s
     * @return Array con los elementos p que son mayores que num
     */
    public static double[] mayoresQue(final double[] p, int num) {
        double[] resultado = new double[p.length];
        for (int i = 0; i < p.length; i++) {
            if (p[i] > num) {
                resultado[i] = p[i];
            } else {
                resultado[i] = -1;
            }
        }
        return resultado;
    }

    /**
     * Obtiene una representación del array v como texto
     *
     * @param v Array
     * @return String con la representación de v
     */
    public static String arrayToString(final double[] v) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < v.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(String.format("%.2f", v[i]));
        }
        sb.append("]");
        return sb.toString();
    }
}
