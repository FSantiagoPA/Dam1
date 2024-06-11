package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio02 {
    public static void execute() {
        String frase;
        int vocales = 0;
        int consonantes = 0;
        System.out.println("Dime la frase: ");
        frase = Main.lector.nextLine();

        vocales = contarVocales(frase);
        consonantes = contarConsonantes(frase);

        System.out.printf("Vocales: %d\n", vocales);
        System.out.printf("Consonantes: %d\n", consonantes);
    }


    /**
     * Determina si el caracter c es una vocal
     * @param c
     * @return true si es una vocal, false en caso contrario
     * @since 0.1
     */
    public static boolean esVocal(char c) {
        String vocales = "aáàäåeéèëiíìïoóòöuúùü";
        c = Character.toLowerCase(c);
        return vocales.indexOf(c) >= 0;
    }

    /**
     * Determina si el caracter c es una consonante
     * @param c
     * @return true si es una consonante, false en caso contrario
     * @since 0.1
     */
    public static boolean esConsonante(char c) {
        return (Character.isLetter(c) && !esVocal(c));
    }

    /**
     * Cuenta las vocales que tiene el texto pasado como parámetro
     * @param texto Texto a analizar
     * @return El número de vocales del texto
     * @since 0.1
     */
    public static int contarVocales(String texto) {
        int vocales = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (esVocal(c)) {
                vocales++;
            }
        }
        return vocales;
    }

    /**
     * Cuenta las consonantes que tiene el texto pasado como parámetro
     *
     * @param texto Texto a analizar
     * @return El número de consonantes del texto
     * @since 0.1
     */
    public static int contarConsonantes(String texto) {
        int consonantes = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (esConsonante(c)) {
                consonantes++;
            }
        }
        return consonantes;
    }
}
