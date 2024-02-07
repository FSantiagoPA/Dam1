package consantiagocom.SegundoTrimestre.Tema07Poo.Ejercicio06;

/*import net.datafaker.Faker;

public class Principal {

    //Faker para generar datos aleatorios
    private final Faker faker = new Faker();
    public static final int MAX_BICIS = 100;
    private GestorStock gestorStock = new GestorStock(MAX_BICIS);

    //Arrays de marcas y modelos para generar stock aleatorio
    String[] marcas = {"BH", "Orbea", "Scott", "Giant", "Cannondale", "Specialized", "Trek", "Merida", "Cube", "BMC"};
    String[] modelos = {"X-Trail", "Fusion", "Giant", "Talon", "Epic", "e-MTB", "Trail", "Rush", "Ride", "Ripley"};

    public Ej6() {

        //Generar stock aleatorio
        for (int i = 0; i < 25; i++) {
            gestorStock.nuevaBicicleta(
                    faker.number().numberBetween(100000, 999999),
                    marcas[faker.random().nextInt(0, marcas.length - 1)],
                    modelos[faker.random().nextInt(0, modelos.length - 1)],
                    faker.number().randomDouble(2, 10, 20),
                    faker.number().numberBetween(20, 29),
                    faker.random().nextBoolean(),
                    String.format("%02d/%02d/%04d", faker.number().numberBetween(1, 31), faker.number().numberBetween(1, 12), faker.number().numberBetween(2010, 2021)),
                    faker.number().randomDouble(2, 100, 1000),
                    faker.random().nextInt(0, 100)
            );
        }

        gestorStock.mostrarStock();


        //Menu principal
        do {
            JDeploy.deployMenu("GESTION DE BICICLETAS", "0.- Salir", ".- ", "Añadir bicicleta", "Vender bicicleta", "Consultar bicicleta", "Mostrar stock");
            int opt = JRequest.requestInt("Introduzca una opción: ");

            switch (opt) {
                case 0 -> {
                    return;
                }
                case 1 -> gestorStock.nuevaBicicleta();
                case 2 -> gestorStock.venderBicicleta();
                case 3 -> runConsultarBicicleta();
                case 4 -> gestorStock.mostrarStock();
            }

        } while (true);

    }

    //Submenu de consultas
    public void runConsultarBicicleta() {
        do {
            JDeploy.deployMenu("CONSULTA BICICLETA", "0.- Volver al menu principal", ".- ", "Por referencia", "Por marca", "Por modelo");
            int opt = JRequest.requestInt("Introduzca una opción: ");

            switch (opt) {
                case 0 -> {
                    return;
                }
                case 1 -> gestorStock.consultaReferencia();
                case 2 -> gestorStock.consultaMarca();
                case 3 -> gestorStock.consultaModelo();
            }

        } while (true);
    }
}*/
