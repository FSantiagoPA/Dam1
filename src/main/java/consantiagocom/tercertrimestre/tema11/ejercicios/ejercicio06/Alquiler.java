package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * Clase que representa un Alquiler de un Multimedia
 */
public class Alquiler {
    /** Constantes estáticas de configuración */
    private static final int MAX_DIAS_ALQUILER = 3;
    private static final double RECARGO_POR_DIA = 2;
    private static int N_ALQUILERES = 0;
    /** Atributos */
    private final int id;
    private final Socio socio;
    private final GregorianCalendar fechaAlquiler;
    private GregorianCalendar fechaDevolucion;

    /**
     * Crea un Alquiler con el Socio y fechas indicadas
     * @param socio Socio que realiza el Alquiler
     * @param fechaAlquiler Fecha en la que se realiza el Alquiler
     */
    public Alquiler(Socio socio, GregorianCalendar fechaAlquiler) {
        this(socio, fechaAlquiler, null);
    }

    /**
     * Crea un Alquiler con el Socio y las fecha de alquiler y devolución indicadas.
     * Este método solo sería utilizado durante la fase de prubas, para generar casos de prueba
     * TODO: Marcar como privado cuando finalice la fase de pruebas
     * @param socio Socio que realiza el Alquiler
     * @param fechaAlquiler Fecha en la que se realiza el Alquiler
     * @param fechaDevolucion Fecha en la que se devuelve el Alquiler
     */
    public Alquiler(Socio socio, GregorianCalendar fechaAlquiler, GregorianCalendar fechaDevolucion) {
        this.id = ++N_ALQUILERES;
        this.socio = socio;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;

        if(fechaDevolucion != null) {
            devolver(fechaDevolucion);
        }
    }

    /**
     * Devuelve un Alquiler en la fecha indicada
     * @param fechaDevolucion Fecha en la que se realiza la devolución
     * @return 0 si no se ha generado Recargo, en caso contrario devuelve el importe
     * que ha generado e Recargo
     */
    public double devolver(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        long dias = ChronoUnit.DAYS.between(this.fechaAlquiler.toInstant(), this.fechaDevolucion.toInstant());
        if(dias > MAX_DIAS_ALQUILER) {
            double recargo = (dias - MAX_DIAS_ALQUILER) * RECARGO_POR_DIA;
            socio.generarRecargo(this, recargo);
            return recargo;
        }
        return 0;
    }

    /**
     * Devuelve un Alquiler en la fecha actual
     * @return 0 si no se ha generado Recargo, en caso contrario devuelve el importe
     * que ha generado e Recargo
     */
    public double devolver() {
        return this.devolver(new GregorianCalendar());
    }

    public int getId() {
        return id;
    }

    public Socio getSocio() {
        return socio;
    }

    public GregorianCalendar getFechaAlquiler() {
        return fechaAlquiler;
    }

    public String getFechaAlquilerStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechaAlquiler.getTime());
    }

    public GregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getFechaDevolucionStr() {
        if(fechaDevolucion != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(fechaDevolucion.getTime());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id=" + id +
                ", socio=" + socio +
                ", fechaAlquiler=" + getFechaAlquilerStr() +
                ", fechaDevolución=" + getFechaDevolucionStr() +
                '}';
    }

    /**
     * Permite ordenar los Alquileres por fecha de alquiler
     */
    public static class ComparatorFechaAlquiler implements Comparator<Alquiler> {
        @Override
        public int compare(Alquiler o1, Alquiler o2) {
            return o1.getFechaAlquiler().compareTo(o2.getFechaAlquiler());
        }
    }
}