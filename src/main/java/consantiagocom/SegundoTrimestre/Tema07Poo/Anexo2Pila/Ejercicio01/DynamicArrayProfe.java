package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio01;

import java.util.Arrays;

public class DynamicArrayProfe {

    private final float GROW_FACTOR = 2f;
    private double [] data;
    private int elementCount;

    public DynamicArrayProfe(int capacidadInicial){
        data = new double[capacidadInicial];
        elementCount = 0;
    }
    public boolean isFull(){
        return elementCount == data.length;
    }
    private void resize(){
        double[] copy = new double[Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < elementCount; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }
    public boolean add(double element){
        if (isFull()){
            resize();
        }
        data[elementCount++] = element;
        return true;
    }
    public boolean add(int index, double value){
        if (index > elementCount || index < 0)
            return false;
        if (isFull()){
            resize();
        }
        moveToRight(index);
        data[index] = value;
        return true;
    }
    private void moveToRight(int index){
        for (int i = elementCount; i <index; i++) {
            data[i] = data[i-1];
        }
        elementCount++;
    }
    private void moveToLeft(int index){
        for (int i = index; i <elementCount - 1; i++) {
            data[i] = data[i+1];
        }
        elementCount--;
    }
    public double remove(int index){
        if (index > elementCount || index < 0)
            return Double.POSITIVE_INFINITY;

        double result = data[index];
        moveToLeft(index);
        return result;
    }
    public double remove(double element){
        double result = Double.POSITIVE_INFINITY;
        for (int i = 0; i <elementCount; i++) {
            if (data[i] == element){
                result = data[i];
                moveToLeft(i);
                return result;
            }
        }
        return result;
    }
    public double get(int index) {
        if (index > elementCount || index < 0)
            return Double.POSITIVE_INFINITY;
        return data[index];
    }
    public boolean set(int index, double value){
        if (index > elementCount || index < 0)
            return false;
        data[index] = value;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicArrayProfe that = (DynamicArrayProfe) o;

        if (elementCount != that.elementCount) return false;
        for(int i = 0; i <elementCount; i++) {
            if (data[i] != that.data[i])
                return false;
        }
        return true;
        //return Arrays.equals(data, that.data);
    }
    public int size(){
        return elementCount;
    }

    @Override
    public int hashCode() {
        //Habria que crear una funcion hash que solo tuviese en cuenta
        //los primeros elementCount -1 elementos

        double[] effectiveArray = new double[elementCount];
        for (int i = 0; i <effectiveArray.length; i++) {
            effectiveArray[i]= data[i];
        }
        int result = Arrays.hashCode(data);
        result = 31 * result + elementCount;
        return result;
    }

    @Override
    public String toString() {
        return "DynamicArrayProfe{ " +
                "data= " + Arrays.toString(data) +
                ", elementCount=" + elementCount +
                " }";
    }
}
