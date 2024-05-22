package consantiagocom.tercertrimestre.tema11.ej02;

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
     * MEtodo para calcular distancia
     * @param uno
     * @param dos
     * @return
     */
    public static double distance(Punto uno, Punto dos){
        return Math.sqrt(Math.pow((dos.x-uno.x),2)+Math.pow((dos.y- uno.y),2));
    }
    public void traslada(double x , double y){
        this.x = + x;
        this.y = - y;
    }
    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
