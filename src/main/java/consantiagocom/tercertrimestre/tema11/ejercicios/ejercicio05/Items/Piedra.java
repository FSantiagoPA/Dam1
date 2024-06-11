package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items;

public class Piedra extends Item {
    public static final String NOMBRE = "Piedra";
    private static final int STACK_SIZE = 64;

    public Piedra() {
        super(NOMBRE);
    }

    @Override
    public int stackSize() {
        return STACK_SIZE;
    }
}