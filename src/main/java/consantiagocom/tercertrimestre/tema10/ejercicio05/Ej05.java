package consantiagocom.tercertrimestre.tema10.ejercicio05;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Ej05 {

    public Ej05(){
        System.out.println("Ejercicio 5");
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            pacientes.add(new Paciente(faker.name().fullName(),
                    faker.date().birthday(),
                    faker.options().option('M', 'F'),
                    faker.number().randomDouble(2, 1, 2),
                    faker.number().randomDouble(2, 50, 100)));
        }

        for (Paciente paciente : pacientes){
            System.out.println(paciente);
        }

        ResultReturn mayorMenor = mayorMenor(pacientes);
        System.out.println("El paciente mas mayor es: " + pacientes.get(mayorMenor.maxX));
        System.out.println("El paciente mas pequeño es: " + pacientes.get(mayorMenor.minX));

        int[] pacientesPorSexo = pacientesPorSexo(pacientes);
        System.out.println("El numero de pacientes hombres es: " + pacientesPorSexo[0]);
        System.out.println("El numero de pacientes mujeres es: " + pacientesPorSexo[1]);


    }

    ResultReturn mayorMenor(ArrayList<Paciente> pacientes){
        ResultReturn result = new ResultReturn();
        result.minX = 0;
        result.maxX = 0;

        Date maxDate = pacientes.get(0).getFechaNacimiento();
        Date minDate = pacientes.get(0).getFechaNacimiento();

        for (Paciente paciente : pacientes){
            if (paciente.getFechaNacimiento().before(minDate)){
                result.maxX = pacientes.indexOf(paciente);
                minDate = pacientes.get(result.maxX).getFechaNacimiento();
            }
            if (paciente.getFechaNacimiento().after(maxDate)){
                result.minX = pacientes.indexOf(paciente);
                maxDate = pacientes.get(result.maxX).getFechaNacimiento();
            }
        }

        return result;
    }

    int[] pacientesPorSexo(ArrayList<Paciente> pacientes){
        int[] result = new int[2];

        for (Paciente paciente : pacientes){
            if (paciente.getSexo() == 'M'){
                result[0]++;
            } else {
                result[1]++;
            }
        }

        return result;
    }

    public static class ResultReturn {
        private int minX;
        private int maxX;
    }
}
