package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios.busquedayordenacionarrays;

public class EstadisticasArray {
    private final int[] array;
    private int min;
    private int max;
    private int suma;
    private final double media;
    private int cantidadNumerosNegativos;
    private int cantidadNumerosPositivos;

    public EstadisticasArray(int[] array) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        this.array = array;
        suma = 0;
        for (int e : array) {
            if (e >= 0)
                cantidadNumerosPositivos++;
            else
                cantidadNumerosNegativos++;
            if (e > max)
                max = e;
            if (e < min)
                min = e;
            suma += e;
        }
        media = (double)suma / array.length;
    }

    /**
     * @return the array
     */
    public int[] getArray() {
        return array;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @return the suma
     */
    public int getSuma() {
        return suma;
    }

    /**
     * @return the media
     */
    public double getMedia() {
        return media;
    }

    /**
     * @return the cantidadNumerosNegativos
     */
    public int getCantidadNumerosNegativos() {
        return cantidadNumerosNegativos;
    }

    /**
     * @return the cantidadNumerosPositivos
     */
    public int getCantidadNumerosPositivos() {
        return cantidadNumerosPositivos;
    }
}
