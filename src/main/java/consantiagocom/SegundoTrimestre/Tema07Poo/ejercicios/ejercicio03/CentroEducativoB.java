package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio03;

import consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.Config;
import consantiagocom.SegundoTrimestre.Tema07Poo.utils.Lib;
import net.datafaker.Faker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * La implementación de CentroEducativo podemos abordarla con dos estrategias bien diferenciadas:
 * - Opción A) Al borrar un alumno, trasladamos el último a la posición del alumno borrado y
 *   decrementamos el contador de alumnos. Esta opción es útil si no necesitamos el que array
 *   de alumnos esté ordenado.
 *   * Ventajas: borrado e inserción rápidos
 *   * Desventajas: no es posible optimizar las búsquedas al no tener ordenado el array
 * - Opción B) Al borrar un alumno marcamos su posición como null y tener en cuenta que
 *   pueden existir elementos del array a null.
 *   * Ventajas: borrado rápido.
 *   * Desventajas: búsqueda e inserción lentas. Una posible mejora es llevar la cuenta de los elementos
 *     efectivos que hay en el array.
 * - Opción C) Mantenemos el array ordenado basándonos en el nia. Al borrar un alumno desplazamos
 *   todos los que queden a la derecha del alumno borrado una posición hacia la izquierda.
 *   * Ventajas: búsquedas rápidas que podrán será óptima si se búsca por nia
 *   * Desventajas: borrado e inserción más lento al tener que mantener el orden del array.
 *  En este caso implementamos la opción B)
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
        /* Buscamos la primera posición libre para insertar el alumno */
        int i = 0;
        boolean encontrado = false;
        while (i < alumnos.length && !encontrado) {
            if (alumnos[i] == null) {
                encontrado = true;
            } else {
                i++;
            }
        }
        /* Si lo hemos encontrado lo insertamos en la posición i */
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
     * @return Si lo encuentra devuelve su posición, en caso contrario devuelve -1
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
        /* Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda */
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
            /* Una vez sabemos el número de alumnos los asignamos al vector */
            while (i < alumnos.length && cont < contadorAlumnos) {
                if (alumnos[i]!= null) {
                    if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                        alumnosGrupo[cont] = alumnos[i];
                        // si quisiéramos devolver una copia en lugar de los originales haríamos:
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
        /* Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda */
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
            /* Una vez sabemos el número de alumnos los asignamos al vector */
            while (i < alumnos.length && cont < contadorAlumnos) {
                if (alumnos[i]!= null) {
                    if (alumnos[i].getEdad() == edad) {
                        alumnosEdad[cont] = alumnos[i];
                        // si quisiéramos devolver una copia en lugar de los originales haríamos:
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
        /* Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /* Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda */
        int nAlumnos = 0;
        int i = 0;
        //Convertimos a minúsculas
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

            /* Una vez sabemos el número de alumnos los asignamos al vector */
            while (i < alumnos.length && cont < contadorAlumnos) {
                if (alumnos[i]!= null) {
                    if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                        alumnosApellidos[cont] = alumnos[i];
                        // si quisiéramos devolver una copia en lugar de los originales haríamos:
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
     * Busca el grupo código codigo
     * @param codigo
     * @return grupo o null
     */
    public Grupo buscarGrupoPorCodigo(int codigo) {
        /* Buscamos que el código que ha introducido el usuario corresponde a un grupo válido */
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
