package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio04;

public class Principal {
    public static void main(String[] args) {

        Punto p1 = new Punto(1,2);
        Punto p2 = new Punto(5,9);

        System.out.printf("Distancia entre los puntos: %.3f\n", p1.distance(p2));

        p1.showdistance();
        p2.showdistance();


    }
}
