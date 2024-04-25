package consantiagocom.tercertrimestre.tema10.ejercicio07;

import consantiagocom.tercertrimestre.tema10.LibMethods;

import java.util.HashMap;

public class Ej07 {
    private HashMap<String,Double> currency = new HashMap<>();

    public  Ej07(){
        //List of all curencies
        currency.put("USD",1.07);
        currency.put("GBP",0.86);
        currency.put("INR",89.25);
        currency.put("AUD",1.65);
        currency.put("CAD",1.47);
        currency.put("ARS",936.42);
        currency.put("BOB",7.42);
        currency.put("CLP",1.018);
        currency.put("COL",4.234);
        currency.put("CRC",538.72);
        currency.put("CUP",25.72);
        currency.put("DOP",62.96);
        currency.put("MXN",18.47);

        int menu;
        String moneda;
        Double euros;
        do{
            menu();
            menu= LibMethods.scanInt();
            switch (menu){
                case 1:
                    System.out.println("Introduce la modena a cual quieres convertir el euro");
                    moneda = LibMethods.scanString();
                    //Confimation to see if key existst
                    if(currency.containsKey(moneda)){
                        System.out.println("Introduce la cantidad en euros");
                        euros = LibMethods.scanDouble();
                        System.out.println(currency.get(moneda)*euros);
                    }else
                        System.out.println("Este moneda no existe");
                    break;
                case 0:
                    break;
                default:
                    break;
            }

        }while(menu!=0);
    }

    public void menu(){
        System.out.println("Menu Principal");
        System.out.println("--------------");
        System.out.println("1.Convertir euro");
        System.out.println("0. Salir de la aplicación.");
    }
}
