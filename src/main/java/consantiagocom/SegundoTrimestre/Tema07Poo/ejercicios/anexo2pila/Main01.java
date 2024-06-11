package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {

        Pila pila = new Pila(5);
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNext()){
            sb.append(scanner.nextLine());
        }
        String texto = sb.toString();
        texto = texto.replaceAll("\\s+","");
        System.out.println(texto);
    }
}

        //explota(5);
        /*GenericDynamicArray pila = new GenericDynamicArray(5);
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <65; i++) {
            String dato = String.valueOf(r.nextInt(65,90));
            if (r.nextBoolean()){
                System.out.print(dato);
                pila.push(dato);
            }else {
                dato = pila.pop();
                if (dato != null)
                sb.append(dato);
            }
        }
        System.out.println();
        System.out.println(sb.toString());*/
        //////////////
         /* public static int explota(int num){
                int valor = explota(num +1);
                return valor;
            }*/