package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio08;

/**
 * Ejercicio08
 * Crear un programa que permita encriptar y desencriptar un texto.
 * License: ? Public Domain
 * Tema08 GUI
 * @author Germ�n Gasc�n <ggascon@gmail.com>
 * @version 0.1, 2024-03-18
 * @since 0.1, 2024-03-18
 **/
public class Ejercicio08 {
    public Ejercicio08() {
        // String text = "&&**!!  ++%%^^";
        String text = """
        Don Quijote de la Mancha es una novela escrita por el espa�ol Miguel de Cervantes Saavedra.
        Publicada su primera parte con el t�tulo de El ingenioso hidalgo don Quijote de la Mancha a
        comienzos de 1605, es la obra m�s destacada de la literatura espa�ola y una de las principales
        de la literatura universal.
        En 1615 apareci� su continuaci�n con el t�tulo de Segunda parte
        del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se public� dividido en cuatro partes;
        pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, qued� revocada de hecho la
        partici�n en cuatro secciones del volumen publicado diez a�os antes por Cervantes.
        Es la primera obra genuinamente desmitificadora de la tradici�n caballeresca y cort�s por su tratamiento
        burlesco. Representa la primera novela moderna y la primera novela polif�nica; como tal,
        ejerci� un enorme influjo en toda la narrativa europea. Por considerarse �el mejor trabajo
        literario jam�s escrito�, encabez� la lista de las mejores obras literarias de la historia,
        que se estableci� con las votaciones de cien grandes escritores de 54 nacionalidades a petici�n
        del Club Noruego del Libro y Bokklubben World Library en 2002; as�, fue la �nica excepci�n en el
        estricto orden alfab�tico que se hab�a dispuesto.
        """;
        String encrypted = Crypto.encrypt(text.getBytes(), 1000);
        System.out.println(encrypted);

        String decrypted = Crypto.decrypt(encrypted.getBytes(), 1000);
        System.out.println(decrypted);
    }
}
