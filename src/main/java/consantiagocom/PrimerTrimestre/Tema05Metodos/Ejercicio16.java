package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int n;
        char c;
        System.out.println("*** CONTADOR DE 4 D�GITOS ***");
        System.out.print("Indica el n�mero a sustituir: ");
        n = Integer.parseInt(lector.nextLine());
        System.out.print("Indica el car�cter de sustituci�n: ");
        c = lector.nextLine().charAt(0);
        // imprimirContador(n,c);
        System.out.println(generarContador(n, c));
        lector.close();
    }

    /**
     * Imprime una secuencia contadora desde 0-0-0-0 hasta 9-9-9-9
     * donde toda aparici�n del n�mero indicado en num, es sustituida
     * por el car�cter indicado en c
     *
     * @param num N�mero que va a ser sustituido
     * @param c Car�cter por el cual se sustituir�
     */
    public static void imprimirContador(int num, char c) {
        String numStr = String.valueOf(num);
        String charStr = String.valueOf(c);
        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= 9; k++) {
                    for(int l = 0; l <= 9; l++) {
                        String aux = i + "-" + j + "-" + k + "-" + l;
                        System.out.println(aux.replaceAll(numStr, charStr));
                    }
                }
            }
        }
    }

    /**
     * Genera una secuencia contadora desde 0-0-0-0 hasta 9-9-9-9
     * devolvi�ndola como un String, donde toda aparici�n del n�mero
     * indicado en num, es sustituida por el car�cter indicado en c
     *
     * @param num N�mero que va a ser sustituido
     * @param c Car�cter por el cual se sustituir�
     * @return La secuencia contadora generada
     */
    public static String generarContador(int num, char c) {
        String numStr = String.valueOf(num);
        String charStr = String.valueOf(c);
        String secuencia = "";
        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= 9; k++) {
                    for(int l = 0; l <= 9; l++) {
                        String aux = i + "-" + j + "-" + k + "-" + l + "\n";
                        secuencia += aux.replaceAll(numStr, charStr);
                    }
                }
            }
        }
        return secuencia;
    }
}