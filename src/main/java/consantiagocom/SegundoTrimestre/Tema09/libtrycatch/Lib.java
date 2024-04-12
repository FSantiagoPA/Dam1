package consantiagocom.SegundoTrimestre.Tema09.libtrycatch;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Lib {

    private final static Scanner scanner =new Scanner(System.in);

    /**
     * Lee un n�mero entero introducido por el usuario
     * @param mensaje Mensaje que se muestra al usuario
     * @return N�mero entero introducido por el usuario
     */
    public static int readInt(String mensaje)  {
        while (true) {
            try {
                System.out.println(mensaje);
                return scanner.nextInt();
                // Si el usuario introduce un valor que no es un n�mero, se informa al usuario
                // El programa no se detiene y se vuelve a pedir el n�mero
            } catch (InputMismatchException e) {
                System.out.println("El valor introducido no es un n�mero");
            } finally {
                // Se vac�a el buffer del lector
                scanner.nextLine();
            }
        }
    }
}
