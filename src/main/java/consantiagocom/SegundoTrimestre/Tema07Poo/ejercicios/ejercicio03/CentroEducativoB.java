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
 * - Opci�n B) Al borrar un alumno marcamos su posici�n como null y tener en cuenta que
 *   pueden existir elementos del array a null.
 *   * Ventajas: borrado r�pido.
 *   * Desventajas: b�squeda e inserci�n lentas. Una posible mejora es llevar la cuenta de los elementos
 *     efectivos que hay en el array.
 * - Opci�n C) Mantenemos el array ordenado bas�ndonos en el nia. Al borrar un alumno desplazamos
 *   todos los que queden a la derecha del alumno borrado una posici�n hacia la izquierda.
 *   * Ventajas: b�squedas r�pidas que podr�n ser� �ptima si se b�sca por nia
 *   * Desventajas: borrado e inserci�n m�s lento al tener que mantener el orden del array.
 *  En este caso implementamos la opci�n B)
 **/
public class CentroEducativoB {
    public static final int MIN_NIA = 0;
    public static final int MAX_NIA = 1999999;
    public static final int MIN_TELEFONO = 0;
    public static final int MAX_TELEFONO = 999999999;

    private final Alumno[] alumnos;
    private int contadorAlumnos;
    private final Grupo[] grupos;

    public CentroEducativoB(int maxAlumnos, int maxGrupos) {
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
        for (int i = 0; i < grupos.length; i++) {
            grupos[i] = new Grupo(i, "GRUPO " + i);
        }
    }

    private void generarAlumnosAleatorios(int nAlumnos) {
        for (int i = 0; i < nAlumnos; i++) {
            alumnos[i] = alumnoAleatorio();
            contadorAlumnos++;
        }
    }

    private Alumno alumnoAleatorio() {
        Faker faker = new Faker(new Locale("ES"));
        int nia = Lib.random(1000000, 1099999);
        String nombre = faker.name().firstName(); // nombres[Lib.random(0, nombres.length-1)];
        String apellido1 = faker.name().lastName(); // apellidos[Lib.random(0, apellidos.length-1)];
        String apellido2 = faker.name().lastName(); // apellidos[Lib.random(0, apellidos.length-1)];
        GregorianCalendar fechaNacimiento = new GregorianCalendar(Lib.random(1998, 2008), Lib.random(Calendar.JANUARY, Calendar.DECEMBER), Lib.random(1,28));
        Grupo grupo = grupos[Lib.random(0, grupos.length-1)];
        String telefono = String.valueOf(Lib.random(965700000, 965799999));
        return new Alumno(nia, nombre, apellido1 + " " + apellido2, fechaNacimiento, grupo, telefono);
    }

    public boolean nuevoAlumno(int nia, String nombre, String apellidos, GregorianCalendar fechaNacimiento, Grupo grupo, String telefono) {
        /* Buscamos la primera posici�n libre para insertar el alumno */
        int i = 0;
        boolean encontrado = false;
        while (i < alumnos.length && !encontrado) {
            if (alumnos[i] == null) {
                encontrado = true;
            } else {
                i++;
            }
        }
        /* Si lo hemos encontrado lo insertamos en la posici�n i */
        if (encontrado){
            alumnos[i] = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);
            contadorAlumnos++;
        }
        return encontrado;
    }

    public boolean bajaAlumno(int nia) {
        int pos = buscarPosicionAlumno(nia);
        if (pos >= 0) {
            alumnos[pos] = null;
            contadorAlumnos--;
            return true;
        }
        return false;
    }


    /**
     * Busca un alumno por Nia
     * @param nia
     * @return Si lo encuentra devuelve el alumno, en caso contrario devuelve null
     */
    public Alumno buscarAlumnoPorNia(int nia) {
        int i = 0;
        int cont = 0;
        while (i < alumnos.length && cont < contadorAlumnos) {
            if (alumnos[i]!= null) {
                if (alumnos[i].getNia() == nia) {
                    return alumnos[i];
                }
                cont++;
            }
            i++;
        }
        return null;
    }

    /**
     * Busca un alumno por Nia
     * @param nia
     * @return Si lo encuentra devuelve su posici�n, en caso contrario devuelve -1
     */
    private int buscarPosicionAlumno(int nia) {
        int i = 0;
        int cont = 0;
        while (i < alumnos.length && cont < contadorAlumnos) {
            if (alumnos[i]!= null) {
                if (alumnos[i].getNia() == nia) {
                    return i;
                }
                cont++;
            }
            i++;
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
        int i = 0;
        while (i < alumnos.length && nAlumnos < contadorAlumnos) {
            if (alumnos[i]!= null) {
                if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                    nAlumnos++;
                }
            }
            i++;
        }
        if (nAlumnos > 0) {
            i = 0;
            alumnosGrupo = new Alumno[nAlumnos];
            int cont = 0;
            /* Una vez sabemos el n�mero de alumnos los asignamos al vector */
            while (i < alumnos.length && cont < contadorAlumnos) {
                if (alumnos[i]!= null) {
                    if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                        alumnosGrupo[cont] = alumnos[i];
                        // si quisi�ramos devolver una copia en lugar de los originales har�amos:
                        // alumnosGrupo[cont] = new Alumno(alumnos[i]);
                        cont++;
                    }
                }
                i++;
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
        int i = 0;
        while (i < alumnos.length && nAlumnos < contadorAlumnos) {
            if (alumnos[i]!= null) {
                if (alumnos[i].getEdad() == edad) {
                    nAlumnos++;
                }
            }
            i++;
        }
        if (nAlumnos > 0) {
            i = 0;
            alumnosEdad = new Alumno[nAlumnos];
            int cont = 0;
            /* Una vez sabemos el n�mero de alumnos los asignamos al vector */
            while (i < alumnos.length && cont < contadorAlumnos) {
                if (alumnos[i]!= null) {
                    if (alumnos[i].getEdad() == edad) {
                        alumnosEdad[cont] = alumnos[i];
                        // si quisi�ramos devolver una copia en lugar de los originales har�amos:
                        // alumnosEdad[cont] = new Alumno(alumnos[i]);
                        cont++;
                    }
                }
                i++;
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
        int i = 0;
        //Convertimos a min�sculas
        apellidos = apellidos.toLowerCase();

        while (i < alumnos.length && nAlumnos < contadorAlumnos) {
            if (alumnos[i]!= null) {
                if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                    nAlumnos++;
                }
            }
            i++;
        }
        if (nAlumnos > 0) {
            alumnosApellidos = new Alumno[nAlumnos];
            i = 0;
            int cont = 0;

            /* Una vez sabemos el n�mero de alumnos los asignamos al vector */
            while (i < alumnos.length && cont < contadorAlumnos) {
                if (alumnos[i]!= null) {
                    if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                        alumnosApellidos[cont] = alumnos[i];
                        // si quisi�ramos devolver una copia en lugar de los originales har�amos:
                        // alumnosApellidos[cont] = new Alumno(alumnos[i]);
                        cont++;
                    }
                }
                i++;
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
        int i = 0;
        int cont = 0;
        StringBuilder sb = new StringBuilder();
        // Mostrar todos los alumnos
        while (i < alumnos.length && cont < contadorAlumnos) {
            if (alumnos[i] != null) {
                cont++;
                sb.append(alumnos[i].toString()).append("\n");
            }
            i++;
        }
        return sb.toString();
    }

    public String listadoGrupos() {
        StringBuilder sb = new StringBuilder();
        for (Grupo grupo : grupos) {
            sb.append(grupo.toString()).append("\n");
        }
        return sb.toString();
    }
}
