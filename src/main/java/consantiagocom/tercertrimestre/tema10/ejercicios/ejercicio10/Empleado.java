package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio10;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Empleado {
    private final String nie;
    private final String nombre;
    private final String apellido;
    private final GregorianCalendar fechaNaci;
    private double sueldo;
    private  Hijo hijo;

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getNie() {
        return nie;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public GregorianCalendar getFechaNaci() {
        return fechaNaci;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }

    public Empleado(String nie, String nombre, String apellido, GregorianCalendar fechaNaci, double sueldo, Hijo hijo) {
        this.nie = nie;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNaci = fechaNaci;
        this.sueldo = sueldo;
        this.hijo = hijo;
    }

    public Empleado(String nie, String nombre, String apellido, GregorianCalendar fechaNaci, double sueldo) {
        this.nie = nie;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNaci = fechaNaci;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd--MM-yyyy");
        return "Empleado{" +
                "nie='" + nie + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNaci=" + sdfDate.format(fechaNaci.getTime()) +
                ", sueldo=" + sueldo +
                ", hijo=" + hijo +
                '}';
    }
}