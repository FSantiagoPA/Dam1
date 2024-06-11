package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio15 {
    public static void execute() {
        final int N_NUMEROS = 20;
        final int N_COLUMNAS = 4;
        int[] v = new int[N_NUMEROS];
        int num;
        for (int i = 0; i < N_NUMEROS; i++) {
            System.out.print("v[" + i + "] = ");
            num = Main.lector.nextInt();
            Main.lector.nextLine();
            v[i] = num;
        }
        System.out.println(arrayToStringTabuladoMejorado(v, N_COLUMNAS));
    }

    /**
     * Muestra el Array v en nColumnas de forma tabulada.
     * Esta versi�n no tiene en cuenta el n�mero de digitos que tiene los n�meros
     * por lo que si se introduce un n�mero muy grande se ver� mal.
     *
     * @param v Array a mostrar
     * @param nColumnas N�mero de columnas que mostrar�
     * @return String con la representaci�n del array como texto
     */
    public static String arrayToStringTabulado(final int[] v, int nColumnas) {
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        for (int i = 0; i < v.length; i++) {
            sb.append(v[i] + "\t");
            cont++;
            if (cont == nColumnas) {
                sb.append("\n");
                cont = 0;
            }
        }
        return sb.toString();
    }

    /**
     * Muestra el Array v en nColumnas de forma tabulada.
     * Esta versi�n mira antes cual es el tama�o m�nimo de columna, es decir,
     * el n�mero del array que tiene m�s d�gitos.
     *
     * @param v Array a mostrar
     * @param nColumnas N�mero de columnas que mostrar�
     */
    public static String arrayToStringTabuladoMejorado(final int[] v, int nColumnas) {
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        int maxArray = String.valueOf(maxArray(v)).length();
        int minArray = String.valueOf(minArray(v)).length();
        int anchoTabulacion = Math.max(maxArray, minArray) + 1;

        System.out.println(anchoTabulacion);
        for (int i = 0; i < v.length; i++) {
            sb.append(String.format("%" + anchoTabulacion + "d", v[i]));
            cont++;
            if (cont == nColumnas) {
                sb.append("\n");
                cont = 0;
            }
        }
        return sb.toString();
    }

    /**
     * Obtiene el menor elemento del array
     *
     * @param v array
     * @return El elemento m�s peque�o del array
     */
    public static int minArray(final int[] v) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < v.length; i++) {
            if (v[i] < min)
                min = v[i];
        }
        return min;
    }

    /**
     * Obtiene el elemento m�s grande del array
     *
     * @param v array
     * @return El elemento m�s grande del array
     */
    public static int maxArray(final int[] v) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > max)
                max = v[i];
        }
        return max;
    }
}
