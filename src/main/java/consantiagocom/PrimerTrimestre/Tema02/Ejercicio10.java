package consantiagocom.PrimerTrimestre.Tema02;

public class Ejercicio10 {
    public enum MesesDelAnio{
        ENERO,FEBRERO,MARZO,ABRIL,MAYO,JUNIO,JULIO,AGOSTO,SEPTIEMBRE,OCTUBRE,NOVIEMBRE,DICIEMBRE
    }

    public enum NotasMusicales{
        DO,RE,MI,FA,SOL,LA,SI
    }
    public enum NotasAlumnos{
        SUSPENDIDO,SUFICIENTE,BIEN,EXELENTE,SOBRESALIENTE
    }
    public static void main(String[] args) {

        System.out.println("Mes del año: " + MesesDelAnio.AGOSTO);
        System.out.println("Nota musicales: " + NotasMusicales.DO);
        System.out.println("Notas alumnos: " + NotasAlumnos.EXELENTE);
    }

}
