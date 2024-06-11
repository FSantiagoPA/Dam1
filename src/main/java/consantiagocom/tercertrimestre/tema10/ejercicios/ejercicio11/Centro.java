package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio11;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

public class Centro {
    private  ArrayList<Alumno>alumno;
    private  ArrayList<Asignatura> asignaturas;
    private  ArrayList<Aula>aulas;
    private  ArrayList<Grupo>grupos;
    private  ArrayList<Profesor>profesors;
    Faker faker = new Faker(new Locale("es","ES"));


    protected Centro(){
        alumno = new ArrayList<>();
        asignaturas = new ArrayList<>();
        aulas = new ArrayList<>();
        grupos = new ArrayList<>();
        profesors = new ArrayList<>();
    }

    /**
     * Add Student
     * @return
     */
    protected String altaAlumno(){
        System.out.println("Error");
        StringBuilder sb = new StringBuilder();
        String nombre = Input.inputName();
        if(comprobarAlumno(nombre) == 0 ){
            return sb.append("Este alumno ya existe").toString();
        }
        String nombreGrupo = Input.inputName();
        int id = comprobarGrupo(nombreGrupo);
        if(id == 0){
            String [] asignaturas = Input.inputStringArray();
            if(comprobarAsignaturas(asignaturas)==0)
                return sb.append("Una de las asignaturas no existe").toString();
            alumno.add(new Alumno(nombre,grupos.get(id),asignaturas));
        }else{
            return sb.append("El grupo no existe").toString();
        }
        return sb.toString();
    }

    /**
     * Confirm if the student exists by name
     * @param nombre
     * @return
     */
    protected int comprobarAlumno(String nombre){
        for (int i = 0; i < alumno.size(); i++){
            if(alumno.get(i).getNombre().equalsIgnoreCase(nombre))
                return i;
        }
        return 1;
    }
    protected  int comprobarGrupo(String nombre){
        for (int i = 0; i < alumno.size(); i++){
            if(alumno.get(i).getGrupo().getNombre().equalsIgnoreCase(nombre))
                return i;
        }
        return 0;
    }

    /**
     * Confirm is subject exists by name from an array when adding
     * stident
     * @param aray
     * @return
     */
    protected int comprobarAsignaturas(String [] aray){
        int contador = 0 ;
        for (Asignatura asignatura : asignaturas) {
            for (String s : aray) {
                if (s.equalsIgnoreCase(asignatura.getNombre()))
                    contador++;
                if (contador == aray.length)
                    return 1;
            }
        }
        return 0;
    }

    /**
     * Confirm is subject exists by name
     * @param nombre
     * @return
     */
    protected int comprobarAsignaturas(String nombre){
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre().equalsIgnoreCase(nombre))
                return 1;
        }
        return 0;
    }

    /**
     * Confirm if teacher exists
     * @param nombre
     * @return
     */
    protected int comprobarProfesor(String nombre){
        for (int i = 0; i < alumno.size(); i++){
            if(profesors.get(i).getNombre().equalsIgnoreCase(nombre))
                return i;
        }
        return 0;
    }

    /**
     * confirm is room exists
     * @param codigo
     * @return
     */
    protected int comprobarAula(String codigo){
        for (int i = 0; i <aulas.size();i++){
            if(aulas.get(i).getXodigoIdentificador().equalsIgnoreCase(codigo))
                return i;
        }
        return 0;
    }

    /**
     * Create subject
     * @return
     */
    protected String altaAsignatura() {
        StringBuilder sb = new StringBuilder();
        String nombre = Input.inputName();
        if (comprobarAsignaturas(nombre)==0){
            return sb.append("Este asignatura ya existe").toString();
        }
        String nombreProfesor =Input.inputName();
        int id =comprobarProfesor(nombreProfesor);
        String codigoDeIdnetificacion = Input.inputName();
        if(id == 0)
            return sb.append("Este profesor no existe").toString();
        asignaturas.add(new Asignatura(codigoDeIdnetificacion,nombre,profesors.get(id)));
        return sb.append("Nueva asignatura añadida").toString();
    }

    /**
     * create room
     * @return
     */
    protected String altaAula(){
        StringBuilder sb = new StringBuilder();
        String codIden = Input.idenCode();
        if(comprobarAula(codIden) == 1){
            int metros =  Input.inputInteger();
            aulas.add(new Aula(codIden,metros));
            return sb.append("Alta dada").toString();
        }

        return sb.append("Este aula ya existe").toString();
    }

    /**
     * create room
     * @return
     */
    protected String altaGrupo(){
        StringBuilder sb = new StringBuilder();
        String codIden = Input.idenCode();
        if(comprobarGrupo(codIden) == 1){
            String nombre = Input.inputName();
            String codAula = Input.idenCode();
            int idAula = comprobarAula(codAula);
            if(idAula==0)
                return sb.append("Este aula no existe").toString();
            grupos.add(new Grupo(codIden,nombre,aulas.get(idAula)));
            return sb.append("Alta dada").toString();
        }
        return sb.append("Este grupo ya existe").toString();
    }

    /**
     * create teacher
     * @return
     */
    protected String altaProfesor(){
        StringBuilder sb = new StringBuilder();
        String dni = Input.idenCode();
        String nombre = Input.inputName();
        if(comprobarProfesor(nombre) != 0){
            String sueldo = Input.idenCode();
            profesors.add(new Profesor(dni,nombre,sueldo));
            return sb.append("Alta dada").toString();
        }
        return sb.append("Este profesor existe").toString();
    }

    /**
     * consult student
     * @return
     */
    protected String consultAlumno(){
        StringBuilder sb = new StringBuilder();
        String nombre = Input.inputName();
        int idAlu =comprobarAlumno(nombre);
        if(idAlu != 1)
            return sb.append(alumno.get(idAlu)).toString();
        return sb.append("Este alumno no existe").toString();
    }

    /**
     * consult by group
     * @return
     */
    protected String consultGrupo(){
        StringBuilder sb = new StringBuilder();
        String nombreGrup = Input.inputName();
        if(comprobarGrupo(nombreGrup) == 0)
            return sb.append("Este grupo no existe").toString();
        for(int i = 0; i < alumno.size();i++ ){
            if(alumno.get(i).getGrupo().getNombre().equalsIgnoreCase(nombreGrup)){
                sb.append(alumno.get(i));
            }
        }
        if(sb.isEmpty())
            return sb.append("Este grupo es vaccio").toString();
        return sb.toString();
    }

    /**
     * consult teacher
     * @return
     */
    protected String consultProfesor(){
        StringBuilder sb = new StringBuilder();
        String nombre = Input.inputName();
        for (int i = 0; i <profesors.size();i++){
            if (profesors.get(i).getNombre().equalsIgnoreCase(nombre))
                sb.append(profesors.get(i));
        }
        if(sb.isEmpty())
            sb.append("Este profesor no existe");
        return sb.toString();
    }

    protected String exit(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Fin").toString();
    }

    protected String consulta(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Consultas").toString();
    }
}
