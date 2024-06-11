package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

/**
 * Clase que representa una Entrada Normal
 */
public class EntradaNormal extends Entrada {
    private final int numeroSorteo;

    /**
     * Crea una Entrada para el Partido, Zona, Fila y Asiento indicados
     * @param partido
     * @param zona
     * @param fila
     * @param asiento
     * @throws IllegalArgumentException En caso de que el Asiento esté ocupado
     */
    public EntradaNormal(Partido partido, Zona zona, Fila fila, Asiento asiento) throws IllegalArgumentException {
        super(partido, zona, fila, asiento);
        this.numeroSorteo = partido.getNumeroSorteo();
    }

    public int getNumeroSorteo() {
        return numeroSorteo;
    }

    @Override
    public String toString() {
        return "EntradaNormal{" +
                "id=" + id +
                ", partido=" + partido.getLocal() + " VS " + partido.getVisitante() +
                ", zona=" + zona.getId() +
                ", fila=" + fila.getNumero() +
                ", asiento=" + asiento.getNumero() +
                ", numeroSorteo=" + numeroSorteo +
                ", precio=" + zona.getPrecioBase() +
                '}';
    }
}
