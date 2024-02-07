package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio01;

import net.datafaker.Faker;
import java.util.Locale;
import java.util.Random;

public class Car {

    static Random rng = new Random();
    static Faker fk = new Faker(new Locale("en","US"));

    public enum kindOfCar{Mini,Utilitarian,Familiar,Sporty}
    public enum insuranceModality{ThirdParty,All_Risk}

    private String model;
    private String colour;
    private boolean typeOfPaint;
    private String numberPlate;
    private int yearOfMake;
    private kindOfCar kindOfCar;
    private insuranceModality insuranceModality;


    public Car(String model, String colour, boolean typeOfPaint, String numberPlate, int yearOfMake, kindOfCar kindOfCar, insuranceModality insuranceModality) {
        this.model = model;
        this.colour = colour;
        this.typeOfPaint = typeOfPaint;
        this.numberPlate = numberPlate;
        this.yearOfMake = yearOfMake;
        this.kindOfCar = kindOfCar;
        this.insuranceModality = insuranceModality;
    }
    public Car(){

        int selectType;
        selectType = rng.nextInt(kindOfCar.values().length);
        int selectInsurance;
        selectInsurance = rng.nextInt(insuranceModality.values().length);

        this.model = fk.vehicle().makeAndModel();
        this.colour = fk.color().name();
        this.typeOfPaint = rng.nextBoolean();
        this.numberPlate = fk.vehicle().licensePlate();
        this.yearOfMake = rng.nextInt(2000,2024 + 1);
        this.kindOfCar = kindOfCar.values()[selectType];
        this.insuranceModality = insuranceModality.values()[selectInsurance];

    }

    public static Random getRng() {
        return rng;
    }

    public static void setRng(Random rng) {
        Car.rng = rng;
    }

    public static Faker getFk() {
        return fk;
    }

    public static void setFk(Faker fk) {
        Car.fk = fk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isTypeOfPaint() {
        return typeOfPaint;
    }

    public void setTypeOfPaint(boolean typeOfPaint) {
        this.typeOfPaint = typeOfPaint;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public Car.kindOfCar getKindOfCar() {
        return kindOfCar;
    }

    public void setKindOfCar(Car.kindOfCar kindOfCar) {
        this.kindOfCar = kindOfCar;
    }

    public Car.insuranceModality getInsuranceModality() {
        return insuranceModality;
    }

    public void setInsuranceModality(Car.insuranceModality insuranceModality) {
        this.insuranceModality = insuranceModality;
    }

    @Override
    public String toString() {
        return "Car{ " +
                "model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", typeOfPaint=" + typeOfPaint +
                ", numberPlate='" + numberPlate + '\'' +
                ", yearOfMake=" + yearOfMake +
                ", kindOfCar=" + kindOfCar +
                ", insuranceModality=" + insuranceModality +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (typeOfPaint != car.typeOfPaint) return false;
        if (yearOfMake != car.yearOfMake) return false;
        if (!model.equals(car.model)) return false;
        if (!colour.equals(car.colour)) return false;
        if (!numberPlate.equals(car.numberPlate)) return false;
        if (kindOfCar != car.kindOfCar) return false;
        return insuranceModality == car.insuranceModality;
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + colour.hashCode();
        result = 31 * result + (typeOfPaint ? 1 : 0);
        result = 31 * result + numberPlate.hashCode();
        result = 31 * result + yearOfMake;
        result = 31 * result + kindOfCar.hashCode();
        result = 31 * result + insuranceModality.hashCode();
        return result;
    }
}
