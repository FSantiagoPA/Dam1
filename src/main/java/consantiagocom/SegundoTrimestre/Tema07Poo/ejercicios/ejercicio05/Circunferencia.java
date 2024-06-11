package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio05;
import consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio04.Punto;

public class Circunferencia {
    private Punto centro;
    private double radio;

    public Circunferencia(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public Circunferencia(double x, double y, double radio) {
        centro = new Punto(x,y);
        this.radio = radio;
    }

    public Circunferencia() {
        centro = new Punto(0,0);
        radio = 1;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        // Copia o asignación
        // IMPORTANTE: tener claro las diferencias
        this.centro = new Punto(centro);
        // this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularDistancia(Punto p) {
        return centro.calcularDistancia(p);
    }

    public double calcularDistancia(Circunferencia c) {
        return centro.calcularDistancia(c.centro);
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radio,2);
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    public void visualizarCirculo() {
        System.out.print("Círculo de radio " + radio + " cm situado en ");
        if(centro.getX() == 0 && centro.getY() == 0) {
            System.out.println("el origen de coordenadas");
        } else {
            System.out.println("el punto " + centro.toString());
        }
    }

    @Override
    public String toString() {
        String result = "Circunferencia de radio " + radio + " cm situada en ";
        if(centro.getX() == 0 && centro.getY() == 0) {
            result += "el origen de coordenadas";
        } else {
            result += "el punto " + centro.toString();
        }
        return result;
    }
}
