package consantiagocom.tercertrimestre.tema11.ejercicios.utils;

/**
 * Clase que representa un Bombo para generar n�meros enteros aleatorios
 * Otra opci�n ser�a utilizar Generics para que la clase pudiese manejar
 * otros tipos de datos.
 */
public class Bombo {
    /** Array que representa las bolas del bombo */
    private final int[] bolas;
    /** N�mero de bolas del bombo */
    private int nBolas;
    /** Bola menor */
    private final int min;
    /** Bola mayor */
    private final int max;

    /**
     * Construye un bombo con bolas comprendidas entre min y max
     * @param min Bola menor
     * @param max Bola mayor
     */
    public Bombo(int min, int max) {
        nBolas = max - min + 1;
        this.min = min;
        this.max = max;
        bolas = new int[nBolas];
        init();
    }

    /**
     * Inicializa el bombo
     */
    public void init() {
        int cont = min;
        for(int i = 0; i < bolas.length; i++) {
            bolas[i] = cont;
            cont++;
        }
        reset();
    }

    /**
     * Obtiene una bola del bombo.
     * Se intercambian los elementos y se reduce el n�mero de bolas para que no se puedan repetir
     * @return La bola extra�da
     */
    public int getBola() {
        int pos = Lib.aleatorio(0, nBolas - 1);
        int bola = bolas[pos];
        bolas[pos] = bolas[nBolas - 1];
        bolas[nBolas - 1] = bola;
        nBolas--;
        return bola;
    }

    /**
     * Vuelve a rellenar el bombo con todas las bolas
     */
    public void reset() {
        nBolas = max - min + 1;
    }
}
