package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio01;

/**
 * Clase que representa un Punto
 */
public class Punto {
    private final double x;
    private final double y;

    /**
     * Crea un Punto en la coordenada (x, y) indicada
     * @param x Coordenada en el eje de las abcisas
     * @param y Coordenada en el eje de las ordenadas
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Crea un Punto en la coordenada (0, 0)
     */
    public Punto() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Calcula la distancia entre el punto actual y el punto recibido como parámetro
     * utilizando el teorema de Pitágoras
     * @param punto Punto destino
     * @return La distancia entre el punto actual y el punto recibido como parámetro
     */
    public double distancia(Punto punto) {
        return Math.sqrt(Math.pow(this.x - punto.getX(), 2) + Math.pow(this.y - punto.getY(), 2));
    }

    public static double distancia(Punto p1, Punto p2) {
        return p1.distancia(p2);
    }

    /**
     * Obtiene una representación del punto como un String
     * @return String que indica la posición del punto
     */
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}