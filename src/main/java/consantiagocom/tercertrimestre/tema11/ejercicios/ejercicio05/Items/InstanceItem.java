package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Apilable;
import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.DestroyListener;

/**
 * Clase para representar cada una de las instancias de un Item.
 * Ejemplo: Solo existirá un Item Madera pero podremos tener en el Inventario
 * muchas instancias del Item madera, cada una con su desgaste.
 */
public class InstanceItem implements Apilable {
    private static int N_INSTANCES = 0;
    private final int id;
    private final Item item;
    private int usosRestantes;
    private final DestroyListener destroyListener;

    /**
     * Crea una instancia del item indicado. Recibe un Destruible
     * para ejecutar el onDestroy cuando el objeto se desgaste
     * @param item Item del cual queremos crear una instancia
     * @param destroyListener Objeto que implementa la interfaz Destruible (y que será informado de la destrucción)
     */
    public InstanceItem(Item item, DestroyListener destroyListener) {
        this.id = ++N_INSTANCES;
        this.item = item;
        this.usosRestantes = item.getDurabilidad();
        this.destroyListener = destroyListener;
    }

    public InstanceItem(Item item) {
        this(item, null);
    }

    /**
     * Método genérico empleado para hacer uso del la Instancia de Item.
     * Decrementa el número de usos restantes y llama a onDestroy cuando
     * se agota su uso.
     */
    public void usar() {
        if (usosRestantes > 0) {
            usosRestantes--;
            if (this.usosRestantes == 0 && destroyListener != null) {
                destroyListener.onDestroy(this);
            }
        }
    }

    /**
     * Obtiene el Item
     * @return Item del la instancia
     */
    public Item getItem() {
        return item;
    }


    /**
     * Obtiene el id de la instancia
     * @return id de la instancia de item
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el id del Item
     * @return id del Item
     */
    public int getItemId() {
        return item.getId();
    }

    /**
     * Obtiene los usos que le quedan a la Instancia
     * @return usos que le quedan
     */
    public int getUsosRestantes() {
        return usosRestantes;
    }

    /**
     * Obtiene el número de elementos que pueden apilarse del Item en una ranura (Slot)
     * @return número de elementos que pueden apilarse del Item
     */
    @Override
    public int stackSize() {
        return item.stackSize();
    }

    @Override
    public String toString() {
        return "InstanceItem{" +
                "id=" + id +
                ", " + item.toString() +
                ", usosRestantes=" + usosRestantes +
                '}';
    }
}
