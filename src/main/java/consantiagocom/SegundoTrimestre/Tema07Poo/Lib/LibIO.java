package consantiagocom.SegundoTrimestre.Tema07Poo.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LibIO {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Metodo para solicitar String
     * @param mensaje el mensaje a mostrar en pantalla
     * @param min la longitud minima valido del String
     * @param max la longituda maxima valido del String
     * @return el texto(String) que a insertado el usuario (si es valido)
     */
    public static String solicitarString(String mensaje, int min, int max){
        String result;
        boolean valido;
        do {
            System.out.println(mensaje);
            result = scanner.nextLine();
            valido = result.length() >= min && result.length() <= max;

            if (!valido)
                System.err.printf("La longitud debe estar entre %d y %d", min,max);
        }while (!valido);
        return result;
    }

    /**
     * Metodo para solicitar una fecha
     * @param mensaje el mensaje a mostrar en pantalla
     * @param formato el formato a seguir al insertar la fecha
     * @return la fecha insertada del ususario (si es valido)
     */
    public static Date solicitarFechaDate(String mensaje, SimpleDateFormat formato){
        Date fecha = null;
        boolean valido;
        do {
            System.out.println(mensaje);
            String fecharStr = scanner.nextLine();

            try {
                fecha = formato.parse(fecharStr);
            } catch (ParseException e) {}
            valido = fecha != null;
            if (!valido)
                System.out.println("El formato de la fecha no es valido");
        } while (!valido);
        return fecha;
    }

    /**
     * Metodo para solicitar un double
     * @param mensaje el mensaje a mostrar en pantalla
     * @param min el numero minimo valido
     * @param max el numero maximo valido
     * @return el numero(Double) que a insertado el usuario (si es valido)
     */
    public static double solicitarDouble(String mensaje, double min, double max){
        double result;
        boolean valido;

        do {
            System.out.println(mensaje);
            result = Double.parseDouble(scanner.nextLine());
            valido = result >= min && result <= max;
            if (!valido)
                System.err.printf("La longitud tiene que ser entre %s y %s", min,max);
        }while (!valido);
        return result;
    }
}
