package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila;


public class Pila<T>{
    private Object[] datos;
    private int tope;

    public Pila(int capacidadInicial){
        datos = new String[capacidadInicial];
        tope = -1;
    }

    public void push(T elemento){
        if (isFull()){
            ampliarArray();
        }
        datos[++tope] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T  pop(){
        if (!isEmpty()){
         return (T) datos[tope--];
        }
        return null;
    }

    public int size(){
        return tope + 1;
    }

    @SuppressWarnings("unchecked")
    public T top(){
        if (!isEmpty())
            return (T) datos[tope];
        return null; // devuelve null si la pila esta vacia.
    }

    private boolean isFull(){
        return tope == datos.length-1;
    }

    public boolean isEmpty(){
        return tope == - 1;
    }

    private void ampliarArray(){
        Object[] nuevoArray = new Object[datos.length * 2];
        for (int i = 0; i < datos.length; i++) {
            nuevoArray[i]=datos[i];
        }
        datos = nuevoArray;
    }
}
