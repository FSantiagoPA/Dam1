package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio04;

public class Ejercicio4 {

    public Ejercicio4() {
        Punto p1 = new Punto(8,4);
        Punto p2 = new Punto();
        Punto p3 = new Punto(3, 5);
        Punto p4 = new Punto(4.5,3.5);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println("La distancia entre p1 = " + p1 + " y p3 = " + p3 + " es " + p1.calcularDistancia(p3));
    }
}
