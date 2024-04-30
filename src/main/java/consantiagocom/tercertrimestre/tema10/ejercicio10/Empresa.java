package consantiagocom.tercertrimestre.tema10.ejercicio10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Empresa {
    private List<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>(10);
    }

    /**
     * Metodo para crear nuevo empleado.
     * @param nombre del empleado.
     * @param apellidos del empleado.
     * @param NIF del empleado.
     * @param fechaNacimiento del empleado.
     * @param sueldo del empleado.
     * @return el empleado que se a creado
     */
    public Empleado nuevoEmpleado(String nombre, String apellidos, String NIF, Date fechaNacimiento, double sueldo) {
        if (!empleados.isEmpty()) {
            for (int i = 0; i < empleados.size(); i++) {
                if (!NIF.equals(empleados.get(i).getNIF())) {
                    Empleado empleado = new Empleado(nombre, apellidos, NIF, sueldo, fechaNacimiento);
                    empleados.add(empleado);
                    return empleado;
                }
                else {
                    return null;
                }
            }
        }else{
            Empleado empleado = new Empleado(nombre, apellidos, NIF, sueldo, fechaNacimiento);
            empleados.add(empleado);
            return empleado;
        }
        return null;
    }

    /**
     * Metodo para crear nuev hijo.
     * @param nif del empleado encargado del hijo
     * @param nombre del hijo
     * @param fechaNacimiento del hijo
     * @return el hijo que se a creado o null si no se a creado correctamente
     */
    public Hijo nuevoHijo(String nif,String nombre, Date fechaNacimiento){
        Empleado empleado = getEmpleadoNif(nif);
        if(empleado == null){
            return null;
        }
        return empleado.nuevoHijo(nombre,fechaNacimiento);
    }

    /**
     * Metodo para modificar el salario del empleado
     * @param nif del empleado
     * @param sueldo a la que queremos cambiar
     * @return la cantidad a la que se a cambiado o null si no se a cambiado correctamente.
     */
    public double modificarSalario(String nif, double sueldo){
        Empleado empleado = getEmpleadoNif(nif);
        if (empleado == null){
            return 0;
        }
        empleado.setSueldo(sueldo);
        return sueldo;
    }

    /**
     * Metodo para eliminar un empleado
     * @param nif del empleado a eliminar
     * @return el empleado eliminado o null si no se a eliminado correctamente.
     */
    public Empleado eliminarEmpleado(String nif){
        Empleado empleado = getEmpleadoNif(nif);
        if (empleado == null){
            return null;
        }
        empleados.remove(empleado);
        return empleado;
    }

    /**
     * Metodo para eliminar un hijo.
     * @param nif del empleado encargado del hijo a eliminar
     * @param nombreHijo el nombre del hijo
     * @return el hijo que se a eliminado o null si no se a eliminado correctamente.
     */
    public Hijo eliminarHijo(String nif, String nombreHijo){
        Empleado empleado = getEmpleadoNif(nif);
        if (empleado == null){
            return null;
        }
        return empleado.eliminarHijo(nombreHijo);
    }

    /**
     * Metodo para sacar el empleado por su nif
     * @param nif el nif del empleado a sacar
     * @return el empleado o null si el nif no coincide con ningun empleado.
     */
    public Empleado getEmpleadoNif(String nif){
        for (Empleado empleado : empleados) {
            if (empleado.getNIF().equals(nif)) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Metodo para sacar empleados por nombre
     * @param nombre a buscar en los empleado
     * @return el empleado con ese nombre
     */
    public Empleado getEmpleadoNombre(String nombre){
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre)) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Metodo para sacar los empleados en un rango de edad
     * @param edadMin edad minima
     * @param edadMax edad maxima
     * @return lista con los empleados encontrados entre ese rango de edad.
     */
    public ArrayList<Empleado> getEmpleadoRangoEdad(int edadMin, int edadMax){
        ArrayList<Empleado> empleadosEdad = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (Calculos.calcularEdad(empleado.getFechaNacimiento()) >= edadMin && Calculos.calcularEdad(empleado.getFechaNacimiento()) <= edadMax) {
                empleadosEdad.add(empleado);
            }
        }
        return empleadosEdad;
    }

    /**
     * Metodo para sacar los empleados por un rango de sueldo
     * @param sueldoMin el suelod minimo
     * @param sueldoMax el suelod maximo
     * @return lista de empleados que tenga un sueldo entre el rango
     */
    public ArrayList<Empleado> getEmpleadosRangoSalario(double sueldoMin, double sueldoMax){
        ArrayList<Empleado> empleadosSalario = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getSueldo() >= sueldoMin && empleado.getSueldo() <= sueldoMax) {
                empleadosSalario.add(empleado);
            }
        }
        return empleadosSalario;
    }

    /**
     * Metodo para sacar los empleados con hijos menores de edad.
     * @return lista con los empleados.
     */
    public ArrayList<Empleado> getEmpleadosHijosMenoresEdad(){
        ArrayList<Empleado> empleadosHijosMenores = new ArrayList<>();
        for (Empleado empleado : empleados) {
            for (Hijo hijo : empleado.getHijos()) {
                if (Calculos.calcularEdad(hijo.getFechaNacimiento()) < 18) {
                    empleadosHijosMenores.add(empleado);
                    break;
                }
            }
        }
        return empleadosHijosMenores;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        return empleados.equals(empresa.empleados);
    }

    @Override
    public int hashCode() {
        return empleados.hashCode();
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "empleados=" + empleados +
                '}';
    }

}
