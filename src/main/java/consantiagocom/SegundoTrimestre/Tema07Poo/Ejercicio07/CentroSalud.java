package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
            generarPacientesAleatroios(capacidadInicialPacientes);
            generarAtencionesAleatorias(capacidadInicialAtencionMedica);
        }
    }
    private void generarPacientesAleatroios(int cantidadPaciente){
        Faker fk = new Faker(new Locale("es"));
        for (int i = 0; i < cantidadPaciente ; i++) {
            String sip = String.format("%05d",(i+1));
            String nombre = fk.name().fullName();
            Paciente.Genero[] valores = Paciente.Genero.values();
            Paciente.Genero genero = valores[fk.random().nextInt(0, valores.length) - 1];
            Date fechaNacimiento = fk.date().birthday(0,99);
            pacientes[numPacientes++] = new Paciente(sip,nombre,genero,fechaNacimiento);
            // otra forma de hacer numPacientes++;
        }
    }
    private void generarAtencionesAleatorias(int cantidadAtenciones){
        Faker fk = new Faker(new Locale("es"));
        for (int i = 0; i < cantidadAtenciones ; i++) {
            Date fechaEntrada = fk.date().past(30,0, TimeUnit.DAYS);
            Paciente paciente = pacientes[i];  //---- Paciente paciente = pacientes[fk.random().nextInt(0,numPacientes -1];
            String sintamologia = fk.medical().symptoms();
            AtencionMedica atencionMedica = new AtencionMedica(paciente,fechaEntrada,sintamologia);
            if (fk.random().nextInt(100) > 100 - 40){
                double temperatura = fk.random().nextDouble(35,41);
                double ppm = fk.random().nextDouble(50,110);
                double tensionSistolica = fk.random().nextDouble(50,150);
                double tensionDiastolica = fk.random().nextDouble(50,150);
                atencionMedica.setConstantesVitales(temperatura,ppm,tensionSistolica,tensionDiastolica);
                if (fk.random().nextInt(100) > 100 - 50){
                    Date fechaAlta = fechaEntrada;
                    String motivoAlta = fk.medical().diagnosisCode();
                    atencionMedica.altaPaciente(fechaAlta,motivoAlta);
                }
            }
            atencionMedicas[numAtencionMedica] = atencionMedica;
            numAtencionMedica++;
        }
    }

    @Override
    public String toString() {
        return "CentroSalud{" +
                "pacientes=" + Arrays.toString(pacientes) +
                ", numPacientes=" + numPacientes +
                ", atencionMedicas=" + Arrays.toString(atencionMedicas) +
                ", numAtencionMedica=" + numAtencionMedica +
                '}';
    }
}
