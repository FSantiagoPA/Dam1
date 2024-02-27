package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio08;
import consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio08.Ejercicio08;
public class Main08 {
    public Main08() {
        Ejercicio08<String> stack = new Ejercicio08<>();
        stack.push("Hola");
        stack.push("Mundo");
        stack.push("!");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Ejercicio08<Integer> stack2 = new Ejercicio08<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());

        Ejercicio08<Double> stack3 = new Ejercicio08<>();
        stack3.push(1.1);
        stack3.push(2.2);
        stack3.push(3.3);
        System.out.println(stack3.pop());
        System.out.println(stack3.pop());
        System.out.println(stack3.peek());
        System.out.println(stack3.pop());
        System.out.println(stack3.pop());

        Ejercicio08<Boolean> stack4 = new Ejercicio08<>();
        for (int i = 0; i < 100; i++) {
            stack4.push(true);
        }
        System.out.println(stack4.isFull());
        stack4.push(false);
        System.out.println(stack4.isFull());

    }
}
