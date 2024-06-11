package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items;

public class Pico extends Item {
    public static final String NOMBRE = "Pico";
    private static final int DURABILIDAD = 200;
    private static final int STACK_SIZE = 1;

    public Pico() {
        super(NOMBRE, DURABILIDAD);
    }

    @Override
    public int stackSize() {
        return STACK_SIZE;
    }
}
