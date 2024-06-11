package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio06;

import consantiagocom.SegundoTrimestre.Tema07Poo.utils.LibIO;
import consantiagocom.tercertrimestre.tema10.ejercicios.utils.LibMethods;

import java.util.HashMap;

public class Ej06 {
    //Inicializamos el HashMap
    private final HashMap<String,String> Traductor = new HashMap<>();

    public Ej06(){
        int menu;
        int palabras;
        String key;
        String value;
        do {
            menu();
            menu = LibMethods.scanInt();
            switch (menu){
                case 1:
                    System.out.println("¿Cuantas palabras deseas intruducir?");
                    palabras = LibMethods.scanInt();
                    for (int i = 0; i < palabras; i++){
                        key = LibIO.solicitarString("Introduce palabra en ingles",1,10);
                        value = LibIO.solicitarString("Introduce traduccion al valencia",1,10);
                        Traductor.put(key,value);
                    }
                    break;
                case 2:
                    key = LibIO.solicitarString("Palabra a buscar",1,10);
                    System.out.println(Traductor.getOrDefault(key, "No hay traduccion para este palabra"));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (menu !=0);
    }
    public void  menu(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("--------------");
        System.out.println("1. Introduce parejas de palabras.");
        System.out.println("2. Traducir palabras.");
        System.out.println("0. Salir de la aplicación.");
    }
}
