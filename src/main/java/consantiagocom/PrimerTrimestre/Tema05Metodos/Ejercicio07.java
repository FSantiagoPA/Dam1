package consantiagocom.PrimerTrimestre.Tema05Metodos;

/*
Escribe un m�todo que acepte un n�mero entero y calcule su factorial (n!).
*/

public class Ejercicio07 {
    public Ejercicio07(){
        System.out.println(factorial(5));
    }
    public static int factorial(int num){
        int resultado = 1;
        for (int i = num; i >= 1; i--){
            resultado *= i;
        }
        return resultado;
    }
}
