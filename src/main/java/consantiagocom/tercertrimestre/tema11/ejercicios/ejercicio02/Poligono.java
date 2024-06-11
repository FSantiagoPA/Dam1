package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio02;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio01.Punto;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que representa un Pol�gono a partir de una Lista de Puntos
 */
public class Poligono {
    /** V�rtices del Pol�gono */
    private ArrayList<Punto> puntos;

    /**
     * Construye un pol�gono a partir de una lista de puntos
     * @param puntos La lista de puntos
     */
    public Poligono(Punto... puntos) {
        this.puntos = new ArrayList<>();
        for(int i = 0; i < puntos.length; i++) {
            this.puntos.add(puntos[i]);
        }
        // Tambi�n podemos hacerlo sin bucle aprovechando los m�todos de la interfaz Collection
        // this.puntos.addAll(Arrays.asList(puntos));
    }

    /**
     * Construye un pol�gono a partir de un ArrayList de puntos
     * @param puntos ArrayList con los puntos del pol�gono
     */
    public Poligono(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    /**
     * Traslada un pol�gono con un desplazamiento indicado por x e y
     * @param x Desplazamiento en el eje horizontal
     * @param y Desplazamiento en el eje vertical
     */
    public void traslada(double x, double y) {
        // Versi�n sin necesidad de setters
        // Se pod�a haber modificado cada punto definiendo setters en la clase Punto
        ArrayList<Punto> puntosPrima = new ArrayList<>();
        for(Punto punto: puntos) {
            puntosPrima.add(new Punto(punto.getX() + x, punto.getY() + y));
        }
        this.puntos = puntosPrima;
    }

    /**
     * Obtiene el n�mero de v�rtices del pol�gono
     * @return El n�mero de v�rtices del pol�gono
     */
    public int numVertices() {
        return puntos.size();
    }

    /**
     * Obtiene el per�metro del pol�gono
     * @return
     */
    public double perimetro() {
        double suma = 0;
        for(int i = 0; i < puntos.size(); i++) {
            //Como sabemos que los puntos vecinos son adyacentes
            Punto p1 = puntos.get(i);
            //Para tener en cuenta el �ltimo con el primero hacemos el m�dulo
            Punto p2 = puntos.get((i+1) % puntos.size());
            suma += p1.distancia(p2);
        }
        return suma;
    }

    /**
     * Obtiene la representaci�n del pol�gono como una cadena de caracteres
     * @return Representaci�n del pol�gono indicando cada uno de los puntos que lo conforman
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pol�gono {\n");
        for(Punto punto: puntos) {
            builder.append("  (").append(punto.getX()).append(",").
                    append(punto.getY()).append(")\n");
        }
        builder.append("}");
        return builder.toString();
    }
}
