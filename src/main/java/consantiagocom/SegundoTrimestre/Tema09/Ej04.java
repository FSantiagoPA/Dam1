package consantiagocom.SegundoTrimestre.Tema09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej04 {

    // Escáner estático para evitar crear uno nuevo cada vez que necesitemos leer un número
    private static final Scanner lector = new Scanner(System.in);

    // Constructor
    public Ej04() {

        //Probando con un array de 5 elementos
        int[] arr = new int[5];
        checkArray(arr);

        //Probando con una array nula
        int[] arr2 = null;
        checkArray(arr2);

    }

    /**
     * Lee números del usuario y los almacena en la array
     * Si el usuario no introduce un número, lanzará y gestionará una InputMismatchException
     * Si el usuario introduce más números de los que el array puede almacenar, lanzará y gestionará una ArrayIndexOutOfBoundsException
     * Si el array es nulo, saldrá del método
     * @param arr Array para almacenar los números
     */
    public void checkArray(int[] arr){
        // Si el array es nulo, salimos del método
        if (arr == null){
            System.out.println("El array no está inicializado");
            return;
        }

        // Si el array no es nulo, comenzamos a leer números
        int i=0;

        while (true){
            // Intentamos leer un número y almacenarlo en la array
            try{
                arr[i] = readInt("Introduce un número");
                i++;

                // Captura si la usuario no introduce un número
            } catch (InputMismatchException ime){
                System.out.println("No has introducido un número entero");
                lector.nextLine();
                //Detectando si la array está llena
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("Has introducido demasiados números");
                System.out.println("Saliendo del bucle");
                break;
            }
        }
    }

    /**
     * Lee un número entero del usuario.
     * @param mensaje Mensaje para mostrar al usuario
     * @return El número introducido por el usuario
     * @throws InputMismatchException Si el usuario no introduce un número
     */
    public int readInt(String mensaje) throws InputMismatchException {
        System.out.println(mensaje);
        return lector.nextInt();
    }
}
