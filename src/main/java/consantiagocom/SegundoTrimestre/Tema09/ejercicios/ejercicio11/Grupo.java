package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio11;

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
}