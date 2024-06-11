package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio03;

import java.util.Scanner;

public class Ejercicio03 {
    public Ejercicio03() {
        // Vamos a leer el archivo a parsear desde la entrada est�ndar
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // Mientras haya datos en la entrada est�ndar, los leemos l�nea a l�nea
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();

        CodigoFuenteParser codigoFuenteParser = new CodigoFuenteParser(sb.toString(), "{([", "})]");
        if (codigoFuenteParser.parse(true)) {
            System.out.println("El documento est� bien formado");
        } else {
            System.err.println(codigoFuenteParser.getErrorMessage());
        }
    }
}