package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

/**
 * Clase que representa un Asiento del Estadio
 */
public class Asiento {
    public static int N_ASIENTOS = 0;
    /** Atributos */
    private final int id;
    private final int numero;

    /**
     * Crea un Asiento con el número indicado
     * @param numero
     */
    public Asiento(int numero) {
        this.id = ++N_ASIENTOS;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asiento asiento = (Asiento) o;
        return id == asiento.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "id=" + id + ", " +
                "numero=" + numero +
                '}';
    }
}