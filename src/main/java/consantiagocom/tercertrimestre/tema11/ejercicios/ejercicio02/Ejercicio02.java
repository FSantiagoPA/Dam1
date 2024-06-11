package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio02;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio01.Punto;

public class Ejercicio02 {
    public Ejercicio02() {
        Poligono poligono = new Poligono(new Punto(0,0),
                new Punto(2,0), new Punto(2,2), new Punto(0,2));
        System.out.println(poligono.toString());
        System.out.println("Perímetro: " + poligono.perimetro());
        int trasladaX = 4;
        int trasladaY = -3;
        poligono.traslada(trasladaX,trasladaY);
        System.out.println("Trasladamos x=+" + trasladaX +", y=" + trasladaY +": " + poligono.toString());
        System.out.println("Perímetro: " + poligono.perimetro());
    }
}