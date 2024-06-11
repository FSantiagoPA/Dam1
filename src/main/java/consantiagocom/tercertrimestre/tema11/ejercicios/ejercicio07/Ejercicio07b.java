package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07.Exceptions.EntradaNoExisteException;
import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07.Exceptions.EntradaYaDevueltaException;
import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07.Exceptions.PartidoNoValidoException;
import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07.Exceptions.PartidoYaJugadoException;
import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ejercicio07b {
    private final GestionEntradas gestionEntradas;

    public Ejercicio07b() {
        int opcion;
        gestionEntradas = new GestionEntradas();
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevoPartido();
                    break;
                case 2:
                    gestionarEntradas();
                    break;

                case 0:
                    System.out.println("Hasta pronto");
                    break;
            }
        } while (opcion != 0);
    }

    /** Se encarga de la opci�n del men� Gesti�n de entradas */
    private void gestionarEntradas() {
        int idPartido;
        boolean validado;
        int opcion;
        do {
            mostrarPartidosPendientes();
            idPartido = solicitarIdPartido();
            try {
                gestionEntradas.setPartidoActual(idPartido);
                validado = true;
            } catch (PartidoYaJugadoException | PartidoNoValidoException e) {
                validado = false;
                System.out.println(e.getMessage());
            }
            if(validado) {
                do {
                    opcion = menuEntradas();
                    switch (opcion) {
                        case 1:
                            venderEntradas();
                            Lib.pausa();
                            break;
                        case 2:
                            devolverEntrada();
                            Lib.pausa();
                            break;
                        case 3:
                            mostrarDisponibilidadAsientos();
                            Lib.pausa();
                            break;
                        case 4:
                            mostrarRecaudacion();
                            Lib.pausa();
                            break;
                        case 0:
                            gestionEntradas.clearPartidoActual();
                            break;
                    }
                } while (opcion != 0);
            }
        } while (!validado);
    }

    /**
     * Muestra la recaudaci�n total  de las entradas
     */
    private void mostrarRecaudacion() {
        System.out.println("Recaudaci�n: " + gestionEntradas.getRecaudacion());
    }

    /**
     * Devuelve una entrada
     */
    private void devolverEntrada() {
        int numeroEntrada = solicitarNumeroEntrada();
        if(numeroEntrada >= 0) {
            try {
                gestionEntradas.devolverEntrada(numeroEntrada);
                System.out.println("La entrada ha sido devuelta correctamente");
            } catch (EntradaNoExisteException | EntradaYaDevueltaException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Solo n�meros positivos");
        }
    }

    /**
     * Solicita al usuario el n�mero de entrada
     * @return n�mero de entrada le�do, en caso de error devuelve -1
     */
    private int solicitarNumeroEntrada() {
        int numeroEntrada = -1;
        System.out.println("N�mero entrada: ");
        try {
            numeroEntrada = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {

        }
        return numeroEntrada;
    }

    /**
     * Opci�n del men� para la venta de entradas
     */
    private void venderEntradas() {
        Zona zona;
        Fila fila;
        Asiento asiento;
        boolean validado;

        mostrarZonas();
        zona = solicitarZona();
        validado = zona != null;
        if(!validado) {
            return;
        }

        mostrarDisponibilidadAsientos(zona);
        fila = solicitarFila(zona);
        validado = fila != null;
        if(!validado) {
            return;
        }

        asiento = solicitarAsiento(fila);
        validado = asiento != null;
        if(!validado) {
            return;
        }

        Entrada entrada = gestionEntradas.venderEntrada(zona, fila, asiento);
        if(entrada != null) {
            System.out.println("Entrada vendida correctamente");
            System.out.println(entrada);
        } else {
            System.out.println("La localidad seleccionada no est� disponible");
        }
    }



    /**
     * Solicita al usuario por teclado el n�mero de asiento de la Fila pasada como par�metro
     * @param fila
     * @return
     */
    private Asiento solicitarAsiento(Fila fila) {
        Asiento asiento = null;
        System.out.println("Asiento: ");
        try {
            int numero = Integer.parseInt(Lib.lector.nextLine());
            asiento = buscarAsiento(fila, numero);
        } catch (NumberFormatException nfe) {

        }
        return asiento;
    }

    /**
     * Muestra los asientos de la Fila recibida como par�metro
     * @param fila Fila a mostrar
     */
    private void mostrarAsientos(Fila fila) {
        Asiento[] asientos = fila.getAsientos();
        for(int i = 0; i < asientos.length; i++) {
            System.out.println(asientos[i].toString());
        }
    }

    /**
     * Solicita una Zona al usuario y muestra la disponibilidad de asientos para dicha Zona
     */
    private void mostrarDisponibilidadAsientos() {
        Zona zona = solicitarZona();
        if(zona != null) {
            mostrarDisponibilidadAsientos(zona);
        } else {
            System.out.println("La zona no existe");
        }
    }

    /**
     * Muestra la disponibilidad de asientos de la Zona pasada como par�metro
     * @param zona Zona a mostrar
     */
    private void mostrarDisponibilidadAsientos(Zona zona) {
        System.out.println(gestionEntradas.zonaToColorString(zona));
    }

    /**
     * Muestra todas las zonas del Estadio
     */
    private void mostrarZonas() {
        Zona[] zonas = gestionEntradas.getZonas();
        for(int i = 0; i < zonas.length; i++) {
            System.out.println(zonas[i]);
        }
    }

    /**
     * Solicita una Fila de la Zona pasada como par�metro
     * @param zona Zona donde se encuentra la Fila
     * @return La Fila solicitada o null en caso de error o no encontrarse la Fila
     */
    private Fila solicitarFila(Zona zona) {
        Fila fila = null;
        int numero;
        System.out.println("Fila: ");
        try {
            numero = Integer.parseInt(Lib.lector.nextLine());
            fila = buscarFila(zona, numero);
        } catch (NumberFormatException nfe) {

        }
        return fila;
    }

    /**
     * Busca el Asiento ubicado en la Fila y numero indicados
     * @param fila Fila donde se encuentra el Asiento
     * @param numero N�mero del Asiento
     * @return
     */
    private Asiento buscarAsiento(Fila fila, int numero) {
        Asiento[] asientos = fila.getAsientos();
        for(int i = 0; i < asientos.length; i++) {
            if(asientos[i].getNumero() == numero) {
                return asientos[i];
            }
        }
        return null;
    }

    /**
     * Busca la Fila con el n�mero y Zona indicados
     * @param zona Zona donde se encuentra la Fila
     * @param numero N�mero de la Fila
     * @return La Fila buscada o null si no se ha encontrado
     */
    private Fila buscarFila(Zona zona, int numero) {
        Fila[] filas = zona.getFilas();
        for(int i = 0; i < filas.length; i++) {
            if(filas[i].getNumero() == numero) {
                return filas[i];
            }
        }
        return null;
    }

    /**
     * Solicita una Zona al usuario
     * @return Zona indicada por el usuario
     */
    private Zona solicitarZona() {
        Zona zona = null;
        int idZona;
        System.out.println("Zona: ");
        try {
            idZona = Integer.parseInt(Lib.lector.nextLine());
            zona = buscarZona(idZona);
        } catch (NumberFormatException nfe) {

        }
        return zona;
    }

    /**
     * Busca la Zona con el idZona recibido como par�metro
     * @param idZona
     * @return
     */
    private Zona buscarZona(int idZona) {
        Zona[] zonas = gestionEntradas.getZonas();
        for(int i = 0; i < zonas.length; i++) {
            if(zonas[i].getId() == idZona) {
                return zonas[i];
            }
        }
        return null;
    }

    /**
     * Solicita al usuario el Id del Partido
     * @return id del Partido elegido o -1 en caso de error
     */
    private int solicitarIdPartido() {
        int idPartido;
        System.out.println("Id Partido: ");
        try {
            idPartido = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {
            idPartido = -1;
        }
        return idPartido;
    }

    /**
     * Crea un nuevo Partido solicitando y validando los datos necesarios
     */
    private void nuevoPartido() {
        GregorianCalendar fechaPartido;
        boolean validado;
        TipoPartido tipoPartido;
        String equipoLocal;
        String equipoVisitante;
        do {
            fechaPartido = solicitarFechaPartido();
            validado = fechaPartido != null;
            if(!validado) {
                System.out.println("Fecha incorrecta. Recuerde dd/mm/yyyy");
            }
        } while(!validado);

        do {
            tipoPartido = solicitarTipoPartido();
            validado = tipoPartido != null;
            if(!validado) {
                System.out.println("TipoPartido incorrecto. Seleccione un tipo de partido");
            }
        } while (!validado);

        do {
            equipoLocal = solicitarEquipo("local");
            validado = equipoLocal.length() > 2;
            if(!validado) {
                System.out.println("El nombre del equipo debe tener al menos 2 caracteres");
            }
        } while (!validado);

        do {
            equipoVisitante = solicitarEquipo("visitante");
            validado = equipoVisitante.length() > 2;
            if(!validado) {
                System.out.println("El nombre del equipo debe tener al menos 2 caracteres");
            }
        } while (!validado);

        gestionEntradas.addPartido(fechaPartido, equipoLocal, equipoVisitante, tipoPartido);
        System.out.println("Partido a�adido correctamente");
    }

    /**
     * Solicita el nombre del equipo
     * @param s Texto a mostrar. Habitualmente "local" o "visitante"
     * @return Nombre del equipo le�do
     */
    private String solicitarEquipo(String s) {
        String equipo = "";
        System.out.println("Equipo " + s + ": ");
        equipo = Lib.lector.nextLine();
        return equipo;
    }

    /**
     * Solicita y valida una fecha al usuario
     * @return La Fecha solicitada o null en caso de error
     */
    private GregorianCalendar solicitarFechaPartido() {
        GregorianCalendar fechaPartido = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaPartidoStr;
        System.out.println("Fecha del partido (dd/mm/yyyy): ");
        fechaPartidoStr = Lib.lector.nextLine();
        try {
            Date datePartido = sdf.parse(fechaPartidoStr);
            fechaPartido.setTime(datePartido);
        }catch (ParseException pe) {
            fechaPartido = null;
        }
        return fechaPartido;
    }

    /**
     * Solicita el TipoPartido
     * @return TipoPartido o null en caso de error
     */
    private TipoPartido solicitarTipoPartido() {
        TipoPartido tipoPartido = null;
        mostrarTiposPartido();
        System.out.println("Elija una opci�n: ");
        try {
            int opcion = Integer.parseInt(Lib.lector.nextLine());
            tipoPartido = TipoPartido.values()[opcion];
        } catch (NumberFormatException nfe) {

        }
        return tipoPartido;
    }

    /**
     * Muestra los TipoPartido disponibles
     */
    private void mostrarTiposPartido() {
        for(TipoPartido tipoPartido: TipoPartido.values()) {
            System.out.println(tipoPartido.ordinal() + ". " +tipoPartido);
        }
    }

    /**
     * Opci�n del men� para la gesti�n de Entradas
     * @return Opci�n l�ida (validada) por teclado
     */
    private int menuEntradas() {
        int opcion = -1;
        do {
            Partido partidoActual = gestionEntradas.getPartidoActual();
            Lib.limpiarPantalla();
            System.out.println(partidoActual.getLocal() + " VS " + partidoActual.getVisitante());
            System.out.println("***********************");
            System.out.println("* GESTI�N DE ENTRADAS *");
            System.out.println("***********************");
            System.out.println("1. Venta de entradas");
            System.out.println("2. Devolver una entrada");
            System.out.println("3. Listado de disponibilidad de localidades por zona");
            System.out.println("4. Mostrar recaudaci�n del partido");
            System.out.println("-----------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opci�n: ");
            try {
                opcion = Integer.parseInt(Lib.lector.nextLine());
                if (opcion < 0 || opcion > 4) {
                    System.out.println("Elija una opci�n del men� [0-4]");
                    Lib.pausa();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo n�meros por favor");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }

    /**
     * Muestra el men� principal y elige una opci�n
     * @return Opci�n (validada) le�da
     */
    private int menuPrincipal() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("**********************");
            System.out.println("* GESTI�N DE ESTADIO *");
            System.out.println("**********************");
            System.out.println("1. Nuevo partido...");
            System.out.println("2. Gesti�n de entradas");
            System.out.println("----------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opci�n: ");
            try {
                opcion = Integer.parseInt(Lib.lector.nextLine());
                if (opcion < 0 || opcion > 2) {
                    System.out.println("Elija una opci�n del men� [0-2]");
                    Lib.pausa();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo n�meros por favor");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }


    /**
     * Muestra los Partidos que est�n pendientes de Jugar, es decir, aquellos cuya fecha es posterior
     * a la fecha actual
     */
    private void mostrarPartidosPendientes() {
        ArrayList<Partido> partidosPendientes = gestionEntradas.getPartidosPendientes();
        for(Partido partido: partidosPendientes) {
            System.out.println(partido.toString());
        }
    }
}
