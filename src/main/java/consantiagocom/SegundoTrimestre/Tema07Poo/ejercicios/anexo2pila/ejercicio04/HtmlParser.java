package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio04;

import consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.anexo2pila.ejercicio03.PilaString;

public class HtmlParser {
    public enum Estado {
        TEXTO, DECLARACION, PROCESANDO_ETIQUETA, BUSCANDO_FIN_DECLARACION, CIERRE_ETIQUETA
    }
    private final String texto;
    /** Estructura interna pila para determinar almacenar el orden de las etiquetas de apertura */
    private final PilaString pila;
    /** Estado del procesado del documento */
    private Estado estado;
    /** Contiene el mensaje de error en caso que el documento no est� bien formado */
    private String errorMessage;

    /**
     * Crea un objeto HtmlParser para determinar si el c�digo html est� bien formado
     * @param texto Cadena de texto que contiene el c�digo html a evaluar
     */
    public HtmlParser(String texto) {
        // Eliminamos todos los espacios en blanco
        this.texto = texto.replaceAll("\\s+", " ");
        this.pila = new PilaString();
        this.errorMessage = "";
    }

    /**
     * Procesa el texto html y determina si el orden de apertura y cierre de etiquetas es correcto
     * @return true si el documento html est� bien formado, false en caso contrario
     */
    public boolean parse() {
        // En este caso implementamos el parseado de forma totalmente manual.
        // Una implementaci�n m�s sencilla podr�a hacerse utilizando StringTokenizer
        // que ofrece m�todos para obtener partes del documento (tokens) a partir de patrones.
        // De esta forma, se simplificar�a el procesado de etiquetas
        // Otra opci�n incluso m�s sencilla es utilizar clases como Jsoup que ya hacen el parseado autom�ticamente
        int i = 0;
        estado = Estado.TEXTO;
        boolean procesandoAtributo = false;
        StringBuilder aperturaEtiqueta = new StringBuilder();
        StringBuilder cierreEtiqueta = new StringBuilder();
        while (i < texto.length()) {
            char c = texto.charAt(i);
            switch (estado) {
                case TEXTO:
                    if (c == '<') {
                        estado = Estado.DECLARACION;
                    }
                    break;
                case DECLARACION:
                    if (Character.isLetter(c)) {
                        estado = Estado.PROCESANDO_ETIQUETA;
                        aperturaEtiqueta.append(c);
                    } else if (c == '/') {
                        estado = Estado.CIERRE_ETIQUETA;
                    } else if (c == '<') {
                        declaracionInesperada(i);
                        return false;
                    } else if (c == '>') {
                        cierreDeclaracionInesperada(i);
                    }
                    break;
                case PROCESANDO_ETIQUETA:
                    if (Character.isLetter(c)) {
                        aperturaEtiqueta.append(c);
                    } else if (c == '/') { // Etiqueta con autocierre
                        aperturaEtiqueta.setLength(0); // borramos la etiqueta
                        estado = Estado.CIERRE_ETIQUETA;
                    } else if (c == '>') { // Fin definici�n de la etiqueta
                        // Procesar etiqueta
                        procesarEtiqueta(aperturaEtiqueta);
                    } else if (Character.isSpaceChar(c)) {
                        // Aqu� acaba el nombre de la etiqueta
                        estado = Estado.BUSCANDO_FIN_DECLARACION;
                    } else if (c == '<') {
                        declaracionInesperada(i);
                        return false;
                    }
                    break;
                case BUSCANDO_FIN_DECLARACION:
                    if (c == '/') {
                        if (!procesandoAtributo) { // Etiqueta con autocierre
                            aperturaEtiqueta.setLength(0); // borramos la etiqueta
                            estado = Estado.CIERRE_ETIQUETA;
                        }
                    } else if (c == '<') {
                        declaracionInesperada(i);
                        return false;
                    } else if (c == '>') { // Fin declaraci�n encontrado
                        // Procesar etiqueta
                        procesarEtiqueta(aperturaEtiqueta);
                    } else if (c == '"') {
                        procesandoAtributo = !procesandoAtributo;
                    }
                    break;
                case CIERRE_ETIQUETA:
                    if (Character.isLetter(c)) {
                        cierreEtiqueta.append(c);
                    } else if (c == '>') { // Fin declaraci�n
                        if (cierreEtiqueta.length() > 0) {
                            String aperturaAnterior = pila.pop();
                            if (!aperturaAnterior.equals(cierreEtiqueta.toString())) {
                                errorMessage = "Se esperaba </" + aperturaAnterior + "> pero </" +
                                        cierreEtiqueta + "> fue encontrado en posici�n " + i + "\n";
                                // errorMessage += texto + "\n\n";
                                errorMessage += pila;
                                return false;

                            }
                        }
                        cierreEtiqueta.setLength(0);
                        estado = Estado.TEXTO;
                    }
                    break;
            }
            i++;
        }
        return pila.isEmpty();
    }

    private void procesarEtiqueta(StringBuilder etiqueta) {
        if (!etiqueta.toString().equalsIgnoreCase("doctype")) {
            pila.push(etiqueta.toString());
        }
        etiqueta.setLength(0);
        estado = Estado.TEXTO;
    }

    private void declaracionInesperada(int pos) {
        errorMessage = "Se esperaba una definici�n de etiqueta y se encontr� otra apertura '<' en posici�n " + pos + "\n";
        errorMessage += texto;
    }

    private void cierreDeclaracionInesperada(int pos) {
        errorMessage = "Se esperaba una definici�n de etiqueta y se encontr� un cierre '<' inesperado en posici�n " + pos + "\n";
        errorMessage += texto;
    }

    /**
     * Obtiene los mensajes de error
     * @return Cadena de texto con los mensajes de error
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
