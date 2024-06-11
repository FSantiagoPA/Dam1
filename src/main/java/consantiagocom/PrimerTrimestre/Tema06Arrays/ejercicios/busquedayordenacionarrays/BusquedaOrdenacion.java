package consantiagocom.PrimerTrimestre.Tema06Arrays.ejercicios.busquedayordenacionarrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BusquedaOrdenacion {
    public enum MetodoOrdenacion {
        BURBUJA, INSERCION, SELECCION, QUICKSORT, COUNTINGSORT
    }

    public enum MetodoRegeneracion {
        AUTOMATICO, MANUAL
    }

    public static int[] array;
    public static Scanner lector = new Scanner(System.in);
    public static final int N_DATOS = 30;
    public static int iteraciones;
    public static MetodoOrdenacion ordenacion = MetodoOrdenacion.QUICKSORT;
    public static int longitudArray = N_DATOS;
    public static int valorMinimoArray = 0;
    public static int valorMaximoArray = N_DATOS;
    public static MetodoRegeneracion regeneracionArray = MetodoRegeneracion.AUTOMATICO;

    public static void main(String[] args) {
        int opcion;
        if (regeneracionArray == MetodoRegeneracion.MANUAL)
            array = crearArray(longitudArray, valorMinimoArray, valorMaximoArray);
        do {
            opcion = mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    opcionMetodosBusqueda();
                    break;
                case 2:
                    opcionMetodosOrdenacion();
                    break;
                case 3:
                    opcionCambiarParametrosArray();
                    break;
                case 4:
                    array = crearArray(longitudArray, valorMinimoArray, valorMaximoArray);
                    mostrarArray(array);
                    pausa();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Rellena el array con números enteros aleatorios
     *
     * @return Array creado
     */
    public static int[] crearArray(int longitud, int min, int max) {
        if (longitud <= 0)
            return null;
        int[] a = new int[longitud];
        for (int i = 0; i < a.length; i++) {
            a[i] = aleatorio(min, max);
        }
        return a;
    }

    /**
     * Genera un número aleatorio entre min y max
     *
     * @param min Número mínimo a generar
     * @param max Número máximo a generar
     * @return Número aleatorio generado
     */
    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Muestra el contenido de un array
     *
     * @param a Array a mostrar
     */
    public static void mostrarArray(int[] a) {
        System.out.println("array = " + Arrays.toString(a));
    }

    /**
     * Solicita por teclado un número al usuario
     *
     * @return El número introducido por el usuario
     */
    public static int solicitarNumero() {
        int num;
        System.out.print("Introduce el número a buscar: ");
        num = lector.nextInt();
        lector.nextLine();
        return num;
    }

    /**
     * Muestra el valor de la variable iteraciones
     *
     * @return
     */
    public static void mostrarIteraciones() {
        System.out.println("(" + iteraciones + " iteraciones)");
    }

    /**
     * Muestra el menú principal al usuario, solicita una opción y comprueba que sea
     * válida
     *
     * @return La opción (validada) introducida por el usuario
     */
    public static int mostrarMenuPrincipal() {
        boolean validado;
        int opcion;
        do {
            int maxOpcion = 3;
            if (regeneracionArray == MetodoRegeneracion.AUTOMATICO)
                array = crearArray(longitudArray, valorMinimoArray, valorMaximoArray);
            borrarPantalla();
            System.out.println("***************************");
            System.out.println("**        Arrays         **");
            System.out.println("** Búsqueda y ordenación **");
            System.out.println("***************************");
            System.out.println("1. Métodos de búsquedas");
            System.out.println("2. Métodos de ordenación");
            System.out.println("3. Cambiar parámetros creación del array");
            if (regeneracionArray == MetodoRegeneracion.MANUAL) {
                System.out.println("4. Crear un nuevo array");
                maxOpcion = 4;
            }
            System.out.println("----------------------------------------");
            System.out.println("0. Salir");
            System.out.print("\nElige una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();
            validado = opcion >= 0 && opcion <= maxOpcion;
            if (!validado) {
                System.out.println(opcion + " no es una opción válida.");
                pausa();
            }
        } while (!validado);
        return opcion;
    }

    /**
     * Muestra el menú de búsquedas al usuario, solicita una opción y comprueba que
     * sea válida
     *
     * @return La opción (validada) introducida por el usuario
     */
    public static int mostrarMenuMetodosBusqueda() {
        boolean validado;
        int opcion;
        do {
            if (regeneracionArray == MetodoRegeneracion.AUTOMATICO)
                array = crearArray(longitudArray, valorMinimoArray, valorMaximoArray);
            borrarPantalla();
            System.out.println("**************************");
            System.out.println("** Métodos de búsquedas **");
            System.out.println("**************************");
            System.out.println("1. Búsqueda lineal");
            System.out.println("2. Búsqueda lineal en array ordenado");
            System.out.println("3. Búsqueda binaria o dicotómica en array ordenado");
            System.out.println("4. Cambiar método de ordenación automática [" + ordenacion + "]");
            System.out.println("--------------------------------------------------");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nElige una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();
            validado = opcion >= 0 && opcion <= 4;
            if (!validado) {
                System.out.println(opcion + " no es una opción válida.");
                pausa();
            }
        } while (!validado);
        return opcion;
    }

    /**
     * Muestra los métodos de búsqueda y ejecuta la opción selecionada
     **/
    public static void opcionMetodosBusqueda() {
        int opcion;
        do {
            opcion = mostrarMenuMetodosBusqueda();
            switch (opcion) {
                case 1:
                    mostrarArray(array);
                    int num = solicitarNumero();
                    int posicion = busquedaLineal(array, num);
                    if (posicion >= 0) {
                        System.out.println("El número " + num + " está en la posición " + posicion + " (array["
                                + posicion + "] = " + array[posicion] + ")");
                    } else {
                        System.out.println("El número " + num + " no está en el array");
                    }
                    mostrarIteraciones();
                    pausa();
                    break;
                case 2:
                    ordenar(array);
                    mostrarArray(array);
                    num = solicitarNumero();
                    posicion = busquedaLinealOrdenado(array, num);
                    if (posicion >= 0) {
                        System.out.println("El número " + num + " está en la posición " + posicion + " (array["
                                + posicion + "] = " + array[posicion] + ")");
                    } else {
                        System.out.println("El número " + num + " no está en el array");
                    }
                    mostrarIteraciones();
                    pausa();
                    break;
                case 3:
                    ordenar(array);
                    mostrarArray(array);
                    num = solicitarNumero();
                    posicion = busquedaDicotomica(array, num);
                    if (posicion >= 0) {
                        System.out.println("El número " + num + " está en la posición " + posicion + " (array["
                                + posicion + "] = " + array[posicion] + ")");
                    } else {
                        System.out.println("El número " + num + " no está en el array");
                    }
                    mostrarIteraciones();
                    pausa();
                    break;
                case 4:
                    int opcionMetodosOrdenacion = mostrarMenuMetodosOrdenacion();
                    switch (opcionMetodosOrdenacion) {
                        case 1:
                            ordenacion = MetodoOrdenacion.BURBUJA;
                            break;
                        case 2:
                            ordenacion = MetodoOrdenacion.INSERCION;
                            break;
                        case 3:
                            ordenacion = MetodoOrdenacion.SELECCION;
                            break;
                        case 4:
                            ordenacion = MetodoOrdenacion.QUICKSORT;
                            break;
                        case 5:
                            ordenacion = MetodoOrdenacion.COUNTINGSORT;
                            break;
                    }
                    break;
            }
        } while (opcion > 0);
    }

    /**
     * Muestra el menú de métodos de ordenación al usuario, solicita una opción y
     * comprueba que sea válida
     *
     * @return La opción (validada) introducida por el usuario
     */
    public static int mostrarMenuMetodosOrdenacion() {
        boolean validado;
        int opcion;
        do {
            if (regeneracionArray == MetodoRegeneracion.AUTOMATICO)
                array = crearArray(longitudArray, valorMinimoArray, valorMaximoArray);
            borrarPantalla();
            System.out.println("***************************");
            System.out.println("** Métodos de ordenación **");
            System.out.println("***************************");
            System.out.println("1. Burbuja");
            System.out.println("2. Inserción");
            System.out.println("3. Selección");
            System.out.println("4. Quicksort");
            System.out.println("5. Countingsort");
            System.out.println("----------------------------");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nElige una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();
            validado = opcion >= 0 && opcion <= 5;
            if (!validado) {
                System.out.println(opcion + " no es una opción válida.");
                pausa();
            }
        } while (!validado);
        return opcion;
    }

    /**
     * Muestra los métodos de ordenación y ejecuta la opción selecionada
     **/
    public static void opcionMetodosOrdenacion() {
        int opcion;
        do {
            opcion = mostrarMenuMetodosOrdenacion();
            switch (opcion) {
                case 1:
                    mostrarArray(array);
                    ordernaBurbuja(array);
                    mostrarArray(array);
                    pausa();
                    break;
                case 2:
                    mostrarArray(array);
                    ordenaInsercion(array);
                    mostrarArray(array);
                    pausa();
                    break;
                case 3:
                    mostrarArray(array);
                    ordenaSeleccion(array);
                    mostrarArray(array);
                    pausa();
                    break;
                case 4:
                    mostrarArray(array);
                    ordenaQuicksort(array, 0, array.length - 1);
                    mostrarArray(array);
                    pausa();
                    break;
                case 5:
                    mostrarArray(array);
                    ordenaContando(array);
                    mostrarArray(array);
                    pausa();
                    break;
            }
        } while (opcion > 0);
    }

    /**
     * Muestra el menú de métodos de ordenación al usuario, solicita una opción y
     * comprueba que sea válida
     *
     * @return La opción (validada) introducida por el usuario
     */
    public static int mostrarMenuCambioParametros() {
        boolean validado;
        int opcion;
        do {
            borrarPantalla();
            System.out.println("*******************************");
            System.out.println("** Parámetros creación array **");
            System.out.println("*******************************");
            System.out.println("1. Longitud [" + longitudArray + "]");
            System.out.println("2. Valor mínimo [" + valorMinimoArray + "]");
            System.out.println("3. Valor máximo [" + valorMaximoArray + "]");
            System.out.println("4. Método de regeneración [" + regeneracionArray + "]");
            System.out.println("----------------------------");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nElige una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();
            validado = opcion >= 0 && opcion <= 4;
            if (!validado) {
                System.out.println(opcion + " no es una opción válida.");
                pausa();
            }
        } while (!validado);
        return opcion;
    }

    /**
     * Muestra el menú para cambiar los parámetros de creación del array y ejecuta
     * la opción selecionada
     **/
    public static void opcionCambiarParametrosArray() {
        int opcion;
        do {
            opcion = mostrarMenuCambioParametros();
            switch (opcion) {
                case 1:
                    System.out.println("Indica la nueva longitud del array (valor actual: " + longitudArray + "):");
                    longitudArray = Integer.parseInt(lector.nextLine());
                    break;
                case 2:
                    System.out.println("Indica el valor mínimo del array (valor actual: " + valorMinimoArray + "):");
                    valorMinimoArray = Integer.parseInt(lector.nextLine());
                    break;
                case 3:
                    System.out.println("Indica el valor máximo del array (valor actual: " + valorMaximoArray + "):");
                    valorMaximoArray = Integer.parseInt(lector.nextLine());
                    break;
                case 4:
                    opcionMetodoRegeneracion();
                    break;
            }
        } while (opcion > 0);
    }

    /**
     * Muestra el menú para cambiar el método de regeneración y ejecuta la opción
     * selecionada
     **/
    public static void opcionMetodoRegeneracion() {
        int opcion = mostrarMenuMetodoRegeneracion();
        regeneracionArray = MetodoRegeneracion.values()[opcion - 1];
    }

    /**
     * Muestra el menú de métodos de regeneración al usuario, solicita una opción y
     * comprueba que sea válida
     *
     * @return La opción (validada) introducida por el usuario
     */
    public static int mostrarMenuMetodoRegeneracion() {
        boolean validado;
        int opcion;
        do {
            borrarPantalla();
            System.out.println("**********************************");
            System.out.println("** Método de regeneración array **");
            System.out.println("**********************************");
            for (int i = 0; i < MetodoRegeneracion.values().length; i++) {
                System.out.printf("%d. %s\n", (i + 1), MetodoRegeneracion.values()[i]);
            }
            System.out.println("----------------------------");
            System.out.print("\nElige una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();
            validado = opcion >= 1 && opcion <= MetodoOrdenacion.values().length;
            if (!validado) {
                System.out.println(opcion + " no es una opción válida.");
                pausa();
            }
        } while (!validado);
        return opcion;
    }

    /**
     * Borra la pantalla utilizando códigos ANSI
     **/
    public static void borrarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    /**
     * Muestra un mensaje solicitando que se pulse la tecla INTRO para continuar
     */
    public static void pausa() {
        System.out.println("Pulsa INTRO para continuar ...");
        lector.nextLine();
    }

    /**
     * Realiza una búsqueda lineal en un array que puede no estar ordenado
     *
     * @param array Array sobre el que se realizará la búsqueda
     * @param num   Número a buscar
     * @return La posición donde se encuentra el número buscado o -1 si no se
     *         encuentra
     */
    public static int busquedaLineal(int[] array, int num) {
        iteraciones = 0;
        for (int i = 0; i < array.length; i++) {
            iteraciones++;
            if (array[i] == num) { /** Si lo encontramos devolvemos la posición */
                return i;
            }
        }
        return -1;
    }

    /**
     * Realiza una búsqueda lineal en un array ordenado
     *
     * @param array Array sobre el que se realizará la búsqueda
     * @param num   Número a buscar
     * @return La posición donde se encuentra el número buscado o -1 si no se
     *         encuentra
     */
    public static int busquedaLinealOrdenado(int[] array, int num) {
        iteraciones = 0;
        for (int i = 0; i < array.length; i++) {
            iteraciones++;
            if (array[i] == num) { /** Lo hemos encontrado */
                return i;
            } else if (array[i] > num) { /**
             * Si el número buscado es mayor que el elemento actual ya sabemos que no está
             */
                return -1;
            }
        }
        return -1;
    }

    /**
     * Realiza una búsqueda binaria o dicotómica en un array ordenado
     *
     * @param array Array sobre el que se realizará la búsqueda
     * @param num   Número a buscar
     * @return La posición donde se encuentra el número buscado o -1 si no se
     *         encuentra
     */
    public static int busquedaDicotomica(int[] array, int num) {
        int centro;
        int inf = 0;
        int sup = array.length - 1;
        iteraciones = 0;
        while (inf <= sup) {
            iteraciones++;
            centro = (sup + inf) / 2;
            if (array[centro] == num) {
                return centro;
            } else if (num < array[centro]) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return -1;
    }

    /**
     * Ordena un array mediante el método de la burbuja
     *
     * @param array Array a ordenar
     */
    public static void ordernaBurbuja(int[] array) {
        boolean hayCambios = true;
        while (hayCambios) {
            hayCambios = false;
            for (int i = 0; i < array.length - 1; i++) {
                // Si el elemento actual es mayor que el elemento siguiente los intercambiamos
                if (array[i] > array[i + 1]) {
                    intercambio(array, i, i + 1);
                    hayCambios = true;
                }
            }
        }
    }

    /**
     * Ordena un array mediante el método de inserción
     *
     * @param array
     */
    public static void ordenaInsercion(int[] array) {
        int aux;
        int j;
        for (int i = 1; i < array.length; i++) {
            aux = array[i]; // Guardamos el elemento actual
            // j apunta al elemento anterior al actual
            j = i - 1;
            // Mientras queden posiciones y aux sea menor que los que tiene a su izquierda
            // los desplazamos a la derecha
            while ((j >= 0) && (aux < array[j])) {
                array[j + 1] = array[j];
                j--;
            }
            // Colocamos a aux en el sitio que le corresponde
            array[j + 1] = aux;
        }
    }

    /**
     * Orderna un array mediante el método de selección
     *
     * @param array
     */
    public static void ordenaSeleccion(int[] array) {
        int min;
        int pos;
        for (int i = 0; i < array.length - 1; i++) {
            // Elegimos como el mínimo el elemento
            min = array[i];
            pos = i; // Guardamos la posición del supuesto mínimo
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    pos = j;
                }
            }
            // Si se ha encontrado algún elemento menor los intercambiamos
            if (pos != i) {
                intercambio(array, i, pos);
            }
        }
    }

    /**
     * Ordena un array mediante el método Quicksort (algoritmo recursivo)
     * El método realiza llamadas recursivas ordenando el subarray comprendido
     * entre izquierda y derecha
     *
     * @param array     Array que queremos ordenar
     * @param izquierda Posición de inicio del subarray (incialmente será 0)
     * @param derecha   Posición final del subarray (inicialmente será array.length
     *                  -1)
     */
    public static void ordenaQuicksort(int[] array, int izquierda, int derecha) {
        // 1. Elegimos el pivote
        int pivote = array[izquierda];
        // 2. Los elementos mayores al pivote van a su derecha, los menores a su
        // izquierda
        // esta parte de la implementación es el corazón del ordenamiento
        // se utilizan variables auxiliares:
        // - i para controlar los elementos a la izquierda del pivote
        // - j para controlar los elementos a la derecha del pivote
        int i = izquierda;
        int j = derecha;
        // mientras los indices no se crucen
        while (i < j) {
            // mientras que el elemento array[i] sea menor o igual al pivote
            // se aumenta el valor de i
            // cuando el bucle finalice, el elemento en array[i] es mayor que pivote y
            // deberá ir a su derecha
            while (array[i] <= pivote && i < j) {
                i++;
            }
            // mientras que el elemento array[j] sea mayor al pivote
            // se desminuye el valor de j
            // cuando el bucle finalice, el elemento en array[j] es menor o igual a pivote y
            // deberá ir a su izquierda
            while (array[j] > pivote) {
                j--;
            }
            // siempre y cuando i sea menor a j, se hace un cambio de los elementos
            // ya que el elemento en array[i] debe ir a la derecha y array[j] a la izquierda
            if (i < j) {
                intercambio(array, i, j);
            }
        }
        // En este punto v[j] es menor o igual al pivote, actualizamos la posición del
        // pivote,
        // trasladando array[j] a la ubicación del pivote y viceversa
        array[izquierda] = array[j];
        array[j] = pivote;
        // 3. Para V1 y V2, aplicar el mismo proceso.
        if (izquierda < j - 1) {
            // Quicksort aplicado a V1
            ordenaQuicksort(array, izquierda, j - 1);
        }
        if (j + 1 < derecha) {
            // Quicksort aplicado a V2
            ordenaQuicksort(array, j + 1, derecha);
        }
    }

    /**
     * Ordena un array mediante el método Countingsort
     *
     * @param array Array que queremos ordenar
     */
    public static void ordenaContando(int[] array) {
        EstadisticasArray estadisticas = new EstadisticasArray(array);
        ordenaContando(array, estadisticas.getMin(), estadisticas.getMax());
    }

    /**
     * Ordena un array mediante el método Countingsort
     * Se indica min y max para evitar que haga más iteraciones
     *
     * @param array Array que queremos ordenar
     * @param min   El elemento más pequeño del array
     * @param max   El elemento más grande del array
     */
    public static void ordenaContando(int[] array, int min, int max) {
        int longitud = Math.max(Math.abs(min), Math.abs(max));
        int[] contador = new int[longitud + 1];
        int[] negativos = null;
        if (min < 0) {
            negativos = new int[contador.length];
        }
        for (int i = 0; i < array.length; i++) {
            int valor = array[i];
            if (valor < 0)
                negativos[Math.abs(valor)]++;
            else
                contador[valor]++;
        }
        int offset = 0;
        if (min < 0) {
            for (int i = negativos.length - 1; i >= 0; i--) {
                int valor = negativos[i];
                for (int j = 0; j < valor; j++) {
                    array[offset] = i * (-1);
                    offset++;
                }
            }
        }
        for (int i = 0; i < contador.length; i++) {
            int valor = contador[i];
            for (int j = 0; j < valor; j++) {
                array[offset] = i;
                offset++;
            }
        }
    }

    /**
     * Intercambia los elementos del array que ocupan las posiciones i y j
     **/
    public static void intercambio(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    /**
     * Ordena el array pasado como parámetro según el método de ordenación elegido
     * en la configuración
     */
    public static void ordenar(int[] array) {
        switch (ordenacion) {
            case BURBUJA:
                ordernaBurbuja(array);
                break;
            case INSERCION:
                ordenaInsercion(array);
                break;
            case SELECCION:
                ordenaSeleccion(array);
                break;
            case QUICKSORT:
                ordenaQuicksort(array, 0, array.length - 1);
                break;
            case COUNTINGSORT:
                ordenaContando(array);
                break;
        }
    }
}
