package consantiagocom.tercertrimestre.tema10.ejercicio09;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyDict {

    //Dictionary
    private final HashMap<String, String> dictionary;

    // Constructor
    public MyDict() {
        this.dictionary = new HashMap<>();
    }

    /**
     * Adds a new word to the dictionary
     * @param word Word to add
     * @param description Translation of the word
     */
    public void addWord(String word, String description) throws KeyAlreadyExistsException {
        if (dictionary.containsKey(word)) {
            throw new KeyAlreadyExistsException("Word already in dictionary");
        } else {
            dictionary.put(word, description);
        }
    }

    /**
     * Modifies the description of the given word
     * @param word Word to modify
     * @param description New description
     */
    public void modifyWord(String word, String description) throws NoSuchElementException{
        if (dictionary.containsKey(word)) {
            dictionary.replace(word, description);
        } else {
            throw new NoSuchElementException("Word not in dictionary");
        }
    }

    /**
     * Deletes the given word from the dictionary
     * @param word Word to delete
     */
    public void deleteWord(String word) throws NoSuchElementException{
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
        } else {
            throw new NoSuchElementException("Word not in dictionary");
        }
    }

    /**
     * Prints the description of the given word
     * @param word Word to search
     * @throws NoSuchElementException if the word is not in the dictionary
     * @return Description of the word
     */
    public String getDescription(String word) throws NoSuchElementException{
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        } else {
            throw new NoSuchElementException("Word not in dictionary");
        }
    }
    public String getRandomWord() {
        int random = (int) (Math.random() * dictionary.size());
        return (String) dictionary.keySet().toArray()[random];
    }
    public String[] getPalbra(){
        Set<String> palabra = dictionary.keySet();
        String [] save = palabra.toArray(new String[0]);
        return save;

    }
    /**
     * Prints the dictionary
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : dictionary.keySet()) {
            sb.append(key).append(" = ").append(dictionary.get(key)).append("\n");
        }
        return sb.toString();
    }
}
