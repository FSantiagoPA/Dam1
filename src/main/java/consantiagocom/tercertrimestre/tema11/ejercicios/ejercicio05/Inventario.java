package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items.InstanceItem;

/**
 * Clase que representa el inventario compuesto por un array de Slot configurable
 */
public class Inventario implements DestroyListener {
    private static final int N_SLOTS = 7;
    private final Slot[] slots;

    /**
     * Construye un inventario con N_SLOTS ranuras
     * y las inicializa
     */
    public Inventario() {
        slots = new Slot[N_SLOTS];
        for(int i = 0; i < slots.length; i++) {
            slots[i] = new Slot(this);
        }
    }

    /**
     * A�ade cantidad de InstanceItem al inventario
     * @param instanceItem El InstanceItem que se quiere a�adir
     * @param cantidad La cantidad a a�adir
     * @return Devuelve el n�mero de instanceItem que se han a�adido
     */
    public int add(InstanceItem instanceItem, int cantidad) {
        int restantes = cantidad;
        InstanceItem currentInstanceItem = instanceItem;
        int lastRestantes = 0;

        for(int i = 0; i < slots.length && restantes > 0; i++) {
            if(restantes != lastRestantes && isNuevaInstanciaNecesaria(instanceItem) ) {
                currentInstanceItem = new InstanceItem(instanceItem.getItem(), this);
            }
            lastRestantes = restantes;
            restantes = slots[i].apilar(currentInstanceItem, restantes);
        }
        return cantidad - restantes;
    }


    /**
     * Este m�todo solo es necesario si los InstanceItem puede estar duplicados
     * En un juego normal esto no ocurrir�a ya que lo que har�amos es mover objetos
     * de un lugar a otro, pero no los crear�amos. Por tanto con comprobar si es un
     * objeto destruible (getDurabilidad() > 0) es suficiente.
     * @param instanceItem
     * @return
     */
    public boolean isNuevaInstanciaNecesaria(InstanceItem instanceItem) {
        for(int i = 0; i < slots.length; i++) {
            InstanceItem slotInstanceItem = slots[i].getInstanceItem();

            if(slotInstanceItem != null && instanceItem.getUsosRestantes() > 0 && slotInstanceItem.getId() == instanceItem.getId())
                return true;
        }
        return false;
    }

    /**
     * Extrae cantidad de InstanceItem al inventario
     * @param instanceItem El InstanceItem que se quiere extraer
     * @param cantidad La cantidad a extraer
     * @return Devuelve el n�mero de instanceItem que se han extra�do
     */
    public int remove(InstanceItem instanceItem, int cantidad) {
        int extraidos = 0;
        int restantes = cantidad;

        for(int i = 0; i < slots.length && restantes > 0; i++) {
            extraidos = slots[i].desapilar(instanceItem, restantes);
            restantes -= extraidos;
        }
        return cantidad - restantes;
    }

    /**
     * Representaci�n del inventario como una cadena de caracteres
     * @return String con la informaci�n del inventario
     */
    @Override
    public String toString() {
        System.out.println("Inventario: ");
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < slots.length; i++) {
            if(slots[i]!= null) {
                builder.append(slots[i].toString()).append("\n");
            }
        }
        return builder.toString();
    }

    /**
     * Este m�todo es llamado cuando un Item
     * @param instanceItem Objeto que se va a destruir
     */
    @Override
    public void onDestroy(InstanceItem instanceItem) {

    }
}