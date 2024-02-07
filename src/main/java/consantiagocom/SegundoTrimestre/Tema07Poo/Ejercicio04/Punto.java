package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio04;

public class Punto {

    private  double x;
    private  double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punto(){
        this(0,0);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double distance(Punto p){
        return Math.sqrt(Math.pow(p.getX() - this.x, 2) + Math.pow(p.getY() - this.y ,2));
    }
    public void showdistance(){
        System.out.printf("(%.1f , %.1f) ",this.x,this.y);
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x= " + x +
                ", y= " + y +
                '}';
    }
}
