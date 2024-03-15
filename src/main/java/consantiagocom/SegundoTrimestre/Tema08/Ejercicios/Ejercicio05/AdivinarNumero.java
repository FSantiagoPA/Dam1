package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.Ejercicio05;

import java.util.Random;

public class AdivinarNumero {
    private static final int MAX_ATTEMPTS = 5;
    public int numIntentos = MAX_ATTEMPTS;
    public int numAdivinar;

    public AdivinarNumero() {
        reinicar();
    }

    public void reinicar() {
        numIntentos = MAX_ATTEMPTS;
        numAdivinar = new Random().nextInt(101);
    }

    public int intentoAdivinar(int guess) {
        if (guess == numAdivinar) {
            return 0; // Wins the game!
        } else {
            numIntentos--;
            if (numIntentos == 0) {
                return -1; // Loses the game!
            } else {
                return 1; // Game continues
            }
        }
    }
}
