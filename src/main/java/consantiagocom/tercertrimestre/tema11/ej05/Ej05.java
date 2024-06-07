package consantiagocom.tercertrimestre.tema11.ej05;

import consantiagocom.tercertrimestre.tema10.LibMethods;

public class Ej05 {
    public Ej05() {
        int opt1;
        final int SPACES = 7;
        Menu menu = new Menu(SPACES);

        do{
            System.out.println("1-Add item");
            System.out.println("2-Remove item");
            System.out.println("3-Show inventory");
            System.out.println("0-Exit");
            opt1 = LibMethods.scanInt();

            switch( opt1){

                case 1:
                    System.out.println("Introduzca el índice del artículo:: ");
                    int index = LibMethods.scanInt();
                    System.out.println("Introduzca el nombre del item: ");
                    String item = LibMethods.scanString();
                    menu.addItem(index, item);
                    break;
                case 2:
                    System.out.println("Ingrese el índice del elemento a eliminar: ");
                    int delete = LibMethods.scanInt();
                    menu.removeItem(delete);
                    break;
                case 3:
                    System.out.println(menu.paintInvetory());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Dato incorrecto");
                    break;

            }
        }while( opt1 != 0);
    }
}

