package consantiagocom.tercertrimestre.tema11.ej03;

public class CocheCambioManual extends Coche{

    public CocheCambioManual(String matricula, int velocidadActual, int marchaActual, int[] posiciones) {
        super(matricula, velocidadActual, marchaActual, posiciones);
    }

    @Override
    public void cambiarMarcha(int marchaActual) {
        if( marchaActual > 0)
            super.cambiarMarcha(marchaActual);
        else
            super.cambiarMarcha(0);
    }
}
