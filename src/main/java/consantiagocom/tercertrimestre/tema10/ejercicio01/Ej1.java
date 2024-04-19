package consantiagocom.tercertrimestre.tema10.ejercicio01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ej1 {

    public Ej1(){
        int [] array = new int[10];

        Random random = new Random();

        int arrayAleatoria;
        for (int i = 0; i < 10; i++) {
           array[i] = random.nextInt(51);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(setnumer(array));
    }

    public List<Integer> setnumer(int[] arr){
        ArrayList<Integer> lista = new ArrayList<>(arr.length);

        for (int i : arr){
            if (i % 2 == 0){
                lista.add(i);
            }else {
                lista.add(i);
            }
        }
        return lista;
    }

}
