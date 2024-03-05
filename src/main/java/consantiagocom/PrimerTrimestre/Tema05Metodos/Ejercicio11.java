package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio11 {
    public static final int UNO = 1;
    public static final int DOS = 2;
    public static final int X = 3;
    public static void main(String[] args) {
        for(int i = 1; i <= 15; i++) {
            System.out.printf("Partido%02d %4s\n", i, resultado());
        }
    }
    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
    public static String resultado(){
        int resultado = aleatorio(1,3);
        String resultadoStr = String.valueOf(resultado);
        if (resultado == 3) {
            resultadoStr = "X";
        }
        return resultadoStr;
    }

}
