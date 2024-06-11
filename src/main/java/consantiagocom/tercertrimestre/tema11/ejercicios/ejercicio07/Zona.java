package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Color;

import java.util.Map;

/**
 * Clase que representa una Zona del Estadio
 */
public class Zona {
    /** Constantes de configuración */
    public static final int ANCHO_COLUMNA = 3;
    public static final int ANCHO_FILA = 1;
    public static final String TITULO_FILA = "Fila ";
    /** Atributos */
    private final int id;
    private final TipoZona tipoZona;
    private final double precioBase;
    private final Fila[] filas;

    /**
     * Crea una Zona con el id, TipoZona y precioBase indicados
     * @param id
     * @param tipoZona
     * @param precioBase
     */
    public Zona(int id, TipoZona tipoZona, double precioBase) {
        this.id = id;
        this.tipoZona = tipoZona;
        this.precioBase = precioBase;
        this.filas = new Fila[Estadio.FILAS_POR_ZONA];
        for(int i = 1; i <= Estadio.FILAS_POR_ZONA; i++) {
            this.filas[i-1] = new Fila(i);
        }
    }

    public int getId() {
        return id;
    }

    public TipoZona getTipoZona() {
        return tipoZona;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Fila[] getFilas() {
        return filas;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "id=" + id +
                ", tipoZona=" + tipoZona +
                ", precioBase=" + precioBase +
                //", filas=" + Arrays.toString(filas) +
                '}';
    }

    /**
     * Devuelve el encabezado indicando el número de asiento
     **/
    public String toColorStringHeader() {
        StringBuilder builder = new StringBuilder();
        Fila filaReferencia = getFilas()[0];
        int offset = TITULO_FILA.length() + String.valueOf(getFilas().length).length();
        int offsetHeader = offset + (filaReferencia.getAsientos().length * ANCHO_COLUMNA) / 2;

        int zeroPadding = String.valueOf(filaReferencia.getAsientos().length).length();
        builder.append(String.format("%" + offsetHeader + "s", "ASIENTOS")).append("\n");
        builder.append(String.format("%"+offset+"s", ""));
        for(Asiento asiento: filaReferencia.getAsientos()) {
            builder.append(String.format("%"+ANCHO_COLUMNA+"s", String.format("%0"+zeroPadding+"d", asiento.getNumero())));
        }
        builder.append("\n");
        return builder.toString();
    }

    /**
     * Obtiene una representación con colores de la Zona como un String
     * @return String que representa la información de la Zona
     */
    public String toColorString(Map<Asiento, Entrada> entradas) {
        StringBuilder builder = new StringBuilder();
        int zeroPadding = String.valueOf(getFilas().length).length();

        for(Fila fila: getFilas()) {
            builder.append(TITULO_FILA).append(String.format("%0" + zeroPadding + "d", fila.getNumero()));
            for(Asiento asiento: fila.getAsientos()) {
                builder.append(" ");
                Entrada entrada = entradas.get(asiento);
                if(entrada != null && entrada.fechaDevolucion == null) {
                    builder.append(Color.ANSI_RED_BACKGROUND);
                } else {
                    builder.append(Color.ANSI_GREEN_BACKGROUND);
                }
                builder.append(String.format("%"+ (ANCHO_COLUMNA - 1) +"s",""));
                builder.append(Color.ANSI_RESET);
            }
            for(int i = 0; i < ANCHO_FILA; i++) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
