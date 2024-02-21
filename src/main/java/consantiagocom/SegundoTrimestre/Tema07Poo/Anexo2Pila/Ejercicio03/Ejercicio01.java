package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio03;

import consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Pila;

public class Ejercicio01 {
    private final Pila pila;
    private final String texto;
    public Ejercicio01(Pila pila, String texto) {
        this.pila = pila;
        this.texto = texto;
    }
    public boolean inspeccionDeCodigo(){
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '(' || texto.charAt(i)  == '{' || texto.charAt(i) == '[')
                pila.push(String.valueOf(texto.charAt(i)));
            else if (texto.charAt(i) == ')' || texto.charAt(i)  == '}' || texto.charAt(i) == ']') {
                if(pila.isEmpty())
                    return false;
                String aux = pila.pop();

                if (texto.charAt(i) == '(' && !aux.equals(")"))
                    return false;
                if (texto.charAt(i) == '{' && !aux.equals("}"))
                    return false;
                if (texto.charAt(i) == '[' && !aux.equals("]"))
                    return false;
            }
        }
        return pila.isEmpty();
    }
}
