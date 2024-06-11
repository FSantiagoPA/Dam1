package consantiagocom.tercertrimestre.tema11.ejercicios.ejercicio04;

public class Ejercicio04 {

    public Ejercicio04() {
        //Creamos un array de Electrodomesticos
        Electrodomestico[] listaElectrodomesticos = new Electrodomestico[10];

        //Asignamos cada una de las posiciones como queramos
        listaElectrodomesticos[0] = new Electrodomestico(200, 60, 'F', "blanco");
        listaElectrodomesticos[1] = new Lavadora(150, 30);
        listaElectrodomesticos[2] = new Television(500, 80, 'E', "negro", 42, false);
        listaElectrodomesticos[3] = new Electrodomestico();
        listaElectrodomesticos[4] = new Electrodomestico(600, 20, 'D', "gris");
        listaElectrodomesticos[5] = new Lavadora(300, 40, 'Z', "blanco", 40);
        listaElectrodomesticos[6] = new Television(250, 70);
        listaElectrodomesticos[7] = new Lavadora(400, 100, 'A', "verde", 15);
        listaElectrodomesticos[8] = new Television(200, 60, 'C', "naranja", 30, true);
        listaElectrodomesticos[9] = new Electrodomestico(50, 10);

        //Creamos las variables que usaremos para almacenar la suma de los precios
        double sumaElectrodomesticos = 0;
        double sumaTelevisiones = 0;
        double sumaLavadoras = 0;

        //Recorremos el array invocando el metodo precioFinal
        for(int i = 0; i < listaElectrodomesticos.length; i++) {
            /*
             * Cuando una Television o una Lavadora esté en la posición del array actual,
             * pasará por su clase y por la de Electrodomestico, ya que una Television es un Electrodomestico.
             * Cada uno ejecuta su propia versión del método precioFinal
             */
            double precio = listaElectrodomesticos[i].precioFinal();
            sumaElectrodomesticos += precio;

            if(listaElectrodomesticos[i] instanceof Lavadora) {
                sumaLavadoras += precio;
            } else if(listaElectrodomesticos[i] instanceof Television) {
                sumaTelevisiones += precio;
            }
            System.out.println(listaElectrodomesticos[i].toString());
        }

        //Mostramos los resultados
        System.out.println("La suma del precio de los electrodomésticos es de " + sumaElectrodomesticos);
        System.out.println("La suma del precio de las lavadoras es de " + sumaLavadoras);
        System.out.println("La suma del precio de las televisiones es de " + sumaTelevisiones);

    }
}