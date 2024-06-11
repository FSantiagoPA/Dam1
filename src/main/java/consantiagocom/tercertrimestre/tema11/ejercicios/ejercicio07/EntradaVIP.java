package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Lib;

public class EntradaVIP extends Entrada {
    /** Constantes de configuración */
    private static final int LONGITUD_CODIGO = Long.toString(Estadio.N_ZONAS_VIP *
            Estadio.FILAS_POR_ZONA * Estadio.ASIENTOS_POR_FILA).length();
    private static final int CARACTERES_DELANTE = 3;
    private static final int CARACTERES_DETRAS = 2;
    /** Para obtener el código */
    private static int CONTADOR = 0;
    private final String codigo;

    /**
     * Crea un EntradaVIP para el Partido, Zona, Fila y Asiento indicados
     * @param partido
     * @param zona
     * @param fila
     * @param asiento
     * @throws IllegalArgumentException En caso de que el Asiento esté ocupado
     */
    public EntradaVIP(Partido partido, Zona zona, Fila fila, Asiento asiento) throws IllegalArgumentException {
        super(partido, zona, fila, asiento);
        int num = ++CONTADOR;
        this.codigo = Lib.stringAleatorio(CARACTERES_DELANTE) +
                String.format("%0"+LONGITUD_CODIGO+"d", num) +
                Lib.stringAleatorio(CARACTERES_DETRAS);
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "EntradaVIP{" +
                "id=" + id +
                ", partido=" + partido.getLocal() + " VS " + partido.getVisitante() +
                ", zona=" + zona.getId() +
                ", fila=" + fila.getNumero() +
                ", asiento=" + asiento.getNumero() +
                ", codigo='" + codigo + '\'' +
                ", precio=" + zona.getPrecioBase() +
                '}';
    }
}
