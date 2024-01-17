import com.farmacia.controller.MenuController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (autenticarAdmin()) {
            System.out.println("*********Autenticação bem-sucedida.********");
            System.out.println("//----Bem-vindo ao PharmaGest!-----//");
            MenuController menuController = new MenuController();
            menuController.exibirMenuPrincipal();
        } else {
            System.out.println("Falha na autenticação. Acesso negado.");
        }
    }

    private static boolean autenticarAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        scanner.close();

        return "admin".equals(usuario) && "123".equals(senha);
    }
}
