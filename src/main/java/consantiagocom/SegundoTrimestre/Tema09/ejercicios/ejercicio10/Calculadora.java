package consantiagocom.SegundoTrimestre.Tema09.ejercicios.ejercicio10;

import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Lib;
import consantiagocom.SegundoTrimestre.Tema09.ejercicios.utils.Log;

import java.util.Random;
import java.util.Scanner;
public class Calculadora {
    public static final boolean DEBUG = true;
    public Calculadora() {
        int opcion = 0;
        float operando1 = 0;
        float operando2 = 0;
        float resultado = 0;
        int operando1Resto = 0;
        int operando2Resto = 0;
        int resultadoResto = 0;
        boolean validado = false;

        do {
            do {
                System.out.println("**************************");
                System.out.println("*** CALCULADORA BÁSICA ***");
                System.out.println("**************************");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("5. Resto división");
                System.out.println("------------------");
                System.out.println("0. Salir");
                System.out.print("\nElija una opción: ");
                try {
                    opcion = Integer.parseInt(opcionAleatoria(1, 7, 0.05f));
                    validado = true;
                } catch (NumberFormatException nfe) {
                    Log.e("Debe introducir un número entre 0 y 5");
                    validado = false;
                }
            } while (!validado);
            switch(opcion) {
                //Suma
                case 1:
                    System.out.println("\n************ SUMA ************");
                    do {
                        System.out.print("Introduzca el primer operando: ");
                        try {
                            operando1 = Float.parseFloat(opcionAleatoria(0, 20, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Sólo números por favor");
                        }
                    } while (!validado);
                    do {
                        System.out.print("\nIntroduzca el segundo operando: ");
                        try {
                            operando2 = Float.parseFloat(opcionAleatoria(0, 20, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Sólo números por favor");
                        }
                    } while (!validado);
                    resultado = operando1 + operando2;
                    System.out.println("\n" + operando1 + " + " + operando2 + " = " + resultado);
                    System.out.println("\nPulse INTRO para continuar ...");
                    if(!DEBUG) {
                        Lib.lector.nextLine();
                    }
                    break;
                //Resta
                case 2:
                    System.out.println("\n************ RESTA ************");
                    do {
                        System.out.print("Introduzca el primer operando: ");
                        try {
                            operando1 = Float.parseFloat(opcionAleatoria(0, 20, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Sólo números por favor");
                        }
                    } while (!validado);
                    do {
                        System.out.print("\nIntroduzca el segundo operando: ");
                        try {
                            operando2 = Float.parseFloat(opcionAleatoria(0, 20, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Sólo números por favor");
                        }
                    } while (!validado);
                    resultado = operando1 - operando2;
                    System.out.println("\n" + operando1 + " - " + operando2 + " = " + resultado);
                    System.out.println("\nPulse INTRO para continuar ...");
                    if(!DEBUG) {
                        Lib.lector.nextLine();
                    }
                    break;
                //Multiplicación
                case 3:
                    System.out.println("\n******** MULTIPLICACIÓN *********");
                    do {
                        System.out.print("Introduzca el primer operando: ");
                        try {
                            operando1 = Float.parseFloat(opcionAleatoria(0, 20, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Sólo números por favor");
                        }
                    } while (!validado);
                    do {
                        System.out.print("\nIntroduzca el segundo operando: ");
                        try {
                            operando2 = Float.parseFloat(opcionAleatoria(0, 20, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Sólo números por favor");
                        }
                    } while (!validado);
                    resultado = operando1 * operando2;
                    System.out.println("\n" + operando1 + " x " + operando2 + " = " + resultado);
                    System.out.println("\nPulse INTRO para continuar ...");
                    if(!DEBUG) {
                        Lib.lector.nextLine();
                    }
                    break;
                //División
                case 4:
                    System.out.println("\n********** DIVISIÓN ***********");
                    do {
                        System.out.print("Introduzca el primer operando: ");
                        try {
                            operando1 = Float.parseFloat(opcionAleatoria(0, 5, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Sólo números por favor");
                        }
                    } while (!validado);
                    do {
                        System.out.print("\nIntroduzca el segundo operando: ");
                        try {
                            operando2 = Float.parseFloat(opcionAleatoria(0, 3, 0.05f));
                            if(operando2 != 0) {
                                validado = true;
                            } else {
                                validado = false;
                                Log.e("El divisor no puede ser 0");
                            }
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Sólo números por favor");
                        }
                    } while (!validado);
                    resultado = operando1 / operando2;
                    System.out.println("\n" + operando1 + " / " + operando2 + " = " + resultado);
                    System.out.println("\nPulse INTRO para continuar ...");
                    if(!DEBUG) {
                        Lib.lector.nextLine();
                    }
                    break;
                //Resto división
                case 5:
                    System.out.println("\n******** RESTO DIVISIÓN ********");
                    do {
                        System.out.print("Introduzca el primer operando: ");
                        try {
                            operando1Resto = Integer.parseInt(opcionAleatoria(0, 5, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Solo números por favor");
                        }
                    } while (!validado);
                    do {
                        System.out.print("\nIntroduzca el segundo operando: ");
                        try {
                            operando2Resto = Integer.parseInt(opcionAleatoria(0, 3, 0.05f));
                            validado = true;
                        } catch (NumberFormatException nfe) {
                            validado = false;
                            Log.e("Solo números por favor");
                        }
                    } while (!validado);
                    try {
                        resultadoResto = operando1Resto % operando2Resto;
                        System.out.println("\n" + operando1Resto + " % " + operando2Resto + " = " + resultadoResto);
                    } catch (ArithmeticException ae) {
                        Log.e("El segundo operando no puede ser 0");
                    }

                    System.out.println("\nPulse INTRO para continuar ...");
                    if(!DEBUG) {
                        Lib.lector.nextLine();
                    }
                    break;
                //Ponemos la opción 0 para que el no se tome como default
                //pero en realidad no hace nada.
                case 0:
                    break;
                default:
                    System.out.println("\nXXXXXXXXXXXXXXXXXX ERROR XXXXXXXXXXXXXXXXXXXXXXXX");
                    System.out.println(opcion + " no es una opción válida del menú");
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                    System.out.println("Pulse INTRO para continuar ...");
                    if(!DEBUG) {
                        Lib.lector.nextLine();
                    }
                    break;
            }

        } while (opcion != 0);
        System.out.println("Hasta pronto");
    }



    public String opcionAleatoria(int min, int max, float probabilidadLetra) {
        String result;
        if(DEBUG) {
            int aleatorio = Lib.aleatorio(min, max);
            String[] v = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            Random r = new Random();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            float sorteoLetra = r.nextFloat();
            if (sorteoLetra < probabilidadLetra) {
                result = v[Lib.aleatorio(0, v.length - 1)];
                System.out.println(result);
                return result;
            } else {
                result = String.valueOf(aleatorio);
                System.out.println(result);
                return result;
            }
        } else {
            return Lib.lector.nextLine();
        }
    }
}