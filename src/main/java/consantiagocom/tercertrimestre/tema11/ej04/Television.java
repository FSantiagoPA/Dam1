package consantiagocom.tercertrimestre.tema11.ej04;

import consantiagocom.tercertrimestre.tema11.ej04.Enums.Color;
import consantiagocom.tercertrimestre.tema11.ej04.Enums.ConsumoEnergetico;

public class Television extends Electrodomestico{

    private double pulgadas;
    private boolean smartTV;

    //Constructor por defecto
    public Television(){
        this.pulgadas = 20;
        this.smartTV = false;
    }

    //Constructor con el precio y peso
    public Television(int precioBase, int peso, double pulgadas, boolean smartTV){
        super(precioBase,peso);
        this.pulgadas = pulgadas;
        this.smartTV = smartTV;
    }

    //Un constructor con la resolución, smartTV y el resto de atributos heredados.
    public Television(Color color, ConsumoEnergetico consumoEnergetico, int precioBase, int peso,
                      double pulgadas, boolean smartTV){
        super(color,consumoEnergetico,precioBase,peso);
        this.pulgadas = pulgadas;
        this.smartTV = smartTV;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    /**
     * Método precioFinal(): si tiene una resolución mayor de 40 pulgadas, se incrementara el precio un 30% y si es smartTV, aumentará 50 €.
     * Llama al método padre y añade el precio de la resolución y smartTV.
     * @return precio final
     */
    @Override
    public double precioFinal() {
        super.precioFinal();
        double cambioDePrecio = getPrecioBase();
        double precioSmart = 0;
        double sum;
        if (isSmartTV())
            precioSmart = 50;
        if (getPulgadas() > 40){
            cambioDePrecio = cambioDePrecio * 1.30;
        }
        sum = precioBase + precioSmart + cambioDePrecio;
        return  sum;
    }
}
