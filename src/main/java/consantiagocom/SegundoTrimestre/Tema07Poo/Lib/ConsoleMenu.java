package consantiagocom.SegundoTrimestre.Tema07Poo.Lib;

import java.util.Scanner;

public class ConsoleMenu {
    public static Scanner scanner = new Scanner(System.in);
    private static final int INICIAL_CAPACITY = 5;
    private final String text;
    private ConsoleMenu[] options;
    private int numOptions;

    /**
     * Constuctor de menus
     * @param text es el titulo del menu a crear
     */
    public ConsoleMenu(String text) {
        this.text = text;
        this.options = null;
        numOptions = 0;
    }

    /**
     * Extender capacidad del menu
     */
    private void extendCapacity(){
        ConsoleMenu[] copy = new ConsoleMenu[options.length * 2];
        for(int i = 0; i < options.length; i++){
            copy[i] = options[i];
        }
        options = copy;
    }

    /**
     * Añadir opcion al menu
     * @param text es el titulo de la opcino que queramos añadir
     * @return la opcion añadida
     */
    public ConsoleMenu addOption(String text){
        if (options == null){
            options = new ConsoleMenu[INICIAL_CAPACITY];
        }
        if (numOptions == options.length){ //El array esta lleno
            extendCapacity();
        }
        ConsoleMenu result = new ConsoleMenu(text);
        options[numOptions] = result;
        numOptions++;
        return result;

    }

    /**
     * Para mostrar el menu
     * @return opcion seleccionada por el usuario
     */
    public int showMenu(){
        boolean valid;
        int option;
        do{
            System.out.println(this);
            option = Integer.parseInt(scanner.nextLine());
            valid = option >= 1 && option <= numOptions;
        }while (!valid);
        return option;
    }

    /**
     * Metodo para pasar el menu a String
     * @return el builder a String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("*** ").append(text).append(" ***\n");
        for(int i = 0; i < numOptions; i++){
            sb.append(i + 1).append(options[i].text).append("\n");
        }
        sb.append("------------------------------\n");
        sb.append("Elige una opcion: \n");
        return sb.toString();
    }
    public String toStringCharacters(){
        String characters = "abcdefghijklmnñopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        sb.append("*** ").append(text).append(" ***\n");
        for(int i = 0; i < numOptions; i++){
            sb.append(characters.charAt(i)).append(options[i].text).append("\n");
        }
        sb.append("------------------------------\n");
        sb.append("Elige una opcion: \n");
        return sb.toString();
    }
}
