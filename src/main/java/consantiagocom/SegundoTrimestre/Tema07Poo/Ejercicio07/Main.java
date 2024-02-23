package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

import consantiagocom.SegundoTrimestre.Tema07Poo.Lib.ConsoleMenu;
import consantiagocom.SegundoTrimestre.Tema07Poo.Lib.LibIO;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static CentroMedico centroMedico;
    public static ConsoleMenu consoleMenu;
    public static ConsoleMenu consoleGenero;
    public static ConsoleMenu consoleConsultas;
    public static void main(String[] args) {
        centroMedico = new CentroMedico(500,1000);

        System.out.println(centroMedico);

        consoleMenu = new ConsoleMenu("URGENCIAS");
        consoleMenu.addOption(" Nuevo paciente");
        consoleMenu.addOption(" Atender paciente");
        ConsoleMenu consultas = consoleMenu.addOption(" Consultas");
        consoleMenu.addOption(" Alta medica");

        Paciente.Genero[] generos = Paciente.Genero.values();
        consoleGenero = new ConsoleMenu("Opciones");
        for (int i = 0; i < generos.length; i++) {
            consoleGenero.addOption( generos[i].toString());
        }

        consoleConsultas = new ConsoleMenu("Consultas");
        consoleConsultas.addOption(" Por sip");
        consoleConsultas.addOption(" Por fechas");
        consoleConsultas.addOption(" Estadisticas");
        consoleConsultas.addOption(" Mostrar historico mensual");
        consoleConsultas.addOption(" AltaMedica");


        int opcion;
        do{
            opcion = consoleMenu.showMenu();
            switch(opcion){
                case 1:
                    nuevoPaciente();
                    break;
                case 2:
                    atenderPaciente();
                    break;
                case 3:
                    consultas();
                    break;
                case 4:
                    // altaMedica();
                    break;
                case 5:
                    System.out.println("Xao");
                    break;
            }
        }while (opcion != 5);

    }
    public static void nuevoPaciente() {
        String sip;
        sip = LibIO.solicitarString("Sip", 4, 12);

        Paciente paciente = centroMedico.buscarPacientePorSip(sip);
        if (paciente == null) {
            System.out.printf("No existe ningun paciente con el sip %s.", sip);
            String nombre = LibIO.solicitarString("Nombre: ", 2, 30);

            int opcionGenero = consoleGenero.showMenu();
            Paciente.Genero genero = Paciente.Genero.values()[opcionGenero - 1];

            Date fechaNacimiento = LibIO.solicitarFechaDate("Fecha nacimiento [dd/MM/yyyy]: ", new SimpleDateFormat("dd/MM/yyyy"));

            paciente = centroMedico.nuevoPaciente(sip, nombre, genero, fechaNacimiento);
            if (paciente == null) {
                System.err.println("No se puede añadir el paciente");
            } else {
                System.out.println("Paciente: añadido: " + paciente);
            }
        }

        String sintomalogia = LibIO.solicitarString("Sintomalogia: ", 4, 50);
        if (centroMedico.entradaPaciente(paciente, sintomalogia)) {
            System.out.println("Entradada del paciente registrada correctamente");
        } else {
            System.err.println("No se pudo registrar la entradad del paciente");
        }
        System.out.println(centroMedico);
    }
    public static void atenderPaciente(){
        String sip = LibIO.solicitarString("Sip: ",4,12);
        Paciente paciente = centroMedico.buscarPacienteEnEspera(sip);
        if(paciente == null) {
            System.out.println("No existe ningun paciente en espera con ese sip");
            return;
        }
        System.out.println("Constantes vitales");
        double temperatura = LibIO.solicitarDouble("Temperatura: ",34,45);
        double ppm = LibIO.solicitarDouble("Pulsaciones por minuto: ",30,250);
        double tensionSistolica = LibIO.solicitarDouble("Tension sistolica: ",40,200);
        double tensionDiastolica = LibIO.solicitarDouble("Tension sistolica: ",40,200);
        if(centroMedico.atenderPaciente(sip,temperatura,ppm,tensionSistolica,tensionDiastolica)){
            System.out.println("El paciente a sido atendido correctamente");
        }else{
            System.err.println("No se pudo atender al paciente");
        }
    }
    public static void consultas(){
        int opcion = consoleConsultas.showMenu();

        switch (opcion){
            case 1:
                String sip = LibIO.solicitarString("Sip",5,12);
                System.out.println(centroMedico.buscarPacientePorSip(sip));
                break;
            case 2:
                Date fechaInical = LibIO.solicitarFechaDate("Dime la fecha de incio: ", new SimpleDateFormat("dd/MM/yyyy"));
                Date fechaFinal = LibIO.solicitarFechaDate("Dime la fecha de incio: ", new SimpleDateFormat("dd/MM/yyyy"));
                System.out.println(centroMedico.buscarPorFecha(fechaInical,fechaFinal));
            case 3:
                System.out.println(centroMedico.estadisticas());
            case 4:
                Atencion[] historialAtenciones = centroMedico.obtenerHistorial();
                System.out.println(Arrays.toString(historialAtenciones));

                historialAtenciones[0].setconstantesVitales(-1000,-1000,-1000,-1000);
                System.out.println(historialAtenciones[0]);

                historialAtenciones = centroMedico.obtenerHistorial();
                System.out.println(historialAtenciones[0]);
            case 5:
                String sipp = LibIO.solicitarString("Sip: ",4,12);

        }
    }
}
