import java.util.Scanner;
import com.farmacia.controller;

public class Main {
    public static void main(String[] args) {
        if (autenticarAdmin()) {
            System.out.println("Autenticação bem-sucedida. Bem-vindo ao PharmaGest!");
            MenuController menuController = new MenuController();
            menuController.exibirMenuPrincipal();
        } else {
            System.out.println("Falha na autenticação. Acesso negado.");
        }
    }

    private static boolean autenticarAdmin() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Usuário: ");
            String usuario = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            return "admin".equals(usuario) && "123".equals(senha);
        }
    }
}
