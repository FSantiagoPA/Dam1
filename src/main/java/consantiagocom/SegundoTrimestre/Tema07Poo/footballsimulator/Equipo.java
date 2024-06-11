package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Random;

public class Equipo {
    private final String nombre;
    private final Estadio estadio;
    private final Jugador[] jugadores;
    private final Jugador[] alineacion;
    private int numJugadores;
    private float presupuesto;

    public Equipo(String nombre, String nombreEstadio, int capacidadEstadio,
                  int cantidadJugadores, float presupuesto) {
        cantidadJugadores = MathUtil.clamp(cantidadJugadores, Config.MIN_JUGADORES, Config.MAX_JUGADORES);
        estadio = new Estadio(nombreEstadio, capacidadEstadio);
        jugadores = new Jugador[Config.MAX_JUGADORES];
        this.nombre = nombre;
        numJugadores = 0;
        this.presupuesto = presupuesto;
        alineacion = new Jugador[Config.MIN_JUGADORES];
        generarJugadores(cantidadJugadores);
        generarAlineacion();
    }

    private void generarJugadores(int cantidadJugadores) {
        Random random = new Random();
        Faker faker = new Faker(new Locale("es", "ES"));
        for (int i = 0; i < cantidadJugadores; i++) {
            String nombre = faker.name().firstName() + " " + faker.name().lastName();
            float portero = random.nextFloat(Config.MIN_RANDOM_STATS, Config.MAX_RANDOM_STATS + 1);
            float defensa = random.nextFloat(Config.MIN_RANDOM_STATS, Config.MAX_RANDOM_STATS + 1);
            float pase = random.nextFloat(Config.MIN_RANDOM_STATS, Config.MAX_RANDOM_STATS + 1);
            float regate = random.nextFloat(Config.MIN_RANDOM_STATS, Config.MAX_RANDOM_STATS + 1);
            float tiro = random.nextFloat(Config.MIN_RANDOM_STATS, Config.MAX_RANDOM_STATS + 1);
            float estadoForma = random.nextFloat(Config.MIN_RANDOM_STATS, Config.MAX_RANDOM_STATS + 1);
            jugadores[numJugadores] = new Jugador(nombre, portero, defensa, pase, regate, tiro, estadoForma);
            numJugadores++;
        }
    }

    private void generarAlineacion() {
        int contador = 0;
        // Elegimos portero
        alineacion[contador++] = elegirPortero();

        // Elegimos defensas
        Jugador[] defensas = elegirDefensas(4);
        for (int i = 0; i < defensas.length; i++) {
            alineacion[contador++] = defensas[i];
        }

        // Elegimos medios
        Jugador[] medios = elegirMedios(4);
        for (int i = 0; i < medios.length; i++) {
            alineacion[contador++] = medios[i];
        }

        // Elegimos delanteros
        Jugador[] delanteros = elegirDelanteros(2);
        for (int i = 0; i < delanteros.length; i++) {
            alineacion[contador++] = delanteros[i];
        }
    }

    private Jugador elegirPortero() {
        Jugador portero = null;
        int contador = 0;
        // Elegimos como portero el primer jugador disponible
        // Es decir, el primer jugador del array jugadores que no esté en la alineación
        do {
            if (!estaEnAlineacion(jugadores[contador])) {
                portero = jugadores[contador];
            }
            contador++;
        } while (portero == null);

        // Buscamos si existe algún otro jugador que tenga más stats de portero
        // que no esté ya en la alineación
        for (int i = 1; i < numJugadores; i++) {
            Jugador jugadorActual = jugadores[i];
            if (!estaEnAlineacion(jugadorActual)) {
                if (jugadorActual.getPortero() > portero.getPortero()) {
                    portero = jugadorActual;
                }
            }
        }
        return portero;
    }

    private boolean estaEnAlineacion(Jugador jugador) {
        for (int i = 0; i < alineacion.length; i++) {
            if (alineacion[i] != null && alineacion[i].equals(jugador)) {
                return true;
            }
        }
        return false;
    }

