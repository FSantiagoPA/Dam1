package consantiagocom.tercertrimestre.tema11.ej06;

import java.util.GregorianCalendar;

public class Rent {

    //Atributos
    private final Member member;
    private final Multimedia multimedia;
    private final GregorianCalendar dayWhenRented;
    public GregorianCalendar getDayWhenRented() {
        return dayWhenRented;
    }



    public Member getMember() {
        return member;
    }
    public Multimedia getMultimedia() {
        return multimedia;
    }

    public Rent(Member member, Multimedia multimedia, GregorianCalendar dayWhenRented) {
        this.member = member;
        this.multimedia = multimedia;
        this.dayWhenRented = dayWhenRented;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "member=" + member +
                ", multimedia=" + multimedia +
                ", dayWhenRented=" + dayWhenRented +
                '}';
    }
}
