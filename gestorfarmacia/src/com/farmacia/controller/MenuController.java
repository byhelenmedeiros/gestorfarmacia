import java.util.Scanner;
import com.farmacia.model.Sessao;
import com.farmacia.controller.GerirFinanceiro;  
import com.farmacia.controller.GerirMedicamentos; 
import com.farmacia.controller.GerirClientes;  

public class MenuController {
    private Scanner scanner;
    private GerirMedicamentos gerirMedicamentos;
    private GerirClientes gerirClientes;
    private Sessao sessao;
    private VendaController vendaController;

    public MenuController() {
        this.scanner = new Scanner(System.in);
        this.sessao = new Sessao();  
        this.gerirMedicamentos = new GerirMedicamentos(this);
        this.gerirClientes = new GerirClientes(this);
        this.vendaController = new VendaController(gerirMedicamentos, gerirClientes, sessao);
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
        System.out.println("3. Controle financeiro");
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

