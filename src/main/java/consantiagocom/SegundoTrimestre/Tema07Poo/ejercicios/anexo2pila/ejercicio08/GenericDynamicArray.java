package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio08;

public class GenericDynamicArray<T> {
    /** Capacidad inicial por defecto del array */
    private final static int DEFAULT_CAPACITY = 10;
    /** Factor de crecimiento */
    private final static float GROW_FACTOR = 2f;
    /** Los datos del array */
    private Object[] data;
    /** N�mero de elementos del array */
    private int size;

    /**
     * Crear un array din�mico con la capacidad inicial por defecto
     */
    public GenericDynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Crea un array din�mico con la capacidad inicial indicada
     * @param capacity Capacidad inicial
     */
    public GenericDynamicArray(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    /**
     * Obtiene el elemento que ocupa el �ndice index
     * @param index �ndice del elemento a obtener
     * @return el valor obtenido o ERROR
     */
    public T get(int index) {
        if (index >= size || index < 0)
            return null;
        return (T)data[index];
    }

    /**
     * A�ade el elemento indicado al array
     * @param value Elemento a a�adir
     * @return true
     */
    public boolean add(T value) {
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
    public boolean add(int index, T value) {
        if (index >= size || index < 0)
            return false;
        if (isFull())
            expand();
        moveToRight(index);
        data[index] = value;
        return true;
    }

    /**
     * Establece el valor del elemento con �ndice index
     * @param index �ndice del elemento a modificar
     * @param value Valor que toma el elemento
     * @return true
     */
    public boolean set(int index, T value) {
        if (index >= size || index < 0)
            return false;
        data[index] = value;
        return true;
    }

    /**
     * M�todo de uso interno para ampliar la capacidad del array seg�n el factor de crecimiento
     */
    private void expand() {
        Object[] array = new Object[Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < data.length; i++)
            array[i] = data[i];
        data = array;
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
        return size >= data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++)
            sb.append(data[i]).append(" ");
        sb.append("]");
        return "GenericDynamicArray{" +
                "data=" + sb.toString() +
                ", size=" + size +
                '}';
    }
}