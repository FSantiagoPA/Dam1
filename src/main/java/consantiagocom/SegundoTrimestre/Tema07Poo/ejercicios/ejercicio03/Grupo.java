package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio03;

public class Grupo {
    private final int codigo;
    private final String nombre;

    public Grupo(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}