package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio08;

/**
 * Ejercicio08
 * Crear un programa que permita encriptar y desencriptar un texto.
 * License: ? Public Domain
 * Tema08 GUI
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-03-18
 * @since 0.1, 2024-03-18
 **/
public class Ejercicio08 {
    public Ejercicio08() {
        // String text = "&&**!!  ++%%^^";
        String text = """
        Don Quijote de la Mancha es una novela escrita por el español Miguel de Cervantes Saavedra.
        Publicada su primera parte con el título de El ingenioso hidalgo don Quijote de la Mancha a
        comienzos de 1605, es la obra más destacada de la literatura española y una de las principales
        de la literatura universal.
        En 1615 apareció su continuación con el título de Segunda parte
        del ingenioso caballero don Quijote de la Mancha. El Quijote de 1605 se publicó dividido en cuatro partes;
        pero al aparecer el Quijote de 1615 en calidad de Segunda parte de la obra, quedó revocada de hecho la
        partición en cuatro secciones del volumen publicado diez años antes por Cervantes.
        Es la primera obra genuinamente desmitificadora de la tradición caballeresca y cortés por su tratamiento
        burlesco. Representa la primera novela moderna y la primera novela polifónica; como tal,
        ejerció un enorme influjo en toda la narrativa europea. Por considerarse «el mejor trabajo
        literario jamás escrito», encabezó la lista de las mejores obras literarias de la historia,
        que se estableció con las votaciones de cien grandes escritores de 54 nacionalidades a petición
        del Club Noruego del Libro y Bokklubben World Library en 2002; así, fue la única excepción en el
        estricto orden alfabético que se había dispuesto.
        """;
        String encrypted = Crypto.encrypt(text.getBytes(), 1000);
        System.out.println(encrypted);

        String decrypted = Crypto.decrypt(encrypted.getBytes(), 1000);
        System.out.println(decrypted);
    }
}
