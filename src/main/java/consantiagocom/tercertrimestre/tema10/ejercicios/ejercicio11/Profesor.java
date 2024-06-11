package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio11;

public class Profesor {
    private String dni;
    private String nombre;
    private String sueldo;

    public Profesor(String dni, String nombre, String sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sueldo='" + sueldo + '\'' +
                '}';
    }
}
