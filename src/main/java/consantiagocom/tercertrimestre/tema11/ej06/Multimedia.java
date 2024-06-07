package consantiagocom.tercertrimestre.tema11.ej06;



import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Multimedia {
    public enum TYPE {
        CD,DVD,BLU_RAY,ARCHIVE
    }
    private final String title;
    private final String author;
    private final TYPE format;
    private final GregorianCalendar calendar;
    private ArrayList<Rent> rent;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public TYPE getFormat() {
        return format;
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }

    public Multimedia(String title, String author, TYPE format, GregorianCalendar calendar) {
        this.title = title;
        this.author = author;
        this.format = format;
        this.calendar = calendar;
        //Initially empty
        this.rent = new ArrayList<>();
    }

    /**
     *Could be used with multimedia as an object
     */
    public boolean confirmMedia(String author, String title){
        return this.author.equalsIgnoreCase(author) && this.title.equalsIgnoreCase(title);
    }

    public void rentAnItem(){

    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", format=" + format +
                ", calendar=" + calendar +
                '}';
    }
}
