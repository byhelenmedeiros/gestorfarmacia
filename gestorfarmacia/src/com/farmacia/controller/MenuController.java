import java.util.Scanner;

public class MenuController {
    private Scanner scanner;
    private GerirMedicamentos gerirMedicamentos;
    private GerirClientes gerirClientes;
    private VendaController vendaController;
    private Sessao sessao; 

    public MenuController() {
        this.scanner = new Scanner(System.in);
        this.gerirMedicamentos = new GerirMedicamentos(this);
        this.gerirClientes = new GerirClientes(this);
        this.vendaController = new VendaController(gerirMedicamentos, gerirClientes, sessao);
        this.sessao = new Sessao();
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
                    System.out.println("Escolheu Relat�rio de Vendas.");
                    break;
                case 4:
                    System.out.println("Voc� escolheu gerir funcion�rios.");
                    break;
                case 5:
                    gerirClientes.exibirSubMenuClientes();
                    break;
                case 8:
                    System.out.println("Escolheu Obter n�mero total de vendas.");
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("Saindo.");
                    break;
                default:
                    System.out.println("Op��o inv�lida. Escolha novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void mostrarMenuPrincipal() {
        System.out.println("---- MENU PRINCIPAL ----");
        System.out.println("1. Registrar Venda");
        System.out.println("2. Gerir Medicamentos");
        System.out.println("3. Relat�rio de Vendas");
        System.out.println("4. Gerir Funcion�rios");
        System.out.println("5. Gerir Clientes");
        System.out.println("8. Obter n�mero total de vendas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma op��o: ");
    }

    private int receberOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um n�mero v�lido.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}

