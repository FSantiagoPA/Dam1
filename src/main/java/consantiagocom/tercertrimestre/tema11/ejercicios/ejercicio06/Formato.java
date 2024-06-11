package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Lib;

/**
 * Enumerado que representa los distintos formatos que tiene un Multimedia
 * Si Formato puede cambiar de forma habitual, sería mejor implementarlo como una clase que cargaríamos
 * con datos procedentes de una base de datos.
 */
public enum Formato {
    CD, DVD, BLURAY, ARCHIVO;

    /**
     * Obtiene un Formato aleatorio
     * @return Formato aleatorio
     */
    public static Formato random() {
        return Formato.values()[Lib.aleatorio(0,Formato.values().length-1)];
    }
}
