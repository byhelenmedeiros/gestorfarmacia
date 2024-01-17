
import java.util.Scanner;

public class MenuController {
    private GerirMedicamentos gerirMedicamentos;
    private GerirClientes gerirClientes;
    private VendaController vendaController;
    private Scanner scanner;

    public MenuController() {
        this.scanner = new Scanner(System.in);
        this.gerirMedicamentos = new GerirMedicamentos(this);
        this.gerirClientes = new GerirClientes(this);
        this.vendaController = new VendaController(gerirMedicamentos, gerirClientes, scanner);
    }

    public void exibirMenuPrincipal() {
        int opcao;

        do {
            mostrarMenuPrincipal();
            opcao = receberOpcao();

            switch (opcao) {
                case 1:
                    vendaController.realizarVenda();
                    break;
                case 2:
                    gerirMedicamentos.exibirSubMenuMedicamentos();
                    break;
                case 3:
                    GerirFinanceiro gerirFinanceiro = new GerirFinanceiro();
                    gerirFinanceiro.exibirSubMenuFinanceiro();
                    break;
                case 4:
                    System.out.println("Voce escolheu gerir funcionarios.");
                    GerirFuncionarios.cadastrarFuncionario();
                    break;
                case 5:
                    gerirClientes.exibirSubMenuClientes();
                    break;
                case 8:
                    System.out.println("Escolheu Obter numero total de vendas.");
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("Saindo.");
                    break;
                default:
                    System.out.println("Opcao invalida. Escolha novamente.");
            }
        } while (opcao != 0);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("---- MENU PRINCIPAL ----");
        System.out.println("1. Registrar Venda");
        System.out.println("2. Gerir Medicamentos");
        System.out.println("3. Controle financeiro");
        System.out.println("4. Cadastro de funcionario");
        System.out.println("5. Gerir Clientes");
        System.out.println("8. Obter numero total de vendas");
        System.out.println("0. Sair");
    }

    private int receberOpcao() {
        System.out.print("Escolha uma opcao: ");

        while (!scanner.hasNextInt()) {
            scanner.nextLine(); 
            System.out.println("Por favor, digite um numero valido.");
        }

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        return opcao;
    }
}
