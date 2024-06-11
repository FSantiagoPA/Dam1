package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio03;

public class CocheCambioAutomatico extends Coche {
    /**
     * Crea un coche con cambio automático
     * @param matricula Matrícula del coche
     */
    public CocheCambioAutomatico(String matricula, int[] velocidadMaximaMarcha) {
        super(matricula, velocidadMaximaMarcha);
    }

    /**
     * Aumenta la velocidad en un incremento de a.
     * Si la velocidad a alcanzar es superior a la permitida por la marcha actual irá
     * cambiando automáticamente de marcha hasta alcanzar la velocidad objetivo o la velocidad máxima permitida
     * @param a Aumento de la velocidad
     */
    @Override
    public void acelerar(double a) {
        double velocidadFinal = velocidad + a;
        double deltaV = 0;
        if(velocidadFinal > velocidadMaximaMarcha[velocidadMaximaMarcha.length-1]) {
            System.out.println("Velocidad no alcanzable");
            return;
        }
        while(velocidad < velocidadFinal) {
            if(velocidadMaximaMarcha[marcha] > velocidadFinal) {
                deltaV = velocidadFinal - velocidad;
            } else {
                deltaV = velocidadMaximaMarcha[marcha] - velocidad;
            }
            super.acelerar(deltaV);
            if(velocidad < velocidadFinal) {
                super.cambiarMarcha(marcha + 1);
                System.out.println("Cambio marcha " + marcha);
            }
        }
    }

    /**
     * Reduce la velocidad en la cantidad indicada como parámetro siempre y cuando la velocidad final no sea negativa.
     * Si es necesario reducirá las marchas.
     * @param f Cantidad de frenada
     */
    @Override
    public void frenar(double f) {
        double velocidadFinal = velocidad - f;
        double deltaV = 0;
        if(velocidadFinal < 0) {
            System.out.println("Imposible frenar");
            return;
        }
        while(velocidad > velocidadFinal) {
            if(velocidadFinal > velocidadMaximaMarcha[marcha-1]) {
                deltaV = velocidad - velocidadFinal;
            } else {
                deltaV = velocidad - velocidadMaximaMarcha[marcha-1];
            }
            super.frenar(deltaV);
            if(velocidad > velocidadFinal) {
                super.cambiarMarcha(marcha -1);
                System.out.println("Cambio marcha " + marcha);
            } else if(velocidad == 0) {
                cambiarMarcha(0);
                System.out.println("Punto muerto");
            }
        }
    }
}
