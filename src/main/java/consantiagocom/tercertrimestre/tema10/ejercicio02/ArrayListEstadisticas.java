package consantiagocom.tercertrimestre.tema10.ejercicio02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadistica{
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayListEstadisticas() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListEstadisticas(int capacity){
        super(capacity);
    }
    public ArrayListEstadisticas(Collection<Double> collection){
        super(collection);
    }

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

    @Override
    public double sumatorio() {
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += i;
        }
        return sum;
    }

    @Override
    public double media() {
        return sumatorio() / size();
    }

    @Override
    public double moda() {
        double moda = get(0);
        int contador = 0;
        for(double i : this){
            int contador2 = 0;
            for (double j : this){
                if (i == j) {
                    contador2++;
                }
            }
        }
        return moda;
    }
    @Override
    public String toString(){
        String str = "[";
        for (double i : this){
            str += String.format("%.3f", i) + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        return str;
    }
}


// si queremos aumentar la capacidad del array debemos poner el this