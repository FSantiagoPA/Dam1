package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio01;

public class Principal {
    public static void main(String[] args) {

        Car car01 = new Car("Ford fiesta","Red",false,"A012",2022, Car.kindOfCar.Familiar, Car.insuranceModality.ThirdParty);
        System.out.println(car01.toString());

        System.out.println();

        Car car02 = new Car();
        System.out.println(car02.toString());

    }
}
