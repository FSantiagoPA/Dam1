package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio13 {
    public static void execute() {
        final int N_NUMEROS = 10;
        int[] v = new int[N_NUMEROS];
        int num;
        int sum = 0;
        for (int i = 0; i < N_NUMEROS; i++) {
            System.out.print("v[" + i + "] = ");
            num = Main.lector.nextInt();
            Main.lector.nextLine();
            v[i] = num;
            sum += num;
        }
        System.out.println(arrayToString(v));
        System.out.println("Media: " + (float) sum / N_NUMEROS);
    }

    /**
     * Obtiene una representación de los elementos del array como una cadena de caracteres
     * En la librería estándar de Java ya existe un método que hace esta misma función
     * Arrays.toString(array);
     *
     * @param v Array a mostrar
     * @return String con la representación como texto del array
     */
    public static String arrayToString(final int[] v) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < v.length; i++) {
            sb.append(v[i] + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}
