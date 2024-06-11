package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio10;

import consantiagocom.tercertrimestre.tema10.ejercicios.utils.LibMethods;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Management {
    private ArrayList<Empleado>empleados = new ArrayList<Empleado>();
    private ArrayList<Hijo>hijos = new ArrayList<Hijo>();
    private static int cont =0;
    public Management(){
        empleados = new ArrayList<>();
        hijos = new ArrayList<>();
    }

    protected int newWorker(int num){
        String nie = LibMethods.scanString();
        String nombre = LibMethods.scanString();
        String apellido = LibMethods.scanString();
        GregorianCalendar fechaNaci = LibMethods.dateWithRand();
        double sueldo = LibMethods.scanDouble();
        String nombreHijo ="No tiene hijo";
        int edadHijo = 0;
        if( num == 1) {
            nombreHijo = LibMethods.scanString();
            edadHijo = LibMethods.scanInt();
            hijos.add(new Hijo(nombreHijo,edadHijo));
            cont++;
            if(empleados.size() != 0) {
                for (int i = 0; i < empleados.size(); i++) {
                    if(nie == empleados.get(i).getNie())
                        return 0;
                }
            }
            empleados.add(new Empleado(nie,nombre,apellido,fechaNaci,sueldo,hijos.get(cont)));
            return 1;
        }

        empleados.add(new Empleado(nie,nombre,apellido,fechaNaci,sueldo));
        return 1;
    }

    /**
     * Method to add new child to a worker
     * @param nie
     * @param nombre
     * @param edad
     * @return
     */
    public int newChild(String nie, String nombre, int edad) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNie().equals(nie)) {
                empleados.get(i).setHijo(new Hijo(nombre,edad));
                return 1;
            }
        }
        return 0;
    }

    /**
     * Method to remove worker
     * @param nie
     * @return
     */
    protected int removeWorker(String nie){
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNie().equals(nie)) {
                empleados.remove(i);
                return 1;
            }
        }
        return 0;
    }

    /**
     * method to alter the salary of a worker
     * @param nie
     * @param sueldo
     * @return
     */
    protected int setSueldo(String nie, double sueldo){
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNie().equals(nie)) {
                empleados.get(i).setSueldo(sueldo);
                return 1;
            }
        }
        return 0;
    }

    /**
     * Get worker by nif
     * @param nie
     * @return
     */
    protected String consultarNif(String nie){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNie().equals(nie)) {
                sb.append(empleados.get(i));
            }
        }
        return sb.toString();
    }

    /**
     * get worker by name
     * @param nombre
     * @return
     */
    protected String consultarNombre(String nombre){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equals(nombre)) {
                sb.append(empleados.get(i));
            }
        }
        return sb.toString();
    }

    /**
     * Get all minors in childer
     * @return
     */
    protected String menoresEdad(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < hijos.size();i++){
            if(hijos.get(i).getEdad() <18){
                sb.append(hijos.get(i));
            }
        }
        return sb.toString();
    }

    /**
     * Get all worker with  salary in range of min salary and max salary
     * @param min
     * @param max
     * @return
     */
    protected String rangoSueldo(double min, double max){
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < empleados.size();i++){
            if(empleados.get(i).getSueldo() >min && max < empleados.get(i).getSueldo())
                sb.append(empleados.get(i));
        }
        return sb.toString();
    }

    /**
     * Method to get workers withing a range of maximum and minimum age
     * @param max
     * @param min
     * @return
     */
    protected String rangoEdad(int max, int min){
        StringBuilder sb = new StringBuilder();
        GregorianCalendar calendar = new GregorianCalendar();

        for (int i =0; i < empleados.size();i++){
            if(empleados.get(i).getFechaNaci().before(max) && empleados.get(i).getFechaNaci().after(min)){
                sb.append(empleados.get(i));
            }
        }
        return sb.toString();
    }

}
