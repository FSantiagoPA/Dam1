package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio11;

import consantiagocom.tercertrimestre.tema10.ejercicios.utils.LibMenu;

public class Ejer11 {



    public Ejer11()  {
        Centro centro = new Centro();
       /* int submenu = 6 ;
        String[] options ={"1- Alta alumno","2- Alta asignatura","3- Alta aula","4- Alta profesor", "5- Alta Grupo","6-Consultas","7-Salir"};
        String[] searchOptions ={"1- mostrar por alumno","2-Mostrar por profesor","3-Mostrar por grupo"};

        Object[] method ={centro.altaAlumno(),centro.altaAsignatura(),centro.altaAula(),centro.altaProfesor(),centro.altaGrupo()};
        Object[] submethod={centro.consultAlumno(),centro.consultProfesor(),centro.consultGrupo(),centro.};

        new LibMenu(options,method,searchOptions,submethod,submenu);*/

        String[] options ={"1- Alta alumno","2- Alta asignatura","3- Alta aula","4- Alta profesor", "5- Alta Grupo",
                "6- mostrar por alumno","7-Mostrar por profesor","8-Mostrar por grupo","9-Salir"};
        Object[] method ={centro.altaAlumno(),centro.altaAsignatura(),centro.altaAula(),centro.altaProfesor(),centro.altaGrupo(),
                centro.exit()};
        new LibMenu(options,method);
    }
}
