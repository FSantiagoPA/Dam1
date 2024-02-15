/*

package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;
import consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07.Paciente;

import java.util.Arrays;
import java.util.Date;

public class AtencionMedica {

    private static final int POSICION_TEMPERATURA = 0;
    private static final int POSICION_PPM = 1;
    private static final int POSICION_TENSION_SISTOLICA = 2;
    private static final int POSICION_TENSION_DISTOLICA = 3;

    private final Paciente paciente;
    private final Date fechaEntrada;
    private final String sintomatologia;
    private double[] preRev;
    private  Date fechaAlta;
    private  String motivoAlta;


*/
/**
     * Constructor de atencion
     * @param paciente el paciente al que queremos crear una atencion
     * @param fechaEntrada fecha actual que seria cuando entra el paciente
     * @param sintomatologia la sintomologia que tenga el paciente
     *//*


    public Atencion(Paciente paciente, Date fechaEntrada, String sintomatologia) {
        this.paciente = paciente;
        this.fechaEntrada = fechaEntrada;
        this.sintomatologia = sintomatologia;
        preRev = null;
        if (atencion.motivoAlta != null)
    }
    public boolean isAtendido(){
        return preRev == null;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void altaPaciente(Date fechaAlta, String motivoAlta){
        this.fechaAlta = fechaAlta;
        this.motivoAlta = motivoAlta;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public String getSintomatologia() {
        return sintomatologia;
    }


     */
/**
     *
     * @param temperatura
     * @param ppm
     * @param tensionSistolica
     * @param tensionDistolica
     *//*


    public void setconstantesVitales(double temperatura, double ppm, double tensionSistolica, double tensionDistolica){
        preRev = new double[4];
        setTemperatura(temperatura);
        setPPM(ppm);
        setTensionSistolica(tensionSistolica);
        setTensionDistolica(tensionDistolica);
    }

    public double getTemperatura(){
        if (preRev == null)
            return -1;
        return preRev[POSICION_TEMPERATURA];
    }
    private void setTemperatura(double temperatura){
        preRev[POSICION_TEMPERATURA] = temperatura;
    }

    public double getPPM(){
        if (preRev == null)
            return -1;
        return preRev[POSICION_PPM];
    }
    private void setPPM(double ppm){
        preRev[POSICION_PPM] = ppm;
    }

    public double getTensionSistolica(){
        if (preRev == null)
            return -1;
        return preRev[POSICION_TENSION_SISTOLICA];
    }
    private void setTensionSistolica(double tensionSistolica){
        preRev[POSICION_TENSION_SISTOLICA] = tensionSistolica;
    }
    public double getTensionDistolica(){
        if (preRev == null)
            return -1;
        return preRev[POSICION_TENSION_SISTOLICA];
    }
    private void setTensionDistolica(double tensionDistolica){
        preRev[POSICION_TENSION_DISTOLICA] = tensionDistolica;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public String getMotivoAlta() {
        return motivoAlta;
    }

    @Override
    public String toString() {
        return "Atencion{" +
                "paciente=" + paciente +
                ", fechaEntrada=" + fechaEntrada +
                ", sintomatologia='" + sintomatologia + '\'' +
                ", preRev=" + Arrays.toString(preRev) +
                ", fechaAlta=" + fechaAlta +
                ", motivoAlta='" + motivoAlta + '\'' +
                "}\n";
    }
}
// Mi compa andre no sabe como subir cosas al git.....

*/
