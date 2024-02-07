package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio06;

public class Bicicleta {
    private final long referencia;
    private final String marca;
    private final String modelo;
    private final double peso;
    private final int pulgadas;
    private final boolean electrica;
    private final String fechaFabricacion;
    private final double precio;
    private int stock;

    // Control de referencia de bicicletas
    private long refInit = 0;

    // Constructor por defecto
    public Bicicleta(long referencia, String marca, String modelo, double peso, int pulgadas, boolean electrica, String fechaFabricacion, double precio, int stock) {
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.pulgadas = pulgadas;
        this.electrica = electrica;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.stock = stock;
    }

    //Getters
    public long getReferencia() {
        return referencia;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPeso() {
        return peso;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public boolean isElectrica() {
        return electrica;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public long getRefInit() {
        return refInit;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    // Método para imprimir la información de la bicicleta
    @Override
    public String toString() {
        String toReturn = String.format("Ref. : %-10d || Marca: %-12s || Modelo: %-8s || Peso: %-5.2f || Pulgadas: %-4d || Electrica: %-4s || Fecha de fabricación: %-10s || Precio: %-8.2f || Stock: %-3d", referencia, marca, modelo, peso, pulgadas, (electrica ? "si" : "no"), fechaFabricacion, precio, stock);

        return toReturn;
    }

}