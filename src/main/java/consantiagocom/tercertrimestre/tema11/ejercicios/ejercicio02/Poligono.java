package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio02;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio01.Punto;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que representa un Polígono a partir de una Lista de Puntos
 */
public class Poligono {
    /** Vértices del Polígono */
    private ArrayList<Punto> puntos;

    /**
     * Construye un polígono a partir de una lista de puntos
     * @param puntos La lista de puntos
     */
    public Poligono(Punto... puntos) {
        this.puntos = new ArrayList<>();
        for(int i = 0; i < puntos.length; i++) {
            this.puntos.add(puntos[i]);
        }
        // También podemos hacerlo sin bucle aprovechando los métodos de la interfaz Collection
        // this.puntos.addAll(Arrays.asList(puntos));
    }

    /**
     * Construye un polígono a partir de un ArrayList de puntos
     * @param puntos ArrayList con los puntos del polígono
     */
    public Poligono(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    /**
     * Traslada un polígono con un desplazamiento indicado por x e y
     * @param x Desplazamiento en el eje horizontal
     * @param y Desplazamiento en el eje vertical
     */
    public void traslada(double x, double y) {
        // Versión sin necesidad de setters
        // Se podía haber modificado cada punto definiendo setters en la clase Punto
        ArrayList<Punto> puntosPrima = new ArrayList<>();
        for(Punto punto: puntos) {
            puntosPrima.add(new Punto(punto.getX() + x, punto.getY() + y));
        }
        this.puntos = puntosPrima;
    }

    /**
     * Obtiene el número de vértices del polígono
     * @return El número de vértices del polígono
     */
    public int numVertices() {
        return puntos.size();
    }

    /**
     * Obtiene el perímetro del polígono
     * @return
     */
    public double perimetro() {
        double suma = 0;
        for(int i = 0; i < puntos.size(); i++) {
            //Como sabemos que los puntos vecinos son adyacentes
            Punto p1 = puntos.get(i);
            //Para tener en cuenta el último con el primero hacemos el módulo
            Punto p2 = puntos.get((i+1) % puntos.size());
            suma += p1.distancia(p2);
        }
        return suma;
    }

    /**
     * Obtiene la representación del polígono como una cadena de caracteres
     * @return Representación del polígono indicando cada uno de los puntos que lo conforman
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Polígono {\n");
        for(Punto punto: puntos) {
            builder.append("  (").append(punto.getX()).append(",").
                    append(punto.getY()).append(")\n");
        }
        builder.append("}");
        return builder.toString();
    }
}
