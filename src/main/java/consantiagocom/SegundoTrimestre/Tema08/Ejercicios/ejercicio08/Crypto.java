package consantiagocom.SegundoTrimestre.Tema08.Ejercicios.ejercicio08;

import java.util.Base64;
import java.util.Random;

/**
 * Crypto
 * License: ? Public Domain
 * Tema08 GUI
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-03-18
 * @since 0.1, 2024-03-18
 **/
public class Crypto {
    /**
     * Chars in Base64 standard
     * Note: padding (=) is optional
     * See: <a href="https://datatracker.ietf.org/doc/html/rfc4648#section-4">RFC 4648</a>
     **/
    private static final String base64Table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static String encrypt(byte[] bytes, long key) {
        Random random = new Random(key);
        System.out.println(new String(bytes));
        System.out.println(getStats(new String(bytes)));
        Base64.Encoder encoder = Base64.getEncoder();
        String text = encoder.encodeToString(bytes);
        System.out.println(text);
        System.out.println(getStats(text));
        int tableLength = base64Table.length();
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int pos = base64Table.indexOf(c);
            if (pos < 0 && c == '=') // padding
                continue;
            int offset = random.nextInt(tableLength);
            pos = Math.floorMod(pos + offset, base64Table.length());
            // pos = (pos + key) % table.length();
            sb.append(base64Table.charAt(pos));
        }
        return sb.toString();
    }

    public static String decrypt(byte[] bytes, long key) {
        Random random = new Random(key);
        String text = new String(bytes);
        StringBuilder sb = new StringBuilder(text.length());
        int tableLength = base64Table.length();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int pos = base64Table.indexOf(c);
            if (pos < 0 && c == '=') // padding
                continue;
            int offset = random.nextInt(tableLength);
            pos = Math.floorMod(pos - offset, base64Table.length());
            // pos = (pos - key) % table.length();
            sb.append(base64Table.charAt(pos));
        }
        Base64.Decoder decoder = Base64.getDecoder();
        text = new String(decoder.decode(sb.toString()));
        return text;
    }

    public static String getStats(String text) {
        long[] data = new long[255];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            data[c]++;
        }

        StringBuilder sb = new StringBuilder(127);
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                sb.append((char)i).append("(").append(data[i]).append(") ");
            }
        }
        return sb.toString();
    }
}
