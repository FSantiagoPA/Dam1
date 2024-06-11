package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio11;

import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ejercicio11 {
    private final static boolean DEBUG = true;
    private final Scanner lector;
    private final Alumno[] alumnos;
    private final Grupo[] grupos;

    private final String[] nombres = {"Juan", "Isabel", "Pablo", "Sergio", "Rubén", "Alicia", "Ana", "María", "José", "Fernando", "Germán"};
    private final String[] apellidos = {"Fernández", "Gutiérrez", "Ramírez", "Torregrosa", "Signes", "García", "Gallego", "Alonso", "Tormos"};

    public Ejercicio11(int maxAlumnos, int nGrupos) {
        lector = new Scanner(System.in);
        int opcion;
        alumnos = new Alumno[maxAlumnos];
        grupos = new Grupo[nGrupos];
        generarDatosAleatorios(8);

        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevoAlumno();
                    break;
                case 2:
                    bajaAlumno();
                    break;
                case 3:
                    consultas();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while(opcion != 0);
    }

    private void nuevoAlumno() {
        boolean validado = false;
        int nia = 0;
        String nombre = "";
        String apellidos = "";
        String fechaNacimientoString;
        GregorianCalendar fechaNacimiento = null;
        Grupo grupo = null;
        long telefono = 0;
        Lib.limpiarPantalla();
        System.out.println("*** NUEVO ALUMNO ***" );
        do {
            System.out.print("Nia: ");
            try {
                nia = Integer.parseInt(opcionAleatoria(-10,2199999, 0.05f));
                validado = nia < 1999999 && nia > 0;
                if (!validado) {
                    System.out.println("Nia debe estar comprendido en el rango [0-1999999]");
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                }
                /** Comprobamos que dicho NIA no esté duplicado **/
                if (buscarAlumnoPorNia(nia) >= 0) {
                    validado = false;
                    System.out.println("El nia introducido ya corresponde a un alumno.");
                    System.out.println("Introduzca otro por favor");
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                }
            } catch (NumberFormatException nfe) {
                System.out.println("El nia debe ser un número");
            }
        } while (!validado);

        do {
            System.out.print("Nombre: ");
            try {
                nombre = nombreAleatorio(0.05f);
                validado = nombre.length() > 2;
                if (!validado) {
                    System.out.println("Nombre debe tener almenos 2 caracteres");
                    if (!DEBUG) {
                        Lib.pausa();
                    }
                }
            } catch (NullPointerException npe) {
                validado = false;
                System.out.println("Nombre no puede ser nulo");
            }
        } while (!validado);

        do {
            System.out.print("Apellidos: ");
            try {
                apellidos = apellidoAleatorio(0.05f);
                validado = apellidos.length() > 2;
                if (!validado) {
                    System.out.println("Apellidos debe tener almenos 2 caracteres");
                    if (!DEBUG) {
                        Lib.pausa();
                    }
                }
            } catch (NullPointerException npe) {
                System.out.println("Apellidos no puede ser nulo");
            }
        } while (!validado);

        do {
            System.out.print("Fecha nacimiento (dd-mm-yyyy): ");
            fechaNacimientoString = fechaAleatoria(1998, 2014, 0.1f);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = sdf.parse(fechaNacimientoString);
                fechaNacimiento = new GregorianCalendar();
                fechaNacimiento.setTime(date);
                validado = true;
            } catch (ParseException pe) {
                validado = false;
                System.out.println("El formato de la fecha de nacimiento no es válido. Recuerde (dd-mm-yyyy).");
                if(!DEBUG) {
                    Lib.pausa();
                }
            }
        } while (!validado);

        do {
            int i;
            System.out.println("Grupos disponibles");

            for(i = 0; i < grupos.length; i++) {
                System.out.println("Código: " + grupos[i].getCodigo() + ", nombre: " + grupos[i].getNombre());
            }
            System.out.print("Código del grupo: ");

            int codigo = grupoAleatorio(0.05f);
            validado = false;
            i = 0;
            /** Buscamos que el código que ha introducido el usuario corresponde a un grupo válido **/
            /** En caso afirmativo lo asignamos **/
            while(i < grupos.length && !validado) {
                if(grupos[i].getCodigo() == codigo) {
                    grupo = grupos[i];
                    validado = true;
                } else {
                    i++;
                }
            }
        } while (!validado);

        do {
            System.out.print("Teléfono: ");
            try {
                telefono = Long.parseLong(opcionAleatoria(-200, 999999999, 0.05f));
                /** Para facilitar la introducción de datos permitimos poner números pequeños como teléfono **/
                validado = telefono > 0 && telefono < 999999999;
            } catch (NumberFormatException nfe) {
                validado = false;
                System.out.println("El teléfono debe ser un número");
            }
        } while (!validado);

        /** Buscamos la primera posición libre para insertar el alumno **/
        int i = 0;
        boolean encontrado = false;
        while(i < alumnos.length && !encontrado) {
            if(alumnos[i] == null) {
                encontrado = true;
            } else {
                i++;
            }
        }
        /** Si lo hemos encontrado lo insertamos en la posición i **/
        if(encontrado){
            alumnos[i] = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);
            System.out.println("Alumno guardado correctamente");
        } else {
            System.out.println("Imposible añadir el alumno.");
            System.out.println("El array de alumnos está lleno");
        }
        if(!DEBUG) {
            Lib.pausa();
        }
    }

    private void bajaAlumno() {
        int nia;
        int pos;
        Lib.limpiarPantalla();
        System.out.println("*** BAJA ALUMNO ***" );
        System.out.print("Nia: ");
        try {
            nia = Integer.parseInt(opcionAleatoria(-10, 2199999, 0.05f));
            pos = buscarAlumnoPorNia(nia);
            if (pos >= 0) {
                alumnos[pos] = null;
                System.out.println("Alumno borrado correctamente");
            } else {
                System.out.println("No existe ningún alumno con el nia " + nia);
            }
            if(!DEBUG) {
                Lib.pausa();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Nia debe ser un número");
        }
    }

    private void consultas() {
        int opcion;
        int i;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    //Por grupo
                    int codigo;
                    Alumno[] alumnosGrupo;
                    System.out.println("Grupos disponibles");
                    for (i = 0; i < grupos.length; i++) {
                        System.out.println("Código: " + grupos[i].getCodigo() + ", nombre: " + grupos[i].getNombre());
                    }
                    System.out.print("Código del grupo: ");
                    try {
                        codigo = grupoAleatorio(0.05f);
                        alumnosGrupo = buscarAlumnoPorGrupo(codigo);
                        if (alumnosGrupo != null) {
                            for (i = 0; i < alumnosGrupo.length; i++) {
                                System.out.println(alumnosGrupo[i].toString());
                            }
                        } else {
                            System.out.println("No se han encontrado alumnos del grupo con código " + codigo);
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Elija uno de los grupos");
                    }
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                    break;
                case 2:
                    //Por edad
                    int edad;
                    Alumno[] alumnosEdad;
                    System.out.print("Edad: ");
                    try {
                        edad = Integer.parseInt(opcionAleatoria(0, 100, 0.05f));
                        alumnosEdad = buscarAlumnoPorEdad(edad);
                        if (alumnosEdad != null) {
                            for (i = 0; i < alumnosEdad.length; i++) {
                                System.out.println(alumnosEdad[i].toString());
                            }
                        } else {
                            System.out.println("No se han encontrado alumnos que tengan " + edad + " años");
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("La edad debe ser un número");
                    }
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                    break;
                case 3:
                    //Por nia
                    int nia;
                    System.out.print("Nia: ");
                    try {
                        nia = Integer.parseInt(opcionAleatoria(-10, 2199999, 0.05f));
                        int pos = buscarAlumnoPorNia(nia);
                        if (pos >= 0) {
                            System.out.println(alumnos[pos].toString());
                        } else {
                            System.out.println("No se ha encontrado ningún alumno con el nia " + nia);
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Nia debe ser un número");
                    }
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                    break;
                case 4:
                    //Por apellidos
                    String apellidos;
                    Alumno[] alumnosApellidos;
                    System.out.print("Apellidos: ");
                    try {
                        apellidos = apellidoAleatorio(0.05f);
                        alumnosApellidos = buscarAlumnoPorApellidos(apellidos);
                        if (alumnosApellidos != null) {
                            for (i = 0; i < alumnosApellidos.length; i++) {
                                System.out.println(alumnosApellidos[i].toString());
                            }
                        } else {
                            System.out.println("No se han encontrado alumnos que tengan " + apellidos + " como apellidos");
                        }
                    } catch (NullPointerException npe) {
                        System.out.println("Debe introducir los apellidos del alumno");
                    }
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                    break;
                case 5:
                    boolean fin = false;
                    i = 0;
                    //Mostrar todos los alumnos
                    while(i < alumnos.length && !fin) {
                        if(alumnos[i] != null) {
                            System.out.println(alumnos[i].toString());
                        } else {
                            fin = true;
                        }
                        i++;
                    }
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                    break;
            }
        } while (opcion != 0);

    }

    private void generarDatosAleatorios(int nAlumnos) {
        generarGruposAleatorios();
        generarAlumnosAleatorios(nAlumnos);
    }

    private void generarGruposAleatorios() {
        for(int i = 0; i < grupos.length; i++) {
            grupos[i] = new Grupo(i, "GRUPO " + i);
        }
    }

    private void generarAlumnosAleatorios(int nAlumnos) {
        for(int i = 0; i < nAlumnos; i++) {
            alumnos[i] = alumnoAleatorio();
        }
    }
    private Alumno alumnoAleatorio() {
        int nia = Lib.aleatorio(1000000, 1099999);
        String nombre = nombres[Lib.aleatorio(0, nombres.length-1)];
        String apellido1 = apellidos[Lib.aleatorio(0, apellidos.length-1)];
        String apellido2 = apellidos[Lib.aleatorio(0, apellidos.length-1)];
        GregorianCalendar fechaActual = new GregorianCalendar();
        int anyoActual = fechaActual.get(Calendar.YEAR);
        GregorianCalendar fechaNacimiento = new GregorianCalendar(Lib.aleatorio(anyoActual - 30, anyoActual - 20), Lib.aleatorio(Calendar.JANUARY, Calendar.DECEMBER), Lib.aleatorio(1,28));
        Grupo grupo = grupos[Lib.aleatorio(0, grupos.length-1)];
        int telefono = Lib.aleatorio(965700000, 965799999);
        return new Alumno(nia, nombre, apellido1 + " " + apellido2, fechaNacimiento, grupo, telefono);
    }

    private int menuPrincipal() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("*********************");
            System.out.println("** GESTIÓN ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo alumno...");
            System.out.println("2. Baja de alumno...");
            System.out.println("3. Consultas...");
            System.out.println("---------------------");
            System.out.println("0. Salir\n");
            System.out.print("Elija una opción: ");
            try {
                opcion = Integer.parseInt(opcionAleatoria(1, 4, 0.05f));
                if (opcion < 0 || opcion > 3) {
                    System.out.println("Elija una opción del menú [0-3]");
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Elija una opción del menú [0-3]");
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    private int menuConsultas() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("***************");
            System.out.println("** CONSULTAS **");
            System.out.println("****************");
            System.out.println("1. Por grupo...");
            System.out.println("2. Por edad...");
            System.out.println("3. Por nia...");
            System.out.println("4. Por apellidos...");
            //Aunque no lo pide el ejercicio, añadimos la opción de mostrar todos para facilitar las pruebas
            System.out.println("5. Mostrar todos...");
            System.out.println("----------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.print("Elija una opción: ");
            try {
                opcion = Integer.parseInt(opcionAleatoria(0, 6, 0.05f));
                if (opcion < 0 || opcion > 5) {
                    System.out.println("Elija una opción del menú [0-5]");
                    if(!DEBUG) {
                        Lib.pausa();
                    }
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Elija una opción del menú [0-5]");
            }
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    /**
     * Busca alumnos por Grupo
     * @param codigoGrupo
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    private Alumno[] buscarAlumnoPorGrupo(int codigoGrupo) {
        Alumno[] alumnosGrupo = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        int i = 0;
        boolean fin = false;
        while(i < alumnos.length && !fin) {
            if(alumnos[i]!= null) {
                if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                    nAlumnos++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        if(nAlumnos > 0) {
            i = 0;
            alumnosGrupo = new Alumno[nAlumnos];
            int cont = 0;
            fin = false;
            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            while(i < alumnos.length && !fin) {
                if(alumnos[i]!= null) {
                    if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                        alumnosGrupo[cont] = alumnos[i];
                        cont++;
                    }
                    i++;
                } else {
                    fin = true;
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
    private Alumno[] buscarAlumnoPorEdad(int edad) {
        Alumno[] alumnosEdad = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        int i = 0;
        boolean fin = false;
        while(i < alumnos.length && !fin) {
            if(alumnos[i]!= null) {
                if (alumnos[i].getEdad() == edad) {
                    nAlumnos++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        if(nAlumnos > 0) {
            i = 0;
            fin = false;
            alumnosEdad = new Alumno[nAlumnos];
            int cont = 0;
            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            while(i < alumnos.length && !fin) {
                if(alumnos[i]!= null) {
                    if (alumnos[i].getEdad() == edad) {
                        alumnosEdad[cont] = alumnos[i];
                        cont++;
                    }
                    i++;
                } else {
                    fin = true;
                }
            }
        }
        return alumnosEdad;
    }

    /**
     * Busca un alumno por Nia
     * @param nia
     * @return Si lo encuentra devuelve la posición del array donde está el alumno,
     * en caso contrario devuelve -1
     */
    private int buscarAlumnoPorNia(int nia) {
        int i = 0;
        boolean fin = false;
        while(i < alumnos.length && !fin) {
            if(alumnos[i]!= null) {
                if (alumnos[i].getNia() == nia) {
                    return i;
                }
                i++;
            } else {
                fin = true;
            }
        }
        return -1;
    }

    /**
     * Busca alumnos por Apellidos
     * @param apellidos
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    private Alumno[] buscarAlumnoPorApellidos(String apellidos) {
        Alumno[] alumnosApellidos = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        int i = 0;
        boolean fin = false;
        //Convertimos a minúsculas
        apellidos = apellidos.toLowerCase();

        while(i < alumnos.length && !fin) {
            if(alumnos[i]!= null) {
                if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                    nAlumnos++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        if(nAlumnos > 0) {
            alumnosApellidos = new Alumno[nAlumnos];
            i = 0;
            int cont = 0;
            fin = false;
            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            while(i < alumnos.length && !fin) {
                if(alumnos[i]!= null) {
                    if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                        alumnosApellidos[cont] = alumnos[i];
                        cont++;
                    }
                    i++;
                } else {
                    fin = true;
                }
            }
        }
        return alumnosApellidos;
    }

    public String opcionAleatoria(int min, int max, float probabilidadLetra) {
        String result;
        if(DEBUG) {
            int aleatorio = Lib.aleatorio(min, max);
            String[] v = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            Random r = new Random();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            float sorteoLetra = r.nextFloat();
            if (sorteoLetra < probabilidadLetra) {
                result = v[Lib.aleatorio(0, v.length - 1)];
                System.out.println(result);
                return result;
            } else {
                result = String.valueOf(aleatorio);
                System.out.println(result);
                return result;
            }
        } else {
            return Lib.lector.nextLine();
        }
    }

    public String nombreAleatorio(float probabilidadError) {
        String nombre = null;
        if(DEBUG) {
            double alea = Lib.aleatorio(0, 1.0);
            if (alea < probabilidadError) {
                nombre = nombres[Lib.aleatorio(0, nombres.length - 1)];
            }
        } else {
            nombre = Lib.lector.nextLine();
        }
        return nombre;
    }

    public String apellidoAleatorio(float probabilidadError) {
        String apellido = null;
        if(DEBUG) {
            double alea = Lib.aleatorio(0, 1.0);
            if (alea < probabilidadError) {
                apellido = apellidos[Lib.aleatorio(0, apellidos.length - 1)];
            }
        } else {
            apellido = Lib.lector.nextLine();
        }
        return apellido;
    }

    public String fechaAleatoria(int minAnyo, int maxAnyo, float probabilidadError) {
        String fecha = "";
        if(DEBUG) {
            String fechaAux = "";
            int anyo = Lib.aleatorio(minAnyo, maxAnyo);
            int mes = Lib.aleatorio(1, 12);
            int dia = Lib.aleatorio(1, 28);

            fecha = anyo + "-" + mes + "-" + dia;
            if (Lib.aleatorio(0, 1.0) < probabilidadError) {
                int indice = Lib.aleatorio(0, fecha.length() - 2);
                fechaAux = fecha.substring(indice - 1);
                fechaAux = fechaAux + (char) Lib.aleatorio(60, 100);
                fechaAux = fechaAux + fecha.substring(indice + 1, fecha.length());
                fecha = fechaAux;
            }

        } else {
            fecha = lector.nextLine();
        }
        return fecha;
    }

    public int grupoAleatorio(float probabilidadError) {
        int grupo;
        if (Lib.aleatorio(0, 1.0) < probabilidadError) {
            grupo = Lib.aleatorio(-10000, -1);
        } else {
            grupo = grupos[Lib.aleatorio(0,grupos.length-1)].getCodigo();
        }
        return grupo;
    }
}
