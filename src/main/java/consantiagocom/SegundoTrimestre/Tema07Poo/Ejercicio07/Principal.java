package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

import consantiagocom.SegundoTrimestre.Tema07Poo.Lib.ConsolMenu;
import consantiagocom.SegundoTrimestre.Tema07Poo.Lib.LibIO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {

    private static CentroSalud centroSalud;
    private static ConsolMenu menuGenero;
    public static void main(String[] args) {
        centroSalud = new CentroSalud(500,1000);


        ConsolMenu consolMenu = new ConsolMenu("Urgencia");
        consolMenu.addOpcion("nuevo paciente");
        consolMenu.addOpcion("Atender paciente");
        ConsolMenu consulta = consolMenu.addOpcion("consulta");
        consolMenu.addOpcion("Alta medica");

        Paciente.Genero[] generos = Paciente.Genero.values();
        menuGenero = new ConsolMenu("Selecciona un genero");
        for (int i = 0; i < generos.length; i++) {
            menuGenero.addOpcion(generos[i].toString());
        }

        int opcion;
        do {
            opcion = consolMenu.mostrarMenu();
            switch (opcion){
                case 1:
                    nuevoPaciente();
                    break;
                case 2:
//                    atenderPaciente();
//                    break;
//                case 3:
//                    consultas();
//                    break;
//                case 4:
//                    altaMedica();
//                    break;
                case 5:
                    System.out.println("Hasta pronto");
                    break;
            }
        }while (opcion != 5);
        System.out.println(centroSalud);
    }
    public static void nuevoPaciente(){
        String sip;
        sip = LibIO.solicitarString("SIP: ", 4 , 12);
        Paciente paciente = centroSalud.buscarPacientePorSip(sip);
        if (paciente == null){
            System.out.println("No existe un pacinete");
            String nombre = LibIO.solicitarString("Nombre",2,30);
            int optionGenero = menuGenero.mostrarMenu();
            Paciente.Genero generos = Paciente.Genero.values()[optionGenero-1];
            Date fechaNacimiento = LibIO.solicitarDate("fechaNacimiento", new SimpleDateFormat("dd/MM/yy"));
            paciente = centroSalud.nuevoPaciente(sip,nombre,generos,fechaNacimiento);
            if (paciente == null) {
                System.out.println("No se pudo añadir el paciente");
            }else {
                System.out.println("Paciente añadido correctamente: " + paciente);
            }
        }
        String sintamologia = LibIO.solicitarString("Sintamologia",4,50);
        if (centroSalud.entradaPaciente(paciente,sintamologia))
            System.out.println("Entrada del paciente registrado corectamente");
        else
            System.err.println("no se pudo registrar el paciente");
    }
    public void atenderPaciente(){
        String sip = LibIO.solicitarString("Sip: ",4,10);
        Paciente paciente = centroSalud.buscarPacienteEspera(sip);
        if (paciente == null) {
            System.out.println("No existe ningun paciente en espera con ese sip");
            return;
        }
    }

}
