import menu.ApplicationMenu;

import java.util.Scanner;

/**
 * Clase principal que maneja la autenticación y ejecución del menú de la aplicación.
 */
public class Main {
    /**
     * Método principal para ejecutar la aplicación.
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     * @throws Exception Excepción en caso de problemas durante la ejecución del programa.
     */
    public static void main(String[] args) throws Exception {
        ApplicationMenu appMenu = new ApplicationMenu();
        int intentos = 3;

        while (intentos > 0) {
            System.out.print("Ingrese su nombre de usuario: ");
            Scanner scanner = new Scanner(System.in);
            String usuario = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            if (appMenu.autenticarUsuario(usuario, contrasena)) {
                System.out.println("Bienvenido, " + usuario);
                appMenu.mostrarMenu();
                break;
            } else {
                System.out.println("Credenciales incorrectas. Intentos restantes: " + (intentos - 1));
                intentos--;
            }
        }

        if (intentos == 0) {
            System.out.println("Máximo de intentos alcanzado. Programa terminado.");
        }
    }
}
