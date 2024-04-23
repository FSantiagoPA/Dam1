package consantiagocom.tercertrimestre.tema10.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("Casa","vivienda, inmueble, domicilio, hogar, residencia, piso, apartamento, departamento, techo, apartamiento, cuarto, casalicio.");
        diccionario.put("Manzana","Fruto del manzano, de forma globosa algo hundida por los extremos del eje");
        diccionario.put("Futbol", "uego entre dos equipos de once jugadores cada uno, cuyo objetivo es hacer entrar en la portería contraria un balón");


//        for (Map.Entry e : diccionario.entrySet()){
//            System.out.println(e.getKey() + " : " + e.getValue());
//        }

        //Obtencion unicamnte de las claves
        Set<String> claves = diccionario.keySet();
        System.out.println(claves);

        //Obtecion unicamnte de los valores
        Collection<String> valores = diccionario.values();
        System.out.println(valores);

        //System.out.println("Casa significado: " + diccionario.get("Casa"));
    }
}
