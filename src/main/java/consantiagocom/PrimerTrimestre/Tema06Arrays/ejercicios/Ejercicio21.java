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
    // método venía impuesto por el enunciado
    /**
     * Rellena el array recibido como parámetro con números aleatorios
     *
     * @param array Array a rellenar
     */
    public static void crearArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = alea(0, 50);
        }
    }

    /**
     * Muestra el array pasado como parámetro
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

        // 2. Utilizar el método toString de la clase Arrays.
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
     * Muestra los elementos del array que son múltiplos de 3
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
     * Genera un número entero aleatorio entre min y max
     *
     * @param min Número mínimo a ser generado
     * @param max Número máximo a ser generado
     * @return Número entero aleatorio generado
     */
    public static int alea(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Muestra el menú principal de la aplicación, solicita un número
     * de opción y comprueba que esté comprendido entre los posibles valores
     *
     * @return Devuelve la opción seleccionada por el usuario
     */
    public static int mostrarMenu() {
        int opcion;
        boolean validado;
        do {
            borrarPantalla();
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("==============");
            System.out.println("1. Rellenar array");
            System.out.println("2. Visualizar contenido del array");
            System.out.println("3. Visualizar contenido par");
            System.out.println("4. Visualizar contenido múltiplo de 3");
            System.out.println("--------------------------------------");
            System.out.println("0. Salir del menú");
            System.out.print("Selecciona una opción: ");
            opcion = Main.lector.nextInt();
            Main.lector.nextLine();
            validado = opcion >= 0 && opcion <= 4;
            if (!validado) {
                System.out.println(opcion + " no és una opción válida.");
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
     * Solicita la pulsación de la tecla INTRO.
     * Útil para parar la salida de datos por pantalla.
     */
    public static void pausa() {
        System.out.print("Pulsa INTRO para continuar ...");
        Main.lector.nextLine();
    }

}
