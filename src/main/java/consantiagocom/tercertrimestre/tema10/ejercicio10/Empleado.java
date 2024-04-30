package consantiagocom.tercertrimestre.tema10.ejercicio10;

import java.util.*;

public class Empleado {
    private final String nombre;
    private final String apellidos;
    private final String NIF;
    private double sueldo;
    private final Date fechaNacimiento;
    private List<Hijo> hijos;

    public Empleado(String nombre, String apellidos, String NIF, double sueldo, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        hijos = new ArrayList<>();
    }

    /**
     * Metodo para crear un nuevo hijo.
     * @param nombre del hijo.
     * @param fechaNacimiento del hijo.
     * @return el hijo que se a creado.
     */
    public Hijo nuevoHijo(String nombre, Date fechaNacimiento){
        Hijo hijo = new Hijo(nombre,fechaNacimiento);
        hijos.add(hijo);
        return hijo;
    }

    /**
     * Metodo para eliminar un hijo
     * @param nombre del hijo a eliminar.
     * @return el hijo que se a eliminado o null si no se a eliminado correctamente.
     */
    public Hijo eliminarHijo(String nombre){
        Hijo hijo = getHijoPorNombre(nombre);
        if (hijo == null){
            return null;
        }
        hijos.remove(hijo);
        return hijo;
    }

    /**
     * Metodo para buscar hijo por nombre
     * @param nombre del hijo a buscar
     * @return el hijo que se a encontrado o null si no se a encontrado
     */
    private Hijo getHijoPorNombre(String nombre){
        for (Hijo hijo : hijos) {
            if (hijo.getNombre().equals(nombre)) {
                return hijo;
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<Hijo> getHijos() {
        return hijos;
    }

    public void setHijos(List<Hijo> hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", NIF='" + NIF + '\'' +
                ", sueldo=" + sueldo +
                ", fechaNacimiento=" + fechaNacimiento +
                ", hijos=" + hijos +
                '}';
    }
}
