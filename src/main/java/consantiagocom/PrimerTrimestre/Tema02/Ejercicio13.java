package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int dias = 1;
        int hora = 1;
        int minutos = 1;
        int ss = 60;
        System.out.println("Ingrese una cantidad de segundos");
        int segundos = s.nextInt();

        int resultadoMinutos = (segundos * minutos)/ss;
        int resultadoHoras = (segundos * minutos) / ss /60;
        int resultadoDias = (segundos * dias)/86400;

        System.out.println(segundos + " segundos");
        System.out.println(segundos + " segundos " + " equivalen a " + resultadoMinutos + " minutos");
        System.out.println(segundos + " segundos " + " equivalen a " + resultadoHoras + " hora");
        System.out.println(segundos + " segundos " + " equivalen a " + resultadoDias + " dias");

    }
}
