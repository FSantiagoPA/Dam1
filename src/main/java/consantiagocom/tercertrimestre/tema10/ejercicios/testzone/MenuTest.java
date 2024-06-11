package consantiagocom.tercertrimestre.tema10.ejercicios.testzone;

import consantiagocom.tercertrimestre.tema10.ejercicios.utils.LibMenu;

import java.io.IOException;

public class MenuTest {
    public static void main(String[] args) throws IOException {


        String [] optionText = {"1- First option","2- Second option","3-Thirds option","4-Exit"};
        Object[] testMethods={ one(), two(), three(),four()};
        new LibMenu(optionText,testMethods);
        //System.out.println(new LibMenu(optionNum,optionText,testMethods));

    }

    public static String one(){
        StringBuilder sb = new StringBuilder();
        sb.append("Option one");
        return sb.toString();
    }

    public static String two(){
        StringBuilder sb = new StringBuilder();
        sb.append("Option two");
        return sb.toString();
    }
    public static String three(){
        StringBuilder sb = new StringBuilder();
        sb.append("Option three");
        return sb.toString();
    }

    public static String four(){
        StringBuilder sb = new StringBuilder();
        sb.append("Exit");
        return sb.toString();
    }
}