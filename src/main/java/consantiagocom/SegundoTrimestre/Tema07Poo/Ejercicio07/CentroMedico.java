package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CentroMedico {
    private final Paciente[] pacientes;
    private int numPacientes;
    private final Atencion[] atenciones;
    private int numAtenciones;
    private double[] estadisticas;

    /**
     * Constructor centro medico
     * @param capacidadInicalPacientes define el tamaño del array de pacientes
     * @param capacidadIncialAtenciones define el tamño del array de atenciones
     */
    public CentroMedico(int capacidadInicalPacientes, int capacidadIncialAtenciones){
        pacientes = new Paciente[capacidadInicalPacientes];
        numPacientes = 0;
        atenciones = new Atencion[capacidadIncialAtenciones];
        numAtenciones = 0;
        estadisticas = null;
        if (Config.DEBUG) {
            generarDatosAleatoriosPacientes(capacidadInicalPacientes);
            generarDatosAleatoriosAtenciones(capacidadIncialAtenciones);
        }
    }
    private void generarDatosAleatoriosPacientes(int numMaxPacientes){
        Faker fk = new Faker();
        Random rnd = new Random();

        String sip;
        String nombre;
        int seleccionGenero;
        Paciente.Genero genero;
        Date fechaNacimineto;

        for(int i = 0; i < numMaxPacientes; i++){
            sip = String.format("%05d",(i+1));
            nombre = fk.name().fullName().toString();
            seleccionGenero = rnd.nextInt(Paciente.Genero.values().length);
            genero = Paciente.Genero.values()[seleccionGenero];
            fechaNacimineto = fk.date().birthday();

            pacientes[numPacientes] = new Paciente(sip,nombre, genero, fechaNacimineto);
            numPacientes++;
        }
    }
    private void generarDatosAleatoriosAtenciones(int numMaxAtenciones){
        Faker fk = new Faker();

        Date fechaEntrada;
        String sintomologia;

        for(int j = 0; j < numMaxAtenciones; j++){
            fechaEntrada = fk.date().past(30,0, TimeUnit.DAYS);
            Paciente paciente = pacientes[fk.random().nextInt(0, numPacientes - 1)];
            sintomologia = fk.medical().symptoms();
            Atencion atencion = new Atencion(paciente,fechaEntrada,sintomologia);

            if(fk.random().nextInt(100) > 100 - 40) {
                double temperatura = fk.random().nextDouble(35, 41);
                double ppm = fk.random().nextDouble(50,110);
                double tensionSistolica = fk.random().nextDouble(50,150);
                double tensionDistolica = fk.random().nextDouble(50,150);
                if(fk.random().nextInt(100) > 100 - 40) {
                    Date fechaAlta = fechaEntrada;
                    String motivoAlta = fk.medical().diagnosisCode();
                    atencion.altaPaciente(fechaAlta,motivoAlta);
                }
            }
            atenciones[numAtenciones] = atencion;
            numAtenciones++;

        }
    }

    /**
     * Busqueda de paciente por medio del sip
     * @param sip define el sip del paciente que se busca
     * @return el paciente en el que el sip coincide con el parametro sip dado
     */
    public Paciente buscarPacientePorSip(String sip){
        for (int i = 0; i < numPacientes; i++){
            if(pacientes[i].getSip().equals(sip)){
                return pacientes[i];
            }
        }
        return null;
    }
    public Atencion buscarPorFecha(Date fechaInical, Date fechaFinal){
        for (int i = 0; i < numAtenciones;i++){
            int inicio = fechaInical.compareTo(atenciones[i].getFechaEntrada());
            int finale = fechaFinal.compareTo(atenciones[i].getFechaEntrada());
            if (inicio >= 0 && finale <= 0)
                return atenciones[i];
        }
        return null;
    }
    public double[] estadisticas(){
        estadisticas = new double[4];
        double temperaturas = 0;
        double ppms = 0;
        double tensionesSistolicas = 0;
        double tensionesDistolicas = 0;
        for (int i = 0; i < numAtenciones; i++){
            temperaturas += atenciones[i].getTemperatura();
            ppms += atenciones[i].getPPM();
            tensionesSistolicas += atenciones[i].getTensionSistolica();
            tensionesDistolicas += atenciones[i].getTensionDistolica();
        }
        estadisticas[0] = temperaturas / numAtenciones;
        estadisticas[1] = ppms / numAtenciones;
        estadisticas[2] = tensionesSistolicas / numAtenciones;
        estadisticas[3] = tensionesDistolicas / numAtenciones;

        return estadisticas;
    }

    public Atencion[] obtenerHistorial(){
        //Opcion 1: Devolver datos originales
        //return atenciones;
        //Opcion 2: Devolver copia de las atenciones
        Atencion[] historicoAtenciones = new Atencion[numAtenciones];
        for (int i = 0; i < numAtenciones;i++){
            historicoAtenciones[i] =  new Atencion(atenciones[i]);
        }
        return historicoAtenciones;
    }
    public boolean altaMedica(String sip, String motivoAlta){
        //buscarAtencionPacienteNoAtendido();
        return false;
    }
    /**
     * Crear nuevo paciente
     * @param sip el sip del paciente
     * @param nombre el nombre del paciente
     * @param genero el genero del paciente
     * @param fechaNacimineto la fecha de nacimiento del paciente
     * @return el paciente creado correctamente
     */
    public Paciente nuevoPaciente(String sip, String nombre, Paciente.Genero genero, Date fechaNacimineto){
        if(buscarPacientePorSip(sip) != null)
            return null;
        Paciente paciente = new Paciente(sip,nombre,genero,fechaNacimineto);
        pacientes[numPacientes++] = paciente;
        return paciente;
    }

    /**
     * Para buscar el paciente a atender
     * @param sip usamos el sip para buscar el paciente que tiene que ser atendido
     * @return la atencion del paciente que tenga dicho sip
     */
    public Atencion buscarAtencionPaciente(String sip, boolean atendido){
        for (int i = 0; i < numAtenciones; i++){
            Paciente paciente = atenciones[i].getPaciente();
            if (atenciones[i].isAtendido() && paciente.getSip().equals(sip)){
                return atenciones[i];
            }
        }
        return null;
    }

    /**
     * Atender al paciente
     * @param sip para buscar al paciente a atender
     * @param temperatura la temperatura del paciente
     * @param ppm las pulsaciones por minuto del paciente
     * @param tensionSistolica la tension sistolica del paciente
     * @param tensionDiastolica la tension diastolica del paciente
     * @return false si la atencion del paciente esta vacio y true si se a efectuado correctamente la atencion
     */
   /* public boolean atenderPaciente(String sip,double temperatura,double ppm,double tensionSistolica,double tensionDiastolica){
        Atencion atencion = buscarAtencionPacienteNoAtendido(sip);
        if (atencion == null)
            return false;
        atencion.setconstantesVitales(temperatura,ppm,tensionSistolica,tensionDiastolica);
        return true;
    }*/

    /**
     * Crear la atencion para el paciente
     * @param paciente el paciente al que queremos crear la atencion
     * @param sintomalogia la sintologia que tiene el paciente
     * @return true para verificar que se a creado correctamnete
     */
    public boolean entradaPaciente(Paciente paciente, String sintomalogia){
        atenciones[numAtenciones] = new Atencion(paciente, new Date(),sintomalogia);
        numAtenciones++;
        return true;
    }

    /**
     * Buscar a un paciente en espera por su sip
     * @param sip el sip co elq ue quermos buscar al paciente
     * @return el paciente que esta en espera con dicho sip o nada ya que no existe ningun paciente con dicho sip en espera
     */
    public Paciente buscarPacienteEnEspera(String sip){
        for (int i = 0; i < numAtenciones; i++){
            Paciente paciente = atenciones[i].getPaciente();
            if (atenciones[i].isAtendido() && paciente.getSip().equals(sip)){
                return paciente;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "CentroMedico{" + "\n" +
                "pacientes=" + Arrays.toString(pacientes) + "\n" +
                "atenciones=" + Arrays.toString(atenciones) +
                '}';
    }
}
