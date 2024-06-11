package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio03;

import java.util.Objects;

public class CodigoFuenteParser {
    /** S�mbolos de apertura como por ejemplo "{([" */
    private final String simbolosApertura;
    /** S�mbolos de cierre como por ejemplo "})]" */
    private final String simbolosCierre;
    /** Texto a parsear */
    private final String texto;
    /** Estructura interna pila para determinar el orden correcto de cierre */
    private final PilaString pila;
    /** Contiene el mensaje de error en caso que el documento no est� bien formado */
    private String errorMessage;

    /**
     * Crea un objeto CodigoFuenteParser para determinar si el c�digo est� bien formado
     * @param texto Cadena de texto que contiene el c�digo fuente a evaluar
     * @param simbolosApertura S�mbolos utilizados como apertura
     * @param simbolosCierre S�mbolos utilizados como cierre
     */
    public CodigoFuenteParser(String texto, String simbolosApertura, String simbolosCierre) {
        this.simbolosApertura = simbolosApertura;
        this.simbolosCierre = simbolosCierre;
        // Eliminamos todos los espacios en blanco
        this.texto = texto.replaceAll("\\s+", "");
        this.pila = new PilaString();
        this.errorMessage = "";
    }

    /**
     * Procesa el texto y determina si el orden de apertura y cierre de los s�mbolos recibidos
     * en el constructor es correcto
     * @param showDebugInfo Determina si se mostrar� informaci�n de depuraci�n
     * @return true si el documento est� bien formado, false en caso contrario
     */
    public boolean parse(boolean showDebugInfo) {
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (simbolosApertura.indexOf(c) >= 0) {
                pila.push(String.valueOf(c));
                if (showDebugInfo) {
                    System.out.println("Push: " + c);
                }
            } else {
                int index = simbolosCierre.indexOf(c);
                if (index >= 0) {
                    String aux = pila.pop();
                    if (aux == null) {
                        errorMessage = "Se ha encontrado un " + c + " sin apertura";
                        return false;
                    }
                    String match = simbolosApertura.substring(index, index + 1);
                    if (showDebugInfo) {
                        System.out.println("Pop: " + aux);
                    }
                    if (!aux.equals(match)) {
                        errorMessage = "Error: esperando un " + aux + " pero " + c + " ha sido encontrado";
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Obtiene los mensajes de error
     * @return Cadena de texto con los mensajes de error
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodigoFuenteParser that = (CodigoFuenteParser) o;

        if (!Objects.equals(simbolosApertura, that.simbolosApertura))
            return false;
        if (!Objects.equals(simbolosCierre, that.simbolosCierre))
            return false;
        if (!texto.equals(that.texto)) return false;
        if (!pila.equals(that.pila)) return false;
        return Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        int result = simbolosApertura != null ? simbolosApertura.hashCode() : 0;
        result = 31 * result + (simbolosCierre != null ? simbolosCierre.hashCode() : 0);
        result = 31 * result + texto.hashCode();
        result = 31 * result + pila.hashCode();
        result = 31 * result + (errorMessage != null ? errorMessage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CodigoFuenteParser{" +
                "simbolosApertura='" + simbolosApertura + '\'' +
                ", simbolosCierre='" + simbolosCierre + '\'' +
                ", texto='" + texto + '\'' +
                ", pila=" + pila +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
