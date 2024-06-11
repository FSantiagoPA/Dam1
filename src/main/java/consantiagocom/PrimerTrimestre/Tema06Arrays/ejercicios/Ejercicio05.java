package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio05 {
    public static void execute() {
        String frase;
        System.out.print("Frase: ");
        frase = Main.lector.nextLine();
        String masLarga = palabraMasLarga(frase);
        System.out.printf("La palabra más larga es %s y tiene %d caracteres\n", masLarga, masLarga.length());
        System.out.println("");
    }

    /**
     * Determina cual es la palabra más larga de la frase
     *
     * @param frase
     * @return La palabra más larga
     */
    public static String palabraMasLarga(String frase) {
        String[] palabras = frase.split("\\s+");
        String masLarga = "";
        for (int i = 0; i < palabras.length; i++) {
            if (masLarga.length() < palabras[i].length()) {
                masLarga = palabras[i];
            }
        }
        return masLarga;
    }
}