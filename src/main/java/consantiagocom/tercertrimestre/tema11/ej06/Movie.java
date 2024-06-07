package consantiagocom.tercertrimestre.tema11.ej06;

import java.util.GregorianCalendar;

public class Movie extends Multimedia {

    //Atributos
    private final int duration;
    private final String primaryActor;
    private final String  primaryActress;

    public int getDuration() {
        return duration;
    }

    public String getPrimaryActor() {
        return primaryActor;
    }

    public String getPrimaryActress() {
        return primaryActress;
    }

    public Movie(String title, String author, TYPE format, GregorianCalendar calendar, int duration, String primaryActor, String primaryActress) {
        super(title, author, format, calendar);
        this.duration = duration;
        this.primaryActor = primaryActor;
        this.primaryActress = primaryActress;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "duration=" + duration +
                ", primaryActor='" + primaryActor + '\'' +
                ", primaryActress='" + primaryActress + '\'' +
                '}';
    }
}
