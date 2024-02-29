package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio08Generic;

public class Ejercicio08<T> {


    private T[] stack = (T[]) new Object[100];
    private int top = -1;

    public void push(T value) {
        if (!isFull()) {
            stack[++top] = value;
        } else {
            stack = resize();
        }
    }

    public T pop() {
        T value = peek();
        if (value != null) {
            top--;
        }
        return value;
    }

    public T peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            return null;
        }
    }

    public T[] resize() {
        T[] newStack = (T[]) new Object[stack.length * 2];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        return newStack;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

}
