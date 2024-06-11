package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

public class MathUtil {
    public static int clamp(int valor, int valorMinimo, int valorMaximo) {
        if (valor < valorMinimo)
            return valorMinimo;
        if (valor > valorMaximo)
            return valorMaximo;
        return valor;
    }

    public static float clamp(float valor, float valorMinimo, float valorMaximo) {
        if (valor < valorMinimo)
            return valorMinimo;
        if (valor > valorMaximo)
            return valorMaximo;
        return valor;
    }

}