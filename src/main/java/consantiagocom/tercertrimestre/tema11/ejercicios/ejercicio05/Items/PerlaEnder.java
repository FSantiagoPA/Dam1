package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items;

public class PerlaEnder extends Item {
    public static final String NOMBRE = "Perla de Ender";
    private static final int STACK_SIZE = 16;

    public PerlaEnder() {
        super(NOMBRE);
    }

    @Override
    public int stackSize() {
        return STACK_SIZE;
    }
}
