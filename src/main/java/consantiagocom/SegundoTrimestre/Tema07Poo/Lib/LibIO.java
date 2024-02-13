package consantiagocom.SegundoTrimestre.Tema07Poo.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LibIO {

    private static final Scanner s = new Scanner(System.in);
    public static String solicitarString(String mensaje, int min, int max){
        String resultado;
        boolean valido;
        do {
            System.out.println(mensaje);
            resultado = s.next();
            valido = resultado.length() >= min && resultado.length() <= max;
            if (!valido){
                System.err.printf("La longitud debe estar entre %d y %d caracteres\n",min,max);
            }
        }while (!valido);
        return resultado;
    }
    public  static Date solicitarDate(String mensaje, SimpleDateFormat foramto){
        Date fecha = null;
        boolean valido;
        do {
            System.out.println(mensaje);
            String fechaStr = s.nextLine();

            try {
                fecha = foramto.parse(fechaStr);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            valido = fecha != null;
            if (!valido) {
                System.out.println("El formato de la decha no es valido");
            }
        }while (!valido);
        return fecha;
    }
}
