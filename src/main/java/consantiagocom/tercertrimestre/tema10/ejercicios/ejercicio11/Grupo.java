package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio11;

public class Grupo {
    private String codigoIdentificador;
    private String nombre;
    private Aula aula;

    public Grupo( String codigoIdentificador,String nombre, Aula aula) {
        this.codigoIdentificador = codigoIdentificador;
        this.nombre = nombre;
        this.aula = aula;
    }

    public String getId() {
        return codigoIdentificador;
    }


    public String getNombre() {
        return nombre;
    }

    public Aula getAula() {
        return aula;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "codigoIdentificador=" + codigoIdentificador +
                ", nombre='" + nombre + '\'' +
                ", aula=" + aula +
                '}';
    }
}