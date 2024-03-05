package consantiagocom.PrimerTrimestre.Tema05Metodos;


public class Ejercicio12 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int  solution(int number) {
        int counterM3 = 0;
        int counterM5 = 0;
        int sum1 = 0;
        int resultado = 0;
        for(int i = 0; i <=number; i++){
            if(number % 3 == 0 || number % 5 == 0){
                System.out.println();
                if (counterM3 == counterM5){
                    counterM3--;
                }else {
                    counterM5--;
                }
                counterM3++;
                counterM5++;
                sum1 = number + counterM3 + counterM5;
            }
            resultado = sum1;
        }
        return resultado;
    }
}

