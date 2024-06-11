package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05;

/**
 * Interfaz que implementarán todos los items para indicar cuál es el tamaño máximo de la pila,
 * que en el caso de los items que no sean apilables devolverá 1
 */
public interface Apilable {

    /**
     * Devuelve el número de items que pueden ser apilados
     * en un Slot del inventario
     * @return número de items que pueden ser apilados
     */
    int stackSize();
}