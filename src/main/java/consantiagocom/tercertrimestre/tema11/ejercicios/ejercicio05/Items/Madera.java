package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items;

public class Madera extends Item {
    public static final String NOMBRE = "Madera";
    private static final int STACK_SIZE = 64;

    public Madera() {
        super(NOMBRE);
    }

    @Override
    public int stackSize() {
        return STACK_SIZE;
    }
}