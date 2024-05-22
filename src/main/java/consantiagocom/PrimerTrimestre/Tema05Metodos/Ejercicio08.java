package consantiagocom.PrimerTrimestre.Tema05Metodos;

/*
Escribe un método que reciba 4 parámetros de tipo entero y compruebe si la secuencia de números
recibida es capicua
*/

public class Ejercicio08 {

    public Ejercicio08(){
        System.out.println(capicua(1,3,3,1));
    }
    public static boolean capicua(int num1,int num2,int num3,int num4){
        String numero = String.valueOf(num1) + String.valueOf(num2) +
                String.valueOf(num3) + String.valueOf(num4);
        String stringReverse = "";
        for (int i = numero.length() - 1; i >= 0; i--) {
            stringReverse += numero.charAt(i);
        }
        return numero.equals(stringReverse);
    }
}
