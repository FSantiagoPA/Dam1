package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Random;

public class Ejercicio28 {
    /* En Unicode las letras de la A-Z corresponden a n�meros entre 65 y 90 */
    private static final int A = 65;
    /* Sumamos 1 a 90 para tener en cuenta otra letra, si sale el 91 lo
     * tomaremos como si fu�se la � que es el 209 en Unicode */
    private static final int Z = 90;
    /* Valor en Unicode de la letra � */
    private static final int ENYE = 209;

    public static void execute() {
        final int N_ELEMENTOS = 500;
        char[] v = new char[N_ELEMENTOS];
        rellenarArray(v);
        System.out.println(arrayToString(v));
        mostrarOcurrencias(v);
    }

    /**
     * Genera un array de car�cteres aleatorios.
     * Los car�cteres son generados mediante n�meros aleatorios.
     * En Unicode las letras de la A-Z corresponden a n�meros entre 65 y 90
     * La letra � tiene es el n�mero 209 en Unicode
     * @param vector Vector a rellenar con caracteres
     */
    public static void rellenarArray(char[] vector) {
        int num;
        for(int i = 0; i < vector.length; i++) {
            // 65 -> A
            // 90 -> Z
            // 209 -> �
            // Generamos un n�mero entre 65 y 91
            // De 65 a 90 ser�n las letras normales A..Z en ingl�s pero falta la �
            // Si sale el 91 lo tomaremos como si fu�se la � que es el 209 en Unicode
            num = alea(A, Z + 1);
            if(num == Z + 1) {
                num = ENYE;
            }
            vector[i] = (char)num;
        }
    }

    /**
     * Muestra el n�mero de apariciones de cada car�cter que hay en el vector
     * @param vector Array con los car�cteres
     */
    public static void mostrarOcurrencias(final char[] vector) {
        int[] o = new int[Z + 1 - A + 1];
        int num;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < vector.length; i++) {
            num = vector[i] - A;
            if(num > Z) {
                num = Z + 1 - A;
            }
            o[num]++;
        }
        for(int i = 0; i < o.length; i++) {
            s.setLength(0);
            num = i + A;
            if(num == Z + 1) {
                num = ENYE;
            }
            s.append((char)num).append(" --> ").append(o[i]);
            System.out.println(s.toString());
        }
    }

    /**
     * Obtiene la representaci�n como texto del array v
     * @param v Array a mostrar
     * @result String con la representaci�n de v como texto
     */
    public static String arrayToString(final char[] v) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < v.length; i++) {
            if(i!=0) {
                sb.append(", ");
            }
            sb.append(v[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Genera un n�mero entero aleatorio entre min y max
     * @param min N�mero m�nimo a ser generado
     * @param max N�mero m�ximo a ser generado
     * @return N�mero entero aleatorio generado
     */
    public static int alea(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
