package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio03;

/**
 * Clase que representa a un coche con cambio manual
 */
public class CocheCambioManual extends Coche {

    /**
     * Crea un coche con cambio manual
     * @param matricula Matrícula del coche
     */
    public CocheCambioManual(String matricula, int[] velocidadMaximaMarcha) {
        super(matricula, velocidadMaximaMarcha);
    }

    /**
     * Cambia la marcha a la marcha indicada
     * siempre que esté dentro del rango de marchas del coche
     * @param m March
     */
    @Override
    public void cambiarMarcha(int m) {
        super.cambiarMarcha(m);
    }

    /**
     * Aumenta la velocidad del coche según el parámetro recibido
     * siempre que la marcha actual lo permita
     * @param a Aumento de la velocidad
     */
    @Override
    public void acelerar(double a) {
        super.acelerar(a);
    }

    /**
     * Reduce la velocidad según el parámetro recibido
     * siempre que la velocidad sea mayor que cero
     * @param f Cantidad de frenada
     */
    @Override
    public void frenar(double f) {
        super.frenar(f);
    }
}
