package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio11 {

    public static void execute() {
        String nombre;
        String apellido1, apellido2;
        String nombreCompleto;
        String nombreCompletoMinusculas;
        System.out.print("Nombre: ");
        nombre = Main.lector.nextLine();
        System.out.print("Apellido1: ");
        apellido1 = Main.lector.nextLine();
        System.out.print("Apellido2: ");
        apellido2 = Main.lector.nextLine();
        nombreCompleto = nombre + " " + apellido1 + " " + apellido2;
        nombreCompletoMinusculas = nombreCompleto.toLowerCase();
        System.out.println(nombreCompletoMinusculas);
        System.out.println(nombreCompleto.toUpperCase());
        System.out.println(nombreCompleto.length());
        if (nombreCompleto.length() >= 5) {
            System.out.println(nombreCompleto.substring(0, 5));
        }
        if (nombreCompleto.length() >= 2) {
            System.out.println(nombreCompleto.substring(nombreCompleto.length() - 2, nombreCompleto.length()));
        }
        System.out.println("Ocurrencias de " + nombreCompleto.charAt(nombreCompleto.length() - 1) +
                ": " + nApariciones(nombreCompleto.charAt(nombreCompleto.length() - 1), nombreCompleto));

        System.out.println(nombreCompletoMinusculas.replace(nombreCompletoMinusculas.charAt(0),
                Character.toUpperCase(nombreCompletoMinusculas.charAt(0))));
        System.out.println("***" + nombreCompleto + "***");
        for (int i = nombreCompleto.length() - 1; i >= 0; i--) {
            System.out.print(nombreCompleto.charAt(i));
        }
        System.out.println("");
    }

    /**
     * Calcula el número de veces que aparece el carácter c en el String s
     *
     * @param c
     * @param s
     * @return Número de veces que se repite el carácter
     */
    public static int nApariciones(char c, String s) {
        int nVeces = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                nVeces++;
            }
        }
        return nVeces;
    }
}
