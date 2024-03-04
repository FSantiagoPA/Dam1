package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Random;

public class Ejercicio14 {
    public static void main(String[] args) {

        Random random = new Random();

        final int TIRADA = 1000000;
        int dado;
        int uno = 0, dos = 0, tres = 0,
                cuadro = 0, cinco = 0, seis = 0;
        double porcentajeUno,porcentajeDos,porcentajeTres,porcentajeCuatro,
                porcentajeCinco,porcentajeSeis;

        for (int i = 1; i <TIRADA; i++) {
            dado = random.nextInt(6 - 1 + 1) + 1;

            switch (dado){
                case 1:
                    uno++;
                case 2:
                    dos++;
                case 3:
                    tres++;
                case 4:
                    cuadro++;
                case 5:
                    cinco++;
                case 6:
                    seis++;
            }
        }
        porcentajeUno  = (double) (uno * 100) / TIRADA;
        porcentajeDos  = (double) (dos * 100) / TIRADA;
        porcentajeTres  = (double) (tres * 100) / TIRADA;
        porcentajeCuatro  = (double) (cuadro * 100) / TIRADA;
        porcentajeCinco  = (double) (cinco * 100) / TIRADA;
        porcentajeSeis  = (double) (seis * 100) / TIRADA;
        System.out.println("Han salido " + uno + " uno (" + porcentajeUno + "%)");
        System.out.println("Han salido " + dos + " dos (" + porcentajeDos + "%)");
        System.out.println("Han salido " + tres + " tres (" + porcentajeTres + "%)");
        System.out.println("Han salido " + cuadro + " cuatro (" + porcentajeCuatro + "%)");
        System.out.println("Han salido " + cinco + " cinco (" + porcentajeCinco + "%)");
        System.out.println("Han salido " + seis + " seis (" + porcentajeSeis + "%)");

    }

}
