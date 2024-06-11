package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

import java.util.Objects;

/**
 * Clase que representa al Autor de un Multimedia
 */
public class Autor {
    /** Para generar el atributo id de forma autonumérica */
    private static int N_AUTORES = 0;
    private final int id;
    private final String nombre;
    private final String apellidos;

    /**
     * Crea un Autor con el nombre y apellidos indicados
     * @param nombre Nombre del Autor
     * @param apellidos Apellidos del Autor
     */
    public Autor(String nombre, String apellidos) {
        this.id = ++N_AUTORES;
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
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }

    /**
     * Redefinimos el método equals para indicar que dos objetos Autor son iguales
     * si su id, su nombre y sus apellidos son iguales
     * @param o Autor con el que queremos comparar
     * @return True si son iguales, False en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Autor autor = (Autor) o;
        return id == autor.id &&
                Objects.equals(nombre, autor.nombre) &&
                Objects.equals(apellidos, autor.apellidos);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos);
    }
}
