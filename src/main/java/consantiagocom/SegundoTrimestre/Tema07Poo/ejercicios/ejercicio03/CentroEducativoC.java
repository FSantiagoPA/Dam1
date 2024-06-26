package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio03;

import consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.Config;
import consantiagocom.SegundoTrimestre.Tema07Poo.utils.Lib;
import net.datafaker.Faker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * La implementaci�n de CentroEducativo podemos abordarla con dos estrategias bien diferenciadas:
 * - Opci�n A) Al borrar un alumno, trasladamos el �ltimo a la posici�n del alumno borrado y
 *   decrementamos el contador de alumnos. Esta opci�n es �til si no necesitamos el que array
 *   de alumnos est� ordenado.
 *   * Ventajas: borrado e inserci�n r�pidos
 *   * Desventajas: no es posible optimizar las b�squedas al no tener ordenado el array
 * - Opci�n B) Al borrar un alumno marcamos su posici�n como null, pero debemos tener en cuenta que
 *   pueden existir elementos del array a null.
 *   * Ventajas: borrado r�pido.
 *   * Desventajas: b�squeda e inserci�n lentas. Una posible mejora es llevar la cuenta de los elementos
 *     efectivos que hay en el array.
 * - Opci�n C) Mantenemos ordenado el array bas�ndonos en el nia. Al borrar un alumno desplazamos
 *   todos los que queden a la derecha del alumno borrado una posici�n hacia la izquierda.
 *   * Ventajas: b�squedas r�pidas que podr�n ser� �ptima si se b�sca por nia
 *   * Desventajas: borrado e inserci�n m�s lento al tener que mantener el orden del array.
 *  En este caso implementamos la opci�n C)
 **/
public class CentroEducativoC {
    public static final int MIN_NIA = 0;
    public static final int MAX_NIA = 1999999;
    public static final int MIN_TELEFONO = 0;
    public static final int MAX_TELEFONO = 999999999;

    private final Alumno[] alumnos;
    private int contadorAlumnos;
    private final Grupo[] grupos;

    public CentroEducativoC(int maxAlumnos, int maxGrupos) {
        alumnos = new Alumno[maxAlumnos];
        contadorAlumnos = 0;
        grupos = new Grupo[maxGrupos];
        if (Config.DEBUG)
            generarDatosAleatorios(8);
    }

    /**
     * Crea cantidadAlumnos aleatorios para poder realizar pruebas
     * No confundir con testing
     * @param cantidadAlumnos
     */
    private void generarDatosAleatorios(int cantidadAlumnos) {
        generarGruposAleatorios();
        generarAlumnosAleatorios(cantidadAlumnos);
    }

    /**
     * Crea grupos aleatorios
     */
    private void generarGruposAleatorios() {
        for(int i = 0; i < grupos.length; i++) {
            grupos[i] = new Grupo(i, "GRUPO " + i);
        }
    }

    private void generarAlumnosAleatorios(int nAlumnos) {
        for(int i = 0; i < nAlumnos; i++) {
            Alumno a = alumnoAleatorio();
            nuevoAlumno(a.getNia(), a.getNombre(), a.getApellidos(), a.getFechaNacimiento(), a.getGrupo(), a.getTelefono());
        }
    }

    private Alumno alumnoAleatorio() {
        Faker faker = new Faker(new Locale("ES"));
        int nia = Lib.random(1000000, 1099999);
        String nombre = faker.name().firstName();
        String apellido1 = faker.name().lastName();
        String apellido2 = faker.name().lastName();
        GregorianCalendar fechaNacimiento = new GregorianCalendar(Lib.random(1998, 2008), Lib.random(Calendar.JANUARY, Calendar.DECEMBER), Lib.random(1,28));
        Grupo grupo = grupos[Lib.random(0, grupos.length-1)];
        String telefono = String.valueOf(Lib.random(965700000, 965799999));
        return new Alumno(nia, nombre, apellido1 + " " + apellido2, fechaNacimiento, grupo, telefono);
    }

