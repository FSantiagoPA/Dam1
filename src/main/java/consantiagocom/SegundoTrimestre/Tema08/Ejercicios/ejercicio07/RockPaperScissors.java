package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio07;

import java.util.Random;

public class RockPaperScissors {
    public enum GameValue {
        ROCK("Piedra"),
        PAPER("Papel"),
        SCISSORS("Tijeras");
        private final String value;
        private final static Random random = new Random();
        GameValue(String value) {
            this.value = value;
        }

        private static GameValue getRandomValue() {
            GameValue[] values = GameValue.values();
            return values[random.nextInt(values.length)];
        }

        public static GameValue fromString(String text) {
            for (GameValue v : GameValue.values()) {
                if (v.value.equalsIgnoreCase(text)) {
                    return v;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    public enum GameResult {
        NONE, PLAYER_WINS, CPU_WINS
    }

    private final int roundsToWin;
    private int playerWins;
    private int CPUWins;
    private int draws;
    private GameValue gameValue;
    private GameResult gameResult;

    public RockPaperScissors(int roundsToWin) {
        this.roundsToWin = roundsToWin;
        newGame();
    }

    public void nextRound() {
        if (!isFinished())
            gameValue = GameValue.getRandomValue();
    }

    public void newGame() {
        gameResult = GameResult.NONE;
        playerWins = 0;
        CPUWins = 0;
        draws = 0;
        nextRound();
    }

    public boolean isFinished() {
        return playerWins == roundsToWin || CPUWins == roundsToWin;
    }

    public GameResult attempt(GameValue bet) {
        if (isFinished())
            return gameResult;

        int winnerIndex = Math.floorMod(bet.ordinal() - 1, GameValue.values().length);
        System.out.println("Winner index: " + winnerIndex);
        GameValue winnerValue = GameValue.values()[winnerIndex];
        if (bet == gameValue) {
            gameResult = GameResult.NONE;
            draws++;
        } else if (gameValue == winnerValue) {
            gameResult = GameResult.PLAYER_WINS;
            playerWins++;
        } else {
            gameResult = GameResult.CPU_WINS;
            CPUWins++;
        }
        return gameResult;
    }

    public int getCPUWins() {
        return CPUWins;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getDraws() {
        return draws;
    }

    public GameValue getValue() {
        return gameValue;
    }
}
