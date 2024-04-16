//package consantiagocom.SegundoTrimestre.Tema09.ej05;
//
//import consantiagocom.SegundoTrimestre.Tema09.libtrycatch.Lib;
//
//import java.util.Scanner;
//
//public class Ej05 {
//    private static final Scanner scanner = new Scanner(System.in);
//    private Alumno [] alumnos = new Alumno[2];
//
//    public Ej05(){
//
//        //Creamos un bucle para crear los alumnos
//        for (int i = 0; i <alumnos.length ; i++) {
//
//            String nombre;
//            int edad;
//            int altura;
//
//            //Solicitamos los datos
//            System.out.println("Indica el nombre de los alumnos");
//            nombre = scanner.nextLine();
//            edad = Lib.readInt("Ingresa la edad");
//            altura = Lib.readInt("Ingresa la altura");
//
//            alumnos[i] = new Alumno(nombre,edad,altura);
//        }
//        //Buscar alumno mayor
//         Alumno mayor = alumnos[0];
//
//        for(Alumno alumno : alumnos){
//            if(alumno.getEdad() > mayor.getEdad()){
//                mayor = alumno;
//            }
//            System.out.println("..............................");
//            System.out.println("Nombre: " + alumno.getNombre());
//            System.out.println("Edad: " + alumno.getEdad());
//            System.out.println("Altura: " + alumno.getAltura());
//            System.out.println("..............................");
//        }
//        System.out.println("El alumno mayor es: " + mayor.getNombre());
//
//    }
//}
