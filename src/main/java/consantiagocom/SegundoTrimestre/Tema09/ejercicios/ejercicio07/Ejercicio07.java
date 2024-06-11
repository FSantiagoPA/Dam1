package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio07;

public class Ejercicio07 {
    public Ejercicio07() {
        String[] v = {"Alicia", "Juan", "Pedro", null, "Teresa", null};
        mostrarCadenesArray(v);
    }

    public void mostrarCadenesArray(String[] v) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] != null) {
                System.out.println(v[i].charAt(0));
            }
        }
    }
}
