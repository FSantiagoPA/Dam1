package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05;

/**
 * Interfaz que implementar�n todos los items para indicar cu�l es el tama�o m�ximo de la pila,
 * que en el caso de los items que no sean apilables devolver� 1
 */
public interface Apilable {

    /**
     * Devuelve el n�mero de items que pueden ser apilados
     * en un Slot del inventario
     * @return n�mero de items que pueden ser apilados
     */
    int stackSize();
}