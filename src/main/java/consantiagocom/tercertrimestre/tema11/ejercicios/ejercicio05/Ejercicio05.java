package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05;


import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio05.Items.*;
import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementa Destruible
 * El método onDestroy de ejecutará cuando el item se desgaste
 */
public class Ejercicio05 {
    private final Inventario inventario;
    private final HashMap<Integer, Item> items;

    public Ejercicio05() {
        int opcion;
        inventario = new Inventario();
        items = new HashMap<>();
        initItems();

        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    addItems();
                    break;
                case 2:
                    extractItems();
                    Lib.pausa();
                    break;
                case 3:
                    showInventory();
                    Lib.pausa();
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Inicializa items para tener casos de prueba
     */
    private void initItems() {
        /** Creamos los items */
        Pico pico = new Pico();
        Espada espada = new Espada();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Huevo huevo = new Huevo();
        PerlaEnder perlaEnder = new PerlaEnder();
        /** Añadimos items al HashMap de items */
        items.put(pico.getId(), pico);
        items.put(espada.getId(), espada);
        items.put(piedra.getId(), piedra);
        items.put(madera.getId(), madera);
        items.put(huevo.getId(), huevo);
        items.put(perlaEnder.getId(), perlaEnder);
    }

    /**
     * Muestra el menú principal y solicita una opción válida
     * @return La opción elegida por el usuario
     */
    private int menuPrincipal() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("*************************");
            System.out.println("* GESTIÓN DE INVENTARIO *");
            System.out.println("*************************");
            System.out.println("1. Añadir items");
            System.out.println("2. Extraer items");
            System.out.println("3. Mostrar inventario");
            System.out.println("-----------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            try {
                opcion = Integer.parseInt(Lib.lector.nextLine());
                if (opcion < 0 || opcion > 3) {
                    System.out.println("Elija una opción del menú [0-3]");
                    Lib.pausa();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo números por favor");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    /**
     * Opción del menú para añadir items al inventario
     */
    private void addItems() {
        Item item = menuItems();
        int cantidad;
        int unidades;
        if(item != null) {
            System.out.println("Item seleccionado: " + item.getNombre());
            System.out.println("Cantidad: ");
            try {
                cantidad = Integer.parseInt(Lib.lector.nextLine());
                if (cantidad <= 0) {
                    System.out.println("Cantidad debe ser un número mayor que 0");
                }
                InstanceItem instanceItem = new InstanceItem(item, inventario);
                unidades = inventario.add(instanceItem, cantidad);
                if (unidades == cantidad) {
                    System.out.println("Se han añadido " + unidades + " unidades de " + item.getNombre() + " correctamente");
                } else if (unidades > 0) {
                    System.out.println("Solo se han podido añadir " + unidades + " de " + item.getNombre());
                } else {
                    System.out.println("No se han podido añadir unidades");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo valores numéricos");
            }
        }
    }

    /**
     * Opción del menú para extraer items
     */
    private void extractItems() {
        Item item = menuItems();
        int cantidad;
        int unidades;
        System.out.println("Item seleccionado: " + item.getNombre());
        System.out.println("Cantidad: ");
        try {
            cantidad = Integer.parseInt(Lib.lector.nextLine());
            if(cantidad <= 0) {
                System.out.println("Cantidad debe ser un número mayor que 0");
            }
            InstanceItem instanceItem = new InstanceItem(item, inventario);
            unidades = inventario.remove(instanceItem, cantidad);
            if(unidades == cantidad) {
                System.out.println("Se han extraido " + unidades + " unidades de " + item.getNombre() + " correctamente");
            } else if(unidades > 0){
                System.out.println("Solo se han podido extraer " + unidades + " de " + item.getNombre());
            } else {
                System.out.println("No se han podido extraer unidades");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Solo valores numéricos");
        }
    }

    /**
     * Opción del menú para mostrar el inventario
     */
    private void showInventory() {
        System.out.println("*** INVENTARIO ***");
        System.out.println(inventario.toString());
    }

    /**
     * Opción del menú para mostrar los items disponibles
     * @return El item elegido por el usuario
     */
    private Item menuItems() {
        int opcion = -1;
        Item item = null;

        do {
            Lib.limpiarPantalla();
            System.out.println("*******************");
            System.out.println("* SELECCIONE ITEM *");
            System.out.println("*******************");

            for(Map.Entry<Integer, Item> entry: items.entrySet()) {
                int id = entry.getKey();
                Item itemMenu = entry.getValue();
                System.out.println(id + ". " + itemMenu.getNombre());
            }
            System.out.println("-----------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            try {
                opcion = Integer.parseInt(Lib.lector.nextLine());
                item = items.get(opcion);
                if (opcion != 0 && item == null) {
                    System.out.println("Elija una opción del menú");
                    Lib.pausa();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo números por favor");
                Lib.pausa();
            }
        } while (opcion != 0 && item == null);
        return item;
    }
}
