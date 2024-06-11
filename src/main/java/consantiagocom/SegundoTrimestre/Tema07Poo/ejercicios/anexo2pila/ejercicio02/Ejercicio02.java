package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio02;

import java.util.Random;

public class Ejercicio02 {
    public static final int ELEMENT_COUNT = 3;

    public Ejercicio02() {
        Pila pila = new Pila(ELEMENT_COUNT);
        for (int i = 0; i < ELEMENT_COUNT * 3; i++) {
            pila.push(new Random().nextInt(10));
            System.out.println(pila);
        }

        for (int i = 0; i < ELEMENT_COUNT * 3; i++) {
            System.out.println(pila.pop());
            System.out.println(pila);
        }
    }
}
