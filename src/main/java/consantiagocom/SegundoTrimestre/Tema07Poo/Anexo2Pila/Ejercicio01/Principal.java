package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio01;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Random random = new Random();
        DynamicArrayProfe dynamicArrayProfe = new DynamicArrayProfe(5);
        for (int i = 0; i <5; i++) {
            dynamicArrayProfe.add(random.nextDouble()*100);
        }
        System.out.println(dynamicArrayProfe);
        dynamicArrayProfe.set(3,5);
        System.out.println(dynamicArrayProfe);

    }
}
