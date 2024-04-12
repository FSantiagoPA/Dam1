package consantiagocom.SegundoTrimestre.Tema09;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej03 {
    private static final Scanner lector = new Scanner(System.in);

    public Ej03(){
        //declaraci�n de variables
        //Creando ArrayList debido a que no sabemos cu�ntos n�meros se introducir�n

        ArrayList<Integer> numbers = new ArrayList<>();

        //Bucle while para seguir pidiendo n�meros hasta que se introduzca uno no v�lido

        while (true){
            try{
                //Intenta agregar el n�mero a ArrayList
                numbers.add(readInt("Introduce un numero: "));

                //Si el n�mero no es v�lido, rompe el ciclo
            } catch (InputMismatchException e) {
                System.out.println("Numero invalido introducido");
                System.out.println("Rompiendo bucle");
                break;
            }
        }
        //Si hay n�meros en ArrayList, busca el m�s grande
        if (numbers.size() > 0) {  // o se puede expresar de esta forma tambien !numbers.isEmpty()
            int max = numbers.get(0);
            for (int i : numbers){
                if (i > max)
                    max = i;
            }

            System.out.println("El numero mas grande es: " + max);

            // Si no hay n�meros, imprime un mensaje
        } else {
            System.out.println("No se han introducido numeros");
        }
    }

    /**
     *M�todo para leer un n�mero entero desde la consola
     * @param mensaje Mensaje personalizado para mostrar al usuario
     * @return El n�mero entero le�do desde la consola
     * @throws InputMismatchException Si la entrada no es un n�mero entero
     */
    public int readInt(String mensaje) throws InputMismatchException{
        System.out.println(mensaje);
        return lector.nextInt();
    }
}


