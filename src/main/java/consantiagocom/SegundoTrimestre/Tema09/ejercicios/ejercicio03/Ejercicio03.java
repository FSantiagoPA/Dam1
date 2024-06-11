package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio03;

import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Lib;

public class Ejercicio03 {

    public Ejercicio03() {
        try {
            System.out.printf("El mayor es %.2f\n", solicitarNumeros());
        } catch (NoNumberException nne) {
            System.err.println(nne.getMessage());
        }
    }

    public double solicitarNumeros() throws NoNumberException {
        double mayor = Double.MIN_VALUE;
        double x;
        int cont = 0;
        boolean esNumero;
        do {
            try {
                System.out.print("Indica un número: ");
                x = Double.parseDouble(Lib.lector.nextLine());
                cont++;
                esNumero = true;
                if (x > mayor) {
                    mayor = x;
                }
            } catch (NumberFormatException nfe) {
                if (cont == 0)
                    throw new NoNumberException("No se ha introducido ningún número");
                esNumero = false;
            }
        } while (esNumero);
        return mayor;
    }
}
