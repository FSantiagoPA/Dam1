package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Scanner;
public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int n;
        char c;
        System.out.println("*** CONTADOR DE 4 DÍGITOS ***");
        System.out.print("Indica el número a sustituir: ");
        n = Integer.parseInt(lector.nextLine());
        System.out.print("Indica el carácter de sustitución: ");
        c = lector.nextLine().charAt(0);
        // imprimirContador(n,c);
        System.out.println(generarContador(n, c));
        lector.close();
    }

    /**
     * Imprime una secuencia contadora desde 0-0-0-0 hasta 9-9-9-9
     * donde toda aparición del número indicado en num, es sustituida
     * por el carácter indicado en c
     *
     * @param num Número que va a ser sustituido
     * @param c Carácter por el cual se sustituirá
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
     * devolviéndola como un String, donde toda aparición del número
     * indicado en num, es sustituida por el carácter indicado en c
     *
     * @param num Número que va a ser sustituido
     * @param c Carácter por el cual se sustituirá
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