package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio05;

public class Alumno {
    private final String nom;
    private final int edad;
    private final float estatura;

    public Alumno(String nom, int edad, float estatura) {
        this.nom = nom;
        this.edad = edad;
        this.estatura = estatura;
    }

    public String getNom() {
        return nom;
    }

    public int getEdad() {
        return edad;
    }

    public float getEstatura() {
        return estatura;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nom='" + nom + '\'' +
                ", edad=" + edad +
                ", estatura=" + estatura +
                '}';
    }
}
