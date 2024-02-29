package consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Ejercicio03;

import consantiagocom.SegundoTrimestre.Tema07Poo.Anexo2Pila.Pila;

public class VersionProfe {
    private String texto;
    private final Pila pila;
    private final String simboloApertura;
    private final String simboloCierre;
    private final StringBuilder errores;
    
    public VersionProfe (String texto, String simboloApertura, String simboloCierre){
        this.texto = texto;
        this.simboloApertura = simboloApertura;
        this.simboloCierre = simboloCierre;
        pila = new Pila(20);
        errores = new StringBuilder();
    }
    public boolean parse(){
        for (int i = 0; i <texto.length(); i++) {
            char c = texto.charAt(i);
            if(simboloApertura.indexOf(c) >= 0){ // c es unos de los simbolos de apertura
                pila.push(String.valueOf(c));
                //TODO: FSPR 2024-02-20 Eliminar despues de testing
                System.out.printf("push{%c\n",c);
            }else {
                int indice = simboloCierre.indexOf(c);
                if (indice >= 0){
                    Object dato = pila.pop();
                    if (dato == null){
                        errores.append("Se ha encontrado un ").append(c).append(" sin apertura");
                        return  false;
                    }
                    String apertura = simboloApertura.substring(indice, indice + 1);
                    if (!dato.equals(apertura)){
                        errores.append("Se esperaba un ").append(dato).append(c).append(" ha sido encontrado");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //public String
}
