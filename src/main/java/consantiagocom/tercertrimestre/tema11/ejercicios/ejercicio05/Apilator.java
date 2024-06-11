package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items.InstanceItem;

/**
 * Interfaz que implementar�n aquellos items que puedan apilarse y desapilarse
 */
public interface Apilator {
    /**
     * A�ade cantidad unidades del instanceItem indicado al Slot
     *
     * @param instanceItem objeto a apilar
     * @param cantidad n�mero de unidades a apilar
     * @return 0 si todas las unidades han podido ser a�adidas.
     * Devuelve un n�mero positivo indicando las unidades que no han podido ser a�adidas
     */
    int apilar(InstanceItem instanceItem, int cantidad);

    /**
     * Extrae cantidad unidades del item indicado del Slot
     *
     * @param instanceItem objeto a desapilar
     * @param cantidad n�mero de unidades a desapilar
     * @return n�mero de unidades que se han extraido
     */
    int desapilar(InstanceItem instanceItem, int cantidad);
}