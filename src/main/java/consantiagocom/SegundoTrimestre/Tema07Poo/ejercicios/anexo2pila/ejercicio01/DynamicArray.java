package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio01;

import java.util.Arrays;

public class DynamicArray {
    /*
      Como a�n no hemos visto las Exception de momento utilizamos el menos infinito para detectar errores
    */
    private static final double ERROR = Double.NEGATIVE_INFINITY;
    /* Capacidad inicial por defecto del array */
    private final static int DEFAULT_CAPACITY = 10;
    /* Factor de crecimiento */
    private final static float GROW_FACTOR = 2f;
    /* Los datos del array */
    private double[] data;
    /* N�mero de elementos del array */
    private int size;

    /**
     * Crear un array din�mico con la capacidad inicial por defecto
     */
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Crea un array din�mico con la capacidad inicial indicada
     * @param capacity Capacidad inicial
     */
    public DynamicArray(int capacity) {
        data = new double[capacity];
        size = 0;
    }

    /**
     * Obtiene el elemento que ocupa el �ndice index
     * @param index �ndice del elemento a obtener
     * @return el valor obtenido o ERROR
     */
    public double get(int index) {
        if (index >= size || index < 0)
            return ERROR;
        return data[index];
    }

    /**
     * A�ade el elemento indicado al array
     * @param value Elemento a a�adir
     * @return true
     */
    public boolean add(double value) {
        if (isFull())
            expand();
        data[size] = value;
        size++;
        return true;
    }


    /**
     * M�todo de uso interno para desplazar los elementos a la derecha a partir del �ndice indicado
     * @param index �ndice a partir del cual se desplazar�n los elementos
     */
    private void moveToRight(int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        size++;
    }


    /**
     * A�ade el elemento indicado al array en la posici�n indicada por index
     * @param index �ndice donde se a�adir� el elemento
     * @param value Elemento a a�adir
     * @return true
     */
    public boolean add(int index, double value) {
        if (index >= size || index < 0)
            return false;
        if (isFull())
            expand();
        moveToRight(index);
        data[index] = value;
        return true;
    }

    /**
     * M�todo de uso interno para desplazar los elementos a la izquierda a partir del �ndice indicado
     * @param index �ndice a partir del cual se desplazar�n los elementos
     */
    private void moveToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * Elimina del array el elemento que ocupa la posici�n desplazando una posici�n a la izquierda
     * todos los elementos que hay a su derecha
     * @param index posici�n a eliminar
     * @return El valor eliminado
     */
    public double remove(int index) {
        if (index >= size || index < 0)
            return ERROR;
        double valor = data[index];
        moveToLeft(index);
        return valor;
    }

    /**
     * Elimina del array la primera ocurrencia del valor indicado como par�metro desplazando una posici�n
     * a la izquierda todos los elementos que haya a su derecha
     * @param value valor a eliminar
     * @return true si se ha borrado el elemento, false en caso contrario
     */
    public boolean remove(double value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                moveToLeft(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Establece el valor del elemento con �ndice index
     * @param index �ndice del elemento a modificar
     * @param value Valor que toma el elemento
     * @return true
     */
    public boolean set(int index, double value) {
        if (index >= size || index < 0)
            return false;
        data[index] = value;
        return true;
    }

    /**
     * M�todo de uso interno para ampliar la capacidad del array seg�n el factor de crecimiento
     */
    private void expand() {
        double[] copy = new double[Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }

    /**
     * Obtiene el n�mero de elementos que hay en el array
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * M�todo de uso interno para determinar si el array est� lleno
     * @return true si est� lleno, false si no lo est�
     */
    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicArray that = (DynamicArray) o;

        if (size != that.size) return false;

        // S�lo tenemos en cuenta los elementos del array que est�n en posiciones v�lidas
        for (int i = 0; i < size; i++) {
            if (data[i] != that.data[i])
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++)
            sb.append(data[i]).append(" ");
        sb.append("]");
        return sb.toString();
    }
}