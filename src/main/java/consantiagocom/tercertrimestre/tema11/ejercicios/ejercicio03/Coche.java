package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio03;


public abstract class Coche {
    protected final String matricula;
    protected double velocidad;
    protected int marcha;
    protected final int[] velocidadMaximaMarcha;

    /**
     * Crea un coche con la matricula indicada
     * @param matricula
     */
    public Coche(String matricula, int[] velocidadMaximaMarcha) {
        this.matricula = matricula;
        this.velocidad = 0;
        this.marcha = 0;
        this.velocidadMaximaMarcha = velocidadMaximaMarcha;
    }

    /**
     * Aumenta la velocidad del coche según el parámetro recibido
     * siempre que la marcha actual lo permita
     * @param a Aumento de la velocidad
     */
    public void acelerar(double a) {
        if(a > 0 && marcha > 0 && (this.velocidad + a) <= velocidadMaximaMarcha[marcha]) {
            this.velocidad += a;
        }
    }

    /**
     * Reduce la velocidad según el parámetro recibido
     * siempre que la velocidad sea mayor que cero
     * @param f Cantidad de frenada
     */
    public void frenar(double f) {
        if(f > 0 && marcha > 0 && (this.velocidad - f) >= 0) {
            this.velocidad -= f;
        }
    }

    /**
     * Cambia la marcha a la marcha indicada
     * siempre que esté dentro del rango de marchas del coche
     * @param m March
     */
    protected void cambiarMarcha(int m) {
        if(m >= 0 && m < velocidadMaximaMarcha.length) {
            this.marcha = m;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    /**
     * Obtiene la información del coche como una cadena de caracteres
     * @return String con la representación de los datos del coche
     */
    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                ", marcha=" + marcha +
                '}';
    }
}
