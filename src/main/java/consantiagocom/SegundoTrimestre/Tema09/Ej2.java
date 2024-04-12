package consantiagocom.SegundoTrimestre.Tema09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej2 {

    // Escáner estático para evitar crear uno nuevo cada vez que necesitemos leer un número
    private static final Scanner scanner = new Scanner(System.in);
    public Ej2() {
        soliNumbers();
    }
    public void soliNumbers() {
        //creamos 2 contadores uno para los errores y otro para los numeros ingresados
        int countErrors = 0, countNumbers = 0;
        //iniciamos una array con un capacidad de 10
        double[] numbers = new double[10];

        //hacemos un bucle para que se repita 10 veces
        do {
            try {
                System.out.println("Enter a number");
                numbers[countNumbers] = Double.parseDouble(scanner.nextLine());
                countNumbers++;
            } catch (NumberFormatException n) {
                System.out.println("Enter numbers only!!");
                countErrors++;
            }

        } while (countNumbers < 10);

        System.out.println("You have entered " + countErrors + " mistakes");

        //Si hay números en Array, busca el más grande
        double max = Double.MIN_VALUE;
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println("El numero mas grande es: " + max);
    }
}

