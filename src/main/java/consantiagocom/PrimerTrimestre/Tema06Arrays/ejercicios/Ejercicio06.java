package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

public class Ejercicio06 {
    public static void execute() {
        String frase;
        int nVeces;
        System.out.print("Frase: ");
        frase = Main.lector.nextLine();
        System.out.print("Factor de multiplicación: ");
        nVeces = Main.lector.nextInt();
        Main.lector.nextLine();
        System.out.println(repiteFrase(frase, nVeces));
    }

    /**
     * Repite la frase nVeces veces
     * @param frase
     * @param nVeces
     * @return String con la frase repitida nVeces
     */
    public static String repiteFrase(String frase, int nVeces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nVeces; i++) {
            sb.append(frase).append("\n");
        }
        return sb.toString();
    }
}
