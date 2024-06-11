package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio05;
import consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio04.Punto;

public class Ejercicio5 {

    public Ejercicio5() {
        Circunferencia c1 = new Circunferencia();
        Circunferencia c2 = new Circunferencia(4,5,3);
        Circunferencia c3 = new Circunferencia(new Punto(2,7), 8);
        c1.visualizarCirculo();
        System.out.println("El perímetro del círculo c1 = " + c1.toString() + " es " +c1.calcularPerimetro());
        System.out.println("El área del círculo c1 = " + c1.toString() + " es " +c1.calcularArea());
        c2.visualizarCirculo();
        System.out.println("El perímetro del círculo c2 = " + c2.toString() + " es " +c2.calcularPerimetro());
        System.out.println("El área del círculo c2 = " + c2.toString() + " es " +c2.calcularArea());
        c3.visualizarCirculo();
        System.out.println("El perímetro del círculo c3 = " + c3.toString() + " es " +c3.calcularPerimetro());
        System.out.println("El área del círculo c3 = " + c3.toString() + " es " +c3.calcularArea());
        System.out.println("La distancia entre c1 y c2 es de " + c1.calcularDistancia(c2));
        System.out.println("La distancia entre c1 y c3 es de " + c1.calcularDistancia(c3.getCentro()));
    }
}