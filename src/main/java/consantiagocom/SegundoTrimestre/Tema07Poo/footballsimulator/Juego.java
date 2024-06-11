package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

import java.util.Objects;
import java.util.Random;

public class Juego {
    private final Equipo equipoLocal;
    private final Equipo equipoVisitante;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private final int duracion;
    private int tiempoTranscurrido;
    private Pelota pelota;
    private final Narrador narrador;
    private final Random random;

    public Juego(Equipo equipoLocal, Equipo equipoVisitante, int duracion, String nombreNarrador) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.duracion = duracion;
        this.narrador = new Narrador(nombreNarrador);
        random = new Random();
    }

    public void iniciarPartido() {
        golesEquipoLocal = 0;
        golesEquipoVisitante = 0;
        tiempoTranscurrido = 0;
        System.out.println(narrador.bienvenida(equipoLocal.getEstadio()));
        System.out.println(narrador.presentacion(equipoLocal, equipoVisitante));
        Equipo equipoAtaca;
        Equipo equipoDefiende;
        if (random.nextInt(2) == 0) {
            equipoAtaca = equipoLocal;
            equipoDefiende = equipoVisitante;
        } else {
            equipoAtaca = equipoVisitante;
            equipoDefiende = equipoLocal;
        }
        System.out.println(narrador.sorteo(equipoAtaca));
        pelota = new Pelota(equipoAtaca, equipoDefiende, equipoAtaca.getAlineacion().length / 2);
        do {
            siguienteJugada();
            pausa(Config.DURACION_PAUSA);
            tiempoTranscurrido++;
        } while (tiempoTranscurrido < duracion);
        System.out.println(narrador.mensaje("Final del partido!"));
        mostrarMarcador();
    }

    public void siguienteJugada() {
        int dado;
        switch (pelota.getJugador()) {
            case 0: // PORTERO
                pase();
                break;
            case 1: case 2: case 3: case 4: // DEFENSAS
                dado = dado();
                if (dado > 100 - Config.PROBABILIDAD_PASE_DEFENSA) {
                    pase();
                } else {
                    regate();
                }
                break;
            case 5: case 6: case 7: case 8: // MEDIOS
                dado = dado();
                if (dado > (100 - Config.PROBABILIDAD_TIRO_MEDIO)) {
                    int distancia = pelota.getDistanciaPorteria();
                    if (distancia <= Config.DISTANCIA_MAXIMA_TIRO) {
                        tiro();
                    } else {
                        if (random.nextInt(2) == 0)
                            pase();
                        else
                            regate();
                    }
                } else if (dado > (100 - Config.PROBABILIDAD_REGATE_MEDIO)) {
                    regate();
                } else {
                    pase();
                }
                break;
            case 9: // 1er DELANTERO
                dado = dado();
                if (dado > 100 - Config.PROBABILIDAD_REGATE_DELANTERO) {
                    regate();
                } else {
                    tiro();
                }
                break;
            case 10: // 2n DELANTERO
                tiro();
                break;
        }
    }

    private int getFactorCorreccion() {
        return random.nextInt(0, Config.FACTOR_CORRECCION + 1);
    }

    private void pase() {
        Jugador jugadorAtaca = pelota.getJugadorAtaca();
        Jugador jugadorDefiende = pelota.getJugadorDefiende();
        System.out.println(narrador.pase(jugadorAtaca, pelota.getSiguienteJugadorAtaca()));
        if (jugadorAtaca.getPase() - getFactorCorreccion() > jugadorDefiende.getDefensa() - getFactorCorreccion()) {
            // Acierta el pase
            pelota.pase();
        } else {
            System.out.println(narrador.intercepta(jugadorDefiende));
            System.out.println();
            // El equipo rival recupera la pelota
            pelota.intercepta();
            System.out.printf("Ataca el %s!\n", pelota.getEquipoAtaca().getNombre());
        }
    }

    private void regate() {
        Jugador jugadorAtaca = pelota.getJugadorAtaca();
        Jugador jugadorDefiende = pelota.getJugadorDefiende();
        System.out.println(narrador.regate(jugadorAtaca, jugadorDefiende));
        if (jugadorAtaca.getRegate() - getFactorCorreccion() > jugadorDefiende.getDefensa() - getFactorCorreccion()) {
            pelota.regate();
        } else {
            System.out.println(narrador.intercepta(jugadorDefiende));
            System.out.println();
            pelota.intercepta();
            System.out.printf("Ataca el %s!\n", pelota.getEquipoAtaca().getNombre());
        }
    }

    private void tiro() {
        Jugador ataca = pelota.getJugadorAtaca();
        Jugador portero = pelota.getPorteroDefiende();
        int distancia = pelota.getDistanciaPorteria();
        int correccionTiro = random.nextInt(Config.FACTOR_CORRECCION_TIRO + 1) * distancia;
        int correccionPortero = random.nextInt(Config.FACTOR_CORRECCION + 1);
        if (distancia <= 2)
            narrador.tiroCercano(ataca);
        else
            narrador.tiroLejano(ataca);
        pausa(400);
        if (ataca.getTiro() - correccionTiro > portero.getPortero() - correccionPortero) {
            // Goooool
            System.out.println(narrador.gol());
            if (equipoLocal.equals(pelota.getEquipoAtaca())) {
                golesEquipoLocal++;
            } else {
                golesEquipoVisitante++;
            }
            mostrarMarcador();
        } else {
            System.out.println(narrador.parada());
        }
        pelota.saqueDePorteria();
        narrador.mensaje("Saca el portero del " + pelota.getEquipoAtaca().getNombre());
        pausa(200);
    }

    private void mostrarMarcador() {
        System.out.println(narrador.mensaje(equipoLocal.getNombre() + ": " + golesEquipoLocal + " - " + equipoVisitante.getNombre() + ": " + golesEquipoVisitante));
    }

    private int dado() {
        return random.nextInt(100) + 1;
    }

    public void pausa(int milisegundos) {
        if (!Config.DEBUG) {
            try {
                Thread.sleep(milisegundos);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public Random getRandom() {
        return random;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Juego juego = (Juego) o;

        if (golesEquipoLocal != juego.golesEquipoLocal) return false;
        if (golesEquipoVisitante != juego.golesEquipoVisitante) return false;
        if (duracion != juego.duracion) return false;
        if (tiempoTranscurrido != juego.tiempoTranscurrido) return false;
        if (!equipoLocal.equals(juego.equipoLocal)) return false;
        if (!equipoVisitante.equals(juego.equipoVisitante)) return false;
        return Objects.equals(random, juego.random);
    }

    @Override
    public int hashCode() {
        int result = equipoLocal.hashCode();
        result = 31 * result + equipoVisitante.hashCode();
        result = 31 * result + golesEquipoLocal;
        result = 31 * result + golesEquipoVisitante;
        result = 31 * result + duracion;
        result = 31 * result + tiempoTranscurrido;
        result = 31 * result + (random != null ? random.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "equipoLocal=" + equipoLocal +
                ", equipoVisitante=" + equipoVisitante +
                ", golesEquipoLocal=" + golesEquipoLocal +
                ", golesEquipoVisitante=" + golesEquipoVisitante +
                ", duracion=" + duracion +
                ", tiempoTranscurrido=" + tiempoTranscurrido +
                ", random=" + random +
                '}';
    }
}