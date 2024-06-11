package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items.InstanceItem;

/**
 * Interfaz que implementarán aquellos items que puedan apilarse y desapilarse
 */
public interface Apilator {
    /**
     * Añade cantidad unidades del instanceItem indicado al Slot
     *
     * @param instanceItem objeto a apilar
     * @param cantidad número de unidades a apilar
     * @return 0 si todas las unidades han podido ser añadidas.
     * Devuelve un número positivo indicando las unidades que no han podido ser añadidas
     */
    int apilar(InstanceItem instanceItem, int cantidad);

    /**
     * Extrae cantidad unidades del item indicado del Slot
     *
     * @param instanceItem objeto a desapilar
     * @param cantidad número de unidades a desapilar
     * @return número de unidades que se han extraido
     */
    int desapilar(InstanceItem instanceItem, int cantidad);
}