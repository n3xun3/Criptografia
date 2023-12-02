package authentication;

import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para autenticar usuarios registrados.
 */
public class UserAuthentication {
    private final Map<String, String> usuarios;

    /**
     * Constructor para UserAuthentication.
     */
    public UserAuthentication() {
        usuarios = new HashMap<>();
        usuarios.put("jorge", hashPassword("contrasena1"));
        usuarios.put("felix", hashPassword("contrasena2"));
        usuarios.put("invitado", hashPassword("contrasena3"));
    }

    /**
     * Autentica un usuario.
     * @param usuario Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @return Verdadero si las credenciales son válidas, falso en caso contrario.
     */
    public boolean autenticarUsuario(String usuario, String contrasena) {
        try {
            return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(hashPassword(contrasena));
        } catch (Exception e) {
            System.err.println("Error al autenticar al usuario.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Método para generar un hash de contraseña utilizando el algoritmo SHA-256.
     * @param password Contraseña a hashear.
     * @return Contraseña hasheada en formato hexadecimal.
     */
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());

            // Convertir bytes a representación hexadecimal
            StringBuilder stringBuilder = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                stringBuilder.append(String.format("%02x", hashedByte));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

