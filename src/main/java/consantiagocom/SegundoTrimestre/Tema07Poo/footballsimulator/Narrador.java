package consantiagocom.SegundoTrimestre.Tema07Poo.footballsimulator;

import java.util.Random;

public class Narrador {
    private static final String[] mensajesBienvenida = {
            "Bienvenidos al estadio %s",
            "Saludos desde el estadio de %s",
    };

    private static final String[] mensajesPresentacion = {
            "Hoy se enfrentan dos grandes equipos como son el %s y el %s",
            "Hace un dia estupendo para ver el partido entre el %s y el %s",
            "Hoy el tiempo no acompaña pero aún así la gente no ha fallado y aquí está para animar a su equipo en este interesante partido entre el %s y el %s",
    };

    private static final String[] mensajesSorteo = {
            "El árbitro lanza la moneda al aire y empezará sacando el %s",
            "La moneda ha decidido que empezará sacando el %s",
            "Moverá primero la pelota el %s"
    };

    private static final String[] mensajesPase = {
            "%s combina con %s",
            "%s hace una pase largo para %s",
            "%s descongestiona abriendo para %s",
    };
    private static final String[] mensajesRegate = {
            "Buen regate de %s sobre %s",
            "%s se va de %s",
            "%s intenta un autopase sobre %s",
            "%s intena irse de %s",
    };

    private static final String[] mensajesIntercepta = {
            "pero %s le adivina la intención y se queda con la pelota",
            "pero %s está más rápido y consigue quedarse con el balón",
    };

    private static final String[] mensajesTiroLejano = {
            "%s chuta desde su casa",
            "%s golpea desde 30 metros",
            "%s prueba suerte de 25 metros",
            "%s intenta el tiro desde lejos",
            "%s chuta desde la frontal del área",
    };

    private static final String[] mensajesTiroCercano = {
            "%s se va del último defensa, chuta ...",
            "%s se va de todos y se queda solo ante el portero ...",
            "%s chuta desde el punto de penalti",
            "%s remata de cabeza",

    };

    private static final String[] mensajesGol = {
            "pega en el palo y gooooool",
            "Gooolazo por toda la escuadra",
            "tremendo golazo que le quita las telarañas a la escuadra",
            "Goool, la pelota acaba en el fondo de la portería",
    };

    private static final String[] mensajesParada = {
            "tremendo paradón del portero",
            "se marcha fuera rozando el palo",
            "y manda la pelota al grada!",
            "al larguero!! y finalmente atrapa el portero",
    };

    private final Random random;

    private final String nombre;

    public Narrador(String nombre) {
        this.nombre = nombre;
        this.random = new Random();
    }

    public String getNombre() {
        return nombre;
    }

    public String mensaje(String msg) {
        return msg;
    }

    public String bienvenida(Estadio estadio) {
        int indice = random.nextInt(mensajesBienvenida.length);
        return mensaje(String.format(mensajesBienvenida[indice], estadio.getNombre()));
    }

    public String presentacion(Equipo equipoLocal, Equipo equipoVisitante) {
        int indice = random.nextInt(mensajesPresentacion.length);
        return mensaje(String.format(mensajesPresentacion[indice], equipoLocal.getNombre(), equipoVisitante.getNombre()));
    }

    public String sorteo(Equipo equipo) {
        int indice = random.nextInt(mensajesSorteo.length);
        return mensaje(String.format(mensajesSorteo[indice], equipo.getNombre()));
    }

    public String pase(Jugador origen, Jugador destino) {
        int indice = random.nextInt(mensajesPase.length);
        return mensaje(String.format(mensajesPase[indice], origen.getNombre(), destino.getNombre()));
    }

    public String intercepta(Jugador defensa) {
        int indice = random.nextInt(mensajesIntercepta.length);
        return mensaje(String.format(mensajesIntercepta[indice], defensa.getNombre()));
    }

    public String regate(Jugador origen, Jugador jugadorDefiende) {
        int indice = random.nextInt(mensajesRegate.length);
        return mensaje(String.format(mensajesRegate[indice], origen.getNombre(), jugadorDefiende.getNombre()));
    }

    public String tiroLejano(Jugador origen) {
        int indice = random.nextInt(mensajesTiroLejano.length);
        return mensaje(String.format(mensajesTiroLejano[indice], origen.getNombre()));
    }

    public String tiroCercano(Jugador origen) {
        int indice = random.nextInt(mensajesTiroCercano.length);
        return mensaje(String.format(mensajesTiroCercano[indice], origen.getNombre()));
    }

    public String gol() {
        int indice = random.nextInt(mensajesGol.length);
        return mensaje(String.format(mensajesGol[indice]));
    }

    public String parada() {
        int indice = random.nextInt(mensajesParada.length);
        return mensaje(String.format(mensajesParada[indice]));
    }




}
