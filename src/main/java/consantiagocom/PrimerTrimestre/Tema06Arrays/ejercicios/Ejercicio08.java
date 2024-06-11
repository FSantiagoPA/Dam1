package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio08 {
    public static void execute() {
        String frase;
        String[] palabras;
        int tamanyoColumna;
        int nDecimales;
        System.out.print("Frase: ");
        frase = Main.lector.nextLine();
        // Eliminamos los espacios en blanco del principio y del final (si los hay)
        palabras = frase.split("\\s+");
        // Aprovechamos el método {@link Ejercicio05#palabraMasLarga(String)} realizado en el {@link Ejercicio05}
        tamanyoColumna = Ejercicio05.palabraMasLarga(frase).length();
        nDecimales = String.valueOf(tamanyoColumna).length();
        for (String palabra : palabras) {
            System.out.printf("%-" + tamanyoColumna + "s %" + nDecimales + "d\n", palabra, palabra.length());
        }
    }
}
