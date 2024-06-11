package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

/**
 * Clase que representa al Actor/Actriz de una Pelicula
 */
public class Actor {
    /** Para generar id autonumérico */
    private static int N_ACTORES = 0;
    private final int id;
    private final String nombre;
    private final String apellidos;

    /**
     * Crea un Actor con el nombre y apellidos indicados
     * @param nombre Nombre del Autor
     * @param apellidos Apellidos del Autor
     */
    public Actor(String nombre, String apellidos) {
        this.id = ++N_ACTORES;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}