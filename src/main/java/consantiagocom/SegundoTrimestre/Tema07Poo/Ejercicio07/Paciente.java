package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

public class Paciente {
    private final int SIP;
    private final String nombre;
    private final char sexo;
    private final int edad;


    public Paciente(int SIP, String nombre, char sexo, int edad) {
        this.SIP = SIP;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public int getSIP() {
        return SIP;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return String.format("SIP: %d, Nombre: %s, Sexo: %c, Edad: %d", SIP, nombre, sexo, edad);
    }
}
