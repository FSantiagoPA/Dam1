package consantiagocom.SegundoTrimestre.Tema07Poo.ejercicios.ejercicio03;

import consantiagocom.SegundoTrimestre.Tema07Poo.utils.Ansi;
import consantiagocom.SegundoTrimestre.Tema07Poo.utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ejercicio3 {
    private static final int MAX_ALUMNOS = 100;
    private static final int MAX_GRUPOS = 10;
    private final Scanner lector;
    private final CentroEducativoA centroEducativo;

    public Ejercicio3() {
        lector = new Scanner(System.in);
        int opcion;
        centroEducativo = new CentroEducativoA(MAX_ALUMNOS, MAX_GRUPOS);
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
        int nia;
        String nombre;
        String apellidos;
        String fechaNacimientoString;
        GregorianCalendar fechaNacimiento = null;
        Grupo grupo = null;
        long telefono;
        Ansi.clearScreen();
        System.out.println("*** NUEVO ALUMNO ***" );
        do {
            System.out.println("Nia: ");
            nia = Integer.parseInt(lector.nextLine());
            validado = nia > CentroEducativoA.MIN_NIA && nia < CentroEducativoA.MAX_NIA;
            if(!validado) {
                System.out.printf("Nia debe estar comprendido en el rango [%d, %d]\n", CentroEducativoA.MIN_NIA, CentroEducativoA.MAX_NIA);
                Lib.pause();
                continue;
            }
            /* Comprobamos que dicho NIA no est� duplicado */
            validado = centroEducativo.buscarAlumnoPorNia(nia) == null;
            if(!validado) {
                System.out.println("El nia introducido ya corresponde a un alumno.");
                System.out.println("Introduzca otro por favor");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Nombre: ");
            nombre = lector.nextLine();
            validado = nombre.length() > 2;
            if(!validado) {
                System.out.println("Nombre debe tener almenos 2 caracteres");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Apellidos: ");
            apellidos = lector.nextLine();
            validado = apellidos.length() > 2;
            if(!validado) {
                System.out.println("Apellidos debe tener almenos 2 caracteres");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Fecha nacimiento (dd-mm-yyyy): ");
            fechaNacimientoString = lector.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = sdf.parse(fechaNacimientoString);
                fechaNacimiento = new GregorianCalendar();
                fechaNacimiento.setTime(date);
                validado = true;
            } catch (ParseException pe) {
                validado = false;
                System.out.println("El formato de la fecha de nacimiento no es v�lido. Recuerde (dd-mm-yyyy).");
                Lib.pause();
            }
        } while (!validado);

        do {
            mostrarGrupos();
            System.out.println("C�digo del grupo: ");
            int codigo = Integer.parseInt(lector.nextLine());
            /* Buscamos que el c�digo que ha introducido el usuario corresponde a un grupo v�lido */
            /* En caso afirmativo lo asignamos */
            grupo = centroEducativo.buscarGrupoPorCodigo(codigo);
            validado = grupo != null;
            if (!validado) {
                System.out.println("El c�digo de grupo indicado corresponde a ning�n grupo");
            }
        } while (!validado);

        do {
            System.out.println("Tel�fono: ");
            telefono = Long.parseLong(lector.nextLine());
            /* Para facilitar la introducci�n de datos permitimos poner n�meros peque�os como tel�fono */
            validado = telefono > CentroEducativoA.MIN_TELEFONO && telefono < CentroEducativoA.MAX_TELEFONO;
        } while (!validado);

        // Hemos validado todos los datos, podemos proceder a dar de alta el alumno
        if (centroEducativo.nuevoAlumno(nia, nombre, apellidos, fechaNacimiento, grupo, String.valueOf(telefono))) {
            System.out.println("Alumno guardado correctamente");
        } else {
            System.out.println("Imposible a�adir el alumno.");
            System.out.println("El array de alumnos est� lleno");
        }
        Lib.pause();
    }

    private void bajaAlumno() {
        int nia;
        Ansi.clearScreen();
        System.out.println("*** BAJA ALUMNO ***" );
        System.out.println("Nia: ");
        nia = Integer.parseInt(lector.nextLine());
        if (centroEducativo.bajaAlumno(nia)) {
            System.out.println("Alumno borrado correctamente");
        } else {
            System.out.println("No existe ning�n alumno con el nia " + nia);
        }
        Lib.pause();
    }

    private void consultas() {
        int opcion;
        int i;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    //Por grupo
                    buscarAlumnosPorGrupo();
                    Lib.pause();
                    break;
                case 2:
                    //Por edad
                    buscarAlumnosPorEdad();
                    Lib.pause();
                    break;
                case 3:
                    //Por nia
                    buscarAlumnoPorNia();
                    Lib.pause();
                    break;
                case 4:
                    //Por apellidos
                    buscarAlumnosPorApellidos();
                    Lib.pause();
                    break;
                case 5:
                    mostrarAlumnos();
                    Lib.pause();
                    break;
            }
        } while (opcion != 0);
    }

    private void mostrarGrupos() {
        System.out.println("Grupos disponibles");
        System.out.println(centroEducativo.listadoGrupos());
    }

    private void buscarAlumnosPorGrupo() {
        int codigo;
        Alumno[] alumnosGrupo;
        mostrarGrupos();
        System.out.println("C�digo del grupo: ");
        codigo = Integer.parseInt(lector.nextLine());
        alumnosGrupo = centroEducativo.buscarAlumnosPorGrupo(codigo);
        if (alumnosGrupo != null) {
            for (int i = 0; i < alumnosGrupo.length; i++) {
                System.out.println(alumnosGrupo[i].toString());
            }
        } else {
            System.out.println("No se han encontrado alumnos del grupo con c�digo " + codigo);
        }
    }

    private void buscarAlumnosPorEdad() {
        int edad;
        Alumno[] alumnosEdad;
        System.out.println("Edad: ");
        edad = Integer.parseInt(lector.nextLine());
        alumnosEdad = centroEducativo.buscarAlumnosPorEdad(edad);
        if (alumnosEdad != null) {
            for (int i = 0; i < alumnosEdad.length; i++) {
                System.out.println(alumnosEdad[i].toString());
            }
        } else {
            System.out.println("No se han encontrado alumnos que tengan " + edad + " a�os");
        }
    }

    private void buscarAlumnoPorNia() {
        int nia;
        System.out.println("Nia: ");
        nia = Integer.parseInt(lector.nextLine());
        Alumno alumno = centroEducativo.buscarAlumnoPorNia(nia);
        if(alumno != null) {
            System.out.println(alumno);
        } else {
            System.out.println("No se ha encontrado ning�n alumno con el nia " + nia);
        }
    }

    private void buscarAlumnosPorApellidos() {
        String apellidos;
        Alumno[] alumnosApellidos;
        System.out.println("Apellidos: ");
        apellidos = lector.nextLine();
        alumnosApellidos = centroEducativo.buscarAlumnosPorApellidos(apellidos);
        if (alumnosApellidos != null) {
            for (int i = 0; i < alumnosApellidos.length; i++) {
                System.out.println(alumnosApellidos[i].toString());
            }
        } else {
            System.out.println("No se han encontrado alumnos que tengan " + apellidos + " como apellidos");
        }
    }

    private void mostrarAlumnos() {
        System.out.println("Alumnos disponibles: ");
        System.out.println(centroEducativo.listadoAlumnos());
    }

    private int menuPrincipal() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("*********************");
            System.out.println("** GESTI�N ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo alumno...");
            System.out.println("2. Baja de alumno...");
            System.out.println("3. Consultas...");
            System.out.println("---------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opci�n: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 3) {
                System.out.println("Elija una opci�n del men� [0-3]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    private int menuConsultas() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("***************");
            System.out.println("** CONSULTAS **");
            System.out.println("****************");
            System.out.println("1. Por grupo...");
            System.out.println("2. Por edad...");
            System.out.println("3. Por nia...");
            System.out.println("4. Por apellidos...");
            // Aunque no lo pide el ejercicio, a�adimos la opci�n de mostrar todos para facilitar las pruebas
            System.out.println("5. Mostrar todos...");
            System.out.println("----------------");
            System.out.println("0. Volver al men� principal\n");
            System.out.println("Elija una opci�n: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 5) {
                System.out.println("Elija una opci�n del men� [0-5]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }
}
