package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Apilable;

/**
 * Clase abstracta que se utiliz� como base para representar cada uno de los
 * items del juego.
 * Los items son �nicos y no se deber�an repetir (ver InstanceItem)
 */
public abstract class Item implements Apilable {
    private static int N_ITEM = 0;
    private final int id;
    private final String nombre;
    private final int durabilidad;

    /**
     * Crea un Item con el nombre y la durabilidad indicada
     * @param nombre Nombre del Item
     * @param durabilidad N�mero m�ximo de usos que tendr�n las instancias de Item (InstanceItem) que se creen
     */
    public Item(String nombre, int durabilidad) {
        this.id = ++N_ITEM;
        this.nombre = nombre;
        this.durabilidad = durabilidad;
    }

    /**
     * Crea un Item con el nombre con durabilidad infinita (-1)
     * @param nombre Nombre del Item
     */
    public Item(String nombre) {
        this(nombre, -1);
    }

    /**
     * Obtiene el id del Item
     * @return id del Item
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del Item
     * @return nombre del Item
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el n�mero de usos m�ximo que tendr�n por defecto las instancias de Item (InstanceItem)
     * @return usos m�ximos
     */
    public int getDurabilidad() {
        return durabilidad;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", durabilidad=" + durabilidad +
                '}';
    }
}
