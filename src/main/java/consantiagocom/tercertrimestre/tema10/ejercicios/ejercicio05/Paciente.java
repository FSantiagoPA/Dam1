package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio05;

import java.util.Date;

public class Paciente {

    //Configurando variables constantes
    private static final String DEFAULT_GENDER  = "M";
    static int localId = 1;

    //Atributos
    private int id;
    private String nombre;
    private char sexo;
    private Date fechaNacimiento;
    private double altura;
    private double peso;

    public Paciente(String nombre, Date fechaNacimiento, char sexo , double altura, double peso) {
        this.id = localId++;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.peso = peso;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", fechaNacimiento=" + fechaNacimiento +
                ", altura=" + altura +
                ", peso=" + peso +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;
        return id == paciente.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
