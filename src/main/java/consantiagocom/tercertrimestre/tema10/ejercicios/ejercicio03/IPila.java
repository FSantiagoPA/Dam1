package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio03;

public interface IPila <E> {
    E push (E e);
    E pop();
    int size();
    E top();
    boolean isEmpty();

}
