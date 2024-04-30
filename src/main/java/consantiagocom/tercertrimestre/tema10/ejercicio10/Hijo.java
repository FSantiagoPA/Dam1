package consantiagocom.tercertrimestre.tema10.ejercicio10;

import java.util.Date;
import java.util.Objects;

public class Hijo {
    private final String nombre;
    private final Date fechaNacimiento;

    public Hijo(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hijo hijo = (Hijo) o;

        if (!Objects.equals(nombre, hijo.nombre)) return false;
        return Objects.equals(fechaNacimiento, hijo.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hijo{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
