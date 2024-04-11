package consantiagocom.SegundoTrimestre.Tema09;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej1 {

    public Scanner scanner = new Scanner(System.in);

    public Ej1 () {
        solicitarNumero();
    }
    public void solicitarNumero() {

        ArrayList<Integer> num = new ArrayList<>();

        int numSoli = 1;
        while (numSoli >= 0){
            System.out.println("Introduce un numero: ");
            try {
                numSoli = Integer.parseInt(scanner.nextLine());
                num.add(numSoli);
            } catch (NumberFormatException n) {
                System.out.println("Introduce solo numeros por favor");
            }
        }
    }
}
