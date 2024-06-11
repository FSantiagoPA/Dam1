package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio04;

/**
 * Esta clase debería ser abstracta pero el enunciado del ejercicio nos dice de forma expresa
 * que podemos crear objetos de tipo Electrodomestico.
 */
public class Electrodomestico {
    //Constantes
    /**
     * Colores disponibles.
     * Sería mejor implementarlo como un enumerado pero es requisito del enunciado hacerlo como un String
     */
    private final static String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};

    /**
     * Color por defecto
     */
    protected final static String COLOR_DEF = colores[0];

    /**
     * Consumo energético por defecto
     */
    protected final static char CONSUMO_ENERGETICO_DEF = 'F';

    /**
     * Precio base por defecto
     */
    protected final static double PRECIO_BASE_DEF = 100;

    /**
     * Peso por defecto
     */
    protected final static double PESO_DEF = 5;


    //Atributos
    /**
     * El precio base del electrodomestico
     */
    protected double precioBase;

    /**
     * Color del electrodomestico
     */
    protected String color;

    /**
     * Indica el consumo energetico del electrodomestico
     */
    protected char consumoEnergetico;

    /**
     * Peso del electrodomestico
     */
    protected double peso;


    //Constructores
    /**
     * Constructor con 4 parámetros
     * @param precioBase Precio base en euros
     * @param peso Peso en Kg
     * @param consumoEnergetico Letra asociada al consumo energético
     * @param color Color como cadena de caracteres
     */
    public Electrodomestico(double precioBase, double peso, char consumoEnergetico, String color) {
        this.precioBase = precioBase;
        this.peso = peso;
        comprobarConsumoEnergetico(consumoEnergetico);
        comprobarColor(color);
    }

    /**
     * Contructor por defecto
     */
    public Electrodomestico(){
        this(PRECIO_BASE_DEF, PESO_DEF, CONSUMO_ENERGETICO_DEF, COLOR_DEF);
    }

    /**
     * Crea un Electrodomestico con el precioBase y peso indicados
     * @param precioBase del Electrodomestico
     * @param peso del Electrodomestico
     */
    public Electrodomestico(double precioBase, double peso){
        this(precioBase, peso, CONSUMO_ENERGETICO_DEF, COLOR_DEF);
    }

    /**
     * Comprueba que el color es correcto.
     * Si no lo es se usará el color por defecto (COLOR_DEF)
     * @param color String con el color a comprobar
     */
    private void comprobarColor(String color) {
        boolean encontrado = false;
        for(int i = 0; i < colores.length && !encontrado; i++){
            if (colores[i].equals(color)) {
                encontrado = true;
            }
        }
        if(encontrado){
            this.color = color;
        } else {
            this.color = COLOR_DEF;
        }
    }

    /**
     * Comprueba el consumo energético
     * @param consumoEnergetico Letra del consumo energético
     */
    public void comprobarConsumoEnergetico(char consumoEnergetico){
        consumoEnergetico = Character.toUpperCase(consumoEnergetico);
        if(consumoEnergetico >= 'A' && consumoEnergetico <= 'F') {
            this.consumoEnergetico = consumoEnergetico;
        } else {
            this.consumoEnergetico = CONSUMO_ENERGETICO_DEF;
        }
    }

    /**
     * Devuelve el precio base del Electrodomestico
     * @return precio base del Electrodomestico
     */
    public double getPrecioBase() {
        return precioBase;
    }
    /**
     * Devuelve el color del Electrodomestico
     * @return color del Electrodomestico
     */
    public String getColor() {
        return color;
    }

    /**
     * Devuelve el consumo energético del Electrodomestico
     * @return consumo energético del Electrodomestico
     */
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }
    /**
     * Devuelve el peso del Electrodomestico
     * @return peso del Electrodomestico
     */
    public double getPeso() {
        return peso;
    }
    /**
     * Precio final del Electrodomestico
     * @return precio final del Electrodomestico
     */
    public double precioFinal() {
        double plus = 0;
        switch(consumoEnergetico) {
            case 'A':
                plus += 100;
                break;
            case 'B':
                plus += 80;
                break;
            case 'C':
                plus += 60;
                break;
            case 'D':
                plus += 50;
                break;
            case 'E':
                plus += 30;
                break;
            case 'F':
                plus += 10;
                break;
        }

        if(peso>=0 && peso<19) {
            plus += 10;
        } else if(peso >= 20 && peso < 49) {
            plus += 50;
        } else if(peso >= 50 && peso <= 79) {
            plus += 80;
        } else if(peso >= 80) {
            plus += 100;
        }

        return precioBase + plus;
    }

    /**
     * Obtiene la información de un Electrodomestico como un String
     * @return String con la información del Electrodomestico
     */
    @Override
    public String toString() {
        return "Electrodomestico{" +
                "precioBase=" + precioBase +
                ", color='" + color + '\'' +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                '}';
    }
}
