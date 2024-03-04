package consantiagocom.PrimerTrimestre.Tema03Bucles;

import java.util.Random;

public class Ejercicio13 {
    public static void main(String[] args) {

        Random random = new Random();
        final int TIROS = 1000000;
        int moneda;
        int cara = 0 , cruz = 0;
        double porcentajeCara, porcentajeCruz;

        for (int i = 1; i <=TIROS; i++) {
            moneda = random.nextInt(1 + 1);

            switch (moneda){
                case 0:
                    cara++;
                    break;
                case 1:
                    cruz++;
                    break;
            }
        }
        porcentajeCara = cara * 100 /TIROS;
        porcentajeCruz = cruz * 100 /TIROS ;
        System.out.println("Han salido " + cara + " caras (" + porcentajeCara + "%)");
        System.out.println("Han salido " + cruz + " cruces (" + porcentajeCruz + "%)");

    }
}
