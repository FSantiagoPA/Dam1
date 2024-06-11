package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio11;

import consantiagocom.tercertrimestre.tema10.ejercicios.utils.LibMethods;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Array;

public class Input {
    public static String inputName(){
        System.out.println("Escibe el nombre");

        String nombre = LibMethods.scanString();
        return nombre;
    }

    public static String idenCode() {
        System.out.println("Escibe el codigo");
        String nombre = LibMethods.scanString();
        return nombre;
    }

    public static String[] inputStringArray(){
        String[]asingaturas = new String[5];
        int loop = 1;
        System.out.println("Intoduce 5 asignaturas para matricular");
        for (int i = 0; i < 5; i++){
            do {
                asingaturas[i] = LibMethods.scanString();
                for (String asingatura : asingaturas) {
                    if (asingatura.equalsIgnoreCase(asingaturas[i])) {
                        System.out.println("Este asignatura ya esta entrada");
                    } else
                        loop = 0;
                }
            }while(loop == 1);

        }
        return asingaturas;
    }
    public static int inputInteger(){
        return LibMethods.scanInt();
    }

}
