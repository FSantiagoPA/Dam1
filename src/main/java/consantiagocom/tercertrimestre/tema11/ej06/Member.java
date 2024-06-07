package consantiagocom.tercertrimestre.tema11.ej06;

import java.util.GregorianCalendar;

public class Member {

    //Atributos
    private final String nif;
    private final String name;
    private final GregorianCalendar birthdate;
    private final String city;
    private int Debt;
    public String getNif() {
        return nif;
    }
    public String getName() {
        return name;
    }
    public GregorianCalendar getBirthdate() {
        return birthdate;
    }
    public String getCity() {
        return city;
    }

    public void setDebt(int debt) {
        Debt = debt;
    }

    public Member(String nif, String name, GregorianCalendar birthdate, String city) {
        this.nif = nif;
        this.name = name;
        this.birthdate = birthdate;
        this.city = city;
    }



    @Override
    public String toString() {
        return "Member{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", city='" + city + '\'' +
                ", Debt=" + Debt +
                '}';
    }
}
