package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio03;

public class Student {
    public static long autoIncrement;
    private final String nia;
    private final String name;
    private final String surname;
    private final String dateBirth;
    private final String group;
    private final String phoneNumber;

    public Student(Student student){
        this(student.getName(),student.getSurname(),student.getDateBirth(),student.getGroup(),student.getPhoneNumber());
    }

    public Student(String name, String surname, String dateBirth, String group, String phoneNumber) {
        this.nia = String.format("%07d",++autoIncrement);
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.group = group;
        this.phoneNumber = phoneNumber;


    }

    public String getNia() {
        return nia;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getGroup() {
        return group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
