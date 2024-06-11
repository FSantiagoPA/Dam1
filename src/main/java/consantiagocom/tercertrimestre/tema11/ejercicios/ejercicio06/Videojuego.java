package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

/**
 * Clase que representa un Videojuego
 */
public class Videojuego extends Multimedia {
    /** Constantes de configuraci�n */
    private static final double PRECIOBASE = 4;
    private static final int ANYO_OFERTA = 2010;
    /** Atributos */
    private final Plataforma plataforma;

    /**
     * Crea un Videojuego con el titulo, Autor, Formato, anyo y Plataforma indicadas
     * @param titulo
     * @param autor
     * @param formato
     * @param anyo
     * @param plataforma
     */
    public Videojuego(String titulo, Autor autor, Formato formato, int anyo, Plataforma plataforma) {
        super(titulo, autor, formato, anyo);
        this.plataforma = plataforma;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     * Obtiene el precio del alquiler tomanado como referencia el anyo del Videojuego
     * @return Precio del alquiler
     */
    @Override
    public double getPrecioAlquiler() {
        double precio = PRECIOBASE;
        if(anyo < ANYO_OFERTA) {
            precio--;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + getId() +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", a�o=" + anyo +
                ", formato=" + Format +
                ", alquilado=" + isAlquilado() +
                ", plataforma=" + plataforma +
                '}';
    }
}
