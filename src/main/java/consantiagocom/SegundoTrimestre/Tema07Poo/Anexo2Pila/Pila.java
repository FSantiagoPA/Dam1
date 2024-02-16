package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila;

public class Pila {
    private String[] datos;
    private int tope;

    public Pila(int capacidadInicial){
        datos = new String[capacidadInicial];
        tope = -1;
    }

    public void push(String elemento){
        if (isFull()){
            ampliarArray();
        }
        datos[++tope] = elemento;
    }

    public String pop(){
        if (!isEmpty()){
         return datos[tope--];
        }
        return null;
    }

    public int size(){
        return tope + 1;
    }

    public String top(){
        if (!isEmpty())
            return datos[tope];
        return null; // devuelve null si la pila esta vacia.
    }

    private boolean isFull(){
        return tope == datos.length-1;
    }

    public boolean isEmpty(){
        return tope == - 1;
    }

    private void ampliarArray(){
        String[] nuevoArray = new String[datos.length * 2];
        for (int i = 0; i < datos.length; i++) {
            nuevoArray[i]=datos[i];
        }
        datos = nuevoArray;
    }



}
