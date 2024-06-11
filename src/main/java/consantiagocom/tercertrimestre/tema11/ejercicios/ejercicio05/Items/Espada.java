package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items;

public class Espada extends Item {
    public static final String NOMBRE = "Espada";
    private static final int DURABILIDAD = 200;
    private static final int STACK_SIZE = 1;

    public Espada() {
        super(NOMBRE, DURABILIDAD);
    }

    @Override
    public int stackSize() {
        return STACK_SIZE;
    }
}