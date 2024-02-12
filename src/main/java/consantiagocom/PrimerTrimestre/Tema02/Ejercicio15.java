package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        double gradosKelvin = 273.15;
        double gradosFahrenheit = 33;

        System.out.println("Ingresa una temperatura en grados centigrados");
        double celcius = s.nextDouble();

        double convercionKelvin = (celcius * gradosKelvin);
        double convercionFahreheit = (celcius * gradosFahrenheit);

        System.out.println("Grados celcius: " + celcius + "°");
        System.out.printf("Grados Kelvin: %.1f° \n",convercionKelvin);
        System.out.printf("Grados Fahreheit: %.1f° \n",convercionFahreheit);
    }
}
