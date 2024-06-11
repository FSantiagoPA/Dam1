package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

import java.util.Random;

public class Jugador {
    public static final int VALOR_POR_DEFECTO = 50;
    private static int autoIncrement = 0;
    private final int id;
    private final String nombre;
    private float portero;
    private float defensa;
    private float pase;
    private float regate;
    private float tiro;
    private float estadoForma;

    public Jugador(String nombre, float portero, float defensa, float pase, float regate, float tiro, float estadoForma) {
        this.id = ++autoIncrement;
        this.nombre = nombre;
        this.portero = portero;
        this.defensa = defensa;
        this.pase = pase;
        this.regate = regate;
        this.tiro = tiro;
        this.estadoForma = estadoForma;
    }

    public Jugador(String nombre) {
        this(nombre, VALOR_POR_DEFECTO, VALOR_POR_DEFECTO, VALOR_POR_DEFECTO, VALOR_POR_DEFECTO,
                VALOR_POR_DEFECTO, VALOR_POR_DEFECTO);
    }

    public void entrenarPase() {
        Random random = new Random();
        float mejora = random.nextFloat();
        estadoForma += mejora;
        int dado = random.nextInt(100 + 1 - 1) + 1; // [1 - 100]
        if (dado >= (100 - Config.PROBABILIDAD_MEJORA_PASE)) {
            mejora = random.nextFloat();
            pase += mejora;
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPortero() {
        return portero;
    }

    public float getDefensa() {
        return defensa;
    }

    public float getPase() {
        return pase;
    }

    public float getRegate() {
        return regate;
    }

    public float getTiro() {
        return tiro;
    }

    public float getEstadoForma() {
        return estadoForma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        return id == jugador.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", portero=" + portero +
                ", defensa=" + defensa +
                ", pase=" + pase +
                ", regate=" + regate +
                ", tiro=" + tiro +
                ", estadoForma=" + estadoForma +
                "}\n";
    }
}
