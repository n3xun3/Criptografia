package encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * Clase para manejar la encriptación y desencriptación de frases de manera simétrica.
 */
public class SymmetricEncryption {
    private final SecretKey secretKey;

    /**
     * Constructor para SymmetricEncryption.
     * @throws Exception Excepción en caso de problemas con la generación de la clave.
     */
    public SymmetricEncryption() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Tamaño de la clave
        secretKey = keyGenerator.generateKey();
    }

    /**
     * Encripta una frase.
     * @param frase Frase a encriptar.
     * @return Frase encriptada en formato Base64.
     * @throws Exception Excepción en caso de problemas durante la encriptación.
     */
    public String encriptarFrase(String frase) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] fraseEncriptada = cipher.doFinal(frase.getBytes());
        return Base64.getEncoder().encodeToString(fraseEncriptada);
    }

    /**
     * Desencripta una frase encriptada.
     * @param fraseEncriptada Frase encriptada en formato Base64.
     * @return Frase desencriptada.
     * @throws Exception Excepción en caso de problemas durante la desencriptación.
     */
    public String desencriptarFrase(String fraseEncriptada) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] fraseDesencriptada = cipher.doFinal(Base64.getDecoder().decode(fraseEncriptada));
        return new String(fraseDesencriptada);
    }
}
