package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio03;

import java.util.Scanner;

public class Main {
    private static EducationCenter educationCenter;
    private static Scanner scanner;

    public static void main(String[] args) {
        Main main = new Main();
        main.educationCenter = new EducationCenter("IES la mar",1000);
        scanner = new Scanner(System.in);
        int option;
        do {
             option = mainMenu();
             switch (option){
                 case 1: //alta alumno
                     altaAlumno();
                     break;
                 case 2: //baja alumno
                     break;
                 case 3: // submenu consultas
                     break;
                 case  0:
                     System.out.println("Hasta pronto");
                     break;
             }
        }while (option != 0);
    }
    public  void bajaAlumno(){
        System.out.println("Nia");
        String nia = scanner.nextLine();
        if (educationCenter.eraseStudent(nia)){
            System.out.println("se elimino el alumno");
        }else{
            System.out.println("No se elimino el alumno");
        }
    }
    public static void altaAlumno(){
        String nombre;
        String apellido;
        String fechaNacimiento;
        String grupo;
        String telefo;
        boolean values;
        do {
            System.out.println("Nombre: ");
            nombre = scanner.nextLine();

            values = (nombre.length() >= 2 );
            if (!values){
                System.out.println("El nombre debe tener al menos 2 caracteres");
            }
        }while (!values);

        do {
            System.out.println("apellido: ");
            apellido = scanner.nextLine();

            values = (apellido.length() >= 2 );
            if (!values){
                System.out.println("El apellido debe tener al menos 2 caracteres");
            }
        }while (!values);

        do {
            System.out.println("FechaNacimeinto: ");
            fechaNacimiento = scanner.nextLine();

            values = (fechaNacimiento.length() == 10 && fechaNacimiento.charAt(2) == '-' && fechaNacimiento.charAt(5) == '-' );
            if (!values){
                System.out.println("fehca incorrecta, formato [dd-mm-yy]");
            }
        }while (!values);

        do {
            System.out.println("grupo: ");
            grupo = scanner.nextLine();

            values = (grupo.length() >= 3 );
            if (!values){
                System.out.println("El grupo debe tener al menos 3 caracteres");
            }
        }while (!values);

        do {
            System.out.println("Telefono: ");
            telefo = scanner.nextLine();

            values = (telefo.length() >= 9 );
            if (!values){
                System.out.println("El telefono debe tener al menos 9 numeros");
            }
        }while (!values);

        Student student = educationCenter.newStudent(nombre,apellido,fechaNacimiento,grupo,telefo);
        if (educationCenter.newStudent(nombre,apellido,fechaNacimiento,grupo,telefo) != null){
            System.out.println("Alumno creado correctamente");
        }else {
            System.out.println("Error al crear alumno");
        }
    }
    public static int mainMenu(){
        int option = -1;
        boolean valido;
        do {
            System.out.println("*********************");
            System.out.println("** GESTIÓN ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo alumno …");
            System.out.println("2. Baja de alumno …");
            System.out.println("3. Consultas …");
            System.out.println("------------------------------");
            System.out.println("0. Salir");
            System.out.println();
            System.out.println("Elige una opcion: ");
            option = Integer.parseInt(scanner.nextLine());
            valido = option >= 0 && option < 4;
            if (!valido){
                System.out.println("Opcion no valido");
            }
        }while (!valido);
        return option;
    }
}
