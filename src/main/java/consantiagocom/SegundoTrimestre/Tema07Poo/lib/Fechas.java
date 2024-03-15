package consantiagocom.SegundoTrimestre.Tema07Poo.lib;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class Fechas {
    /**
     * Metodo para obtener fechas aleatorios entre un inicio y fin que viene integrado
     * @return fehca random.
     */
    public static LocalDate obtenerFecha(){
        LocalDate inicio = LocalDate.of(2022, 1, 1);
        LocalDate fin = LocalDate.of(2022, 12, 31);
        long diasAleatorios = (long)(Math.random() * ChronoUnit.DAYS.between(inicio, fin));


        return inicio.plusDays(diasAleatorios);
    }

    /**
     * Metodo para obtener una hora aleatoria
     * @return devuelve un LocalTime
     */
    public static LocalTime obtenerHora(){
        int horaAeleatoria = Randoms.rnd.nextInt(24);
        int minutoAeleatoria = Randoms.rnd.nextInt(60);
        int segundoAeleatoria = Randoms.rnd.nextInt(24);
        return LocalTime.of(horaAeleatoria, minutoAeleatoria, segundoAeleatoria);
    }
}
