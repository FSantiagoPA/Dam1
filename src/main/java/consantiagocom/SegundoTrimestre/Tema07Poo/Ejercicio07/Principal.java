package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio07;

import consantiagocom.SegundoTrimestre.Tema07Poo.Lib.ConsolMenu;

public class Principal {
    public static void main(String[] args) {
        CentroSalud centroSalud = new CentroSalud(500,1000);
        System.out.println(centroSalud);

        ConsolMenu consolMenu = new ConsolMenu("Urgencia");
        consolMenu.addOpcion("nuevo paciente");
        consolMenu.addOpcion("Atender paciente");
        ConsolMenu consulta = consolMenu.addOpcion("consulta");
        consolMenu.addOpcion("Alta medica");
        int opcion;
        do {
            opcion = consolMenu.mostrarMenu();
        }while (opcion != 5);

    }

}
