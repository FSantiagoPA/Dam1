package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.Ejercicio08;

import java.util.Random;

public class Logic {
    private int seed;
    Random rnd = new Random(seed);

    public Logic(int seed){
        this.seed = seed;
    }
    public Logic(){
        this.seed = rnd.nextInt(1,27);
    }
    public String cifra(String texto){
        StringBuilder sb = new StringBuilder(texto.length());
        int posicion;
        int letra;
        int resultadoPosicion;
        int resutadoLetra;
        String cifrado = "";
        for (int i = 0; i < texto.length(); i++){
            posicion = rnd.nextInt();
            letra = texto.charAt(i);
            resultadoPosicion = letra + posicion;
            resutadoLetra = resultadoPosicion;
            sb.append(resutadoLetra);
            cifrado = sb.toString();


        }
        return sb.toString();
    }
   /* public String desifrar(String texto){

    }*/
}
