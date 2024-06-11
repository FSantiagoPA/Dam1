package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio06;

import java.util.Random;

public class Ejercicio06 {
    public Ejercicio06() {
        testCircularQueue(4);
    }

    public void testCircularQueue(int size) {
        Random random = new Random();
        System.out.printf("Creando cola de tamaño %d ...\n", size);
        ColaCircular colaCircular = new ColaCircular(size);
        for (int i = 0; i < size; i++) {
            double value = random.nextDouble() * 10;
            System.out.printf("Encolando %.2f\n", value);
            colaCircular.add(value);
        }
        System.out.println(colaCircular.toDebugString());

        for (int i = 0; i < 10; i++) {
            double value = random.nextDouble() * 10;
            if (random.nextBoolean()) {
                System.out.printf("Encolando %.2f\n", value);
                colaCircular.add(value);
            } else {
                System.out.printf("Desencolando %.2f\n", colaCircular.remove());
            }
            System.out.println(colaCircular.toDebugString());
        }
    }
}
