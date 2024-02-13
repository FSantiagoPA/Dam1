package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

import java.util.Arrays;
import java.util.Date;

public class AtencionMedica {

    private static final int POSICION_TEMPERATURA = 0;
    private static final int POSICION_PMM = 1;
    private static final int POSICION_TENSION_SISCOLICA = 2;
    private static final int POSICION_DIASTOLICA = 3;
    private final Paciente paciente;
    private final Date fechaEntrada;
    private final String sintomalogia;
    private double[] preRev;
    private  Date fechaAlta;
    private  String motivoAlta;

    public AtencionMedica(Paciente paciente, Date fechaEntrada, String sintomalogia) {
        this.paciente = paciente;
        this.fechaEntrada = fechaEntrada;
        this.sintomalogia = sintomalogia;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public boolean isAtendido(){
        return preRev != null;
    }

    public void setConstantesVitales(double temperatura,double ppm,double tensionSistolica,double tensionDistolica){
        preRev = new double[4];
        setTemperatura(temperatura);
        setPPM(ppm);
        setTensionSiscolica(tensionSistolica);
        setTensionDiscolica(tensionDistolica);
    }
    public String getSintomalogia() {
        return sintomalogia;
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
        return preRev[POSICION_PMM];
    }

    private void setPPM(double PPM){
        preRev[POSICION_PMM] = PPM;
    }

    public double getTensionSiscolica(){
        if (preRev == null)
            return -1;
        return preRev[POSICION_TENSION_SISCOLICA];
    }

    private void setTensionSiscolica(double tensionSiscolica){
        preRev[POSICION_TENSION_SISCOLICA] = tensionSiscolica;
    }

    public double getTensionDistolica(){
        if (preRev == null)
            return -1;
        return preRev[POSICION_DIASTOLICA];
    }

    private void setTensionDiscolica(double tensionDiscolica){
        preRev[POSICION_DIASTOLICA] = tensionDiscolica;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public String getMotivoAlta() {
        return motivoAlta;
    }

    public void altaPaciente(Date fechaAlta, String motivoAlta){
        this.fechaAlta = fechaAlta;
        this.motivoAlta = motivoAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtencionMedica that = (AtencionMedica) o;

        if (!paciente.equals(that.paciente)) return false;
        return fechaEntrada.equals(that.fechaEntrada);
    }

    @Override
    public int hashCode() {
        int result = paciente.hashCode();
        result = 31 * result + fechaEntrada.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AtencionMedica{" +
                "paciente=" + paciente +
                ", fechaEntrada=" + fechaEntrada +
                ", sintomalogia='" + sintomalogia + '\'' +
                ", preRev=" + Arrays.toString(preRev) +
                ", fechaAlta=" + fechaAlta +
                ", motivoAlta='" + motivoAlta + '\'' +
                '}';
    }
}
