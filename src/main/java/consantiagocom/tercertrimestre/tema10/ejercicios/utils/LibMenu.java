package consantiagocom.tercertrimestre.tema10.ejercicios.utils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

public class LibMenu {
    /*public LibMenu(String[] option, Object[] choice, String[] SubOption, Object[] subChoice, int submenu) throws IOException {
        int opt,opt2;
        StringWriter sw = new StringWriter();
        final int  EXIT = option.length-1;
        final int  EXIT2 = SubOption.length-1;
        OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
            do {
                display(option);
                opt = LibMethods.scanInt();
                opt = opt - 1;
                streamWriter.write((String) choice[opt]);
                streamWriter.flush();
                if(opt == submenu){
                    do {
                        display(SubOption);
                        opt2 = LibMethods.scanInt();
                        opt2 = opt2 - 1;
                        streamWriter.write((String) subChoice[opt2]);
                        streamWriter.flush();
                    }while(opt2 != EXIT2);
                }

            }while(opt != EXIT);
    }*/

    public LibMenu(String[] option, Object[] choice)  {
        int opt = 0;
        StringWriter sw = new StringWriter();
        final int  EXIT = option.length-1;
        OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
        do {
            display(option);
            try{
                opt = LibMethods.scanInt();
                opt = opt - 1 ;
                System.out.println((String) choice[opt]);
                System.out.println("\n");

            }catch (Exception e){
                System.out.println("Error incorrect data entered");
                System.out.println("\n");
            }

        }while(opt != EXIT);

    }

    private void display(String[] option){
        OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
        for(int i = 0; i < option.length; i++){
            System.out.println(option[i]);
            System.out.println("\n");
        }

    }
}
