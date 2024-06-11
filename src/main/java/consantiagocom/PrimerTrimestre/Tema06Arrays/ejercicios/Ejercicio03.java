package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio03 {
    public static void execute() {
        String frase;
        System.out.print("Frase: ");
        frase = Main.lector.nextLine();
        System.out.println("La frase " + frase + " tiene " + cuentaPalabras(frase) + " palabras");
        System.out.println("La frase " + frase + " tiene " + cuentaPalabrasMejorado(frase) + " palabras");
    }

    /**
     * Cuenta las "palabras" de la frase pasada como parámetro.
     * Esta versión asume que cada texto separado por espacios en blanco es una
     * palabra
     *
     * @param frase La frase a analizar
     * @return El números de palabras de la frase
     */
    public static int cuentaPalabras(String frase) {
        // Eliminamos los espacios en blanco del principio y del final (si los hay)
        frase = frase.trim();
        return frase.split("\\s+").length;
    }

    /**
     * Cuenta las palabras de la frase pasada como parámetro.
     * Esta versión requiere que cara palabra debe empezar por una letra
     *
     * @param frase La frase a analizar
     * @return El números de palabras de la frase
     */
    public static int cuentaPalabrasMejorado(String frase) {
        // Eliminamos los espacios en blanco del principio y del final (si los hay)
        frase = frase.trim();
        // Dividimos la frase en palabras tomando como separador uno o varios espacios en blanco seguidos
        String[] candidatas = frase.split("\\s+");
        int palabras = 0;
        for (int i = 0; i < candidatas.length; i++) {
            if (Character.isLetter(candidatas[i].charAt(0))) {
                palabras++;
            }
        }
        return palabras;
    }
}
