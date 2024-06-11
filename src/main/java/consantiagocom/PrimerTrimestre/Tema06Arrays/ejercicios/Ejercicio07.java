package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio07 {
    public static void execute() {
        String frase;
        String[] palabras;
        System.out.print("Frase: ");
        frase = Main.lector.nextLine();
        // Eliminamos los espacios en blanco del principio y del final (si los hay)
        frase = frase.trim();
        // Dividimos la frase en palabras tomando como separador uno o varios espacios en blanco seguidos
        palabras = frase.split("\\s+");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}