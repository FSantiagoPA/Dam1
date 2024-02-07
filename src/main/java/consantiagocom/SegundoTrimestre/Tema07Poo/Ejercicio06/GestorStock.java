package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio06;

/*
import consantiagocom.jresources.JDate;
import consantiagocom.jresources.JRequest;
import consantiagocom.jresources.JString;

public class GestorStock {

    private Bicicleta[] bicicletas;


    */
/**
     * Creates a new GestorStock with the given number of bikes
     *//*

    public GestorStock(int numBicicletas) {
        this.bicicletas = new Bicicleta[numBicicletas];
    }

    */
/**
     * Creates a new bike with requested data
     *//*

    public void nuevaBicicleta() {
        String Sreferencia = JRequest.requestString("Introduzca la referencia de la bicicleta\n (Escriba 'auto' para que se genere automáticamente):");
        long referencia;

        //Step 1: Check if the reference is "auto" or not
        if (JString.cleanString(Sreferencia).equals("auto")) {
            referencia = -1;
            for (Bicicleta bicicleta : bicicletas) {
                if (bicicleta != null && bicicleta.getReferencia() > referencia) {
                    referencia = bicicleta.getReferencia() + 1;
                } else break;
            }
        }

        //Step 2: Check if the reference already exists in case it's not "auto"
        else {
            referencia = Integer.parseInt(Sreferencia);
            //In case the reference already exists, we update the stock
            for (Bicicleta bicicleta : bicicletas) {
                if (bicicleta != null && bicicleta.getReferencia() == referencia) {
                    int stock = JRequest.requestInt("Introduzca el stock recibido: ");
                    bicicleta.setStock(bicicleta.getStock() + stock);
                    System.out.println("Stock actualizado");
                    System.out.println("Stock actual: " + bicicleta.getStock());
                    return;
                }
            }
        }

        //If the reference doesn't exist, we create a new bike with the given data
        String marca = JRequest.requestString("Introduzca la marca de la bicicleta: ");
        String modelo = JRequest.requestString("Introduzca el modelo de la bicicleta: ");
        double peso = JRequest.requestDouble("Introduzca el peso de la bicicleta: ");
        int pulgadas = JRequest.requestInt("Introduzca las pulgadas de la bicicleta: ");
        boolean electrica = JRequest.readOption("¿Es eléctrica? (y/n): ");
        String fechaFabricacion = JDate.readDate("Introduzca la fecha de fabricación (dd/mm/yyyy): ", "dd/MM/yyyy");
        double precio = JRequest.requestDouble("Introduzca el precio de la bicicleta: ");

        //Creating the new bike
        nuevaBicicleta(referencia, marca, modelo, peso, pulgadas, electrica, fechaFabricacion, precio, 0);
    }


    */
/**
     * Creates a new bike with the given data
     *
     * @param marca            Marca de la bicicleta
     * @param modelo           Modelo de la bicicleta
     * @param peso             Peso de la bicicleta en kg
     * @param pulgadas         Pulgadas de la bicicleta
     * @param electrica        Si es eléctrica o no
     * @param fechaFabricacion Fecha de fabricación de la bicicleta
     * @param precio           Precio de la bicicleta
     * @param stock            Stock de la bicicleta
     *//*

    public void nuevaBicicleta(long referencia, String marca, String modelo, double peso, int pulgadas, boolean electrica, String fechaFabricacion, double precio, int stock) {
        for (int i = 0; i < bicicletas.length; i++) {
            if (bicicletas[i] == null) {
                bicicletas[i] = new Bicicleta(referencia, marca, modelo, peso, pulgadas, electrica, fechaFabricacion, precio, stock);
                return;
            }
        }
    }

    */
/**
     * Requests the reference of the bike and sells it
     *//*

    public void venderBicicleta() {
        long referencia = JRequest.requestInt("Introduzca la referencia de la bicicleta: ");
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getReferencia() == referencia) {
                int stock = JRequest.requestInt("Introduzca el stock vendido: ");
                venderBicicleta(referencia, stock);
                return;
            }
        }

    }

    */
/**
     * Sells the bike with the given reference
     *
     * @param referencia Reference of the bike
     * @param stock      Stock to sell
     *//*

    public void venderBicicleta(long referencia, int stock) {
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getReferencia() == referencia) {
                if (bicicleta.getStock() - stock < 0) {
                    System.out.println("No hay suficiente stock");
                    return;
                }
                bicicleta.setStock(bicicleta.getStock() - stock);
                System.out.println("Stock actualizado");
                System.out.println("Stock actual: " + bicicleta.getStock());
                return;
            }
        }

        System.out.println("No se ha encontrado la bicicleta con la referencia " + referencia);

    }

    */
/**
     * Requests the reference of the bike and prints its data
     *//*

    public void consultaReferencia() {
        long referencia = JRequest.requestInt("Introduzca la referencia de la bicicleta: ");
        consultaReferencia(referencia);
    }

    */
/**
     * Prints the data of the bike with the given reference
     *
     * @param referencia Reference of the bike
     *//*

    public void consultaReferencia(long referencia) {
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null && bicicleta.getReferencia() == referencia) {
                System.out.println(bicicleta);
                return;
            }
        }

        System.out.println("No se ha encontrado la bicicleta con la referencia " + referencia);
    }

    */
/**
     * Requests the brand of the bike and prints the data of all the bikes with that brand
     *//*

    public void consultaMarca() {
        String marca = JRequest.requestString("Introduzca la marca de la bicicleta: ");
        consultaMarca(marca);
    }

    */
/**
     * Prints the data of all the bikes with the given brand
     *
     * @param marca Brand of the bike
     *//*

    public void consultaMarca(String marca) {
        boolean state = false;
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null && bicicleta.getMarca().equals(marca)) {
                state = true;
                System.out.println(bicicleta);
            }
        }

        if (!state)
            System.out.println("No se ha encontrado la bicicleta con la marca " + marca);
    }

    */
/**
     * Requests the model of the bike and prints the data of all the bikes with that model
     *//*

    public void consultaModelo() {
        String modelo = JRequest.requestString("Introduzca el modelo de la bicicleta: ");
        consultaModelo(modelo);
    }

    */
/**
     * Prints the data of all the bikes with the given model
     *
     * @param modelo Model of the bike
     *//*

    public void consultaModelo(String modelo) {
        boolean state = false;
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null && bicicleta.getModelo().equals(modelo)) {
                state = true;
                System.out.println(bicicleta);
            }
        }

        if (!state)
            System.out.println("No se ha encontrado la bicicleta con el modelo " + modelo);
    }

    */
/**
     * Prints all the bikes in the stock
     *//*

    public void mostrarStock() {
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta != null) {
                System.out.println(bicicleta);
            }
        }
    }
}*/
