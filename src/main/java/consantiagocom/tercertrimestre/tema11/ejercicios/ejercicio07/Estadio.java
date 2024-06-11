package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Lib;
import net.datafaker.Faker;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Clase que representa un Estadio
 */
public class Estadio {
    /** Constantes de configuración */
    public static final int N_ZONAS = 15;
    public static final int N_ZONAS_VIP = 2;
    public static final int FILAS_POR_ZONA = 15;
    public static final int ASIENTOS_POR_FILA = 20;

    public static final int MIN_PRECIO_NORMAL = 10;
    public static final int MAX_PRECIO_NORMAL = 40;
    public static final int MIN_PRECIO_VIP = 50;
    public static final int MAX_PRECIO_VIP = 120;
    /** Atributos */
    private final Zona[] zonas;


    private final ArrayList<Partido> partidos;

    /**
     * Crea un Estadio con los valores definidos por defecto
     */
    public Estadio() {
        this(N_ZONAS, N_ZONAS_VIP);
    }

    /**
     * Crea un Estado con el número de zonas totales y VIP indicadas
     * @param nZonasTotales Número de zonas totales que tiene el Estadio
     * @param nZonasVIP Número de zonas VIP que tiene el Estadio
     */
    public Estadio(int nZonasTotales, int nZonasVIP) {
        this.zonas = new Zona[nZonasTotales];
        this.partidos = new ArrayList<>(Config.N_PARTIDOS_ALEATORIOS);

        if(Config.DEBUG) {
            generarZonas(nZonasVIP);
            generarPartidosAleatorios();
            generarVentaEntradasAleatoria();
        }
    }

    /**
     * Genera la venta aleatoria de Entradas
     */
    private void generarVentaEntradasAleatoria() {
        int alea;
        for(int partido = 0; partido < partidos.size(); partido++) {
            for (Zona zona : zonas) {
                for (Fila fila : zona.getFilas()) {
                    for (Asiento asiento : fila.getAsientos()) {
                        alea = Lib.aleatorio(1, 100);
                        if (alea <= Config.PORCENTAJE_ENTRADAS_VENDIDAS) {
                            partidos.get(partido).venderEntrada(zona, fila, asiento);
                        }
                    }
                }
            }
        }
    }

    /**
     * Genera partidos aleatorios
     */
    private void generarPartidosAleatorios() {
        Faker faker = new Faker(new Locale("es"));
        for(int i = 0; i < Config.N_PARTIDOS_ALEATORIOS; i++) {
            GregorianCalendar fechaPartido = new GregorianCalendar();
            Date datePartido;
            if(i < Config.N_PARTIDOS_ALEATORIOS / 2) {
                datePartido = faker.date().past(20, 1, TimeUnit.DAYS);
            } else {
                datePartido = faker.date().future(20, 1, TimeUnit.DAYS);
            }
            fechaPartido.setTime(datePartido);
            partidos.add(new Partido(fechaPartido, faker.esports().team(), faker.esports().team(), TipoPartido.random()));
        }
    }

    /**
     * Genera nZonasVip Zonas aleatorias
     * @param nZonasVip Número de Zonas VIP a a generar
     */
    public void generarZonas(int nZonasVip) {
        for(int i = 1; i <= N_ZONAS; i++) {
            if(nZonasVip > 0) {
                this.zonas[i-1] = new Zona(i, TipoZona.VIP, Lib.aleatorio(MIN_PRECIO_VIP, MAX_PRECIO_VIP));
                nZonasVip--;
            } else {
                this.zonas[i-1] = new Zona(i, TipoZona.NORMAL, Lib.aleatorio(MIN_PRECIO_NORMAL, MAX_PRECIO_NORMAL));
            }
        }
    }

    public void addPartido(GregorianCalendar fecha, String local, String visitante, TipoPartido tipoPartido) {
        partidos.add(new Partido(fecha, local, visitante, tipoPartido));
    }

    /**
     * Busca el Partido con el id indicado como parámetro
     * @param idPartido id del Partido a buscar
     * @return Partido buscado o null en caso de no ser encontrado
     */
    public Partido buscarPartido(int idPartido) {
        for(Partido partido: partidos) {
            if(partido.getId() == idPartido) {
                return partido;
            }
        }
        return null;
    }

    /**
     * Busca los partidos
     * @param calendar
     * @return
     */
    public ArrayList<Partido> buscarPartidosPosterioresAFecha(Calendar calendar) {
        if(partidos.size() == 0)
            return null;
        ArrayList<Partido> partidosFecha = new ArrayList<>();
        for(Partido partido: partidos) {
            if(partido.getFecha().compareTo(calendar) > 0) {
                partidosFecha.add(partido);
            }
        }
        return partidosFecha;
    }

    public Zona[] getZonas() {
        return zonas;
    }


    @Override
    public String toString() {
        return "Estadio{" +
                "zonas=" + Arrays.toString(zonas) +
                '}';
    }
}
