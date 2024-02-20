package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio01;

import java.util.Scanner;

public class Principal {
    private final String texto;
    public Principal(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNext()) {
            sb.append(scanner.nextLine()).append(" ");
        }
        String texto  = sb.toString();
        this.texto = texto.replaceAll("\\s+", " ");
    }
    public String getTexto() {
        return texto;
    }
}
