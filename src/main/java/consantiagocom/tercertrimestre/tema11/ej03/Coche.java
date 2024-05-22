package consantiagocom.tercertrimestre.tema11.ej03;

import java.util.Arrays;

public abstract class Coche {
    protected final String matricula;
    protected int velocidadActual;
    protected int marchaActual;
    protected int[] velocidadesMaximas;

    public String getMatricula() {
        return matricula;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public int getMarchaActual() {
        return marchaActual;
    }
    public int[] getVelocidadesMaximas() {
        return velocidadesMaximas;
    }

    public Coche(String matricula, int velocidadActual, int marchaActual, int[] velocidadesMaximas) {
        this.matricula = matricula;
        this.velocidadActual = 0;
        this.velocidadesMaximas = velocidadesMaximas;
    }

    public void  accelerar(int incremento) {
        if(incremento<0)
            return;
        this.velocidadActual = velocidadActual + incremento;
    }
    public void frenar(){
        this.velocidadActual = velocidadActual;
    }

    public void cambiarMarcha(int marcha){
        if(marcha<0)
            this.marchaActual=0;
        this.marchaActual = marcha;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", velocidadActual=" + velocidadActual +
                ", marchaActual=" + marchaActual +
                ", posiciones=" + Arrays.toString(velocidadesMaximas) +
                '}';
    }
}
