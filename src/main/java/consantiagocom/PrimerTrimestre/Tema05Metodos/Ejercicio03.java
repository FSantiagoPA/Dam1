package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Variables
        int x,y;

        //Pedimos los datos
        System.out.println("Ingresa un digito");
        x = scanner.nextInt();
        System.out.println("Ingresa otro digito");
        y = scanner.nextInt();

        //llamamos el metodo
        System.out.println(maximo(x,y));
    }
    public static boolean maximo(int x, int y){
        boolean b = x > y;
        if (b){
            System.out.println("Es mayor");
        }else{
            System.out.println("Es menor");
        }
        return b;
    }
}
