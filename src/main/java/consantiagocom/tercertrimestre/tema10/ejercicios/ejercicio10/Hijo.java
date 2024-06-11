package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio10;

public class Hijo {
    private final String nombre;
    private final int edad;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Hijo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Hijo{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
