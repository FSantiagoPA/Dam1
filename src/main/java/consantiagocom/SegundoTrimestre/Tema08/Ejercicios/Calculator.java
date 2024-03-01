package consantiagocom.SegundoTrimestre.Tema08.Ejercicios;

public class Calculator {
    public enum Estado{
        OPERADOR_ENTERO, PUNTO, OPERANDO_DECIMAL, OPERADOR, ERROR
    }
    private StringBuilder op1;
    private StringBuilder op2;
    private  StringBuilder operandoActual;
    private String operador;
    private Estado estadoActual;
    private Estado[][] diagramaDeEstado;
    public Calculator() {
        op1 = new StringBuilder();
        op2 = new StringBuilder();
        operandoActual = op1;
        estadoActual = Estado.OPERADOR_ENTERO;
        diagramaDeEstado = new Estado[][]{
                {Estado.OPERADOR_ENTERO, Estado.PUNTO, Estado.OPERADOR, Estado.ERROR},
                {Estado.OPERANDO_DECIMAL, Estado.ERROR},
                {Estado.OPERANDO_DECIMAL, Estado.OPERADOR, Estado.ERROR},
                {Estado.OPERADOR_ENTERO, Estado.ERROR},
                {Estado.ERROR}
        };
    }
    public void addDigit(String digit){
        if (estadoActual == Estado.ERROR)
            return;
        Estado siguienteEstado = Estado.OPERADOR_ENTERO;
        if (estadoActual == Estado.OPERANDO_DECIMAL || estadoActual == Estado.PUNTO)
            siguienteEstado = Estado.OPERANDO_DECIMAL;
        if (!esTrancicionValida(siguienteEstado)){
            error();
            return;
        }
        if (digit == null || digit.length() > 1 || !Character.isDigit(digit.charAt(0))){
            error();
            return;
        }

        operandoActual.append(digit);
        estadoActual = siguienteEstado;

    }

    private void error(){
        estadoActual = Estado.ERROR;
    }

    private boolean esTrancicionValida(Estado siguienteEstado){
        Estado[] estadosTransitables = diagramaDeEstado[estadoActual.ordinal()];
        for (Estado estadosTransitable : estadosTransitables) {
            if (estadosTransitable == siguienteEstado)
                return true;
        }
        return false;
    }
}
