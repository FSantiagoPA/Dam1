package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05;


import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items.InstanceItem;

/**
 * Clase que representa una ranura del Inventario
 */
public class Slot implements Apilator {
    private int cantidad;
    private InstanceItem instanceItem;
    private final DestroyListener destroyListener;

    public Slot(DestroyListener destroyListener) {
        this.instanceItem = null;
        this.cantidad = 0;
        this.destroyListener = destroyListener;
    }

    /**
     * Añade cantidad unidades del item indicado a la casilla.
     *
     * @param instanceItem InstanceItem a apilar
     * @param cant Cantidad de instancias de items a añadir
     * @return
     * Devuelve 0 si todas las unidades han podido ser añadidas.
     * Devuelve un número positivo indicando las unidades que no han podido ser añadidas
     */
    public int apilar(InstanceItem instanceItem, int cant) {
        if(this.cantidad < instanceItem.stackSize()) {
            if(this.instanceItem == null) {
                this.instanceItem = instanceItem;
            }

            //Apilamos si pertenecen al mismo item (mismo ItemId) y la misma durabilidad
            if(this.instanceItem.getItemId() == instanceItem.getItemId() && this.instanceItem.getUsosRestantes() == instanceItem.getUsosRestantes()) {
                if(disponible() >= cant) {
                    this.cantidad += cant;
                    return 0;
                } else {
                    int pendiente = cant - disponible();
                    this.cantidad = instanceItem.stackSize();
                    return pendiente;
                }
            }
        }
        return cant;
    }

    /**
     * Despila del inventario la cantidad de la instancia de item indicada
     * si hay suficientes. Si hay menos que la cantidad indicada, desapila la
     * cantidad que hay en el inventario
     * @param instanceItem InstanceItem a desapilar
     * @param cantidad Cantidad que queremos desapilar
     * @return La cantidad de instancias de item desapiladas
     */
    @Override
    public int desapilar(InstanceItem instanceItem, int cantidad) {
        int extraidos = 0;
        if(this.instanceItem != null && this.instanceItem.getItemId() == instanceItem.getItemId()) {
            if(this.cantidad > 0) {
                if(this.cantidad >= cantidad) {
                    extraidos = cantidad;
                } else {
                    extraidos = this.cantidad;
                }
                this.cantidad -= extraidos;
                if(this.cantidad == 0) {
                    this.instanceItem = null;
                }
            }
        }
        return extraidos;
    }

    /**
     * Obtiene el instaceItem actual
     * @return InstanceItem actual
     */
    public InstanceItem getInstanceItem() {
        return instanceItem;
    }

    /**
     * Indica el espacio que le queda disponible a la ranura
     * @return Espacio disponible
     */
    public int disponible() {
        if(instanceItem != null) {
            return instanceItem.stackSize() - cantidad;
        }
        return 0;
    }

    /**
     * Representación de la información de la ranura del inventario como un String
     * @return String con la información de la ranura
     */
    @Override
    public String toString() {
        return "Slot{" +
                instanceItem +
                ", cantidad=" + cantidad +
                '}';
    }
}
