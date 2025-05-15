package gerenciadorsenhas;

import controller.AuthController;
import controller.PasswordController;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Gerenciador de Senhas ===\n");

        AuthController auth = new AuthController();

        if (auth.login()) {
            PasswordController pc = new PasswordController();
            pc.menu();
        } else {
            System.out.println("\nFalha na autenticação. Encerrando...");
        }
    }
}
