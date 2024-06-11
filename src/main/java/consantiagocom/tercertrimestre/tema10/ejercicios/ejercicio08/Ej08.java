package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio08;

import consantiagocom.tercertrimestre.tema10.ejercicios.utils.LibMethods;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ej08 {

    public MyDict dict;

    public Ej08() {
        dict = new MyDict();
        Scanner lector = new Scanner(System.in);
        int menu;
        dict.addWord("Hola", "Saludo en español");
        dict.addWord("Adiós", "Despedida en español");
        dict.addWord("Perro", "Animal doméstico que ladra");
        dict.addWord("Gato", "Animal doméstico que maúlla");
        dict.addWord("NIF","Numero de identifiacion familiar");

        do {
            menu();
            menu = LibMethods.scanInt();
            switch (menu) {
                case 1:
                    System.out.println("Introduce la palabra");
                    String word = lector.nextLine();
                    System.out.println("Introduce la descripción");
                    String description = lector.next();
                    try {
                        dict.addWord(word, description);
                    } catch (KeyAlreadyExistsException e) {
                        System.out.println("La palabra ya existe y no se ha añadido");
                    }
                    break;

                case 2:
                    System.out.println("Introduce la palabra");
                    word = lector.nextLine();
                    System.out.println("Introduce la nueva descripción");
                    description = lector.nextLine();
                    try {
                        dict.modifyWord(word, description);
                    } catch (NoSuchElementException e) {
                        System.out.println("La palabra no existe y no se ha modificado");
                    }
                    break;

                case 3:
                    System.out.println("Introduce la palabra");
                    word = lector.nextLine();
                    try {
                        dict.deleteWord(word);
                    } catch (NoSuchElementException e) {
                        System.out.println("La palabra no existe y no se ha eliminado");
                    }
                    break;

                case 4:
                    System.out.println("Introduce la palabra");
                    word = lector.nextLine();
                    try {
                        System.out.println(dict.getDescription(word));
                    } catch (NoSuchElementException e) {
                        System.out.println("La palabra no existe");
                    }
                    break;

                case 5:
                    System.out.println(dict);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while (menu != 0);
    }
    public void menu(){
        System.out.println("Ejercicio05 Ejercicio1");
        System.out.println("--------------");
        System.out.println("1. Introducir parejas de palabras.");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("0. Salir de la aplicación.");
    }
}
