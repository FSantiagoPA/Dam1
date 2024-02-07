package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio05;
import consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio04.Punto;

public class Circulo {

    private Punto center;
    private double radio;

    public Circulo(Punto center, double radio) {
        this.center = center;
        this.radio = radio;
    }
    public Circulo(double x, double y, double radio){
        this(new Punto(x,y),radio);
    }
    public Circulo(){
        this(new Punto(),1);
    }

    public Punto getCenter() {
        return center;
    }
    public void setCenter(Punto center) {
        this.center = center;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    /**
     * With this method it is responsible for obtaining the distance from a point to the center
     * @param
     * @return It will return the distance that point x has from the center
     */
    public double distance(Punto p){
        return p.distance(center);
    }

    /**
     * This method will make us the area of the circle
     * @return It will return the result of the mathematical operation
     */
    public double area(){
        return Math.PI * Math.pow(radio,2);
    }

    /**
     * This method will make us the perimeter of the circle
     * @return It will return the result of the mathematical operation
     */
    public double perimeter(){
        return 2 * Math.PI * radio;
    }

    /**
     *
     */
    public void showDistance(){
        System.out.printf("Circle of radius %.1f located in the ", radio);
        if (center.getX() == 0 && center.getY() == 0){
            System.out.println("Coordinates origin");
        }else {
            System.out.print("Point ");
            center.showdistance();
        }
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "center=" + center +
                ", radio=" + radio +
                '}';
    }
}
