package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio06;

import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Log;

public class Ejercicio06 {
    public Ejercicio06() {
        int[] vector = {-2, -1, 0, 1, 2};
        //dividirEntreArray1(2, vector);
        dividirEntreArray2(2, vector);
        dividirEntreArray3(2, vector);
    }

    public void dividirEntreArray1(int x, int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println(x / vector[i]);
        }
    }

    public void dividirEntreArray2(int x, int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            try {
                System.out.println(x / vector[i]);
                // Este tipo de excepciones no deberían ser capturadas
                // Son fácilmente detectables por el programador
            } catch (ArithmeticException ae) {
                Log.e("División por 0");
            }
        }
    }

    public void dividirEntreArray3(int x, int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if(vector[i] != 0) {
                System.out.println(x / vector[i]);
            }
        }
    }
}
