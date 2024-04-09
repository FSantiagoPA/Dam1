package consantiagocom.PrimerTrimestre.Tema02;

public class Ejercicio10 {
    public enum MonthsOfYear {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY,
        AUGUST, SEPTEMBER, OCTOBER, NOVEMBER,DECEMBER
    }
    public enum MusicalNotes{
        DO,RE,MI,FA,SOL,LA,SI,
        B_FLAT,B_DOUBLE_FLAT,E_NATURAL
    }
    public enum StudentGrades{
        EXCELLENT,OUTSTADING,PASS,FAIL
    }

    public static void main(String[] args) {
        MonthsOfYear monthsOfYear = MonthsOfYear.JANUARY;
        MusicalNotes musicalNotes = MusicalNotes.DO;
        StudentGrades studentGrades = StudentGrades.EXCELLENT;

        System.out.println(monthsOfYear);
        System.out.println(musicalNotes);
        System.out.println(studentGrades);
    }
}
