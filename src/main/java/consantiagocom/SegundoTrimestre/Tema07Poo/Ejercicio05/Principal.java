package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio05;


import consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio04.Punto;

public class Principal {
    public static void main(String[] args) {

        Circulo c1 = new Circulo();
        Circulo c2 = new Circulo(2, 3, 5);
        Circulo c3 = new Circulo(new Punto(4, 5), 6);
        Circulo c4 = new Circulo(new Punto(6, 7), 8);

        c1.showDistance();
        System.out.println("\nThe area of circle 1 is: " + c1.area() + "  and the perimeter is: " + c1.perimeter() + " \n");

        c2.showDistance();
        System.out.println("\nThe area of circle 2 is: " + c2.area() + "  and the perimeter is: " + c2.perimeter() + " \n");

        c3.showDistance();
        System.out.println("\nThe area of circle 3 is: " + c3.area() + "  and the perimeter is: " + c3.perimeter() + " \n");

        c4.showDistance();
        System.out.println("\nThe area of circle 4 is: " + c4.area() + "  and the perimeter is: " + c4.perimeter() + " \n");

        System.out.println("\nThe distance between the center of circle 1 and the center of circle2 is: " + c1.distance(c2.getCenter()));
    }
}
