package consantiagocom.SegundoTrimestre.Tema09.ej09;

public class Ej09 {

    public Ej09(){

        // ArithmeticException

        try {
            testArithmeticException();
        } catch (ArithmeticExceptionPersonalizada aep) {
            System.out.println(aep.getMessage());
        }

        // NullPointerException

        try {
            testNullPointerException();
        } catch (NullPointerExceptionPersonalizada np){
            System.out.println(np.getMessage());
        }

        // IndexOutOfBoundsException

        try {
            testIndexOutOfBoundsException();
        } catch (IndexOutOfBoundsExceptionPersonalizada iob){
            System.out.println(iob.getMessage());
        }

    }

    public void testArithmeticException() throws ArithmeticExceptionPersonalizada {
        try {
            int a = 1 / 0;
        } catch (ArithmeticException a) {
            throw new ArithmeticExceptionPersonalizada("Operacion Incorrecta");
        }
    }

    public void testNullPointerException() throws NullPointerExceptionPersonalizada{
        try {
            String cadena = null;
            cadena.charAt(0);
        } catch (NullPointerException n) {
            throw new NullPointerExceptionPersonalizada("Contenido Null");
        }
    }
    public void testIndexOutOfBoundsException() throws  IndexOutOfBoundsExceptionPersonalizada {
        try {
            int[] array = {1, 2, 3};
            System.out.println(array[4]);
        } catch (IndexOutOfBoundsException i) {
            throw new IndexOutOfBoundsExceptionPersonalizada("Array Sobresalida");
        }
    }
}
