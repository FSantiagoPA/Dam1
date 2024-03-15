
package consantiagocom.SegundoTrimestre.Tema08.Ejercicios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculadoraController {
    private final Calculadora calculadora;
    private JLabel pantalla = new JLabel();
    private final ActionListener actionDigito;
    // private final ActionListener actionPunto;
    private final ActionListener actionOperador;

    private final ActionListener actionIgual;
//    private final ActionListener actionON;
//    private final ActionListener actionOFF;
//    private final ActionListener actionAC;


    public CalculadoraController(JLabel display) {
        calculadora = new Calculadora();
        this.pantalla = pantalla;
        actionDigito = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = getBoton(e);
                calculadora.addDigito(boton.getText());
                pantalla.setText(calculadora.getResultado());
            }
        };

        actionOperador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = getBoton(e);
                calculadora.addOperador(boton.getText());
                pantalla.setText(calculadora.getResultado());
            }
        };
        actionIgual = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = getBoton(e);
                calculadora.resolver();
                pantalla.setText(calculadora.getResultado());
            }
        };
    }

    private JButton getBoton(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            return (JButton) e.getSource();
        }
        return null;
    }

    public ActionListener getActionDigito() {
        return actionDigito;
    }

    public ActionListener getActionOperador() {
        return actionOperador;
    }

    public ActionListener getActionIgual() {
        return actionIgual;
    }
}

