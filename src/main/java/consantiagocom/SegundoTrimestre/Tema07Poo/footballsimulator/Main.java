package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

public class Main {
    public static void main(String[] args) {
        Equipo equipoLocal = new Equipo("X�bia", "X�bia Stadium", 2000, 22, 10_000_000);
        Equipo equipoVisitante = new Equipo("D�nia", "D�nia Stadium", 3000, 22, 10_000_000);
        Juego juego = new Juego(equipoLocal, equipoVisitante, 60, "Pepito");
        juego.iniciarPartido();
    }
}
