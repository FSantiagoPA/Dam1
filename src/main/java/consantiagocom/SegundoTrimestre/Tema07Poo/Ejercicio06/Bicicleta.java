package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio06;

public class Bicicleta {
    private static int cont = 0;
    private final String referecncia;
    private final String marca;
    private final String modelo;
    private final double peso;
    private final double tama�oRuedas;
    private final boolean motor;
    private final String fechaFabrica;
    private final int existentcias; //Calculado, creo ???


    private Bicicleta(String referencia, String marca, String modelo, double peso, double tama�oRuedas, boolean motor, String fechaFabrica){
        this.referecncia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.tama�oRuedas = tama�oRuedas;
        this.motor = motor;
        this.fechaFabrica = fechaFabrica;
        this.existentcias = 1;

    }

    public Bicicleta(String marca, String modelo, double peso, double tama�oRuedas, boolean motor, String fechaFabrica) {
        this(String.valueOf(++cont), marca, modelo, peso, tama�oRuedas, motor, fechaFabrica);
    }

    public Bicicleta(Bicicleta b1){
        this(b1.getReferecncia(), b1.getMarca(), b1.getModelo(), b1.getPeso(), b1.getTama�oRuedas(), b1.isMotor(), b1.getFechaFabrica());
    }



    //#region Getters
    public String getReferecncia() {
        return referecncia;
    }
    public String getMarca() {
        return marca;
    }


    public String getModelo() {
        return modelo;
    }


    public double getPeso() {
        return peso;
    }


    public double getTama�oRuedas() {
        return tama�oRuedas;
    }


    public boolean isMotor() {
        return motor;
    }


    public String getFechaFabrica() {
        return fechaFabrica;
    }


    public int getExistentcias() {
        return existentcias;
    }

    //#endregion

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((referecncia == null) ? 0 : referecncia.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bicicleta other = (Bicicleta) obj;
        if (referecncia == null) {
            if (other.referecncia != null)
                return false;
        } else if (!referecncia.equals(other.referecncia))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Bicicleta [referecncia=" + referecncia + ", marca=" + marca + ", modelo=" + modelo + ", peso=" + peso
                + ", tama�oRuedas=" + tama�oRuedas + ", motor=" + motor + ", fechaFabrica=" + fechaFabrica
                + ", existentcias=" + existentcias + "]";
    }
}
