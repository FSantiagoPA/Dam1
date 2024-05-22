package consantiagocom.tercertrimestre.tema11.ej01;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto(){
        this.x = 10;
        this.y = 10;
    }

    /**
     * Metodo de calcular distancia
     * @param uno
     * @param dos
     * @return
     */
    public static double distance(Punto uno,Punto dos){
        return Math.sqrt(Math.pow((dos.x-uno.x),2)+Math.pow((dos.y- uno.y),2));
    }
    /*
     * double x = this.x -punto.x
     * double y = this.y - punto.y
     * p1.distancia(p2)
     */

    public double distanceDos(Punto punto){
        double x = this.x -punto.x;
        double y = this.y - punto.y;
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
