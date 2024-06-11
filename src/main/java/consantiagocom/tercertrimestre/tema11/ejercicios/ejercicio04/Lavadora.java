package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio04;

public class Lavadora extends Electrodomestico {

    //Constantes
    /**
     * Carga por defecto
     */
    private final static int CARGA_DEF = 5;

    //Atributos
    /**
     * Carga de la lavadora
     */
    private final int carga;


    //Constructor
    /**
     * Constructor con 5 parámetros
     * @param precioBase Precio base en euros
     * @param peso Peso en Kg
     * @param consumoEnergetico Letra asociada al consumo energético
     * @param color Color como cadena de caracteres
     * @param carga Carga máxima en Kg
     */
    public Lavadora(double precioBase, double peso, char consumoEnergetico, String color, int carga) {
        super(precioBase,peso, consumoEnergetico,color);
        this.carga=carga;
    }

    /**
     * Contructor por defecto
     */
    public Lavadora(){
        this(PRECIO_BASE_DEF, PESO_DEF, CONSUMO_ENERGETICO_DEF, COLOR_DEF, CARGA_DEF);
    }

    /**
     * Constructor con 2 parámetros
     * @param precioBase Precio base en euros
     * @param peso Peso en Kg
     */
    public Lavadora(double precioBase, double peso) {
        this(precioBase, peso, CONSUMO_ENERGETICO_DEF, COLOR_DEF, CARGA_DEF);
    }

    /**
     * Devuelve la carga de la lavadora
     * @return int con la carga máxima
     */
    public int getCarga() {
        return carga;
    }

    /**
     * Precio final de la lavadora
     * @return precio final de la lavadora
     */
    public double precioFinal() {
        //Invocamos el método precioFinal del método padre
        double plus = super.precioFinal();

        //Añadimos el código necesario para las Lavadoras
        if (carga > 30){
            plus += 50;
        }

        return plus;
    }

    /**
     * Representación de la información de una lavadora como un String
     * @return String con la información de una lavadora
     */
    @Override
    public String toString() {
        return "Lavadora{" +
                "precioBase=" + precioBase +
                ", color='" + color + '\'' +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                ", carga=" + carga +
                '}';
    }
}
