package consantiagocom.PrimerTrimestre.Tema02;

import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        //Definir variables

        double precioLitro;
        double precioLleno;
        double cuentaKilometros;
        double tamanoDeposito;
        double precioLitro2;
        double precioLleno2;
        double cuentaKilometros2;
        double cuentaKilometros3;
        double totalLitros;
        double totalKilometros;
        double consumoCienKm;
        double costoKm;

        //1º vez repostando

        System.out.println("1º vez repostando");
        System.out.println("¿Cuanto vale 1 litro de gasolina?");
        precioLitro = Double.parseDouble (lector.nextLine());
        System.out.println("¿Cuanto te has costado llenar el deposito?");
        precioLleno =  Double.parseDouble (lector.nextLine());
        System.out.println("¿Cuanto marca el cuenta kilometros despues de llenar el deposito?");
        cuentaKilometros = Double.parseDouble (lector.nextLine());

        //2º vez repostando

        System.out.println("2º vez repostando");
        tamanoDeposito = precioLleno / precioLitro;
        System.out.println("¿Cuanto vale 1 litro de gasolina?");
        precioLitro2 = Double.parseDouble (lector.nextLine());
        precioLleno2 = tamanoDeposito*precioLitro2;
        System.out.println("Llenar el deposito cuesta:" + precioLleno2);



        //3º vez repostando

        System.out.println("3º vez repostando");
        System.out.println("¿Cuanto marca el cuenta kilometros despues de llenar el deposito?");
        cuentaKilometros3 = Double.parseDouble (lector.nextLine());

        //Calculos

        totalLitros = tamanoDeposito*3;
        System.out.println("El total de litros respostado las 3 veces son:" + totalLitros);

        cuentaKilometros2 = (precioLleno2*cuentaKilometros)/precioLleno;
        System.out.println("La segunda vez que repostaste tenias: " + cuentaKilometros2 + "km de autonomia");

        totalKilometros = cuentaKilometros+cuentaKilometros2+cuentaKilometros3;
        System.out.println("El total de km que has recogido es:" + totalKilometros);

        consumoCienKm = (totalLitros/totalKilometros)*100;
        System.out.println("El consumo por cada 100km es: " + consumoCienKm);


        costoKm = consumoCienKm/100;
        System.out.println("El coste por km es:" + costoKm);

        lector.close();



    }
}
