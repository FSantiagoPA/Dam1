package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio03;

public class Ejercicio03 {
    public Ejercicio03() {
        // Punto muerto, primera, segunda, tercera, cuarta y quinta
        int[] velocidadMaximaMarcha = {0, 30, 50, 90, 140, 195};
        CocheCambioAutomatico automatico = new CocheCambioAutomatico("1234 KKK", velocidadMaximaMarcha);
        automatico.acelerar(60);
        System.out.println(automatico.toString());
        automatico.acelerar(65);
        System.out.println(automatico.toString());
        automatico.frenar(40);
        System.out.println(automatico.toString());
        automatico.frenar(40);
        System.out.println(automatico.toString());
        automatico.acelerar(105);
        System.out.println(automatico.toString());
        automatico.frenar(150);
        System.out.println(automatico.toString());
        System.out.println("***** MANUAL *****");
        CocheCambioManual manual = new CocheCambioManual("5678 KKK", velocidadMaximaMarcha);
        manual.cambiarMarcha(1);
        manual.acelerar(10);
        System.out.println(manual.toString());
        manual.cambiarMarcha(2);
        manual.acelerar(20);
        System.out.println(manual.toString());
        manual.frenar(30);
        System.out.println(manual.toString());
    }
}