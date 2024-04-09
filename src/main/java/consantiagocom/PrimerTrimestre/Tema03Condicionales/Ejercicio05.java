package consantiagocom.PrimerTrimestre.Tema03Condicionales;

import java.util.Scanner;

public class Ejercicio05 {
    public enum Calificacion {
        INSUFICIENTE,
        SUFICIENTE,
        BIEN,
        NOTABLE,
        SOBRESALIENTE,
        ERROR
    }
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        float notaReal;
        int notaEntera;
        Calificacion nota;
        System.out.print("Escribe la nota obtenida: ");
        notaReal = Float.parseFloat(lector.nextLine());
        lector.close();
        notaEntera = (int) notaReal;
        switch (notaEntera) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                nota = Calificacion.INSUFICIENTE;
                break;
            case 5:
                nota = Calificacion.SUFICIENTE;
                break;
            case 6:
                nota = Calificacion.BIEN;
                break;
            case 7:
            case 8:
                nota = Calificacion.NOTABLE;
                break;
            case 9:
            case 10:
                nota = Calificacion.SOBRESALIENTE;
                break;
            default:
                nota = Calificacion.ERROR;

        }
        System.out.println(notaReal + " es un " + nota + " (" + notaEntera + ")");
    }
}
