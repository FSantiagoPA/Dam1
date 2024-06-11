package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio01;

public class Ejercicio01 {
    public Ejercicio01() {
        Punto p1 = new Punto(2, 2);
        Punto p2 = new Punto(4,2);
        System.out.println("p1="+p1.toString());
        System.out.println("p2="+p2.toString());
        System.out.println("Distancia: " + Punto.distancia(p1, p2));
        System.out.println("Distancia: "+p1.distancia(p2));
    }
}
