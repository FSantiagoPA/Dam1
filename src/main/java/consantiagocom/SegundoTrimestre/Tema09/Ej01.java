package consantiagocom.SegundoTrimestre.Tema09;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej01 {

    // Escáner estático para evitar crear uno nuevo cada vez que necesitemos leer un número
    private static final Scanner scanner = new Scanner(System.in);

    public Ej01() {
        solicitarNumero();
    }
    public void solicitarNumero() {

        //Creamos una array list
        ArrayList<Integer> num = new ArrayList<>();

        int numSoli = 1;
        while (numSoli >= 0){
            System.out.println("Introduce un numero: ");
            try {
                numSoli = Integer.parseInt(scanner.nextLine());
                if (numSoli >= 0)
                    num.add(numSoli);
            } catch (NumberFormatException n) {
                System.out.println("Introduce solo numeros por favor");
            }
        }
        System.out.println("Numero almacenados: " + num);
    }
}
