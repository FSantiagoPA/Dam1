package consantiagocom.tercertrimestre.tema11.ej01;

public class Ej01 {
    public Ej01(){
        Punto punto1 = new Punto(5,5);
        Punto punto2 = new Punto();

        System.out.println(punto1);
        System.out.println(punto2);
        System.out.println("La distancia entre 2 puntos es " + Punto.distance(punto1,punto2));
        System.out.println(punto1.distanceDos(punto2));
    }
}
