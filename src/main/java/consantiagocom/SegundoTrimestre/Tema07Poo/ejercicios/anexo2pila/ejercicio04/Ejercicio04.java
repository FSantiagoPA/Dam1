package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio04;

import java.util.Scanner;

public class Ejercicio04 {
    public Ejercicio04() {
        // Vamos a leer el archivo a parsear desde la entrada est�ndar
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // Mientras haya datos en la entrada est�ndar, los leemos l�nea a l�nea
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();

        HtmlParser htmlParser = new HtmlParser(sb.toString());
        if (htmlParser.parse()) {
            System.out.println("El documento est� bien formado");
        } else {
            System.err.println(htmlParser.getErrorMessage());
        }

    }
}
