package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {

        //Creamos las intancias
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Variables
        int cantidadIntentos;
        int numPrueba;
        int numAleatorio = random.nextInt(1,100);
        boolean acertar = false;

        System.out.println("Ingresa el numero de intentos");
        cantidadIntentos = Integer.parseInt(scanner.nextLine());


        do {
            System.out.println("ingrese un numero");
            numPrueba = scanner.nextInt();
            cantidadIntentos--;

            if (numPrueba > numAleatorio) {
                System.out.println("El numero introducido es menor que el numero buscado");
            }
            if (numPrueba < numAleatorio) {
                System.out.println("El numero introducido es mayor que el numero buscado");
            }
            if (numPrueba == numAleatorio){
                System.out.println("Haz acertado el numero" + numAleatorio);
            }

        }while (cantidadIntentos > 0);
        System.out.println("****************");
        System.out.println("Haz perdidio por usar todo tus intentos");
        System.out.println("El numero aleatorio era: " + numAleatorio);
    }
}
