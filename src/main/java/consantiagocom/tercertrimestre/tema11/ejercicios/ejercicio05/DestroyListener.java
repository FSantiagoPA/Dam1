package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items.InstanceItem;

/**
 * Interfaz que utilizan las instancias de items para avisar a quien implemente la interfaz que un
 * una instancia de item ha agotado sus usos y va a destruirse
 */
public interface DestroyListener {
    void onDestroy(InstanceItem instanceItem);
}
