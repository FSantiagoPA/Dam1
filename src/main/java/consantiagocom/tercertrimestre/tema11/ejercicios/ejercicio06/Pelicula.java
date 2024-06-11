package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

/**
 * Clase que representa un Pelicula
 */
public class Pelicula extends Multimedia{
    /** Constantes de configuración */
    private static final double PRECIOBASE = 4;
    private static final int ANYO_OFERTA = 2012;
    /** Atributos  */
    private final int duracion;
    private final Actor actorPrincipal;
    private final Actor actrizPrincipal;

    /**
     * Crea una Pelicula con el titulo, autor, formato, anyo, duracion, actorPrincipal y actrizPrincipal indicados
     * @param titulo
     * @param autor
     * @param formato
     * @param anyo
     * @param duracion
     * @param actorPrincipal
     * @param actrizPrincipal
     */
    public Pelicula (String titulo, Autor autor, Formato formato, int anyo, int duracion, Actor actorPrincipal, Actor actrizPrincipal) {
        /** Invocamos al constructor padre (Multimedia) */
        super(titulo, autor, formato, anyo);
        this.duracion = duracion;
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
    }

    public Actor getActorPrincipal() {
        return actorPrincipal;
    }

    public Actor getActrizPrincipal() {
        return actrizPrincipal;
    }

    /**
     * Obtiene el precio del alquiler en función del anyo
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
        return "Pelicula{" +
                "id=" + getId() +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", duración=" + duracion +
                ", año=" + anyo +
                ", formato=" + Format +
                ", alquilado=" + isAlquilado() +
                ", actorPrincipal=" + actorPrincipal +
                ", actrizPrincipal=" + actrizPrincipal +
                '}';
    }
}
