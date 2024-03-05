package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1;

        System.out.println("Ingres un numero");
        n1 = scanner.nextInt();

        System.out.println(sumatorio(n1) + n1);
    }
    public static int sumatorio(int n1){
        int resultado = 0;
        for (int i = 0; i <= n1; i++) {
            resultado += i;
        }
        return resultado;
    }
}
