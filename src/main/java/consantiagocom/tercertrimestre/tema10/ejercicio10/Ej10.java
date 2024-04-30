package consantiagocom.tercertrimestre.tema10.ejercicio10;

import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.Date;

public class Ej10 {
    private final Empresa empresa = new Empresa();
    private final ConsoleMenuLib menu = new ConsoleMenuLib("GESTION EMPLEADOS");
    private final ConsoleMenuLib menuConsultas = new ConsoleMenuLib("CONSULTAS EMPLEADOS");

    public Ej10() {
        menu.addOption(" Nuevo empleado");
        menu.addOption(" Nuevo hijo");
        menu.addOption(" Modificar sueldo");
        menu.addOption(" Borrar empleado");
        menu.addOption(" Borrar hijo");
        menu.addOption(" Consultas");
        int opcion;
        do {
            opcion= menu.showMenu();
            switch (opcion){
                case 1:
                    nuevoEmpleado();
                    break;
                case 2:
                    nuevoHijo();
                    break;
                case 3:
                    modificarSueldo();
                    break;
                case 4:
                    borrarEmpleado();
                    break;
                case 5:
                    borrarHijo();
                    break;
                case 6:
                    consultas();
                    break;
                default:
                    System.out.println("Opcion no disponible");
            }
        }while (opcion !=0);
    }

    /**
     * Metodo para solicitar datos del empleado y crearlo.
     */
    private void nuevoEmpleado(){
        String nombre = IOLib.solicitarString("Dime el nombre del empleado: ", 3,30);
        String apellidos = IOLib.solicitarString("Dime los apellidos del empleado: ", 3,30);
        String NIF = IOLib.solicitarString("Dime el NIF del empleado: ", 8,8);
        double sueldo = IOLib.solicitarDouble("Dime el sueldo del empleado: ", 1,10000);
        Date fechaNacimiento = IOLib.solicitarFechaDate("Dime la fecha de nacimiento: ", new SimpleDateFormat("dd/MM/yyyy"));
        System.out.println(empresa.nuevoEmpleado(nombre,apellidos,NIF,fechaNacimiento,sueldo));
    }

    /**
     * Metodo para solitar datos del hijo y crearlo.
     */
    private void nuevoHijo(){
        String nif = IOLib.solicitarString("Dime el nif del empleado resposable del hijo: ",8,8);
        String nombre = IOLib.solicitarString("Dime el nombre del hijo: ", 3,30);
        Date fechaNacimiento = IOLib.solicitarFechaDate("Dime la fecha de nacimiento del hijo: ", new SimpleDateFormat("dd/MM/yyyy"));
        System.out.println(empresa.nuevoHijo(nif,nombre,fechaNacimiento));
    }

    /**
     * Metodo para solictar datos y modificar el sueldo.
     */
    private void modificarSueldo(){
        String nif = IOLib.solicitarString("Dime el nif del empleado resposable del hijo: ",8,8);
        double sueldo = IOLib.solicitarDouble("Dime el nuevo sueldo: ",1,10000);
        System.out.println(empresa.modificarSalario(nif,sueldo));
    }

    /**
     * Metodo para solicitar datos y eliminar a un empleado.
     */
    private void borrarEmpleado(){
        String nif = IOLib.solicitarString("Dime el nif del empleado resposable del hijo: ",8,8);
        System.out.println(empresa.eliminarEmpleado(nif));
    }

    /**
     * Metodo para solicitar datos y eliminar hijo.
     */
    private void borrarHijo(){
        String nif = IOLib.solicitarString("Dime el nif del empleado resposable del hijo: ",8,8);
        String nombreHijo = IOLib.solicitarString("Dime el nombre del hijo: ", 3,30);
        System.out.println(empresa.eliminarHijo(nif,nombreHijo));
    }

    /**
     * Metodo para mostrar menu consultas.
     */
    private void consultas(){
        menuConsultas.addOption("Buscar por nif");
        menuConsultas.addOption("Buscar por nombre");
        menuConsultas.addOption("Buscar por rango de edad");
        menuConsultas.addOption("Buscar por rango de sueldo");
        menuConsultas.addOption("Buscar por hijos menores de edad");
        int opcion;
        do {
            opcion = menuConsultas.showMenu();
            switch (opcion){
                case 0:
                case 1:
                    String nif = IOLib.solicitarString("Dime el nif: ", 8,8);
                    System.out.println(empresa.getEmpleadoNif(nif));
                    break;
                case 2:
                    String nombre = IOLib.solicitarString("Dime el nombre del empleado: ",3,30);
                    System.out.println(empresa.getEmpleadoNombre(nombre));
                    break;
                case 3:
                    int edadMin = IOLib.solicitarInteger("Dime la edad minima: ",1,50);
                    int edadMax = IOLib.solicitarInteger("Dime la edad minima: ",50,100);
                    System.out.println(empresa.getEmpleadoRangoEdad(edadMin,edadMax));
                    break;
                case 4:
                    double sueldoMin = IOLib.solicitarDouble("Dime el sueldo minima: ",1,5000);
                    double sueldoMax = IOLib.solicitarDouble("Dime el sueldo minima: ",5000,10000);
                    System.out.println(empresa.getEmpleadosRangoSalario(sueldoMin,sueldoMax));
                    break;
                case 5:
                    System.out.println(empresa.getEmpleadosHijosMenoresEdad());
                    break;

            }
        }while (opcion !=0);
    }
}
