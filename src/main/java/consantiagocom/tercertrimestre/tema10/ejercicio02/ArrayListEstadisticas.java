package consantiagocom.tercertrimestre.tema10.ejercicio02;

import java.util.*;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadistica{
    private static final int DEFAULT_CAPACITY = 10;

    //Constructor:
    // Extiende la clase ArrayList e implementa la interfaz IEstadisticas
    public ArrayListEstadisticas() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListEstadisticas(int capacity){
        super();
    }
    public ArrayListEstadisticas(Collection<Double> collection){
        super(collection);
    }

    /**
     * Devuelve el valor mínimo de la lista.
     * @return el valor mínimo de la lista
     */
    @Override
    public double minimo() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < size(); i++) {
            double value = get(i);
            if (value > min){
                min = value;
            }
        }
        return min;
    }

    /**
     * Devuelve el valor máximo de la lista.
     * @return el valor máximo de la lista
     */
    @Override
    public double maximo() {
        double max = Double.MIN_VALUE;
        for (int i =0; i < size(); i++){
            double value = get(i);
            if (value > max){
                max = value;
            }
        }
        return max;
    }

    /**
     * Devuelve la suma de todos los valores de la lista
     * @return la suma de todos los valores de la lista
     */
    @Override
    public double sumatorio() {
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += get(i);
        }
        return sum;
    }

    /**
     * Devuelve el promedio de todos los valores de la lista
     * @return el promedio de todos los valores de la lista
     */
    @Override
    public double media() {
        return sumatorio() / size();
    }

    /**
     * Devuelve el valor más repetido de la lista
     * @return el valor más repetido de la lista
     */
//    @Override
//    public double moda() {
//        double moda = get(0);
//        int contador = 0;
//        for(double i : this){
//            int contador2 = 0;
//            for (double j : this){
//                if (i == j) {
//                    contador2++;
//                }
//            }
//            if (contador2 > contador){
//                contador = contador2;
//                moda = i;
//            }
//        }
//        return moda;
//    }

    public double moda() {
        HashMap<Double,Integer> repeticiones = new HashMap<>();
        int maxReps = 0;
        double valorMasRepetido = get(0);
        for (int i = 0; i <size(); i++) {
            double numero = get(i);
            int valor = 0;
            Integer reps = repeticiones.get(numero);
            if (reps != null)
                valor = reps + 1;

            if (maxReps < valor){
                valorMasRepetido = numero;
                maxReps = valor;
            }
            repeticiones.put(numero, valor);
        }
        return valorMasRepetido;
    }

    @Override
    public String toString(){
        String str = "[";
        for (double i : this){
            str += String.format("%.2f", i) + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        return str;
    }
}


// si queremos aumentar la capacidad del array debemos poner el this