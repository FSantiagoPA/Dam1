package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items;

public class Huevo extends Item {
    public static final String NOMBRE = "Huevo";
    private static final int STACK_SIZE = 16;

    public Huevo() {
        super(NOMBRE);
    }

    @Override
    public int stackSize() {
        return STACK_SIZE;
    }
}
