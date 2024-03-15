package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.Ejercicio05;

import java.util.Random;

public class AdivinarNumero {
    private static final int MAX_INTENTOS = 5;
    public int numIntentos = MAX_INTENTOS;
    public int numAdivinar;

    public AdivinarNumero() {
        reinicar();
    }

    public void reinicar() {
        numIntentos = MAX_INTENTOS;
        numAdivinar = new Random().nextInt(101);
    }

    public int intentoAdivinar(int guess) {
        if (guess == numAdivinar) {
            return 0; // Ganas
        } else {
            numIntentos--;
            if (numIntentos == 0) {
                return -1; // Pierdes
            } else {
                return 1; // El juego continua
            }
        }
    }
}
