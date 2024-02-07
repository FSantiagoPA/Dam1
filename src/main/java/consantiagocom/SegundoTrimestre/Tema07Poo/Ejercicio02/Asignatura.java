package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio02;

public class Asignatura {

    private final String name;
    private final int numbericCode;
    private final String course;

    public Asignatura(String name, int numbericCode, String course) {
        this.name = name;
        this.numbericCode = numbericCode;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getNumbericCode() {
        return numbericCode;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Asignaturas{" +
                "name='" + name + '\'' +
                ", numbericCode=" + numbericCode +
                ", course='" + course + '\'' +
                '}';
    }
}
