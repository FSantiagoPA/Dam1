package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios;

import java.util.Random;

public class Ejercicio21 {
    public static void execute() {
        final int N_ELEMENTOS = 10;
        int[] a = new int[N_ELEMENTOS];
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                case 1:
                    crearArray(a);
                    System.out.println("El array se ha inicializado con " + N_ELEMENTOS + " valores aleatorios");
                    pausa();
                    break;
                case 2:
                    visualizarArray(a);
                    pausa();
                    break;
                case 3:
                    visualizarPares(a);
                    pausa();
                    break;
                case 4:
                    visualizarMultiplos3(a);
                    pausa();
                    break;
            }
        } while (opcion != 0);
    }

    // El nombre no es muy significativo, ya que no crea un array
    // sino que lo rellena con datos aleatorios, pero el nombre del
    // m�todo ven�a impuesto por el enunciado
    /**
     * Rellena el array recibido como par�metro con n�meros aleatorios
     *
     * @param array Array a rellenar
     */
    public static void crearArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = alea(0, 50);
        }
    }

    /**
     * Muestra el array pasado como par�metro
     *
     * @param array
     */
    public static void visualizarArray(int[] array) {
        // Dos formas de hacerlo
        // 1. Recorrer el array e imprimir cada elemento
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println("]");

        // 2. Utilizar el m�todo toString de la clase Arrays.
        // Arrays.toString(vector);
    }

    /**
     * Muestra los elementos del array que son pares
     *
     * @param array
     */
    public static void visualizarPares(int[] array) {
        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (cont != 0) {
                    System.out.print(", ");
                }
                System.out.print("v[" + i + "] = " + array[i]);
                cont++;
            }
        }
        System.out.println("");
    }

    /**
     * Muestra los elementos del array que son m�ltiplos de 3
     *
     * @param array
     */
    public static void visualizarMultiplos3(int[] array) {
        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                if (cont != 0) {
                    System.out.print(", ");
                }
                System.out.print("v[" + i + "] = " + array[i]);
                cont++;
            }
        }
        System.out.println("");
    }

    /**
     * Genera un n�mero entero aleatorio entre min y max
     *
     * @param min N�mero m�nimo a ser generado
     * @param max N�mero m�ximo a ser generado
     * @return N�mero entero aleatorio generado
     */
    public static int alea(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Muestra el men� principal de la aplicaci�n, solicita un n�mero
     * de opci�n y comprueba que est� comprendido entre los posibles valores
     *
     * @return Devuelve la opci�n seleccionada por el usuario
     */
    public static int mostrarMenu() {
        int opcion;
        boolean validado;
        do {
            borrarPantalla();
            System.out.println("MEN� PRINCIPAL");
            System.out.println("==============");
            System.out.println("1. Rellenar array");
            System.out.println("2. Visualizar contenido del array");
            System.out.println("3. Visualizar contenido par");
            System.out.println("4. Visualizar contenido m�ltiplo de 3");
            System.out.println("--------------------------------------");
            System.out.println("0. Salir del men�");
            System.out.print("Selecciona una opci�n: ");
            opcion = Main.lector.nextInt();
            Main.lector.nextLine();
            validado = opcion >= 0 && opcion <= 4;
            if (!validado) {
                System.out.println(opcion + " no �s una opci�n v�lida.");
                pausa();
            }
        } while (!validado);
        return opcion;
    }

    /**
     * Borra la pantalla y situa el cursor en la parte superior derecha
     * de la pantalla
     */
    public static void borrarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    /**
     * Solicita la pulsaci�n de la tecla INTRO.
     * �til para parar la salida de datos por pantalla.
     */
    public static void pausa() {
        System.out.print("Pulsa INTRO para continuar ...");
        Main.lector.nextLine();
    }

}
