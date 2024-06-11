package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio05;

import java.util.Random;


public class GuessTheNumber {
    public enum AttemptResult {
        LOWER, GREATER, YOU_WIN, YOU_LOSE
    }
    private final int minNumber;
    private final int maxNumber;
    private final int maxAttempts;
    private int currentAttempts;
    private int currentNumber;
    private final Random random;
    public GuessTheNumber(int minNumber, int maxNumber, int maxAttempts) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.maxAttempts = maxAttempts;
        random = new Random();
        init();
    }

    public void init() {
        this.currentAttempts = maxAttempts;
        this.currentNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

    public AttemptResult attempt(int number) {
        if (currentAttempts > 0) {
            currentAttempts--;
            if (number == currentNumber) {
                return AttemptResult.YOU_WIN;
            }
            if (currentAttempts == 0) {
                return AttemptResult.YOU_LOSE;
            } else if (currentNumber > number) {
                return AttemptResult.GREATER;
            } else {
                return AttemptResult.LOWER;
            }
        }
        return AttemptResult.YOU_LOSE;
    }
    public int getCurrentNumber() {
        return currentNumber;
    }

    public int getCurrentAttempts() {
        return currentAttempts;
    }
}
