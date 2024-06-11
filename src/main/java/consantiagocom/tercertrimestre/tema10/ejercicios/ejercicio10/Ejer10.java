package consantiagocom.tercertrimestre.tema10.ejercicios.ejercicio10;

import consantiagocom.tercertrimestre.tema10.ejercicios.utils.LibMethods;

public class Ejer10 {
    public Ejer10(){
        int numMenu,numSubMenu;
        int num,edad;
        String nie, nombre;
        double sueldo,sueldoMin,sueldoMax;
        String result;
        int minAge,maxAge;
        Management manage = new Management();
        do {
            System.out.println(menu());
            numMenu = LibMethods.scanInt();
            switch (numMenu){
                // Nuevo empleado
                case 1:
                    System.out.println("Entra 1 si tiene un hijo, 0 si no.");
                    num = LibMethods.scanInt();
                    System.out.println("Introduce el nie,nombre,apellido y sueldo, y si tiene hijo su nombre y edad");
                    if(manage.newWorker(num) == 1)
                        System.out.println("Nuevo empleado creado");
                    else
                        System.out.println("Este empleado ya existe");
                    break;
                //Nuevo hijo
                case 2:
                    System.out.println("Pone el numero de identificacion de empleado ");
                    nie = LibMethods.scanString();
                    System.out.println("Entra en nombre del hijo");
                    nombre = LibMethods.scanString();
                    System.out.println("Entra la edad del hijo");
                    edad = LibMethods.scanInt();
                    if(manage.newChild(nie,nombre,edad) == 1)
                        System.out.println("Nuevo niño añadido al empleado" + nie);
                    else
                        System.out.println("Este empleado no existe");
                    break;
                //Modificar sueldo
                case 3:
                    System.out.println("Pone el numero de identificacion de empleado ");
                    nie = LibMethods.scanString();
                    System.out.println("Introduce el nuveo sueldo del trabajador");
                    sueldo = LibMethods.scanDouble();
                    if(manage.setSueldo(nie,sueldo) == 1)
                        System.out.println("Sueldo cambiado");
                    else
                        System.out.println("No existe este empleado");
                    if(manage.removeWorker(nie) == 1)
                        System.out.println("Sueldo cambiado" + nie);
                    else
                        System.out.println("Este empleado no existe");
                    break;
                //Borrar empleado
                case 4:
                    System.out.println("Pone el numero de identificacion de empleado ");
                    nie = LibMethods.scanString();
                    if(manage.removeWorker(nie) == 1)
                        System.out.println("Empleado despidido" + nie);
                    else
                        System.out.println("Este empleado no existe");
                    break;
                // Borrar hijo
                case 5:
                    //
                    //
                    //
                    //
                    //
                    break;
                // Consultas
                case 6:
                    do {
                        System.out.println(subMenuConsultas());
                        numSubMenu = LibMethods.scanInt();
                        switch (numSubMenu) {
                            //  Buscar por NIF
                            case 1:
                                System.out.println("Entra el NIF de empleado");
                                nie = LibMethods.scanString();
                                result =manage.consultarNif(nie);
                                if(result == null)
                                    System.out.println("No hay empleado con este NIE");
                                else
                                    System.out.println(manage.consultarNif(result));
                                break;
                            // Buscar por nombre
                            case 2:
                                System.out.println("Entra el nombre de empleado");
                                nombre = LibMethods.scanString();
                                result = manage.consultarNombre(nombre);
                                if(result == null)
                                    System.out.println("No hay empleado con este NIE");
                                else
                                    System.out.println(result);
                                break;
                            // Buscar por rango de edad.
                            case 3:
                                System.out.println("Introduce la edad minima");
                                minAge = LibMethods.scanInt();
                                System.out.println("Introduce la edad maxima");
                                maxAge = LibMethods.scanInt();
                                result = manage.rangoEdad(minAge,maxAge);
                                break;
                            //Buscar por rango de sueldo.
                            case 4:
                                System.out.println("Introduce el sueldo minimo");
                                sueldoMin = LibMethods.scanDouble();
                                System.out.println("Introduce el sueldo maxima");
                                sueldoMax = LibMethods.scanDouble();
                                result = manage.rangoSueldo(sueldoMin,sueldoMax);
                                if(result == null)
                                    System.out.println("No hay empleado que tienen sueldo dentro este rango");
                                else
                                    System.out.println(result);

                                break;
                            // Buscar por hijos menores de edad
                            case 5:

                                result = manage.menoresEdad();
                                if(result == null)
                                    System.out.println("No hay menores de edad");
                                else
                                    System.out.println(result);
                                break;
                            //Salir
                            case 0:
                                break;
                        }

                    }while(numSubMenu != 0);
                    break;
                //Salir
                /*case 10:
                    System.out.println();
                    break;*/
                case 0:
                    break;
            }

        }while(numMenu != 0);
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("*********************\n");
        sb.append("**Gestion Empleados**\n");
        sb.append("*********************\n");
        sb.append("1. Nuevo empleado\n");
        sb.append("2. Nuevo hijo\n");
        sb.append("3. Modificar sueldo\n");
        sb.append("4. Borrar empleado\n");
        sb.append("5. Borrar hijo\n");
        sb.append("6. Consultas\n");
        sb.append("----------------------\n");
        sb.append("0. Salir\n");
        return sb.toString();
    }

    public String subMenuConsultas(){
        StringBuilder sb = new StringBuilder();
        sb.append("*********************\n");
        sb.append("** CONSULTAS EMPLEADOS**\n");
        sb.append("*********************\n");
        sb.append("1. Buscar por NIF\n");
        sb.append("2. Buscar por nombre\n");
        sb.append("3. Buscar por rango de edad. \n");
        sb.append("4. Buscar por rango de sueldo.\n");
        sb.append("5. Buscar por hijos menores de edad\n");
        sb.append("----------------------\n");
        sb.append("0. Volver al menú principal\n");
        return sb.toString();
    }

}
