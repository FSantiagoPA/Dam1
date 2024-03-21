package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.Ejercicio06;

public class Gestion {

    public Gestion() {
    }
    public String comprovantePeso(float masa, float metros){

        //Peso Bajo
        if (imc(masa, metros) < 18.50) {
            System.out.println("???");
        } else if (imc(masa, metros) < 16.00) {
            return Clasificacion.DELGADEZ_SEVERA.toString();
        } else if (imc(masa,metros) >= 16.00 && imc(masa, metros) <= 16.99) {
            return Clasificacion.DELGADEZ_MODERADA.toString();
        } else if (imc(masa, metros) >= 17.00 && imc(masa, metros) <= 18.49) {
            return Clasificacion.DELGADEZ_LEVE.toString();
        }

        //Peso Normal
        if (imc(masa, metros) >= 18.5 && imc(masa, metros) <= 24.99){
            return Clasificacion.NORMAL.toString();
        } else if (imc(masa, metros) >= 18.5 && imc(masa, metros) <= 22.99) {
            return Clasificacion.NORMAL.toString();
        } else if (imc(masa, metros) >= 23.00 && imc(masa, metros) <= 24.99) {
            return Clasificacion.NORMAL.toString();
        }

        //Sobre Peso
        if (imc(masa, metros) >= 25.00){
            System.out.println("????");
        } else if (imc(masa, metros) >= 25.00 && imc(masa, metros) <= 29.99) {
            return Clasificacion.PREOBESIDAD.toString();
        } else if (imc(masa, metros) >= 25.00 && imc(masa, metros) <= 27.49) {
            return Clasificacion.PREOBESIDAD.toString();
        } else if (imc(masa, metros) >= 27.50 && imc(masa, metros) <= 29.99) {
            return Clasificacion.PREOBESIDAD.toString();
        }

        //Obesidad
        if (imc(masa, metros) >=  30.00){
            System.out.println("???");
        } else if (imc(masa, metros) >= 30.00 && imc(masa, metros) <= 34.99) {
            return Clasificacion.OBESIDAD_LEVE.toString();
        } else if (imc(masa, metros) >= 30.00 && imc(masa, metros) <= 32.49) {
            return Clasificacion.OBESIDAD_LEVE.toString();
        } else if (imc(masa, metros) >= 32.50 && imc(masa, metros) <= 34.99) {
            return Clasificacion.OBESIDAD_LEVE.toString();
        } else if (imc(masa, metros) >= 35.00 && imc(masa, metros) <= 39.99) {
            return Clasificacion.OBESIDAD_MEDIA.toString();
        } else if (imc(masa, metros) >= 35.00 && imc(masa, metros) <= 37.49) {
            return Clasificacion.OBESIDAD_MEDIA.toString();
        } else if (imc(masa, metros) >= 37.50 && imc(masa, metros) <= 39.99) {
            return Clasificacion.OBESIDAD_MEDIA.toString();
        } else if (imc(masa, metros) >= 40.00) return Clasificacion.OBESIDAD_MORBIDA.toString();

        return null;
    }


    private  float imc(float peso, float metros) {
        return (float) (peso/Math.pow(metros,2));
    }
}
