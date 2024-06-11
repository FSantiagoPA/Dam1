package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio02;


import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Lib;
import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Log;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Ejercicio02 {

    public static final int N_ELEMENTOS = 10;
    public Ejercicio02() {
        solicitarNumeros();
    }

    public void solicitarNumeros() {
        double[] v = new double[N_ELEMENTOS];
        int contadorExcepciones = 0;
        for (int i = 1; i <= 10; i++) {
            boolean validado = true;
            do {
                try {
                    System.out.print("Indica el número " + i + ": ");
                    v[i-1] = Double.parseDouble(Lib.lector.nextLine());
                } catch (NumberFormatException nfe) {
                    validado = false;
                    contadorExcepciones++;
                    Log.e(nfe.getMessage());
                }
            } while (!validado);
        }

        System.out.println("NumberFormatException: " + contadorExcepciones);
        System.out.println("Números: " + Arrays.toString(v));
    }
}