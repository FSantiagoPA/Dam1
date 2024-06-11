package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Clase padre utilizada por todos los objetos alquilables
 */
public abstract class Multimedia {
    /** Para generar id de forma autonum�rica */
    private static int N_MULTIMEDIA = 0;
    /** Atributos */
    private final int id;
    protected String titulo;
    protected Autor autor;
    protected int anyo;
    protected Formato Format;
    /**
     * Para implementar los alquileres tenemos varias opciones, las m�s comunes ser�an:
     * - ArrayList en la clase Multimedia
     * - ArrayList en la clase Socio
     * - ArrayList en la clase videoClub
     * La elecci�n de una u otra opci�n depende del uso final que se le vaya a dar, es decir cuales ser�n las
     * b�squedas m�s comunes.
     */
    protected ArrayList<Alquiler> alquileres;

    /**
     * Crea un objeto multimedia con titulo, autor, formato y a�o
     * @param titulo Nombre del multimedia
     * @param autor Autor del multimedia
     * @param formato Formato del multimedia
     * @param anyo A�o de creaci�n del multimedia
     */
    public Multimedia(String titulo, Autor autor, Formato formato, int anyo) {
        this.id = ++N_MULTIMEDIA;
        this.titulo = titulo;
        this.autor = autor;
        this.Format = formato;
        this.anyo = anyo;
        //Al crear un multimedia su lista de alquileres est� inicialmente vac�a
        this.alquileres = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Formato getFormat() {
        return Format;
    }

    public void setFormat(Formato format) {
        Format = format;
    }


    /**
     * Determina si dos Multimedia son iguales. Para ello compara si el titulo y el autor son el mismo
     * @param multimedia Multimedia con el que se quiere comparar
     * @return True si son iguales, False en caso contrario
     */
    public boolean equals(Multimedia multimedia) {
        return this.titulo.equalsIgnoreCase(multimedia.titulo) && this.autor.equals(multimedia.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor, anyo, Format, alquileres);
    }

    /**
     * M�todo a implementar por las clases hijas
     * Obtiene el precio del alquiler
     * @return precio del alquiler
     */
    public abstract double getPrecioAlquiler();

    /**
     * Alquila un Multimedia a un Socio con la fecha actual del sistema
     * @param socio Socio al que se le est� alquilando el Multimedia
     * @return El precio del alquiler si ha ido bien, -1 en caso contrario
     */
    public double alquilar(Socio socio) {
        return this.alquilar(socio, new GregorianCalendar());
    }

    /**
     * Alquila un Multimedia a un Socio con la fecha indicado como par�metro
     * @param socio Socio al que se le est� alquilando el Multimedia
     * @param fechaAlquiler Fecha del alquiler
     * @return El precio del alquiler si ha ido bien, -1 en caso contrario
     */
    public double alquilar(Socio socio, GregorianCalendar fechaAlquiler) {
        if(!isAlquilado()) {
            if(!socio.tieneRecargosPendientes()) {
                alquileres.add(new Alquiler(socio, fechaAlquiler));
                return getPrecioAlquiler();
            } else {
                System.out.println("Imposible alquilar, el socio tiene recargos pendientes");
            }
        }
        return -1;
    }

    /**
     * Devuelve un Multimedia que previamente hab�a sido alquilado
     * @param fechaDevolucion Fecha en la que el Socio realiza la devoluci�n
     * @return Si la devoluci�n ha generado Recargo, la cantidad a pagar por el Socio, si no 0.
     * En caso que el Multimedia no est� alquilado devuelve -1
     */
    public double devolver(GregorianCalendar fechaDevolucion) {
        if(isAlquilado()) {
            return alquileres.get(alquileres.size()-1).devolver(fechaDevolucion);
        }
        return -1;
    }

    /**
     * Devuelve un Multimedia que previamente hab�a sido alquilado tomando como fecha de devoluci�n la fecha actual
     * @return -1, si la devoluci�n ha generado Recargo, la cantidad a pagar por el Socio
     */
    public double devolver() {
        return this.devolver(new GregorianCalendar());
    }

    public ArrayList<Alquiler> getAlquileres() {
        return alquileres;
    }

    /**
     * Determina si un Multimedia est� alquilado actualmente
     * @return True si est� alquilado, False en caso contrario
     */
    public boolean isAlquilado() {
        if(alquileres.size() == 0) {
            return false;
        }
        return alquileres.get(alquileres.size()-1).getFechaDevolucion() == null;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", a�o=" + anyo +
                ", formato=" + Format +
                ", alquilado=" + isAlquilado() +
                '}';
    }

    /**
     * Permite ordenar los Multimedia por t�tulo
     */
    public static class ComparatorTitulo implements Comparator<Multimedia> {
        @Override
        public int compare(Multimedia o1, Multimedia o2) {
            return o1.titulo.compareToIgnoreCase(o2.titulo.toUpperCase());
        }
    }

    /**
     * Permite ordenar los Multimedia por a�o
     */
    public static class ComparatorAnyo implements Comparator<Multimedia> {
        @Override
        public int compare(Multimedia o1, Multimedia o2) {
            return o1.getAnyo() - o2.getAnyo();
        }
    }
}
