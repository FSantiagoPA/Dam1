package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio11;

public class Asignatura {
    private String codigoIdentificador;
    private String nombre;
    private Profesor profesor;

    public Asignatura(String codigoIdentificador,String nombre, Profesor profesor) {
        this.codigoIdentificador = codigoIdentificador;
        this.nombre = nombre;
        this.profesor = profesor;
    }
    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }
    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "String codigoIdentificador=" + codigoIdentificador +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}