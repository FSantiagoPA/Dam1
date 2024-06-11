package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio09 {
    public static void execute() {
        String frase;
        System.out.print("Frase: ");
        frase = Main.lector.nextLine();
        System.out.println(caracteresImpares(frase));
    }

    /**
     * Obtiene los caracteres impares del texto
     *
     * @param texto
     * @return String con los caracteres impares
     */
    public static String caracteresImpares(String texto) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < texto.length(); i += 2) {
            sb.append(texto.charAt(i));
        }
        return sb.toString();
    }
}
