package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio04;

public class Television extends Electrodomestico {

    //Constantes
    /**
     * Resolucion por defecto
     */
    private final static int RESOLUCION_DEF = 20;

    private final static boolean SMARTTV_DEF = false;

    //Atributos
    /**
     * Resolución del televisor
     */
    private final int resolucion;

    /**
     * Indica si es SmartTV
     */
    private final boolean smartTV;

    //Constructor
    /**
     * Crea una Television con los valores por defecto
     */
    public Television() {
        this(PRECIO_BASE_DEF, PESO_DEF, CONSUMO_ENERGETICO_DEF, COLOR_DEF, RESOLUCION_DEF, SMARTTV_DEF);
    }

    /**
     * Constructor con 2 parámetros
     * @param precioBase Precio base en euros
     * @param peso Peso en Kg
     */
    public Television(double precioBase, double peso) {
        this(precioBase, peso, CONSUMO_ENERGETICO_DEF, COLOR_DEF, RESOLUCION_DEF, SMARTTV_DEF);
    }

    /**
     * Contructor con 6 parámetros
     * @param precioBase Precio base en euros
     * @param peso Peso en Kg
     * @param consumoEnergetico Letra asociada al consumo energético
     * @param color Color como cadena de caracteres
     * @param resolucion Resolucion de la pantalla en pulgadas
     * @param smartTV Indica si la televisión es una SmartTV o no
     */
    public Television(double precioBase, double peso, char consumoEnergetico, String color, int resolucion, boolean smartTV) {
        super(precioBase, peso, consumoEnergetico, color);
        this.resolucion = resolucion;
        this.smartTV = smartTV;
    }

    /**
     * Precio final de la television
     * @return precio final de la television
     */
    public double precioFinal() {
        //Invocamos el método precioFinal del método padre
        double plus = super.precioFinal();

        //Añadimos el codigo necesario para las Televisiones
        if (resolucion > 40) {
            plus += precioBase * 0.3;
        }
        if (smartTV) {
            plus += 50;
        }

        return plus;
    }

    /**
     * Representación de la información de una Television como un String
     * @return String con la información de la Television
     */
    @Override
    public String toString() {
        return "Television{" +
                "precioBase=" + precioBase +
                ", color='" + color + '\'' +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                ", resolucion=" + resolucion +
                ", smartTV=" + smartTV +
                '}';
    }
}
