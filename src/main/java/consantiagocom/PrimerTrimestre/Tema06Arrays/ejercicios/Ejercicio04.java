package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio04 {
    public static void execute() {
        String frase;
        String[] palabras;
        System.out.print("Dime la frase: ");
        frase = Main.lector.nextLine();
        // Eliminamos los espacios en blanco del principio y del final (si los hay)
        frase = frase.trim();
        // Dividimos la frase en palabras tomando como separador uno o varios espacios en blanco seguidos
        palabras = frase.split("\\s+");
        for (int i = 0; i < palabras.length; i++) {
            // Reutilizamos los métodos desarrollados en el {@link Ejercicio02}
            int vocales = Ejercicio02.contarVocales(palabras[i]);
            int consonantes = Ejercicio02.contarConsonantes(palabras[i]);
            System.out.println("--------------------");
            System.out.printf("Palabra: %s\n", palabras[i]);
            System.out.printf("  Vocales: %d\n", vocales);
            System.out.printf("  Consonantes: %d\n", consonantes);
        }
    }
}
