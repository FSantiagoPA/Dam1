package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Lib;

public enum TipoPartido {
    BAJA_AFLUENCIA, MEDIA_AFLUENCIA, ALTA_AFLUENCIA;

    /**
     * Genera un TipoPartido aleatorio
     * @return
     */
    public static TipoPartido random() {
        return TipoPartido.values()[Lib.aleatorio(0, TipoPartido.values().length-1)];
    }
}