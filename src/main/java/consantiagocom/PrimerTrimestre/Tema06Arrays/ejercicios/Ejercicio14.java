package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio14 {
    public enum TipoPosicion {
        PAR, IMPAR, ALL
    }

    public static void execute() {
        final int N_NUMEROS = 10;
        char[] v = new char[N_NUMEROS];
        char c;
        for (int i = 0; i < N_NUMEROS; i++) {
            System.out.print("v[" + i + "] = ");
            c = Main.lector.nextLine().charAt(0);
            v[i] = c;
        }
        System.out.println(arrayToString(v, TipoPosicion.PAR));
        System.out.println(arrayToString(v, TipoPosicion.IMPAR));
        System.out.println(arrayToString(v, TipoPosicion.ALL));
    }

    /**
     * Obtiene una representación del array v como texto.
     * TipoElemento permite indicar que tipo de elementos queremos mostrar:
     * - TipoElemento.PAR muestra los elementos que ocupan posición par
     * - TipoElemento.IMPAR muestra los elementos que ocupan posición impar
     * - TipoElemento.ALL muestra todos los elementos
     *
     * @param v   Array a mostrar
     * @param tipo Tipo de elemento a mostrar
     * @return Representación como texto del array
     */
    public static String arrayToString(final char[] v, TipoPosicion tipo) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        int inicio = tipo == TipoPosicion.PAR || tipo == TipoPosicion.ALL ? 0 : 1;
        int incremento = tipo == TipoPosicion.ALL ? 1 : 2;
        for (int i = inicio; i < v.length; i += incremento) {
            sb.append(v[i] + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}
