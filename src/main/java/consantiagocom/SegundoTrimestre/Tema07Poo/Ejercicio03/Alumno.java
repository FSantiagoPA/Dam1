package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio03;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alumno {
    private final int nia;
    private final String nombre;
    private final String apellidos;
    private final GregorianCalendar fechaNacimiento;
    private final Grupo grupo;
    private final String telefono;

    public Alumno(int nia, String nombre, String apellidos, GregorianCalendar fechaNacimiento, Grupo grupo, String telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.grupo = grupo;
        this.telefono = telefono;
    }

    /**
     * Constructor de copia
     * Crea un copia del alumno recibido como parámetro
     * @param alumno Alumno a copiar
     */
    public Alumno(Alumno alumno) {
        this(alumno.getNia(), alumno.getNombre(), alumno.getApellidos(), alumno.getFechaNacimiento(),
                alumno.getGrupo(), alumno.getTelefono());
    }

    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        LocalDate hoy = LocalDate.now();
        LocalDate cumple;
        Period p;
        int anyo = fechaNacimiento.get(Calendar.YEAR);

        //fechaNacimiento.get(Calendar.MONTH) devuelve en el rango [0-11], hay que sumar 1
        int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
        int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);

        cumple = LocalDate.of(anyo, mes, dia);
        p = Period.between(cumple, hoy);
        return p.getYears();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return  String.format("%9d",nia) +
                String.format("%16s",String.format("%-12s",nombre)) +
                String.format("%-25s",apellidos) +
                sdf.format(fechaNacimiento.getTime()) + " (" +getEdad()+" años)" +
                String.format("%10s",grupo.getNombre()) +
                String.format("%12s",telefono);
    }
}
