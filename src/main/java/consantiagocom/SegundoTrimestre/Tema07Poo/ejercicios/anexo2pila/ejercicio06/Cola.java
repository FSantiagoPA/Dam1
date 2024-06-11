package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio06;

import consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio01.DynamicArray;

public class Cola {
    /** Capacidad inicial por defecto */
    private static final int INITIAL_CAPACITY = 10;
    /** Valor con el que reconocemos una condici�n de error */
    private final DynamicArray data;

    /**
     * Crea una cola con la capacidad inicial por defecto
     */
    public Cola() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Crea una cola con una capacidad inicial
     * @param initialCapacity Capacidad inicial de la
     */
    public Cola(int initialCapacity) {
        data = new DynamicArray(initialCapacity);
    }

    /**
     * Obtiene el n�mero de elementos que est�n en la cola
     * @return Cantidad de elementos en la cola
     */
    public int size() {
        return data.size();
    }

    /**
     * Determina si la cola est� vac�a
     * @return true si est� vac�a, false en caso contrario
     */
    public boolean isEmpty() {
        return data.size() == 0;
    }

    /**
     * A�ade un elemento al final de la cola
     * @param value Elemento a a�adir
     * @return true
     */
    public boolean add(double value) {
        return data.add(value);
    }

    /**
     * Extrae (eliminando) el primer elemento de la cola
     * @return Elemento extra�do
     */
    public double remove() {
        if (isEmpty())
            return Double.POSITIVE_INFINITY;
        return data.remove(0);
    }

    /**
     * Consulta (sin eliminar) el primer elemento de la cola
     * @return Primer elemento de la cola
     */
    public double peek() {
        if (isEmpty())
            return Double.POSITIVE_INFINITY;
        return data.get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cola cola = (Cola) o;

        return data.equals(cola.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return "Cola " + data;
    }
}
