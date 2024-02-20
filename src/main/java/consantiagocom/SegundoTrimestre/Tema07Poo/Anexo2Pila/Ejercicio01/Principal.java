package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio01;

import java.util.Scanner;

public class Principal {
    private final String texto;
    public Principal(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stb = new StringBuilder();

        while (scanner.hasNext()) {
            stb.append(scanner.nextLine()).append(" ");
        }
        String texto  = stb.toString();
        this.texto = texto.replaceAll("\\s+", " ");

    }
    public String getTexto() {
        return texto;
    }
}
