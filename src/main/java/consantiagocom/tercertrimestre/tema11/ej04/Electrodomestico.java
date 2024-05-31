package consantiagocom.tercertrimestre.tema11.ej04;

import consantiagocom.tercertrimestre.tema11.ej04.Enums.Color;
import consantiagocom.tercertrimestre.tema11.ej04.Enums.ConsumoEnergetico;

public class Electrodomestico {
    //Atributos
    protected final int precioBase;
    private Color color;
    private ConsumoEnergetico consumoEnergetico;
    private final int peso;

    // Cosntructor por defecto
    public Electrodomestico(){
        this.color = Color.BLANCO;
        this.consumoEnergetico = ConsumoEnergetico.F;
        this.precioBase = 100;
        this.peso = 5;
    }

    // Constructor con precio y peso
    public Electrodomestico(int precioBase, int peso){
        this.color = Color.BLANCO;
        this.consumoEnergetico = ConsumoEnergetico.F;
        this.precioBase = precioBase;
        this.peso = peso;
    }

    //Constructor con todos los atributos
    public Electrodomestico(Color color, ConsumoEnergetico consumoEnergetico, int precioBase, int peso){
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public Color getColor() {
        return color;
    }

    public ConsumoEnergetico getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public int getPeso() {
        return peso;
    }

    /**
     * Este método verifica si el carácter de entrada 'letra' coincide con alguno de los valores del enum ConsumoEnergetico.
     * Si se encuentra una coincidencia, el método retorna sin hacer ningún cambio.
     * Si no se encuentra ninguna coincidencia después de verificar todos los valores del enum, establece el campo 'consumoEnergetico' del objeto actual a ConsumoEnergetico.F.
     * @param letra El carácter a verificar contra los valores del enum ConsumoEnergetico.
     */
    public void comprobarConsumoEnergetico(char letra){
        ConsumoEnergetico [] ce = ConsumoEnergetico.values();
        for (ConsumoEnergetico energetico : ce){
            if (energetico.name().equalsIgnoreCase(String.valueOf(letra))){
                return;
            }
        }
        this.consumoEnergetico = ConsumoEnergetico.F;
    }

    /**
     * Este método verifica si el color de entrada coincide con alguno de los valores del enum Color.
     * Si se encuentra una coincidencia, el método retorna sin hacer ningún cambio.
     * Si no se encuentra ninguna coincidencia después de verificar todos los valores del enum, establece el campo 'color' del objeto actual a Color.BLANCO.
     * @param color El color a verificar contra los valores del enum Color.
     */
    public void comprobarColor(String color){
        Color [] colores = Color.values();
        for(Color c : colores){
            if(c.name().equalsIgnoreCase(color)){
                return;
            }
        }
        this.color = Color.BLANCO;
    }

    /**
     * Este método calcula el precio final de un electrodoméstico.
     * Primero, obtiene el valor del consumo energético y el peso del electrodoméstico.
     * Luego, según el peso del electrodoméstico, asigna un valor específico a 'precioPeso'.
     * Finalmente, suma el precio base, el precio del consumo energético y el precio del peso para obtener el precio final.
     * @return El precio final del electrodoméstico.
     */
    public double precioFinal(){
       double precioConsumo = consumoEnergetico.getValor();
       double precioPeso = getPeso();
       double sum;
       if (peso > 0 && peso <19){
           precioPeso = 10;
       } else if (peso > 20 && peso < 49) {
           precioPeso = 50;
       } else if (peso > 50 && peso < 79) {
           precioPeso = 80;
       } else if (peso > 80) {
           precioPeso = 100;
       }
       sum = precioBase + precioConsumo + precioPeso;
       return sum;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "precioBase=" + precioBase +
                ", color=" + color +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                '}';
    }
}
