package consantiagocom.tercertrimestre.tema10.ejercicio06;

import consantiagocom.tercertrimestre.tema10.LibMethods;

import java.util.HashMap;

public class Ej06 {

    private HashMap<String,String> Traductor = new HashMap<>();
    public Ej06(){
        int menu;
        int palabras;
        String key;
        String valor;
        do{
            menu();
            menu= LibMethods.scanInt();
            switch (menu){
                case 1:
                    System.out.println("¿Cuantas palabras deseas intruducir?");
                    palabras = LibMethods.scanInt();
                    //A loop to add new elements to hashmap
                    for (int i = 0; i < palabras; i++){
                        key = LibMethods.scanString();
                        valor = LibMethods.scanString();
                        Traductor.put(key,valor);
                    }
                    break;
                case 2:
                    key = LibMethods.scanString();
                    //If key doesn't exist it prints out that there is no such word
                    System.out.println(Traductor.getOrDefault(key, "No hay traduccion para este palabra"));
                    break;
                case 0:
                    break;
                default:
                    break;
            }

        }while(menu!=0);
    }

    public void menu(){
        System.out.println("Menu Principal");
        System.out.println("--------------");
        System.out.println("1. Introducir parejas de palabras.");
        System.out.println("2. Traducir palabras.");
        System.out.println("0. Salir de la aplicación.");
    }
}
