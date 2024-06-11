package consantiagocom.PrimerTrimestre.Tema05Metodos;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio21 {
    public static Scanner lector = new Scanner(System.in);
    public static final int DELAY = 500;
    public static int porrasPlayer;
    public static int puntosPlayer;
    public static int tiradaPlayer;
    public static int porrasCPU;
    public static int puntosCPU;
    public static int tiradaCPU;

    public static void main(String[] args) throws InterruptedException {
        boolean plantado = false;
        int opcion;
        char plantarse;
        do {
            opcion = menuPrincipal();
            if (opcion == 1) {
                nuevaPartida();
                do {
                    tiradaPlayer = tiradaPlayer();
                    puntosPlayer += tiradaPlayer;
                    System.out.println("\nTu puntuaci�n actual es " + puntosPlayer);
                    if (puntosPlayer < 11) {
                        System.out.print("�Deseas plantarte con " + puntosPlayer + " puntos? (s/n): ");
                        plantarse = lector.nextLine().charAt(0);
                        plantado = plantarse == 's' || plantarse == 'S';
                        if (plantado) {
                            plantado = false;
                            // Ahora la CPU intenta igualar o mejorar el resultado del jugador
                            while (puntosCPU < puntosPlayer) {
                                tiradaCPU = tiradaCPU();
                                puntosCPU += tiradaCPU;
                                System.out.println("La puntuaci�n actual de la CPU es " + puntosCPU);
                            }
                            if (puntosCPU > 11) {
                                System.out.println("CPU se ha pasado. Porra para Player!!");
                                porrasPlayer++;
                                puntosCPU = 0;
                                puntosPlayer = 0;
                            } else if (puntosCPU > puntosPlayer) { // Gana CPU
                                if (puntosCPU == 11) {
                                    mostrarOnce();
                                    System.out.println("\nDoble porra para CPU\n");
                                    porrasCPU += 2;
                                } else {
                                    System.out.println("CPU ha mejorado tu puntuaci�n. Porra para CPU!!");
                                    porrasCPU++;
                                }
                                puntosCPU = 0;
                                puntosPlayer = 0;
                            } else { // Empate
                                empate();
                            }
                            mostrarStats();
                        }
                    } else if (puntosPlayer == 11) {
                        // Al obtener 11 el jugador suma autom�ticamente 2 porras
                        porrasPlayer += 2;
                        puntosCPU = 0;
                        puntosPlayer = 0;
                        mostrarOnce();
                        System.out.println("\n�Bonificaci�n! Doble porra");
                        mostrarStats();
                    } else {
                        // El jugador se ha pasado
                        System.out.println("Ohh!! Te has pasado");
                        System.out.println("Porra para la CPU");
                        porrasCPU += 1;
                        puntosCPU = 0;
                        puntosPlayer = 0;
                        mostrarStats();
                    }

                } while (porrasPlayer < 5 && porrasCPU < 5);
                if (porrasCPU >= 5) {
                    System.out.println("\nCPU gana la partida!!! por " + porrasCPU + " porras a " + porrasPlayer + "\n");
                } else if (porrasPlayer >= 5) {
                    System.out.println("\nPlayer gana la partida!!! por " + porrasPlayer + " porras a " + porrasCPU + "\n");
                }
            }
        } while (opcion != 0);
        System.out.println("Hasta pronto!!");
    }

    /**
     * Muestra el men� principal y solicita una opci�n
     *
     * @return La opci�n elegida por el usuario
     */
    public static int menuPrincipal() {
        System.out.println("***************************");
        System.out.println("*** JUEGO DE DADOS ONCE ***");
        System.out.println("***************************");
        System.out.println("1. Nueva partida ...");
        System.out.println("0. Salir");
        System.out.print("\nElige una opci�n: ");
        return Integer.parseInt(lector.nextLine());
    }

    /**
     * Mensaje a mostrar cuando se consigue ONCE
     */
    public static void mostrarOnce() {
        System.out.println("\n$$$$$$$$$$$$$$$$");
        System.out.println("$$$$ �ONCE! $$$$");
        System.out.println("$$$$$$$$$$$$$$$$");
    }

    /**
     * Inicia una nueva partida
     */
    public static void nuevaPartida() {
        porrasCPU = 0;
        porrasPlayer = 0;
        puntosCPU = 0;
        puntosPlayer = 0;
    }

    /**
     * Muestra el valor del dado
     *
     * @param dado Valor de la tirada
     */
    public static void mostrarTirada(int dado) {
        System.out.println("\n*****");
        System.out.println("* " + dado + " *");
        System.out.println("*****");
    }

    /**
     * Genera un n�mero entero aleatorio entre min y max (ambos incluidos)
     * @param min M�nimo n�mero a generar
     * @param max M�ximo n�mero a generar
     * @return El n�mero aleatorio generado
     */
    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Genera y muestra la jugada del Player a�adiendo un peque�o retardo
     * para que de tiempo a visualizarlo correctamente en pantalla
     *
     * @return El valor del dado
     * @throws InterruptedException
     */
    public static int tiradaPlayer() throws InterruptedException {
        System.out.println("Jugador lanza el dado al aire ...");
        Thread.sleep(DELAY);
        tiradaPlayer = aleatorio(1, 6);
        mostrarTirada(tiradaPlayer);
        return tiradaPlayer;
    }

    /**
     * Genera y muestra la jugada de la CPU a�adiendo un peque�o retardo
     * para que de tiempo a visualizarlo correctamente en pantalla
     *
     * @return El valor del dado
     * @throws InterruptedException
     */
    public static int tiradaCPU() throws InterruptedException {
        System.out.println("CPU lanza el dado al aire ...");
        Thread.sleep(DELAY);
        tiradaCPU = aleatorio(1, 6);
        mostrarTirada(tiradaCPU);
        return tiradaCPU;
    }

    /**
     * Muestra las estad�sticas totatales
     */
    public static void mostrarStats() {
        System.out.println("\n**********************");
        System.out.println("* " + porrasPlayer + " PLAYER  -  CPU " + porrasCPU + " *");
        System.out.println("**********************");
        System.out.print("\nPulsa intro para continuar...");
        lector.nextLine();
    }

    /**
     * Empate entre Player y CPU
     */
    public static void empate() {
        System.out.println("Empate!! Porra para los dos");
        puntosCPU = 0;
        puntosPlayer = 0;
        porrasCPU++;
        porrasPlayer++;
    }
}