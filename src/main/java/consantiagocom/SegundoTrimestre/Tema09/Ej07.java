package consantiagocom.SegundoTrimestre.Tema09;

public class Ej07 {
    Ej07(){
        //Creamos un par de arrays de cadenas de caracteres y las inicializamos
        // Rellenamos los array con cadenas de caracteres y cadenas nulas
        String[] array = {"Hola", "Adios", null, "Buenos días", "Buenas tardes", "Buenas noches"};
        String[] array2 = {"Hola", "Adios", "Buenos días", "Buenas tardes", "Buenas noches"};
        String[] array3 = {"Hola", "Adios", null, "Buenos días", "Buenas tardes", "Buenas noches", null};
        String[] array4 = {"Hola", "Adios", null, "Buenos días", "Buenas tardes", "Buenas noches", null, null};

        //Llamamos al método mostrarCadenasArray
        System.out.println("Array 1");
        mostrarCadenasArray(array);
        System.out.println("--------------------");
        System.out.println("Array 2");
        mostrarCadenasArray(array2);
        System.out.println("--------------------");
        System.out.println("Array 3");
        mostrarCadenasArray(array3);
        System.out.println("--------------------");
        System.out.println("Array 4");
        mostrarCadenasArray(array4);
    }

    public void mostrarCadenasArray(String[] array) {
        for (String cadena : array) {
            try {
                System.out.println(cadena.charAt(0));
            } catch (NullPointerException e) {
                System.out.println("Cadena nula");
            }
        }
    }
}
