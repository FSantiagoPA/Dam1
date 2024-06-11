package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

import java.util.Arrays;

/**
 * Clase que representa una Fila de una Zona
 */
public class Fila {
    /** Atributos */
    private final int numero;
    private final Asiento[] asientos;

    /**
     * Crea un Fila con el número indicado.
     * Inicializa todos los Asientos de la Fila
     * @param numero Número de la Fila
     */
    public Fila(int numero) {
        this.numero = numero;
        this.asientos = new Asiento[Estadio.ASIENTOS_POR_FILA];
        for(int i = 1; i <= Estadio.ASIENTOS_POR_FILA; i++) {
            this.asientos[i - 1] = new Asiento(i);
        }
    }

    public int getNumero() {
        return numero;
    }

    public Asiento[] getAsientos() {
        return asientos;
    }

    @Override
    public String toString() {
        return "Fila{" +
                "numero=" + numero +
                ", asientos=" + Arrays.toString(asientos) +
                '}';
    }
}