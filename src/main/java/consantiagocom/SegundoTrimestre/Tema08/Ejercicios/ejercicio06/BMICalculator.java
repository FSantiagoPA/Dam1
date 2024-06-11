package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio06;

public class BMICalculator {
    private enum BMIClassification {
        SEVERE_THINNESS("Delgadez severa"),
        MODERATE_THINNESS("Delgadez moderada"),
        MILD_THINNESS("Delgadez leve"),
        NORMAL("Normal"),
        OVERWEIGHT("Sobre peso"),
        OBESE_I("Obesidad leve"),
        OBESE_II("Obesidad media"),
        OBESE_III("Obesidad mórbida");
        private final String text;
        BMIClassification(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
    /**
     * Obtiene el Índice de Masa Corporal a partir de la estatura y el peso
     *
     * @param height estatura en centímetros
     * @param weight peso en Kg.
     * @return IMC
     */
    public static float getBMI(int height, int weight) {
        float meters = (float) height / 100;
        return (float) weight / (meters * meters);
    }

    public static String getBMIString(int height, int weight) {
        float bmi = getBMI(height, weight);
        BMIClassification bmiClassification;
        if (bmi < 16) {
            bmiClassification = BMIClassification.SEVERE_THINNESS;
        } else if (bmi < 17) {
            bmiClassification = BMIClassification.MODERATE_THINNESS;
        } else if (bmi < 18.5) {
            bmiClassification = BMIClassification.MILD_THINNESS;
        } else if (bmi < 25) {
            bmiClassification = BMIClassification.NORMAL;
        } else if (bmi < 30) {
            bmiClassification = BMIClassification.OVERWEIGHT;
        } else if (bmi < 35) {
            bmiClassification = BMIClassification.OBESE_I;
        } else if (bmi < 40) {
            bmiClassification = BMIClassification.OBESE_II;
        } else {
            bmiClassification = BMIClassification.OBESE_III;
        }
        return "IMC = " + String.format("%.2f", bmi) + " (" + bmiClassification.toString() + ")";
    }
}