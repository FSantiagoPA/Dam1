package consantiagocom.tercertrimestre.tema10.ejercicio03;

import java.util.ArrayList;
import java.util.Stack;

public class Pila<E> implements IPila<E>{

    // Atributos
    private final ArrayList<E> stack;

    // Constructor
    public Pila() {
        this.stack = new ArrayList<>();
    }

    // Implementación de la interfaz IPila

    // Expulsa el elemento que está en la cima de la pila.
    @Override
    public E pop() {
        return stack.remove(stack.size() -1);
    }

    // Añade un elemento a la cima de la pila.
    @Override
    public E push(E e) {
        stack.add(e);
        return e;
    }

    // Devuelve el número de elementos de la pila.
    @Override
    public int size() {
        return stack.size();
    }

    // Devuelve el elemento que está en la cima de la pila sin expulsarlo.
    @Override
    public E top() {
        return stack.get(size() - 1);

    }

    // Devuelve true si la pila no tiene elementos.
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
