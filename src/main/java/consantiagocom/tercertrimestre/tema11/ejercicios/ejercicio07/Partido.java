package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Bombo;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un Partido
 */
public class Partido {
    public static final int MAX_VENTA_ENTRADAS_ALEATORIAS = Estadio.N_ZONAS *
            Estadio.FILAS_POR_ZONA * Estadio.ASIENTOS_POR_FILA;
    /** Para generar el id de los Partidos */
    private static int N_PARTIDOS = 0;
    private final int id;
    private final GregorianCalendar fecha;
    private final String local;
    private final String visitante;

    private final TipoPartido tipoPartido;
    private final Map<Asiento, Entrada> entradas;
    private final Bombo bombo;

    /**
     * Crea un partido de tipo tipoPartido entre los equipos local y visitante en la fecha indicada
     * @param fecha
     * @param local
     * @param visitante
     * @param tipoPartido
     */
    public Partido(GregorianCalendar fecha, String local, String visitante, TipoPartido tipoPartido) {
        this.id = ++N_PARTIDOS;
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.tipoPartido = tipoPartido;
        this.bombo = new Bombo(1, MAX_VENTA_ENTRADAS_ALEATORIAS);
        this.entradas = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public String getLocal() {
        return local;
    }

    public String getVisitante() {
        return visitante;
    }

    public TipoPartido getTipoPartido() {
        return tipoPartido;
    }

    public Map<Asiento, Entrada> getEntradas() {
        return entradas;
    }

    /**
     * Obtiene un número aleatorio del Bombo
     * @return
     */
    public int getNumeroSorteo() {
        return bombo.getBola();
    }

    public boolean asientoDisponible(Asiento asiento) {
        return !entradas.containsKey(asiento);
    }

    /**
     * Vende una Entrada en la Zona, Fila y Asiento indicados
     * @param zona
     * @param fila
     * @param asiento
     * @return La Entrada vendida o null en caso que no se haya podido vender
     */
    public Entrada venderEntrada(Zona zona, Fila fila, Asiento asiento) {
        if(asientoDisponible(asiento)) {
            Entrada entrada;
            if (zona.getTipoZona() == TipoZona.NORMAL) {
                try {
                    entrada = new EntradaNormal(this, zona, fila, asiento);
                    entradas.put(asiento, entrada);
                } catch (IllegalArgumentException iae) {
                    return null;
                }
            } else {
                try {
                    entrada = new EntradaVIP(this, zona, fila, asiento);
                    entradas.put(asiento, entrada);
                } catch (IllegalArgumentException iae) {
                    return null;
                }
            }
            return entrada;
        } else {
            return null;
        }
    }


    /**
     * Obtiene la recaudación del Partido
     * @return Recaudación total del Partido
     */
    public double getRecaudacion() {
        double recaudacion = 0;
        for(Entrada entrada: getEntradas().values()) {
            recaudacion += entrada.getImporte();
        }
        return recaudacion;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Partido{" +
                "id=" + id +
                ", fecha=" + sdf.format(fecha.getTime()) +
                ", tipoPartido=" + tipoPartido +
                ", local='" + local + '\'' +
                ", visitante='" + visitante + '\'' +
                '}';
    }

    /**
     * Obtiene la representación visual de una zona indicando la disponibilidad de asientos
     * de la Zona pasada como parámetro
     * @param zona Zona a mostrar
     */
    public String zonaToColorString(Zona zona) {
        return zona.toColorStringHeader() +
                zona.toColorString(entradas);
    }
}
