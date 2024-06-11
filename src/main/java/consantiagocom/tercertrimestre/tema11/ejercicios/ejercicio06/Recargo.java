package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

import java.util.GregorianCalendar;

/**
 * Clase que representa un Recargo
 */
public class Recargo {
    /** Alquiler asociado al Recargo */
    private final Alquiler alquiler;
    /** Importe a pagar */
    private final double cantidadAPagar;
    /** Fecha en la que el Socio realiza el Recargo */
    private GregorianCalendar fechaPago;

    /**
     * Crea un Recargo asociado al Alquiler indicado con el importe cantidadAPagar
     * @param alquiler
     * @param cantidadAPagar
     */
    public Recargo(Alquiler alquiler, double cantidadAPagar) {
        this.alquiler = alquiler;
        this.cantidadAPagar = cantidadAPagar;
        this.fechaPago = null;
    }

    /**
     * Establece como pagado un Recargo poniendo como fechaPago la fecha actual
     */
    public void pagar() {
        this.fechaPago = new GregorianCalendar();
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public double getCantidadAPagar() {
        return cantidadAPagar;
    }

    public GregorianCalendar getFechaPago() {
        return fechaPago;
    }

    @Override
    public String toString() {
        return "Recargo{" +
                "alquiler=" + alquiler +
                ", cantidadAPagar=" + cantidadAPagar +
                ", fechaPago=" + fechaPago +
                '}';
    }
}
