package consantiagocom.SegundoTrimestre.Tema09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej04 {

    // Esc�ner est�tico para evitar crear uno nuevo cada vez que necesitemos leer un n�mero
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
     * Lee n�meros del usuario y los almacena en la array
     * Si el usuario no introduce un n�mero, lanzar� y gestionar� una InputMismatchException
     * Si el usuario introduce m�s n�meros de los que el array puede almacenar, lanzar� y gestionar� una ArrayIndexOutOfBoundsException
     * Si el array es nulo, saldr� del m�todo
     * @param arr Array para almacenar los n�meros
     */
    public void checkArray(int[] arr){
        // Si el array es nulo, salimos del m�todo
        if (arr == null){
            System.out.println("El array no est� inicializado");
            return;
        }

        // Si el array no es nulo, comenzamos a leer n�meros
        int i=0;

        while (true){
            // Intentamos leer un n�mero y almacenarlo en la array
            try{
                arr[i] = readInt("Introduce un n�mero");
                i++;

                // Captura si la usuario no introduce un n�mero
            } catch (InputMismatchException ime){
                System.out.println("No has introducido un n�mero entero");
                lector.nextLine();
                //Detectando si la array est� llena
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("Has introducido demasiados n�meros");
                System.out.println("Saliendo del bucle");
                break;
            }
        }
    }

    /**
     * Lee un n�mero entero del usuario.
     * @param mensaje Mensaje para mostrar al usuario
     * @return El n�mero introducido por el usuario
     * @throws InputMismatchException Si el usuario no introduce un n�mero
     */
    public int readInt(String mensaje) throws InputMismatchException {
        System.out.println(mensaje);
        return lector.nextInt();
    }
}
