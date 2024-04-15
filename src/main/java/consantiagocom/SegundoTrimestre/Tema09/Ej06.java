package consantiagocom.SegundoTrimestre.Tema09;

public class Ej06 {
    Ej06(){

        // Testing methods
        int[] array = {-2, -1, 0, 1, 2};
        dividirEntreArray(2, array);
        System.out.println("----------");
        System.out.println("Reescrito");
        System.out.println("----------");
        dividirEntreArray2(2, array);
    }

    /**
     * Divide un número entre los elementos de un array
     * @param num Número a dividir
     * @param array Array de números entre los que se va a dividir
     */
    public void dividirEntreArray(int num, int[] array) {

        // Recorre el array de divisores
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println(num + " / " + array[i] + " = " + num / array[i]);
                // Si el divisor es 0, se informa al usuario de que no se puede dividir entre 0
                // El programa no se detiene
            } catch (ArithmeticException e) {
                System.out.println("No se puede dividir entre 0");
            }
        }
    }

    /**
     * Divide un número entre los elementos de un array
     * @param num Número a dividir
     * @param array Array de números entre los que se va a dividir
     */
    public void dividirEntreArray2(int num, int[] array) {

        // Recorre el array de divisores y comprueba si hay algún 0
        for (int i : array){
            // Si hay un 0, se informa al usuario de que no se puede dividir entre 0
            // El programa se detiene
            if (i == 0){
                System.out.println("Hay un 0 en el array");
                System.out.println("No se puede dividir entre 0");
                return;
            }
        }

        // Recorre el array de divisores previamente comprobado
        for (int j : array) {
            System.out.println(num + " / " + j + " = " + num / j);
        }
    }
}
