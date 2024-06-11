package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio04;

public interface ICola<E> {
    boolean add(E e);
    E remove();
    int size();
    E peek();
    boolean isEmpty();
}
