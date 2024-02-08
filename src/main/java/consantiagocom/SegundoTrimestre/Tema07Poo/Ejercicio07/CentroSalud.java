package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

public class CentroSalud {
    private final Paciente[] pacientes;
    private int numPacientes;
    private final AtencionMedica[] atencionMedicas;
    private int numAtencionMedica;

    public CentroSalud(int capacidadInicialPacientes, int capacidadInicialAtencionMedica){
        pacientes = new Paciente[capacidadInicialPacientes];
        numPacientes = 0;
        atencionMedicas = new AtencionMedica[capacidadInicialAtencionMedica];
        numAtencionMedica = 0;
        if (Config.DEBUG) {
            generarDatosAleatorios(40, 80);
        }
    }

}
