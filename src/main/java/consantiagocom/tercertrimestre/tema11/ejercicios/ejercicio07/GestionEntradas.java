package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07;

import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07.Exceptions.EntradaNoExisteException;
import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07.Exceptions.EntradaYaDevueltaException;
import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07.Exceptions.PartidoNoValidoException;
import consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio07.Exceptions.PartidoYaJugadoException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionEntradas {
    private final Estadio estadio;
    private Partido partidoActual;


    public GestionEntradas() {
        this.estadio = new Estadio();
        partidoActual = null;
    }


    public void addPartido(GregorianCalendar fecha, String local, String visitante, TipoPartido tipoPartido) {
        estadio.addPartido(fecha, local, visitante, tipoPartido);
    }

    public void setPartidoActual(int idPartido) throws PartidoNoValidoException, PartidoYaJugadoException {
        partidoActual = buscarPartido(idPartido);
        if(partidoActual == null) {
            throw new PartidoNoValidoException("El id del partido no es válido");
        } else if(partidoActual.getFecha().compareTo(Calendar.getInstance()) < 0) {
            throw new PartidoYaJugadoException("El partido seleccionado ya se ha jugado");
        }
    }

    public void clearPartidoActual() {
        partidoActual = null;
    }

    public Partido getPartidoActual() {
        return partidoActual;
    }

    /**
     * Busca el Partido con el id indicado como parámetro
     * @param idPartido id del Partido a buscar
     * @return Partido buscado o null en caso de no ser encontrado
     */
    private Partido buscarPartido(int idPartido) {
        return estadio.buscarPartido(idPartido);
    }

    public ArrayList<Partido> getPartidosPendientes() {
        return estadio.buscarPartidosPosterioresAFecha(Calendar.getInstance());
    }

    /**
     * Busca una entrada a partir del numeroEntrada
     * @param numeroEntrada Número de la entrada
     * @return La Entrada encontrada o null si no se ha encontrado
     */
    public Entrada buscarEntrada(int numeroEntrada) {
        for(Entrada entrada: partidoActual.getEntradas().values()) {
            if(entrada.getId() == numeroEntrada) {
                return entrada;
            }
        }
        return null;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    /**
     * Devuelve una Entrada a partir de su número.
     * @param numeroEntrada Número de la entrada
     * @throws EntradaYaDevueltaException
     * @throws EntradaNoExisteException
     */
    public void devolverEntrada(int numeroEntrada) throws EntradaYaDevueltaException, EntradaNoExisteException {
        for(Entrada entrada : partidoActual.getEntradas().values()) {
            if(entrada.getId() == numeroEntrada) {
                if(entrada.devolver()) {
                    // Ha ido bien, por tanto salimos
                    return;
                } else {
                    throw new EntradaYaDevueltaException("La entrada ya ha sido devuelta");
                }
            }
        }
        throw new EntradaNoExisteException("La entrada " + numeroEntrada + " no existe");
    }


    /**
     * Obtiene la recaudación del partido actual
     * @return El dinero recaudado o 0 si no se ha seleccionado partidoActual
     */
    public double getRecaudacion() {
        if(partidoActual != null)
            return partidoActual.getRecaudacion();
        return 0;
    }


    /**
     * Vende una entrada para un asiento en una zona y filas determinadas
     * @param zona
     * @param fila
     * @param asiento
     * @return La entrada vendida o null si no se ha asignado partido actual
     */
    public Entrada venderEntrada(Zona zona, Fila fila, Asiento asiento) {
        if(partidoActual != null)
            return partidoActual.venderEntrada(zona, fila, asiento);
        return null;
    }

    /**
     * Muestra la disponibilidad de asientos de la Zona pasada como parámetro
     * @param zona Zona a mostrar
     */
    public String zonaToColorString(Zona zona) {
        return getPartidoActual().zonaToColorString(zona);
    }

    /**
     * Obtiene las zonas del estadio
     * @return
     */
    public Zona[] getZonas() {
        if(partidoActual != null)
            return estadio.getZonas();
        return null;
    }


}