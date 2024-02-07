package consantiagocom.PrimerTrimestre.Tema02;

public class Ejercicio03 {
    public static void main(String[] args) {

        float precioZapatos = 85f;
        float porcentaje = 15f;

        float descuento = (precioZapatos * porcentaje) /100;
        float precioFinal = precioZapatos - descuento;


        System.out.println("El precio inicial de los zapatos es: " +precioZapatos+ "$" +
                " y con un descuento de: " +porcentaje+ "%" +
                " y si ahora se le aplicara el descuento su precio final seria: " + precioFinal + "$");
    }
}
