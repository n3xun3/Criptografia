package menu;

import authentication.UserAuthentication;
import encryption.SymmetricEncryption;

import java.util.Scanner;

/**
 * Clase para mostrar el menú de la aplicación y manejar las interacciones del usuario.
 */
public class ApplicationMenu {
    private final SymmetricEncryption symmetricEncryption;
    private final UserAuthentication userAuthentication;

    /**
     * Constructor para ApplicationMenu.
     * @throws Exception Excepción en caso de problemas durante la inicialización.
     */
    public ApplicationMenu() throws Exception {
        symmetricEncryption = new SymmetricEncryption();
        userAuthentication = new UserAuthentication();
    }

    /**
     * Muestra el menú de la aplicación y maneja las opciones seleccionadas por el usuario.
     * @throws Exception Excepción en caso de problemas durante la ejecución del menú.
     */
    public void mostrarMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------- Menú -------------");
            System.out.println("1. Encriptar frase");
            System.out.println("2. Desencriptar frase");
            System.out.println("3. Salir del programa");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la frase a encriptar: ");
                    String frase = scanner.nextLine();
                    String fraseEncriptada = symmetricEncryption.encriptarFrase(frase);
                    System.out.println("Frase encriptada: " + fraseEncriptada);
                    break;
                case 2:
                    System.out.print("Ingrese la frase encriptada: ");
                    String fraseEncriptadaStr = scanner.nextLine();
                    String fraseDesencriptada = symmetricEncryption.desencriptarFrase(fraseEncriptadaStr);
                    System.out.println("Frase desencriptada: " + fraseDesencriptada);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    /**
     * Autentica un usuario.
     * @param usuario Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @return Verdadero si las credenciales son válidas, falso en caso contrario.
     */
    public boolean autenticarUsuario(String usuario, String contrasena) {
        return userAuthentication.autenticarUsuario(usuario, contrasena);
    }
}
