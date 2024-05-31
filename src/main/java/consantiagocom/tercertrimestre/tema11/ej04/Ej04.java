package consantiagocom.tercertrimestre.tema11.ej04;

import java.util.ArrayList;
import java.util.Random;

public class Ej04 {
    public  Ej04(){
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
        Random random = new Random();

        // Crear 10 electrodomésticos con valores aleatorios
        for (int i = 0; i < 10; i++) {
            int tipo = random.nextInt(3);
            switch (tipo) {
                case 0:
                    electrodomesticos.add(new Electrodomestico(random.nextInt(500), random.nextInt(100)));
                    break;
                case 1:
                    electrodomesticos.add(new Lavadora(random.nextInt(500), random.nextInt(100), random.nextInt(10)));
                    break;
                case 2:
                    electrodomesticos.add(new Television(random.nextInt(500), random.nextInt(100), random.nextInt(50), random.nextBoolean()));
                    break;
            }
        }

        double totalElectrodomesticos = 0;
        double totalLavadoras = 0;
        double totalTelevisores = 0;

        // Recorrer la lista y ejecutar precioFinal()
        for (Electrodomestico e : electrodomesticos) {
            double precio = e.precioFinal();
            totalElectrodomesticos += precio;

            if (e instanceof Lavadora) {
                totalLavadoras += precio;
            } else if (e instanceof Television) {
                totalTelevisores += precio;
            }
        }

        // Mostrar el importe total de cada clase
        System.out.println("Total Electrodomesticos: " + totalElectrodomesticos);
        System.out.println("Total Lavadoras: " + totalLavadoras);
        System.out.println("Total Televisores: " + totalTelevisores);
    }
}
