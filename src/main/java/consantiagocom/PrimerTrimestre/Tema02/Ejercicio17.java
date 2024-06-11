package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        public class ConsumMitja {
            public static void main(String[] args) {
                Scanner lector = new Scanner(System.in);
                // Variables PRIMER REPOSTAJE
                float precioLitro1;
                float totalPagado1;
                float kmIniciales;
                // Variables SEGUNDO REPOSTAJE
                float precioLitro2;
                float totalPagado2;
                // Variables TERCER REPOSTAJE
                float kmFinales;
                // Variables para los cálculos
                float litrosRepostados1;
                float litrosRepostados2;
                float kmRecorridos;
                float consumo100;
                float precioKm;

                System.out.println("*** CÁLCULO CONSUMO ***");
                System.out.println("\n\nPRIMER REPOSTAJE");
                System.out.print("Indica el precio del litro de combustible: "); precioLitro1 = lector.nextFloat();
                lector.nextLine();
                System.out.print("Total pagado en el repostaje: ");
                totalPagado1 = lector.nextFloat();
                lector.nextLine();
                System.out.print("Kilómetros que marcaba el cuenta kilómetros: ");
                kmIniciales = lector.nextFloat();
                lector.nextLine();
                System.out.println("\n\nSEGUNDO REPOSTAJE");
                System.out.print("Indica el precio del litro de combustible: "); precioLitro2 = lector.nextFloat();
                lector.nextLine();
                System.out.print("Total pagado en el repostaje: ");
                totalPagado2 = lector.nextFloat();
                lector.nextLine();
                System.out.println("\n\nTERCER REPOSTAJE");
                System.out.print("Kilómetros que marcaba el cuenta kilómetros: ");
                kmFinales = lector.nextFloat();
                lector.nextLine();
                litrosRepostados1 = totalPagado1 / precioLitro1;
                litrosRepostados2 = totalPagado2 / precioLitro2;
                kmRecorridos = kmFinales - kmIniciales;
                consumo100 = 100 * (litrosRepostados1 + litrosRepostados2) / kmRecorridos;
                precioKm = (totalPagado1 + totalPagado2) / kmRecorridos;
                System.out.println("\nConsumo por cada 100Km: " + consumo100);
                System.out.println("Coste por Km: " + precioKm);
                lector.close();
            }
        }

    }
}
