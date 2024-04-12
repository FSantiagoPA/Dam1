package consantiagocom.SegundoTrimestre.Tema09;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej03 {
    private static final Scanner lector = new Scanner(System.in);

    public Ej03(){
        //declaración de variables
        //Creando ArrayList debido a que no sabemos cuántos números se introducirán

        ArrayList<Integer> numbers = new ArrayList<>();

        //Bucle while para seguir pidiendo números hasta que se introduzca uno no válido

        while (true){
            try{
                //Intenta agregar el número a ArrayList
                numbers.add(readInt("Introduce un numero: "));

                //Si el número no es válido, rompe el ciclo
            } catch (InputMismatchException e) {
                System.out.println("Numero invalido introducido");
                System.out.println("Rompiendo bucle");
                break;
            }
        }
        //Si hay números en ArrayList, busca el más grande
        if (numbers.size() > 0) {  // o se puede expresar de esta forma tambien !numbers.isEmpty()
            int max = numbers.get(0);
            for (int i : numbers){
                if (i > max)
                    max = i;
            }

            System.out.println("El numero mas grande es: " + max);

            // Si no hay números, imprime un mensaje
        } else {
            System.out.println("No se han introducido numeros");
        }
    }

    /**
     *Método para leer un número entero desde la consola
     * @param mensaje Mensaje personalizado para mostrar al usuario
     * @return El número entero leído desde la consola
     * @throws InputMismatchException Si la entrada no es un número entero
     */
    public int readInt(String mensaje) throws InputMismatchException{
        System.out.println(mensaje);
        return lector.nextInt();
    }
}


