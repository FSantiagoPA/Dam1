package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio02;

public class Pila {
    /** Tama�o inicial por defecto */
    private static final int INITIAL_SIZE = 10;
    /** Factor de crecimiento cada vez que el array requiera ser redimensionado */
    private static final float GROW_FACTOR = 2f;
    /** Valor con el que reconocemos una condici�n de error */
    private static final double ERROR = Double.NEGATIVE_INFINITY;
    /** Array donde se van a guardar los valores de la pila */
    private double[] data;
    /** Tama�o actual de la pila */
    private int size;

    /**
     * Crea una pila con el tama�o inicial por defecto INITIAL_SIZE
     */
    public Pila() {
        this(INITIAL_SIZE);
    }

    /**
     * Crea una pila de tama�o inicial recibido como par�metro
     * @param size Capacidad inicial de la pila
     */
    public Pila(int size) {
        data = new double[size];
        this.size = 0;
    }

    /**
     * A�ade un elemento a la cima de la pila
     * @param e Elemento a a�adir
     */
    public void push(double e) {
        if (isFull()) {
            expand();
        }
        data[size] = e;
        size++;
    }

    /**
     * Expande el tama�o de la pila con el factor de crecimiento indicado por GROW_FACTOR
     */
    private void expand() {
        double[] aux = new double[Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < data.length; i++) {
            aux[i] = data[i];
        }
        data = aux;
    }

    /**
     * Extrae el elemento que ocupa la cima de la pila
     * @return El elemento de la cima o Double.NEGATIVE_INFINITY si la pila est� vac�a
     */
    public double pop() {
        double e = ERROR;
        if (!isEmpty()) {
            e = data[size - 1];
            size--;
        }
        return e;
    }

    /**
     * Obtiene el valor (sin extraer) del elemento que ocupa la cima de la pila
     * @return El elemento de la cima o Double.NEGATIVE_INFINITY si la pila est� vac�a
     */
    public double top() {
        double e = ERROR;
        if (!isEmpty()) {
            e = data[size - 1];
        }
        return e;
    }

    /**
     * Determina si la pila est� llena
     * M�todo de uso interno y por tanto privado ya que desde el punto de vista del
     * programador que utilice esta clase no tiene sentido, ya que la pila es din�mica,
     * es decir, crece autom�ticamente.
     * @return true si el array ha alcanzado su capacidad m�xima o false en caso contrario
     */
    private boolean isFull() {
        return size == data.length;
    }

    /**
     * Determina si la pila est� vac�a
     * @return true si est� vac�a, false en caso contrario
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve el n�mero de elementos que hay en la pila
     * @return N�mero de elementos de la pila
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i = 0; i < size; i++) {
            sb.append(data[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
