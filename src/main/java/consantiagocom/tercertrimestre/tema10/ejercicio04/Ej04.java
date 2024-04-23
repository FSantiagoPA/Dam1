package consantiagocom.tercertrimestre.tema10.ejercicio04;

public class Ej04 {
    public Ej04(){
        Cola<String> cola = new Cola();

        cola.add("Hola");
        cola.add("Mundo");
        cola.add("!");

        System.out.println(cola.remove());
        System.out.println(cola.remove());
        System.out.println(cola.remove());

        System.out.println("¿Está vacía?: " + cola.isEmpty());
        System.out.println("Tamaño: " + cola.size());

        cola.add("Hola2");
        cola.add("Mundo2");
        cola.add("!2");

        System.out.println(cola.peek());
        cola.remove();
        System.out.println(cola.peek());

        System.out.println("¿Está vacía?: " + cola.isEmpty());
        System.out.println("Tamaño: " + cola.size());
    }
}
