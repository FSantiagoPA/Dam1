package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Random;
import java.util.Scanner;

import java.util.Random;
public class Ejercicio11 {
    public static final int UNO = 1;
    public static final int DOS = 2;
    public static final int X = 3;
    public static void main(String[] args) {
        for(int i = 1; i <= 15; i++) {
            System.out.printf("Partido%02d %4s\n", i, resultadoQuiniela());
        }
    }

    /**
     * Obtiene un número aleatorio entero entre min y max
     * @param min Número mínimo a obtener (incluído)
     * @param max Número máximo a obtener (incluído)
     * @return
     */
    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Obtiene un resultado de la quiniela (1, X, 2) aleatorio
     * @return String con el resultado generado
     */
    public static String resultadoQuiniela() {
        int resultado = aleatorio(1,3);
        String resultadoStr = String.valueOf(resultado);
        if (resultado == 3) {
            resultadoStr = "X";
        }
        return resultadoStr;
    }
}
