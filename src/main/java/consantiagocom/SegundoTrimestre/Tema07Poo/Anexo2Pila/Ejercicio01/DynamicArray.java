package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio01;

public class DynamicArray {
    private final static float factorCrecimiento = 2f;
    private double[] dato;
    private int size;

    public DynamicArray(int capacidadInicial){
        dato = new double[capacidadInicial];
        size = 0;
    }
    public DynamicArray(){
        this(10);
    }
    public double get(int index){
        return dato[index];
    }
    private void moverDerechaArray(int index) {
        for (int i = size; i > index; i--) {
            dato[i] = dato[i - 1];
        }
        size++;
    }
    public boolean add(double value){
        if (size >= dato.length)
            dato = aumentarTamanio();

        dato[size] = value;
        size++;
        return true;
    }
    public boolean add(int index, double value){
        if (size >= dato.length)
            dato = aumentarTamanio();
        moverDerechaArray(index);
        dato[index] = value;
                return true;
    }
    public boolean set(int index, int value) {
        if (index >= size)
            return false;

        dato[index] = value;
        return true;
    }
   private double[] aumentarTamanio(){
       double[] nuevoArray = new double[(int) (size*factorCrecimiento)];
        dato = nuevoArray;
        return nuevoArray;
    }
}
