package consantiagocom.tercertrimestre.tema11.ej06;

import java.util.GregorianCalendar;

public class VideoGame extends Multimedia {

    private final String plataforma;
    public String getPlataforma() {
        return plataforma;
    }

    public VideoGame(String title, String author, TYPE format, GregorianCalendar calendar, String plataforma) {
        super(title, author, format, calendar);
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "plataforma='" + plataforma + '\'' +
                '}';
    }

}
