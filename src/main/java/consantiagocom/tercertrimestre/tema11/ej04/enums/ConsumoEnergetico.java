package consantiagocom.tercertrimestre.tema11.ej04.enums;

public enum ConsumoEnergetico {
    A(100),B(80),C(60),D(50),E(30),F(10);

    private final int valor;

    ConsumoEnergetico(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}