package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

public class Pelota {
    private Equipo equipoAtaca;
    private Equipo equipoDefiende;
    private int jugador;

    public Pelota(Equipo equipoAtaca, Equipo equipoDefiende, int jugador) {
        this.equipoAtaca = equipoAtaca;
        this.equipoDefiende = equipoDefiende;
        this.jugador = jugador;
    }

    public Equipo getEquipoAtaca() {
        return equipoAtaca;
    }

    public Equipo getEquipoDefiende() {
        return equipoDefiende;
    }

    public int getDistanciaPorteria() {
        return equipoAtaca.getAlineacion().length - jugador;
    }

    public void setEquipoAtaca(Equipo equipoAtaca) {
        this.equipoAtaca = equipoAtaca;
    }

    public Jugador getPorteroDefiende() {
        return equipoDefiende.getAlineacion()[0];
    }

    public Jugador getJugadorAtaca() {
        return equipoAtaca.getAlineacion()[jugador];
    }

    public Jugador getSiguienteJugadorAtaca() {
        return equipoAtaca.getAlineacion()[jugador + 1];
    }

    private int getPosicionJugadorDefiende() {
        return equipoDefiende.getAlineacion().length - 1 - jugador;
    }

    public Jugador getJugadorDefiende() {
        int posicionDefiende = getPosicionJugadorDefiende();
        return equipoDefiende.getAlineacion()[posicionDefiende];
    }

    public void pase() {
        jugador++;
        jugador = MathUtil.clamp(jugador, 0, equipoAtaca.getAlineacion().length - 1);
    }

    public void regate() {
        Jugador jugadorAtaca = getJugadorAtaca();
        Jugador jugadorSiguiente = getSiguienteJugadorAtaca();
        equipoAtaca.getAlineacion()[jugador] = jugadorSiguiente;
        equipoAtaca.getAlineacion()[jugador + 1] = jugadorAtaca;
        pase();
    }

    public void intercepta() {
        jugador = getPosicionJugadorDefiende();
        Equipo aux = equipoAtaca;
        equipoAtaca = equipoDefiende;
        equipoDefiende = aux;
    }

    public void saqueDePorteria() {
        jugador = 0;
        Equipo aux = equipoAtaca;
        equipoAtaca = equipoDefiende;
        equipoDefiende = aux;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelota pelota = (Pelota) o;

        if (jugador != pelota.jugador) return false;
        return equipoAtaca.equals(pelota.equipoAtaca);
    }

    @Override
    public int hashCode() {
        int result = equipoAtaca.hashCode();
        result = 31 * result + jugador;
        return result;
    }

    @Override
    public String toString() {
        return "Pelota{" +
                "equipoPosesion=" + equipoAtaca +
                ", jugador=" + jugador +
                '}';
    }
}
