package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio09;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class GameManager {

    private final MyDict dict;

    private final HashMap<String,Integer> best5Scores;
    private final Scanner lector;

    // Constructor
    public GameManager(MyDict dict, Scanner lector) {
        this.dict = dict;
        this.lector = lector;
        this.best5Scores = new HashMap<>();
        this.best5Scores.put(" ", 0);
    }

    public void startGame(){
        System.out.println("Juego de adivinar palabras");
        int score = 0;
        while (true){
            String word = dict.getRandomWord();
            System.out.println("�Qu� significa '" + dict.getDescription(word) + "' ?");
            String answer = lector.nextLine();
            if (word.equals(answer)){
                System.out.println("�Correcto!");
                score++;
            } else {
                System.out.println("�Incorrecto!");
                break;
            }
        }
        System.out.println("Has acertado " + score + " palabras");
        if (isBestScore(score)){
            System.out.println("Estas en el top 5 de mejores puntuaciones!");
            insertScore(score);
        }
    }

    private boolean isBestScore(int score){
        for (String key : best5Scores.keySet()){
            if (score > best5Scores.get(key)){
                return true;
            }
        }
        return false;
    }

    private void insertScore(int score){
        Set<String> keySet = best5Scores.keySet();
        System.out.println(keySet.toString());
        System.out.println("Introduce tu nombre: ");
        String name = lector.nextLine();
        Integer lastScore = best5Scores.put(name,score);
        boolean changed = false;
        String lastKey = "";

        for (String key : keySet){
            lastKey = key;

            if (score > best5Scores.get(key)){
                changed = true;
                best5Scores.remove(key);
                best5Scores.put(key, lastScore);
                break;
            }
            else{
                best5Scores.put(lastKey, best5Scores.get(lastKey));
                break;
            }
        }

    }

    public String getBestScores(){
        StringBuilder bestScores = new StringBuilder();
        for (String key : best5Scores.keySet()) {
            bestScores.append(key).append(": ").append(best5Scores.get(key)).append("\n");
        }
        return bestScores.toString();
    }
}