    /**
     * Da de alumno un nuevo alumno con los datos indicados manteniendo ordenado el array
     * @param nia Nia
     * @param nombre Nombre
     * @param apellidos Los apellidos
     * @param fechaNacimiento Fecha nacimiento
     * @param grupo Grupo
     * @param telefono Tel�fono
     * @return True si se ha a�adido el alumno, False en caso contrario
     */
    public boolean nuevoAlumno(int nia, String nombre, String apellidos, GregorianCalendar fechaNacimiento, Grupo grupo, String telefono) {
        // En esta implementaci�n (B) sabemos que la primera posici�n libre el la apuntada por el contadorAlumnos
        if (contadorAlumnos < alumnos.length) {
            // Buscamos la posici�n donde debemos insertar el alumno
            int i = 0;
            while (alumnos[i] != null && alumnos[i].getNia() < nia && i < contadorAlumnos) {
                i++;
            }
            // i contiene la posici�n donde debemos insertar el alumno
            // Ahora hay que hacer hueco desplazando los que est�n a la derecha
            hacerEspacio(i);
            alumnos[i] = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);
            contadorAlumnos++;
            return true;
        }
        return false;
    }

    public boolean bajaAlumno(int nia) {
        int pos = buscarPosicionAlumno(nia);
        if(pos >= 0) {
            desplazar(pos);
            contadorAlumnos--;
            alumnos[contadorAlumnos] = null;
            return true;
        }
        return false;
    }

    /**
     * Desplaza los elementos del array alumnos una posici�n a la derecha a partir de la posici�n pos
     * @param pos Posici�n a partir de la cual se desplazar�n los elementos
     */
    private void hacerEspacio(int pos) {
        if (pos < contadorAlumnos) {
            for (int i = contadorAlumnos; i > pos; i--) {
                alumnos[i] = alumnos[i - 1];
            }
        }
    }

    /**
     * Desplaza los elementos del array alumnos una posici�n a la izquierda a partir de la posici�n pos
     * @param pos Posici�n a partir de la cual se desplazar�n los elementos
     */
    private void desplazar(int pos) {
        if (pos < contadorAlumnos) {
            for (int i = pos; i < contadorAlumnos; i++) {
                alumnos[i] = alumnos[i + 1];
            }
        }
    }

    /**
     * Busca un alumno por Nia
     * Esta versi�n mantiene el array ordenado por nia, por tanto podemos optimizar la b�squeda
     * @param nia
     * @return Si lo encuentra devuelve el alumno, en caso contrario devuelve null
     */
    public Alumno buscarAlumnoPorNia(int nia) {
        for (int i = 0; i < contadorAlumnos; i++) {
            int alumnoNia = alumnos[i].getNia();
            if (alumnoNia == nia) {
                return alumnos[i];
            }
            // Como el array est� ordenado, si el nia del alumno es mayor que el nia buscado sabemos que no est�
            if (alumnoNia > nia)
                return null;
        }
        return null;
    }

    /**
     * Busca un alumno por Nia
     * @param nia
     * @return Si lo encuentra devuelve su posici�n, en caso contrario devuelve -1
     */
    private int buscarPosicionAlumno(int nia) {
        for (int i = 0; i < contadorAlumnos; i++) {
            int alumnoNia = alumnos[i].getNia();
            if (alumnoNia == nia) {
                return i;
            }
            // Como el array est� ordenado, si el nia del alumno es mayor que el nia buscado sabemos que no est�
            if (alumnoNia > nia)
                return -1;
        }
        return -1;
    }

    /**
     * Busca alumnos por Grupo
     * @param codigoGrupo
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    public Alumno[] buscarAlumnosPorGrupo(int codigoGrupo) {
        Alumno[] alumnosGrupo = null;
        /* Lo ideal ser�a hacerlo con ArrayLists pero a�n no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de b�squeda */
        int nAlumnos = 0;
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                nAlumnos++;
            }
        }
        if(nAlumnos > 0) {
            alumnosGrupo = new Alumno[nAlumnos];
            int cont = 0;
            /* Una vez sabemos el n�mero de alumnos los asignamos al vector */
            for (int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                    alumnosGrupo[cont] = alumnos[i];
                    // si quisi�ramos devolver una copia en lugar de los originales har�amos:
                    // alumnosGrupo[cont] = new Alumno(alumnos[i]);
                    cont++;
                }
            }
        }
        return alumnosGrupo;
    }

    /**
     * Busca alumnos por Edad
     * @param edad
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    public Alumno[] buscarAlumnosPorEdad(int edad) {
        Alumno[] alumnosEdad = null;
        /* Lo ideal ser�a hacerlo con ArrayLists pero a�n no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de b�squeda */
        int nAlumnos = 0;
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getEdad() == edad) {
                nAlumnos++;
            }
        }
        if(nAlumnos > 0) {
            alumnosEdad = new Alumno[nAlumnos];
            int cont = 0;
            /* Una vez sabemos el n�mero de alumnos los asignamos al vector */
            for (int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getEdad() == edad) {
                    alumnosEdad[cont] = alumnos[i];
                    // si quisi�ramos devolver una copia en lugar de los originales har�amos:
                    // alumnosEdad[cont] = new Alumno(alumnos[i]);
                    cont++;
                }
            }
        }
        return alumnosEdad;
    }

    /**
     * Busca alumnos por Apellidos
     * @param apellidos
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    public Alumno[] buscarAlumnosPorApellidos(String apellidos) {
        Alumno[] alumnosApellidos = null;
        /* Lo ideal ser�a hacerlo con ArrayLists pero a�n no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de b�squeda */
        int nAlumnos = 0;
        //Convertimos a min�sculas
        apellidos = apellidos.toLowerCase();
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                nAlumnos++;
            }
        }
        if(nAlumnos > 0) {
            alumnosApellidos = new Alumno[nAlumnos];
            int cont = 0;
            /* Una vez sabemos el n�mero de alumnos los asignamos al vector */
            for (int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                    alumnosApellidos[cont] = alumnos[i];
                    // si quisi�ramos devolver una copia en lugar de los originales har�amos:
                    // alumnosApellidos[cont] = new Alumno(alumnos[i]);
                    cont++;
                }
            }
        }
        return alumnosApellidos;
    }

    /**
     * Busca el grupo c�digo codigo
     * @param codigo
     * @return grupo o null
     */
    public Grupo buscarGrupoPorCodigo(int codigo) {
        /* Buscamos que el c�digo que ha introducido el usuario corresponde a un grupo v�lido */
        /* En caso afirmativo lo asignamos */
        for (int i = 0; i < grupos.length; i++) {
            if (grupos[i].getCodigo() == codigo)
                return grupos[i];
        }
        return null;
    }

    public String listadoAlumnos() {
        StringBuilder sb = new StringBuilder();
        // Mostrar todos los alumnos
        for (int i = 0; i < contadorAlumnos; i++) {
            if(alumnos[i] != null) {
                sb.append(alumnos[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String listadoGrupos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grupos.length; i++) {
            sb.append(grupos[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
