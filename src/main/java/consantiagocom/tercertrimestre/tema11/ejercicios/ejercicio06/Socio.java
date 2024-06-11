package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Lib;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase que representa a un Socio
 */
public class Socio implements Comparable<Socio> {
    /** Para obtener el NIF de forma aleatoria */
    private static int N_SOCIOS = 0;
    private String nif;
    private String nombre;
    private int edad;
    private String poblacion;
    /** Listado de recargos que tiene el socio */
    private final ArrayList<Recargo> recargos;

    /**
     * Crea un Socio con el nif, nombre, edad y población indicados
     * @param nif
     * @param nombre
     * @param edad
     * @param poblacion
     */
    public Socio (String nif, String nombre, int edad, String poblacion) {
        N_SOCIOS++;
        //** Aquí podríamos optar por realizar una doble validación del nif y lanzar una Excepción */
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
        this.poblacion = poblacion;
        this.recargos = new ArrayList<>();
    }

    /**
     * Crea un Socio con el nombre, edad y población indicados
     * El NIF se generará de forma aleatoria a partir del número de socios (N_SOCIOS)
     * Este método solo será utilizado durante la fase de pruebas
     * TODO: Hacer el método privado cuando finalice la fase de pruebas
     * @param nombre
     * @param edad
     * @param poblacion
     */
    public Socio(String nombre, int edad, String poblacion) {
        this("", nombre, edad, poblacion);
        this.nif = "" + N_SOCIOS + Lib.letraNIF(N_SOCIOS);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Genera un recargo asociado al alquiler indicado como parámetro con la cantidad a pagar indicada
     * @param alquiler
     * @param cantidadAPagar
     */
    public void generarRecargo(Alquiler alquiler, double cantidadAPagar) {
        this.recargos.add(new Recargo(alquiler, cantidadAPagar));
    }

    /**
     * Determina si un Socio tiene recargos pendientes
     * @return True en caso afirmativo, False en caso contrario
     */
    public boolean tieneRecargosPendientes() {
        for(Recargo recargo: recargos) {
            if(recargo.getFechaPago() == null) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Recargo> getRecargos() {
        return recargos;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Socio o) {
        return 0;
    }

    /**
     * Permite ordenar los Socios por nombre
     */
    public static class ComparatorNombre implements Comparator<Socio>{
        @Override
        public int compare(Socio o1, Socio o2) {
            return o1.nombre.compareTo(o2.nombre);
        }
    }

    /**
     * Permite ordenar los Socios por edad
     */
    public static class ComparatorEdad implements Comparator<Socio> {
        @Override
        public int compare(Socio o1, Socio o2) {
            return o1.getEdad() - o2.getEdad();
        }
    }
}
