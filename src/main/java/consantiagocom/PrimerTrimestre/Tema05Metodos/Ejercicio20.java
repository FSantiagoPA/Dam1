package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio20 {
    public static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        String fecha;
        boolean fechaValida;
        System.out.println("*** LUCKY NUMBER ***");
        do {
            System.out.print("Indica tu fecha de nacimiento (dd-mm-yyyy): ");
            fecha = lector.nextLine();
            fechaValida = isFechaValida(fecha);
            if(!fechaValida) {
                System.out.println(fecha + " no es una fecha válida");
            }
        } while(!fechaValida);
        System.out.println("El lucky number de " + fecha + " es " + luckyNumber(fecha));
    }

    /**
     * Determina forma "manual" si una fecha es válida.
     *
     * Más adelante lo haremos utilizando SimpleDateFormat
     *
     * @param fecha Fecha a comprobar
     * @return true si la fecha es válida, false en caso contrario
     */
    public static boolean isFechaValida(String fecha) {
        int dia;
        int mes;
        int anyo;
        boolean formatoValido;
        if(fecha.length() == 10) {
            formatoValido = Character.isDigit(fecha.charAt(0)) &&
                    Character.isDigit(fecha.charAt(1)) &&
                    fecha.charAt(2) == '-' &&
                    Character.isDigit(fecha.charAt(3)) &&
                    Character.isDigit(fecha.charAt(4)) &&
                    fecha.charAt(5) == '-' &&
                    Character.isDigit(fecha.charAt(6)) &&
                    Character.isDigit(fecha.charAt(7)) &&
                    Character.isDigit(fecha.charAt(8)) &&
                    Character.isDigit(fecha.charAt(9));
            if(formatoValido) {
                dia = Integer.parseInt(fecha.substring(0,2));
                mes = Integer.parseInt(fecha.substring(3,5));
                anyo = Integer.parseInt(fecha.substring(6,10));
                System.out.println(dia + " " + mes + " " + anyo);
                return dia >= 1 && dia <= 31 && mes >= 1 && mes <=12 && anyo >=1900 && anyo <=2020;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Obtiene el número de la suerte a partir de la fecha indicada
     *
     * @param fecha Fecha a partir de la que obtenemos el número de la suerte
     * @return El número de la suerte calculado
     */
    public static int luckyNumber(String fecha) {
        int res = 0;
        String resString = "";
        for(int i = 0; i < fecha.length(); i++) {
            if(Character.isDigit(fecha.charAt(i))) {
                res +=  Character.getNumericValue(fecha.charAt(i));
            }
        }
        while (res >= 10) {
            resString = String.valueOf(res);
            res = 0;
            for(int i = 0; i < resString.length(); i++) {
                res += Character.getNumericValue(resString.charAt(i));
            }
        }
        return res;
    }
}