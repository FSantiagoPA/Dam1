package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

import java.util.Date;
import java.util.Objects;

public class Paciente {
    public enum Genero{
        HOMBRE,MUJER,OTRO;

        @Override
        public String toString() {
            switch (this) {
                case HOMBRE:
                    return "Hombre";
                case MUJER:
                    return "Mujer";
                case OTRO:
                    return "Otro";
            }
            return super.toString();
        }
    };
    private final String sip;
    private final String nombre;
    private final Genero genero;
    private final Date fechaNacimiento;

    public Paciente(String sip, String nombre, Genero genero, Date fechaNacimiento) {
        this.sip = sip;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;

        if (!sip.equals(paciente.sip)) return false;
        if (!Objects.equals(nombre, paciente.nombre)) return false;
        if (genero != paciente.genero) return false;
        return Objects.equals(fechaNacimiento, paciente.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        int result = sip.hashCode();
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "sip='" + sip + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
