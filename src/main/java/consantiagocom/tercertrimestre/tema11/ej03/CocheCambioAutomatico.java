package consantiagocom.tercertrimestre.tema11.ej03;

public class CocheCambioAutomatico extends Coche{

    public CocheCambioAutomatico(String matricula, int velocidadActual, int marchaActual, int[] posiciones) {
        super(matricula, velocidadActual, marchaActual, posiciones);
    }

    @Override
    public void accelerar(int incremento) {
        if(velocidadActual<0)
            super.accelerar(velocidadActual);
        else
            super.accelerar(0);
    }

    @Override
    public void frenar() {
        super.frenar();
    }
}
