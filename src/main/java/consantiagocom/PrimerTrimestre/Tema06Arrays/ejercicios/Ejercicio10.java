package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio10 {
    public static void execute() {
        String palabra;
        String frase;
        System.out.print("Palabra: ");
        palabra = Main.lector.nextLine();
        if (esPalabraPalindroma(palabra)) {
            System.out.println(palabra + " es una palabra pal�ndroma.");
        } else {
            System.out.println(palabra + " no es una palabra pal�ndroma.");
        }
        System.out.print("Frase: ");
        frase = Main.lector.nextLine();
        if (esFrasePalindroma(frase)) {
            System.out.println(frase + " es una frase pal�ndroma.");
        } else {
            System.out.println(frase + " no es una frase pal�ndroma.");
        }
    }

    /**
     * Determina si palabra es una palabra pal�ndroma
     *
     * @param palabra
     * @return true si palabra es pal�ndroma, false en caso contrario.
     */
    public static boolean esPalabraPalindroma(String palabra) {
        palabra = palabra.trim();
        palabra = eliminarAcentos(palabra);
        String palabraReverse = reverse(palabra);
        return palabra.equalsIgnoreCase(palabraReverse);
    }

    /**
     * Invierte una cadena de texto
     * @param s La cadena a invertir
     * @return La cadena invertida
     */
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));

        return sb.toString();
    }

    /**
     * Determina si frase es una frase pal�ndroma
     * @param frase Frase a analizar
     * @return true si frase es pal�ndroma, false en caso contrario.
     */
    public static boolean esFrasePalindroma(String frase) {
        // Eliminamos espacios en blanco
        frase = frase.replaceAll("\\s+", "");
        // Convertimos a min�sculas
        frase = frase.toLowerCase();
        // Eliminamos acentos
        frase = eliminarAcentos(frase);
        String fraseReverse = reverse(frase);
        return frase.equals(fraseReverse);
    }

    /**
     * Elimina los acentos de una frase
     * @param frase La frase a analizar
     * @return La frase sin acentos
     */
    public static String eliminarAcentos(String frase) {
        String origen = "�������i���������";
        String destino = "aaaaeeeiiiiooouuu";
        for (int i = 0; i < origen.length(); i++) {
            frase = frase.replace(origen.charAt(i), destino.charAt(i));
        }
        return frase;
    }
}
