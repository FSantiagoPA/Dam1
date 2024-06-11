package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

public class Estadio {
    private final String nombre;
    private final int capacidad;

    public Estadio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estadio estadio = (Estadio) o;

        if (capacidad != estadio.capacidad) return false;
        return nombre.equals(estadio.nombre);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + capacidad;
        return result;
    }

    @Override
    public String toString() {
        return "Estadio{" +
                "nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
