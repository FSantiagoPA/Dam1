package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio03;

public class Ej03 {

    public Ej03(){

        //Creamos una pila de Strings
        Pila<String> pila = new Pila<>();

        //A�adimos elementos a la pila
        pila.push("Hola");
        pila.push("Mundo");
        pila.push("");

        //Mostramos y eliminamos algunos elementos
        System.out.println(pila.top());
        pila.pop();
        System.out.println(pila.pop());

        //Mostramos el tama�o de la pila y si est� vac�a
        System.out.println("Tama�o: " + pila.size());
        System.out.println("�Est� vac�a? " + pila.isEmpty());

        //Vaciamos la pila
        System.out.println("Vaciamos la pila");
        while (!pila.isEmpty()){
            pila.pop();
        }

        //Finalmente mostramos si est� vac�a
        System.out.println("�Est� vac�a? " + pila.isEmpty());

    }
}
