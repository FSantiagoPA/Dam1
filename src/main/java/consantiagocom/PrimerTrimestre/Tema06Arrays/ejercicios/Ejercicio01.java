package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio01 {
    public static void execute() {
        String frase;
        System.out.println("Escribe una frase: ");
        frase = Main.lector.nextLine();
        System.out.println(capitalizePhrase(frase));
        System.out.println(capitalizeWords(frase));
    }

    /**
     * Pone la primera letra de la frase en mayúscula
     * @param frase Frase a capitalizar
     * @return Frase capitalizada
     */
    public static String capitalizePhrase(String frase) {
        StringBuilder nuevaFrase = new StringBuilder();
        // Eliminamos los espacios en blanco del principio y del final (si los hay)
        frase = frase.trim();
        // Ponemos la primera letra en mayúscula
        nuevaFrase.append(Character.toUpperCase(frase.charAt(0)));
        // Añadimos el resto de la frase
        nuevaFrase.append(frase.substring(1));
        return nuevaFrase.toString();
    }

    /**
     * Pone la primera letra de cada palabra de la frase en mayúscula
     * @param frase Frase a capitalizar
     * @return Palabras de la frase capitalizadas
     */
    public static String capitalizeWords(String frase) {
        StringBuilder nuevaFrase = new StringBuilder();
        String[] palabras;
        // Eliminamos los espacios en blanco del principio y del final (si los hay)
        frase = frase.trim();
        // Dividimos la frase en palabras tomando como separador uno o varios espacios en blanco seguidos
        palabras = frase.split("\\s+");
        // Para cada palabra
        for (String palabra: palabras) {
            // Ponemos la primera letra en mayúscula
            nuevaFrase.append(Character.toUpperCase(palabra.charAt(0)));
            // Añadimos el resto de la palabra
            nuevaFrase.append(palabra.substring(1));
            nuevaFrase.append(" ");
        }
        return nuevaFrase.toString();
    }
}
