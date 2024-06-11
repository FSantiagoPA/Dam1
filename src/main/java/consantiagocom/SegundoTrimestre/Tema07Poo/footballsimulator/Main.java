package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

public class Main {
    public static void main(String[] args) {
        Equipo equipoLocal = new Equipo("Xàbia", "Xàbia Stadium", 2000, 22, 10_000_000);
        Equipo equipoVisitante = new Equipo("Dènia", "Dènia Stadium", 3000, 22, 10_000_000);
        Juego juego = new Juego(equipoLocal, equipoVisitante, 60, "Pepito");
        juego.iniciarPartido();
    }
}
