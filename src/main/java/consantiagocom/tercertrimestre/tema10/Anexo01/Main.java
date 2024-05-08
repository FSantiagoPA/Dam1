package consantiagocom.tercertrimestre.tema10.Anexo01;

public class Main {
    public static void main(String[] args) {
        RandomSeries randomSeries = new RandomSeries();
//        while (randomSeries.hasNext()) {
//           System.out.println(randomSeries.next());
//        }
        for(double numero : randomSeries){
            System.out.println(numero);
        }
    }
}
