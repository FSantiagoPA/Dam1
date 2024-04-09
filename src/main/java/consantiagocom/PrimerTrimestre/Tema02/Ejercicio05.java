package consantiagocom.PrimerTrimestre.Tema02;

public class Ejercicio05 {
    public static <PI> void main(String[] args) {
        //We assign variables
        int height = 2;
        int width = 4;


        //Operations
        int area = width*height;
        int perimeter = height + height + width + width;

        //print the result
        System.out.println("Area of a rectangle: " + area + "cm^2");
        System.out.println("Perimeter of a rectangle: " + perimeter + "cm");

    }
}
