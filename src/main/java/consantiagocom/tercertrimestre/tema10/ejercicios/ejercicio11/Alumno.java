package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio11;

import java.util.Arrays;

public class Alumno {
    private int id;
    private int counter = 0;
    private String nombre;
    private Grupo grupo;
    private String[] asignatura;

    public Alumno(String nombre, Grupo grupo, String[] asignatura) {
        this.id = ++counter;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignatura = new String[]{Arrays.toString(asignatura)};
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public String[] getAsignatura() {
        return asignatura;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", grupo=" + grupo +
                ", asignatura=" + Arrays.toString(asignatura) +
                '}';
    }
}
