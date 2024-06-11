package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio08;

public class Ejercicio08 {
    public Ejercicio08() {
        int x = -2;
        int[] v = null;

        try {
            int tamanyo = v.length;
        } catch (NullPointerException npe) {
            Log.e("El vector no ha sido inicializado");
            v = new int[5];
            for (int i = 0; i < v.length; i++) {
                v[i] = x;
                x++;
            }
        }

        try {
            for (int i = 0; i <= v.length; i++) {
                try {
                    System.out.println(2 / v[i]);
                } catch (ArithmeticException ae) {
                    Log.e("División por 0");
                }
            }
        } catch (IndexOutOfBoundsException iooe) {
            Log.e("Se ha excedido el límite del array");
        }

    }
}

