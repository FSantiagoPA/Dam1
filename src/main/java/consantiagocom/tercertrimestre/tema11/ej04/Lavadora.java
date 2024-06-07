package consantiagocom.tercertrimestre.tema11.ej04;

import consantiagocom.tercertrimestre.tema11.ej04.enums.Color;
import consantiagocom.tercertrimestre.tema11.ej04.enums.ConsumoEnergetico;

public class Lavadora extends Electrodomestico{
    //Atributos
    private int carga;

    //Constructor por defecto
    public Lavadora(){
        this.carga = 5;
    }

    //Constructor con el precio y peso
    public Lavadora(int precioBase, int peso, int carga){
        super(precioBase, peso);
        this.carga = carga;
    }

    //Un constructor con la carga y el resto de atributos heredados
    public Lavadora(Color color, ConsumoEnergetico consumoEnergetico, int precioBase, int peso, int carga){
        super(color, consumoEnergetico, precioBase, peso);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    /**
     * Método precioFinal(): si tiene una carga mayor de 30 kg, aumentará el precio 50 €, sino es así no se incrementara el precio.
     * Llama al método padre y añade el precio de la carga
     * @return precio final
     */
    public double precioFinal(){
        double sum = precioBase;
        super.precioFinal();
        if(getCarga() > 5){
            sum += 50;
        }
        return sum;
    }
}
