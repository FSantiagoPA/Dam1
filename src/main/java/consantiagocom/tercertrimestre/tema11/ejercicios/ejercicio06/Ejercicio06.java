package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio06;

import consantiagocom.tercertrimestre.tema11.ejercicios.utils.Lib;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase que act�a como Main.
 * Realiza la E/S y validaci�n de datos
 */
public class Ejercicio06 {
    /** Enumerado para representar el tipo de ordenaci�n */
    private enum Orden {
        DEFAULT, TITULO, ANYO, FECHA_ALQUILER
    }
    /** Constantes de configuraci�n */
    private static final int N_PELICULAS = 30;
    private static final int N_VIDEOJUEGOS = 30;
    private static final int N_SOCIOS = 50;
    /** Atributos */
    private final VideoClub videoClub;

    /**
     * Muestra el men� principal, solicita una opci�n al usuario y ejecuta la opci�n elegida
     */
    public Ejercicio06() {
        int opcion;
        videoClub = new VideoClub(N_PELICULAS, N_VIDEOJUEGOS, N_SOCIOS);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    altas();
                    break;
                case 2:
                    alquilar();
                    Lib.pausa();
                    break;
                case 3:
                    devolver();
                    Lib.pausa();
                    break;
                case 4:
                    consultas();
                    break;

                case 0:
                    System.out.println("Hasta pronto");
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el men� de altas, solicita una opci�n al usuario y la ejecuta
     */
    private void altas() {
        int opcion;
        do {
            opcion = menuAltas();
            switch (opcion) {
                case 1:
                    nuevaPelicula();
                    Lib.pausa();
                    break;
                case 2:
                    nuevoVideojuego();
                    Lib.pausa();
                    break;
                case 3:
                    nuevoSocio();
                    Lib.pausa();
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Crea un Socio solicitando los datos al usuario y valid�ndolos
     */
    private void nuevoSocio() {
        String nif;
        String nombre;
        int edad;
        String poblacion;
        boolean validado;

        do {
            nif = solicitarNif();
            validado = nif.length() >= 2;
            if(validado) {
                validado = Lib.validarNIF(nif);
                if(!validado) {
                    System.out.println("El nif introducido no es v�lido");
                }
            } else {
                System.out.println("El nif debe tener al menos 2 caracteres");
            }
        } while (!validado);

        do {
            nombre = solicitarNombre();
            validado = nombre.length() >= 2;
            if(!validado) {
                System.out.println("El nombre debe tener 2 o m�s caracteres");
            }
        } while (!validado);

        do {
            edad = solicitarEdad();
            validado = edad >= VideoClub.EDAD_MINIMA;
            if(!validado) {
                System.out.println("La edad m�nima para hacese socio es de " + VideoClub.EDAD_MINIMA + " a�os");
            }
        } while (!validado);

        do {
            poblacion = solicitarPoblacion();
            validado = poblacion.length() >= 3;
            if(!validado) {
                System.out.println("La poblaci�n debe tener 3 o m�s caracteres");
            }
        } while (!validado);

        videoClub.nuevoSocio(nif, nombre, edad, poblacion);
        System.out.println("Socio a�adido correctamente");
    }

    /**
     * Crea una Pelicula solicitando los datos al usuario y valid�ndolos
     */
    private void nuevaPelicula() {
        boolean validado;
        String titulo;
        Autor autor = null;
        Formato formato = null;
        int duracion;
        int anyo;
        Actor actorPrincipal;
        Actor actrizPrincipal;
        do {
            titulo = solicitarTitulo();
            validado = titulo.length() >= 3;
            if (!validado) {
                System.out.println("El t�tulo debe tener al menos 3 caracteres");
            }
        } while (!validado);

        do {
            int idAutor = solicitarAutor();
            validado = idAutor >= 0;
            if(validado) {
                autor = videoClub.buscarAutor(idAutor);
                validado = autor != null;
            } else {
                System.out.println("El id del autor debe ser un n�mero positivo");
            }
        } while (!validado);

        do {
            int ordinalFormato = solicitarFormato();
            validado = ordinalFormato >= 0 && ordinalFormato < Formato.values().length;
            if(validado) {
                formato = Formato.values()[ordinalFormato];
            } else {
                System.out.println("Elija una opci�n del men�");
            }
        } while (!validado);

        do {
            duracion = solicitarDuracion();
            validado = duracion >= 0;
            if(!validado) {
                System.out.println("Duraci�n debe ser un n�mero positivo");
            }
        } while (!validado);

        do {
            anyo = solicitarAnyo();
            int anyoActual = Calendar.getInstance().get(Calendar.YEAR);
            validado = anyo >= 1900 && anyo <= anyoActual;
            if(!validado) {
                System.out.println("Anyo debe ser un n�mero entre 1900 y " + anyoActual);
            }
        } while (!validado);

        do {
            int idActor = solicitarActorPrincipal();
            actorPrincipal = videoClub.buscarActor(idActor);
            validado = actorPrincipal != null;
        } while (!validado);

        do {
            int idActriz = solicitarActrizPrincipal();
            actrizPrincipal = videoClub.buscarActor(idActriz);
            validado = actrizPrincipal != null;
        } while (!validado);

        videoClub.nuevaPelicula(titulo,autor,formato,anyo,duracion,actorPrincipal,actrizPrincipal);
        System.out.println("Pel�cula a�adida correctamente");
    }

    /**
     * Crea un Videojuego solicitando los datos al usuario y valid�ndolos
     */
    private void nuevoVideojuego() {
        boolean validado;
        String titulo;
        Autor autor = null;
        Formato formato = null;
        int anyo;
        Plataforma plataforma = null;

        do {
            titulo = solicitarTitulo();
            validado = titulo.length() >= 3;
            if (!validado) {
                System.out.println("El t�tulo debe tener al menos 3 caracteres");
            }
        } while (!validado);

        do {
            int idAutor = solicitarAutor();
            validado = idAutor >= 0;
            if(validado) {
                autor = videoClub.buscarAutor(idAutor);
                validado = autor != null;
            } else {
                System.out.println("El id del autor debe ser un n�mero positivo");
            }
        } while (!validado);

        do {
            int ordinalFormato = solicitarFormato();
            validado = ordinalFormato >= 0 && ordinalFormato < Formato.values().length;
            if(validado) {
                formato = Formato.values()[ordinalFormato];
            } else {
                System.out.println("Elija una opci�n del men�");
            }
        } while (!validado);

        do {
            anyo = solicitarAnyo();
            int anyoActual = Calendar.getInstance().get(Calendar.YEAR);
            validado = anyo >= 1900 && anyo <= anyoActual;
            if(!validado) {
                System.out.println("Anyo debe ser un n�mero entre 1900 y " + anyoActual);
            }
        } while (!validado);

        do {
            int ordinalPlataforma = solicitarPlataforma();
            validado = ordinalPlataforma >= 0 && ordinalPlataforma < Plataforma.values().length;
            if(validado) {
                plataforma = Plataforma.values()[ordinalPlataforma];
            } else {
                System.out.println("Elija una opci�n del men�");
            }
        } while (!validado);

        videoClub.nuevoVideojuego(titulo, autor, formato, anyo, plataforma);
        System.out.println("Videojuego a�adido correctamente");
    }

    /**
     * Solicita una plataforma v�lida al usuario a partir de un enumerado
     * @return La opci�n elegida por el usuario
     */
    private int solicitarPlataforma() {
        int ordinalPlataforma = -1;
        mostrarPlataformas();
        System.out.println("Elija una plataforma: ");
        try {
            ordinalPlataforma = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Indique el n�mero que representa la plataforma");
        }
        return ordinalPlataforma;
    }

    /**
     * Solicita una actriz al usuario
     * @return La actriz elegida por el usuario
     */
    private int solicitarActrizPrincipal() {
        int idActriz = -1;
        mostrarActores();
        System.out.println("Id Actriz principal: ");
        try {
            idActriz = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("S�lo n�meros");
        }
        return idActriz;
    }

    /**
     * Solicita una actor al usuario
     * @return La actriz elegida por el usuario
     */
    private int solicitarActorPrincipal() {
        int idActor = -1;
        mostrarActores();
        System.out.println("Id Actor principal: ");
        try {
            idActor = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("S�lo n�meros");
        }
        return idActor;
    }

    /**
     * Muestra todos los Actores
     */
    private void mostrarActores() {
        for(Actor actor: videoClub.getActores()) {
            System.out.println(actor.toString());
        }
    }

    /**
     * Solicita un a�o
     * @return El a�o elegido o -1 en caso de error
     */
    private int solicitarAnyo() {
        int anyo = -1;
        System.out.println("A�o: ");
        try {
            anyo = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo n�meros");
        }
        return anyo;
    }

    /**
     * Solicita la duraci�n
     * @return La duraci�n elegida o -1 en caso de error
     */
    private int solicitarDuracion() {
        int duracion = -1;
        System.out.println("Duraci�n: ");
        try {
            duracion = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo n�meros");
        }
        return duracion;
    }

    /**
     * Solicita un formato
     * @return El ordinal del Formato o -1 en caso de error
     */
    private int solicitarFormato() {
        int ordinalFormato = -1;
        mostrarFormatos();
        System.out.println("Elija un formato: ");
        try {
            ordinalFormato = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Indique el n�mero que representa el formato");
        }
        return ordinalFormato;
    }

    /**
     * Solicita un autor
     * @return El id del Autor elegido o -1 en caso de error
     */
    private int solicitarAutor() {
        int idAutor;
        mostrarAutores();
        System.out.println("Id Autor: ");
        try {
            idAutor = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {
            idAutor = -1;
        }
        return idAutor;
    }

    /**
     * Muestra todas las Plataformas
     */
    private void mostrarPlataformas() {
        for(Plataforma plataforma: Plataforma.values()) {
            System.out.println(plataforma.ordinal() + ". " + plataforma);
        }
    }

    /**
     * Muestra todos los Formatos
     */
    private void mostrarFormatos() {
        for(Formato formato: Formato.values()) {
            System.out.println(formato.ordinal() + ". " + formato);
        }
    }

    /**
     * Muestra todos los Autores
     */
    private void mostrarAutores() {
        for(Autor autor: videoClub.getAutores()) {
            System.out.println(autor.toString());
        }
    }

    /**
     * Solicita el campo edad al usuario
     * @return La edad elegida por el usuario o -1 en caso de error
     */
    private int solicitarEdad() {
        int edad = -1;
        System.out.println("Edad: ");
        try {
            edad = Integer.parseInt(Lib.lector.nextLine());
        } catch (NumberFormatException nfe) {

        }
        return edad;
    }

    /**
     * Solicita el campo poblaci�n al usuario
     * @return La poblaci�n elegida por el usuario
     */
    private String solicitarPoblacion() {
        String poblacion;
        System.out.println("Poblaci�n: ");
        poblacion = Lib.lector.nextLine();
        return poblacion;
    }

    /**
     * Solicita el campo nombre al usuario
     * @return El nombre elegido por el usuario
     */
    private String solicitarNombre() {
        String nombre;
        System.out.println("Nombre: ");
        nombre = Lib.lector.nextLine();
        return nombre;
    }

    /**
     * Solicita el campo t�tulo
     * @return El t�tulo elegido por el usuario
     */
    private String solicitarTitulo() {
        String titulo;
        System.out.println("T�tulo: ");
        titulo = Lib.lector.nextLine();
        return titulo;
    }

    /**
     * Muestra el men� de altas y solicita una opci�n v�lida al usuario
     * @return La opci�n v�lida elegida por el usuario
     */
    private int menuAltas() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("*************");
            System.out.println("**  ALTAS  **");
            System.out.println("*************");
            System.out.println("1. Nueva pel�cula");
            System.out.println("2. Nuevo videojuego");
            System.out.println("3. Nuevo socio");
            System.out.println("----------------------------------------------");
            System.out.println("0. Volver al men� principal\n");
            System.out.println("Elija una opci�n: ");
            try {
                opcion = Integer.parseInt(Lib.lector.nextLine());
                if (opcion < 0 || opcion > 3) {
                    System.out.println("Elija una opci�n del men� [0-3]");
                    Lib.pausa();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo n�meros por favor");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    /**
     * Alquila un Multimedia solicitando los datos al usuario y valid�ndolos
     */
    private void alquilar() {
        String nif;
        int codigo;
        nif = solicitarNif();
        Socio socio = videoClub.buscarSocio(nif);
        if(socio == null) {
            System.out.println("El nif indicado no corresponde a ning�n socio");
            return;
        }
        if(socio.tieneRecargosPendientes()) {
            System.out.println("*** Imposible alquilar ***");
            System.out.println("El socio " + socio.getNombre() + " tiene recargos pendientes");
            return;
        }
        System.out.println("Socio: " + socio.getNombre());
        codigo = solicitarCodigo();
        if(codigo >= 0) {
            Multimedia m = videoClub.buscarMultimedia(codigo);
            if(m != null) {
                System.out.println("Multimedia: " + m.getTitulo());
                double precio = m.alquilar(socio);
                if(precio >= 0) {
                    System.out.println("El precio del alquiler es de " + precio + " �");
                } else {
                    System.out.println("No se ha podido realizar el alquiler");
                }
            } else {
                System.out.println("El c�digo introducido no corresponde a ning�n multimedia");
            }
        }
    }

    /**
     * Solicita un NIF al usuario
     * @return NIF elegido por el usuario
     */
    private String solicitarNif() {
        String nif;
        System.out.println("Nif: ");
        nif = Lib.lector.nextLine();
        return nif;
    }

    /**
     * Solicita el campo codigo al usuario
     * @return El c�digo elegido o -1 en caso de error
     */
    private int solicitarCodigo() {
        int codigo = -1;
        System.out.println("C�digo: ");
        try {
            codigo = Integer.parseInt(Lib.lector.nextLine());
            if(codigo < 0) {
                System.out.println("El c�digo debe ser mayor o igual que 0");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("El c�digo debe ser num�rico");
        }
        return codigo;
    }

    /**
     * Devuelve un Alquiler solicitando y validando los datos necesarios
     */
    private void devolver() {
        int codigo;
        double recargo = 0;
        codigo = solicitarCodigo();
        if(codigo >= 0) {
            Multimedia m = videoClub.buscarMultimedia(codigo);
            if(m != null) {
                if (m.isAlquilado()) {
                    recargo = m.devolver();
                    if (recargo > 0) {
                        System.out.println("**** DEVOLUCI�N CON RECARGO ****");
                        System.out.println("La devoluci�n ha generado un recargo de " + recargo + "�");
                        Alquiler a = m.getAlquileres().get(m.getAlquileres().size() - 1);
                        System.out.println(a.toString());
                    } else {
                        System.out.println("La devoluci�n se ha realizado correctamente");
                    }
                } else {
                    System.out.println("Imposible devolver. No existe ning�n alquiler");
                }
            } else {
                System.out.println("El c�digo introducido no corresponde a ning�n multimedia");
            }
        }
    }

    /**
     * Muestra el men� principal de la aplicaci�n y solicita al usuario una opci�n v�lida
     * @return La opci�n (v�lida) elegida por el usuario
     */
    private int menuPrincipal() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("*************************");
            System.out.println("* GESTI�N DE ALQUILERES *");
            System.out.println("*************************");
            System.out.println("1. Altas ...");
            System.out.println("2. Alquilar");
            System.out.println("3. Devolver");
            System.out.println("4. Consultas...");
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
     * Muestra el men� de consultas, solicita una opci�n y ejecuta la opci�n seleccionada
     */
    private void consultas() {
        int opcion;
        Socio socio;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    mostrarMultimedia(Orden.DEFAULT);
                    Lib.pausa();
                    break;
                case 2:
                    mostrarPeliculas(Orden.TITULO);
                    Lib.pausa();
                    break;
                case 3:
                    mostrarVideojuegos(Orden.ANYO);
                    Lib.pausa();
                    break;
                case 4:
                    mostrarAlquileres(Orden.FECHA_ALQUILER);
                    Lib.pausa();
                    break;
                case 5:
                    socio = solicitarSocio();
                    if(socio != null) {
                        mostrarHistoricoAlquileresSocio(socio);
                    } else {
                        System.out.println("El nif introducido no corresponde a ning�n socio");
                    }
                    Lib.pausa();
                    break;
                case 6:
                    socio = solicitarSocio();
                    if(socio != null) {
                        mostrarAlquileresActualesSocio(socio);
                    } else {
                        System.out.println("El nif introducido no corresponde a ning�n socio");
                    }
                    Lib.pausa();
                    break;
                case 7:
                    mostrarAlquileresPendientesDevolver();
                    Lib.pausa();
                    break;
                case 8:
                    mostrarSociosConRecargosPendientes();
                    Lib.pausa();
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Solicita un Socio al usuario a partir de su NIF
     * @return El Socio indicado o null en caso de no encontrarlo
     */
    private Socio solicitarSocio() {
        System.out.println("Nif: ");
        String nif = Lib.lector.nextLine();
        for(Socio socio: videoClub.getSocios()) {
            if(socio.getNif().equalsIgnoreCase(nif)) {
                return socio;
            }
        }
        return null;
    }

    /**
     * Muestra aquellos Socios que tienen recargos pendientes
     */
    private void mostrarSociosConRecargosPendientes() {
        for(Socio socio : videoClub.getSocios()) {
            for(Recargo r: socio.getRecargos()) {
                if(r.getFechaPago() == null) {
                    System.out.println(r.toString());
                }
            }
        }
    }

    /**
     * Muestra el hist�rico de alquileres del Socio indicado como par�metro
     * @param socio Socio del historial
     */
    private void mostrarHistoricoAlquileresSocio(Socio socio) {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        for(Multimedia m: videoClub.getMultimedia()) {
            for(Alquiler a: m.getAlquileres()) {
                if(a.getSocio().getNif().equalsIgnoreCase(socio.getNif())) {
                    alquileres.add(a);
                }
            }
        }

        ordenarAlquileres(alquileres,Orden.FECHA_ALQUILER);
        for(Alquiler a: alquileres) {
            System.out.println(a.toString());
        }
    }

    /**
     * Muestra los Alquileres activos de un Socio
     * @param socio Socio del que se quieren obtener los Alquileres
     */
    private void mostrarAlquileresActualesSocio(Socio socio) {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        for(Multimedia m: videoClub.getMultimedia()) {
            if(m.getAlquileres().size() > 0) {
                Alquiler ultimoAlquiler = m.getAlquileres().get(m.getAlquileres().size() - 1);
                if (ultimoAlquiler.getSocio().getNif().equalsIgnoreCase(socio.getNif()) && ultimoAlquiler.getFechaDevolucion() == null) {
                    alquileres.add(ultimoAlquiler);
                }
            }
        }
        ordenarAlquileres(alquileres,Orden.FECHA_ALQUILER);
        for(Alquiler a: alquileres) {
            System.out.println(a.toString());
        }
    }

    /**
     * Muestra todos los Alquileres est�n pendientes de devolver
     */
    private void mostrarAlquileresPendientesDevolver() {
        for(Multimedia m: videoClub.getMultimedia()) {
            for(Alquiler a: m.getAlquileres()) {
                if(a.getFechaDevolucion() == null) {
                    System.out.print("[" + m.getId() + " " + m.getTitulo() + "] ");
                    System.out.println(a.toString());
                }
            }
        }
    }

    /**
     * Muestra los alquileres seg�n el orden indicado
     * @param orden Ordenaci�n elegida
     */
    private void mostrarAlquileres(Orden orden) {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        for(Multimedia m: videoClub.getMultimedia()) {
            for(Alquiler a: m.getAlquileres()) {
                alquileres.add(a);
            }
        }
        ordenarAlquileres(alquileres, orden);
        for(Alquiler a: alquileres) {
            System.out.println(a.toString());
        }
    }

    /**
     * Muestra los videojuegos ordenados seg�n el par�metro indicado
     * @param orden Ordenaci�n elegida
     */
    private void mostrarVideojuegos(Orden orden) {
        ordenarMultimedia(videoClub.getMultimedia(), orden);
        for(Multimedia m: videoClub.getMultimedia()) {
            if(m instanceof Videojuego) {
                System.out.println(m.toString());
            }
        }
    }

    /**
     * Muestra los Multimedia ordenados seg�n el par�metro indicado
     * @param orden Ordenaci�n elegida
     */
    private void mostrarMultimedia(Orden orden) {
        ordenarMultimedia(videoClub.getMultimedia(), orden);
        for(Multimedia m: videoClub.getMultimedia()) {
            System.out.println(m.toString());
        }
    }

    /**
     * Ordena los multimedia indicados seg�n el orden pasado como par�metro
     * @param multimedia Lista de Multimedia a ordenar
     * @param orden Orden elegido
     */
    private void ordenarMultimedia(ArrayList<Multimedia> multimedia, Orden orden) {
        switch (orden) {
            case TITULO:
                multimedia.sort(new Multimedia.ComparatorTitulo());
                break;
            case ANYO:
                multimedia.sort(new Multimedia.ComparatorAnyo());
                break;
        }
    }

    /**
     * Ordena los alquileres indicados seg�n el orden pasado como par�metro
     * @param alquileres Lista de Alquileres a ordenar
     * @param orden Orden elegido
     */
    private void ordenarAlquileres(ArrayList<Alquiler> alquileres, Orden orden) {
        switch (orden) {
            case FECHA_ALQUILER:
                alquileres.sort(new Alquiler.ComparatorFechaAlquiler());
                break;
        }
    }

    /**
     * Muestra las Peliculas ordenados seg�n el orden indicado
     * @param orden Orden elegido
     */
    private void mostrarPeliculas(Orden orden) {
        ordenarMultimedia(videoClub.getMultimedia(), orden);
        for(Multimedia m: videoClub.getMultimedia()) {
            if(m instanceof Pelicula) {
                System.out.println(m.toString());
            }
        }
    }

    /**
     * Muestra el men� de consultas y solicita una opci�n v�lida al usuario
     * @return La opci�n elegida por el usuario
     */
    private int menuConsultas() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("**************");
            System.out.println("* CONSULTAS  *");
            System.out.println("**************");
            System.out.println("1. Mostrar todos los objetos multimedia");
            System.out.println("2. Mostrar pel�culas ordenadas por t�tulo");
            System.out.println("3. Mostrar videojuegos ordenados por a�o");
            System.out.println("4. Mostrar todos los alquileres");
            System.out.println("5. Mostrar hist�rico de alquileres de un socio");
            System.out.println("6. Mostrar alquileres actuales de un socio");
            System.out.println("7. Mostrar alquileres pendientes de devolver");
            System.out.println("8. Mostrar socios con recargos pendientes");
            System.out.println("----------------------------------------------");
            System.out.println("0. Volver al men� principal\n");
            System.out.println("Elija una opci�n: ");
            try {
                opcion = Integer.parseInt(Lib.lector.nextLine());
                if (opcion < 0 || opcion > 8) {
                    System.out.println("Elija una opci�n del men� [0-8]");
                    Lib.pausa();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo n�meros por favor");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 8);
        return opcion;
    }
}