package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio02;

public class Principal {
    public static void main(String[] args) {

        Asignatura asignaturas = new Asignatura("Programming",1017,"course 1");

        System.out.println("Name: " + asignaturas.getName());
        System.out.println("Code: " + asignaturas.getNumbericCode());
        System.out.println("Course: " + asignaturas.getCourse());
    }
}
