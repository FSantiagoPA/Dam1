package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio05;

import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Lib;
import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Log;

public class Ejercicio05 {
    public Ejercicio05() {
        String nombre;
        int edad = 0;
        float estatura = 0;
        int numeroAlumnos = 0;
        int i;
        boolean validado = false;
        Alumno[] alumnos;
        do {
            System.out.println("*** GESTIÓN DE ALUMNOS ***");
            System.out.print("Número de alumnos: ");
            try {
                numeroAlumnos = Integer.parseInt(Lib.lector.nextLine());
                validado = numeroAlumnos > 0;
            } catch (NumberFormatException nfe) {
                Log.e("Introduzca el número de alumnos");
            }
        } while (!validado);
        alumnos = new Alumno[numeroAlumnos];
        for (i = 0; i < numeroAlumnos; i++) {
            System.out.print("Nombre: ");
            nombre = Lib.lector.nextLine();
            do {
                try {
                    System.out.print("Edad: ");
                    edad = Integer.parseInt(Lib.lector.nextLine());
                    validado = edad > 0 && edad < 120;
                    if (!validado) {
                        Log.e("La edad debe ser un número entre 0 y 120");
                    }
                } catch (NumberFormatException nfe) {
                    validado = false;
                    Log.e("La edad debe ser un número entre 0 y 120");
                }
            } while (!validado);
            do {
                try {
                    System.out.print("Estatura: ");
                    estatura = Float.parseFloat(Lib.lector.nextLine());
                    validado = estatura > 0.3 && estatura < 2.5;
                    if (!validado) {
                        Log.e("La estatura debe ser un número real entre 0.3 y 2.5");
                    }
                } catch (NumberFormatException nfe) {
                    validado = false;
                    Log.e("La estatura debe ser un número real entre 0.3 y 2.5");
                }
            } while (!validado);
            alumnos[i] = new Alumno(nombre, edad, estatura);
        }

        Alumno alumnoMayor = alumnos[0];
        System.out.println(alumnoMayor.toString());
        for (i = 1; i < alumnos.length; i++) {
            System.out.println(alumnos[i].toString());
            if (alumnos[i].getEdad() > alumnoMayor.getEdad()) {
                alumnoMayor = alumnos[i];
            }
        }

        System.out.println("El alumno mayor es " + alumnoMayor.toString());
    }
}
