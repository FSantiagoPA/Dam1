package consantiagocom.tercertrimestre.tema10.ejercicios.utils;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class LibMethods {

    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);
    public static int randomNumeber(int max, int min){
        int numb;
        return numb= rand.nextInt(max- min + 1) + min;
    }
    public static double randomNumeberDouble(double max, double min){
        double numb;
        return numb= rand.nextDouble()*max+min;
    }
    public static GregorianCalendar dateWithRand(){
        int day = randomNumeber(30,1);
        int month = randomNumeber(12,0);
        int year = randomNumeber(2022,1980);

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(year,month,day);
        return calendar;
    }
    public static int searchIfReferenceInArray(int refence,int counter, int []aray){
        for(int i = 0; i < counter; i++){
            if( refence == aray[i]){
                return 1;
            }
        }
        return  -1;
    }

    public static int searchStringInArray(String refence,int counter, int []aray){
        for(int i = 0; i < counter; i++){
            String search = String.valueOf(aray[i]);
            if( refence.equalsIgnoreCase(search)){
                return 1;
            }
        }
        return  -1;
    }

    public static int scanInt(){
        int loop = -1;
        int num =0;
        do {

            try {
                num = Integer.parseInt(scanner.nextLine());
                loop = 1;
            } catch (NumberFormatException nfe) {
                System.out.println("A number must be introduced");
            }
        }while(loop == -1);
        return num;
    }

    public static double scanDouble(){
        int loop = -1;
        double num =0;
        do {

            try {
                num = Double.parseDouble(scanner.nextLine());
                loop = 1;
            } catch (NumberFormatException nfe) {
                System.out.println("A number must be introduced");
            }
        }while(loop == -1);
        return num;
    }

    public static String scanString(){
        String text;
        return text = scanner.nextLine();
    }

    public  static char scanChar(){
        char caracter;
        return caracter = scanner.next().charAt(0);
    }

    public static String printOutArray(int [] aray ){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aray.length;i++ ) {
            sb.append(aray[i]).append("-");
        }
        return sb.toString();
    }

    public static String visualitzarPosNum(int[] vector, int pos){
        int count=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< vector.length;i++){
            if(vector[i] % pos ==0){
                sb= sb.append(vector[i]).append(" posicion ").append(count);
                sb.append("\n");
            }
            count++;
        }
        return sb.toString();
    }

    public static int[] fillArrayRandomInt(int[] aray, int MAX, int MIN){
        Random rand = new Random();

        for(int i=0; i<aray.length;i++){

            aray[i] = rand.nextInt(MAX-MIN+1)+MIN;
        }

        return aray;
    }
    public static Double[] fillArrayRandomDouble(Double[] aray, Double MAX, Double MIN){
        Random rand = new Random();
        for(int i=0; i<aray.length;i++){

            aray[i] = randomNumeberDouble(MAX,MIN);
        }

        return aray;
    }

    public static int[][] fillMatrixRandom(int[][] matrix, int MAX, int MIN){
        Random rand = new Random();

        for(int i=0; i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = rand.nextInt(MAX-MIN+1)+MIN;
            }
        }

        return matrix;
    }

    public static int[] arrayAdition(int[] aray, int[] arayTwo) {
        final int SIZE=10;
        int sum[]= new int[SIZE];

        for (int i = 0; i < sum.length;i++){

            sum[i]= (aray[i]) + (arayTwo[i]);
        }

        return sum;

    }

    public static int[] arrayMult(int[] aray, int[] arayTwo) {
        final int SIZE=10;
        int mult[]= new int[SIZE];
        for (int i = 0; i < mult.length;i++){

            mult[i]= (aray[i]) * (arayTwo[i]);
        }


        return mult;

    }

    public static int[] makeArayWithElementsAbove(int[] aray, int numb){

        for(int i=0; i<aray.length;i++){
            if(aray[i]>numb){
                aray[i]=aray[i];
            }else{
                aray[i]=0;
            }
        }
        return aray;

    }

    public static int[] inverseArray(int[] aray){
        int [] inverse=new int[aray.length];
        int arayPlace = 0;
        for(int i = aray.length - 1   ; i  >= 0 ; i--){
            inverse[arayPlace]=aray[i];
            arayPlace++;
        }
        return inverse;
    }
    public static String printArrayWithSpecificString(String c, int counter,int [] aray) {
        counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aray.length; i++) {
            String text = String.valueOf(aray[i]);
            if (c.equalsIgnoreCase(text)) {
                sb.append(aray[i]).append("\n");
                counter++;
            }
            if (counter == 0)
                sb.append("No existe");
        }
        return sb.toString();
    }

    public static String printArrayWithSpecificInt(int numb, int counter,int [] aray) {
        counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aray.length; i++) {
            if (numb == aray[i]) {
                sb.append(aray[i]).append("\n");
                counter++;
            }
            if (counter == 0)
                sb.append("No existe");
        }
        return sb.toString();
    }

    public static String firstLetterUpper(String a) {
        //creating substring for getting first letter
        //+ a.subsring(1) is to genereate the rest of the string
        String s=a.substring(0,1).toUpperCase()+a.substring(1);
        return s;
    }

    public static int vocals(String s){
        int numVocales=0;
        String vocales="aáàeéèiíìoóòuúù";
        s=s.toLowerCase();
        //Loop  to get the vocals
        for(int i=0; i < s.length();i++){
            String c = String.valueOf(s.charAt(i));
            if (vocales.contains(c)){
                numVocales++;
            }

        }

        return numVocales ;
    }

    public static int consonants(String s){
        int numconsonants=0;
        String consonants="bcdfghjklmnñpqrstvwxyz";
        s=s.toLowerCase();
        //Loop te get the consonants
        for(int i=0; i < s.length();i++){
            String c = String.valueOf(s.charAt(i));
            if (consonants.contains(c)){
                numconsonants++;
            }

        }

        return numconsonants ;
    }

    public static String longestWord(String texto){
        texto.trim();
        String masLarga="";
        String[] palabras= texto.split("\\s+");
        for(int i = 0; i < palabras.length; i++){
            if(palabras[i].length()> masLarga.length()){
                masLarga=palabras[i];
            }
        }
        return masLarga;
    }

    public static String oneLineWord(String a){
        a=a.trim();
        StringBuilder sb = new StringBuilder();
        String[]lineWord= a.split("\\s+");
        for(String palabra : lineWord){
            sb.append(palabra).append("\n");
        }
        return sb.toString();
    }

    public static String letterOddPos(String frase){
        frase =frase.trim();
        String[]lineWord= frase.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String palabra : lineWord){

            for(int i=0; i < palabra.length();i++){
                String c = String.valueOf(palabra.charAt(i));
                if (!((i%2==0))){
                    sb.append(c);
                }
            }
            sb.append("\n");
        }

        return sb.toString() ;
    }

    public static String eliminarAcentos(String texto){
        String origen="áàéèíìóòúù";
        String destino="aaeeiioouu";
        for(int i = 0; i < origen.length(); i++){
            texto = texto.replace(origen.charAt(i), destino.charAt(i));
        }
        return texto;
    }

    public static String letters( String s, String select, String replace){
        String line;
        line=s.replaceAll(select,replace);
        return line;
    }

    public static String subsituteNumbers( String s, String replace){
        String line;
        line=s.replaceAll("\\d",replace);
        return line;
    }

    public static String letterPosOdd(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < s.length();i++){
            if (!(i%2==0)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String letterPosEven(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < s.length();i++){
            if (i%2==0){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
