package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio12 {
    public static void execute() {
        String frase;
        System.out.print("Frase: ");
        frase = Main.lector.nextLine();
        System.out.println(reemplazarTexto("es", "no por", frase));
        System.out.println(reemplazarNumeros("*", frase));
    }

    /**
     * Reemplaza cada aparici�n de texto por reemplazo
     *
     * @param texto     Texto a ser reemplazado
     * @param reemplazo Texto por el que se reemplazar�
     * @param frase     Frase donde se buscar� el texto
     * @return Frase con el texto reemplazado
     */
    public static String reemplazarTexto(String texto, String reemplazo, String frase) {
        return frase.replace(texto, reemplazo);
    }

    /**
     * Reemplaza los n�meros (de cualquier longitud) que aparezcan en frase
     * por el texto especificado en reemplazo
     *
     * @param reemplazo
     * @param frase
     * @return Frase con los n�meros reemplazados por el texto reemplazo.
     */
    public static String reemplazarNumeros(String reemplazo, String frase) {
        return frase.replaceAll("\\d+", reemplazo);
    }
}
