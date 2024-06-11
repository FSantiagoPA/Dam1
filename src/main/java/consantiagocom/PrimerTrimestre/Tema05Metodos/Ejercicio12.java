package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Random;
public class Ejercicio12 {
    public enum Calificacion {
        INSUFICIENTE, SUFICIENTE, BIEN, NOTABLE, EXCELENTE, ERROR
    }

    public static void main(String[] args) {
        float nota;
        for(int i = 1; i <= 50; i++) {
            nota = aleatorio(0,10);
            System.out.println(obtenerCalificacion(nota));
        }
    }

    /**
     * Obtiene un número real aleatorio entre min y max (ambos incluídos)
     * @param min Número mínimo a obtener
     * @param max Número máximo a obtener
     * @return float el número aleatorio generado
     */
    public static float aleatorio(float min, float max) {
        Random r = new Random();
        return r.nextFloat() * (max - min) + min;
    }

    /**
     * Obtiene la Calificacion a partir de una nota númerica
     * @param n Nota númerica
     * @return Calificación equivalente
     */
    public static Calificacion obtenerCalificacion(float n) {
        Calificacion calificacion;
        int nota = (int)n;
        // Versión con switch. Por supuesto se puede hacer también con if else if
        switch (nota) {
            case 0: case 1: case 2: case 3: case 4:
                calificacion = Calificacion.INSUFICIENTE;
                break;
            case 5:
                calificacion = Calificacion.SUFICIENTE;
                break;
            case 6:
                calificacion = Calificacion.BIEN;
                break;
            case 7: case 8:
                calificacion = Calificacion.NOTABLE;
                break;
            case 9: case 10:
                calificacion = Calificacion.EXCELENTE;
                break;
            default:
                calificacion = Calificacion.ERROR;
                break;
        }
        return calificacion;
    }
}

