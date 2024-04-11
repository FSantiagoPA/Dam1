package consantiagocom.SegundoTrimestre.Tema09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej2 {
    public Ej2(){

        Scanner lector = new Scanner(System.in);

        int countErrors = 0, countNumbers = 0;
        double[] numbs = new double[10];

        do{
            try{
                System.out.println("Introduce un número: ");
                numbs[countNumbers] = lector.nextDouble();
                countNumbers++;
            } catch (InputMismatchException ime){
                System.out.println("El numero introducido no es válido");
                countErrors++;
            } finally {
                lector.nextLine();
            }

        } while (countNumbers < 10);

        System.out.println("Has introducido " + countErrors + " errores");
        System.out.println("Los números introducidos son: ");
        for (double numb : numbs) {
            System.out.println(numb);
        }
        double max = Integer.MIN_VALUE;
        for (double numb : numbs) {
            if (numb > max){
                max = numb;
            }
        }

        System.out.println("El numero mas alto es " + max);
    }
}
