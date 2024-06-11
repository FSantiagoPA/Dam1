package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio09;

import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Lib;

public class Ejercicio09 {
    public Ejercicio09() {
        int[] v = null;
        int x = -2;
        int alea = Lib.aleatorio(0,2);
        if (alea > 0) {
            v = new int[5];
            for (int i = 0; i < v.length; i++) {
                //Para evitar que se produzca siempre el error de división por 0
                if (x == 0 && alea > 1) {
                    v[i] = 1;
                } else {
                    v[i] = x;
                }
                x++;
            }
        }
        try {
            int tamanyo = v.length;
        } catch (NullPointerException npe) {
            throw new PunteroNuloException("El vector no ha sido inicializado");
        }

        try {
            for (int i = 0; i <= v.length; i++) {
                try {
                    System.out.println(2 / v[i]);
                } catch (ArithmeticException ae) {
                    throw new OperacionAritmeticaException("División por 0");
                }
            }
        } catch (IndexOutOfBoundsException iooe) {
            throw new FueraDeRangoException("Se ha excedido el límite del array");
        }
    }
}
