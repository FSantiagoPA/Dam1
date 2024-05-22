package consantiagocom.PrimerTrimestre.Tema05Metodos;

/*
Escribe un método que reciba 1 parámetro de tipo entero y calcule el sumatorio hasta el 1 (por
ejemplo, sumatorio(5) = 5 + 4 + 3 + 2 + 1). Después desde el programa principal que solicite un
número al usuario, calcule el sumatorio y muestre su valor por pantalla.
*/


import java.util.Scanner;

public class Ejercicio09 {
    public Ejercicio09(){
        Scanner scanner = new Scanner(System.in);
        int num;

        System.out.println("Ingresa un numero");
        num = scanner.nextInt();

        System.out.println(sumatorio(5));
        System.out.println(sumatorio(5) + num);
        scanner.close();
    }
    public static int sumatorio (int num){
        int resultado = 0;
        for (int i = num; i >= 1; i--) {
         resultado += i;
        }
        return resultado;
    }
}