    private Jugador[] elegirDefensas(int cantidad) {
        Jugador[] defensas = new Jugador[cantidad];
        int contadorDefensas = 0;
        int contadorJugadores = 0;

        // Elegimos como defensas los primeros [cantidad] jugadores disponibles
        // Es decir, los primeros [cantidad] jugadores del array jugadores que
        // no estén ya en la alineación
        do {
            if (!estaEnAlineacion(jugadores[contadorJugadores])) {
                defensas[contadorDefensas] = jugadores[contadorJugadores];
                contadorDefensas++;
            }
            contadorJugadores++;
        } while (contadorDefensas < cantidad);

        Arrays.sort(defensas, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                if (j1.getDefensa() > j2.getDefensa())
                    return -1;
                if (j1.getDefensa() < j2.getDefensa())
                    return 1;
                return 0;
            }
        });

        for (int i = contadorJugadores; i < numJugadores; i++) {
            Jugador jugadorActual = jugadores[i];
            if (!estaEnAlineacion(jugadorActual)) {
                for (int j = 0; j < defensas.length; j++) {
                    Jugador defensaActual = defensas[j];
                    // Comprobamos si el jugadorActual es mejor como defensa que el defensaActual
                    if (jugadorActual.getDefensa() > defensaActual.getDefensa()) {
                        defensas[j] = jugadorActual;
                        // Desplazamos el resto de defensas para que el array de defensas siga estando ordenado
                        for (int k = j + 1; k < defensas.length; k++) {
                            Jugador aux = defensas[k];
                            defensas[k] = defensaActual;
                            defensaActual = aux;
                        }
                        break;
                    }
                }
            }
        }
        return defensas;
    }

    private Jugador[] elegirMedios(int cantidad) {
        Jugador[] medios = new Jugador[cantidad];
        int contadorMedios = 0;
        int contadorJugadores = 0;

        // Elegimos como medios los primeros [cantidad] jugadores disponibles
        // Es decir, los primeros [cantidad] jugadores del array jugadores que
        // no estén ya en la alineación
        do {
            if (!estaEnAlineacion(jugadores[contadorJugadores])) {
                medios[contadorMedios] = jugadores[contadorJugadores];
                contadorMedios++;
            }
            contadorJugadores++;
        } while (contadorMedios < cantidad);

        Arrays.sort(medios, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                if (j1.getPase() > j2.getPase())
                    return -1;
                if (j1.getPase() < j2.getPase())
                    return 1;
                return 0;
            }
        });

        for (int i = contadorJugadores; i < numJugadores; i++) {
            Jugador jugadorActual = jugadores[i];
            if (!estaEnAlineacion(jugadorActual)) {
                for (int j = 0; j < medios.length; j++) {
                    Jugador medioActual = medios[j];
                    // Comprobamos si el jugadorActual es mejor en pase que el medioActual
                    if (jugadorActual.getPase() > medioActual.getPase()) {
                        medios[j] = jugadorActual;
                        // Desplazamos el resto de medios para que el array de medios siga estando ordenado
                        for (int k = j + 1; k < medios.length; k++) {
                            Jugador aux = medios[k];
                            medios[k] = medioActual;
                            medioActual = aux;
                        }
                        break;
                    }
                }
            }
        }
        return medios;
    }

    private Jugador[] elegirDelanteros(int cantidad) {
        Jugador[] delanteros = new Jugador[cantidad];
        int contadorDelanteros = 0;
        int contadorJugadores = 0;

        // Elegimos como delanteros los primeros [cantidad] jugadores disponibles
        // Es decir, los primeros [cantidad] jugadores del array jugadores que
        // no estén ya en la alineación
        do {
            if (!estaEnAlineacion(jugadores[contadorJugadores])) {
                delanteros[contadorDelanteros] = jugadores[contadorJugadores];
                contadorDelanteros++;
            }
            contadorJugadores++;
        } while (contadorDelanteros < cantidad);

        Arrays.sort(delanteros, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                if (j1.getTiro() > j2.getTiro())
                    return -1;
                if (j1.getTiro() < j2.getTiro())
                    return 1;
                return 0;
            }
        });

        for (int i = contadorJugadores; i < numJugadores; i++) {
            Jugador jugadorActual = jugadores[i];
            if (!estaEnAlineacion(jugadorActual)) {
                for (int j = 0; j < delanteros.length; j++) {
                    Jugador delanteroActual = delanteros[j];
                    // Comprobamos si el jugadorActual es mejor como delantero que el delanteroActual
                    if (jugadorActual.getTiro() > delanteroActual.getTiro()) {
                        delanteros[j] = jugadorActual;
                        // Desplazamos el resto de delanteros para que el array de delanteros siga estando ordenado
                        for (int k = j + 1; k < delanteros.length; k++) {
                            Jugador aux = delanteros[k];
                            delanteros[k] = delanteroActual;
                            delanteroActual = aux;
                        }
                        break;
                    }
                }
            }
        }
        return delanteros;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Jugador[] getAlineacion() {
        return alineacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (numJugadores != equipo.numJugadores) return false;
        if (Float.compare(presupuesto, equipo.presupuesto) != 0) return false;
        if (!nombre.equals(equipo.nombre)) return false;
        if (!estadio.equals(equipo.estadio)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(jugadores, equipo.jugadores)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(alineacion, equipo.alineacion);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + estadio.hashCode();
        result = 31 * result + Arrays.hashCode(jugadores);
        result = 31 * result + numJugadores;
        result = 31 * result + (presupuesto != 0.0f ? Float.floatToIntBits(presupuesto) : 0);
        result = 31 * result + Arrays.hashCode(alineacion);
        return result;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", estadio=" + estadio +
                ", jugadores=" + Arrays.toString(jugadores) +
                ", numJugadores=" + numJugadores +
                ", presupuesto=" + presupuesto +
                ", alineacion=" + Arrays.toString(alineacion) +
                '}';
    }
}
