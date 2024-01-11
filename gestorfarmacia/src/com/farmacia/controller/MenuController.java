
import java.util.Scanner;

import com.farmacia.model.Medicamento;
import com.farmacia.model.Funcionarios;
import com.farmacia.model.Cliente;

public class MenuController {
    private Scanner scanner;
    private GerirMedicamentos gerirMedicamentos;
    private GerirClientes gerirClientes;
     private VendaController vendaController;



    public MenuController() {
        this.scanner = new Scanner(System.in);
        this.gerirMedicamentos = new GerirMedicamentos(this); 
        this.gerirClientes = new GerirClientes(this); 
        this.vendaController = new VendaController(gerirMedicamentos, gerirClientes);


    }

    public void exibirMenuPrincipal() {
        int opcao;

        do {
            mostrarMenuPrincipal();
            opcao = receberOpcao();

            switch (opcao) {
                    case 1:
                    VendaController.realizarVenda();
                    break;

                case 2:
                    exibirMenuMedicamentos(); // Opção para gerir medicamentos
                    break;
                case 3:
                    System.out.println("Escolheu Relatório de Vendas.");
                    break;
                case 4:
                    System.out.println("Voc� escolheu gerir funcionarios.");
                        GerirFuncionarios();
                    break;
                case 5:
                    exibirMenuClientes();
                    break;
                case 8:
                    System.out.println("Escolheu Obter número total de vendas.");
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("Saindo.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }



    private void exibirMenuClientes() {
        int opcao;

        do {
            mostrarSubMenuClientes();
            opcao = receberOpcaoSubMenuClientes();

            switch (opcao) {
                case 1:
                    gerirClientes.cadastroCliente();
                    break;
                case 2:
                    gerirClientes.mostrarTodosClientes();
                    break;
                
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                    return;
                default:
                    System.out.println("Op��o inv�lida. Escolha novamente.");
            }
        } while (opcao != 0);
    }

            private void mostrarSubMenuClientes() {
                System.out.println("------ GESTAO DE CLIENTES ------");
                System.out.println("1. Cadastrar Novo Cliente");
                System.out.println("2. Mostrar Todos os Clientes");
                System.out.println("0. Voltar para o Menu Principal");
                System.out.print("Escolha uma op��o: ");
            }

            private int receberOpcaoSubMenuClientes() {
                while (true) {
                    int opcao = scanner.nextInt();
                    if (opcao >= 0 && opcao <= 2) { 
                        return opcao;
                    } else {
                        System.out.println("Op��o inv�lida. Escolha novamente.");
                    }
                }
            }
        

    private void GerirFuncionarios() {
    }

    private void exibirMenuMedicamentos() {
        int opcao;
    
        do {
            mostrarSubMenuMedicamentos();
            opcao = receberOpcaoSubMenu();
    
            switch (opcao) {
                case 1:
                        gerirMedicamentos.cadastroMedicamento(); // Opção para cadastrar medicamento
                    break;
                case 2:
                        gerirMedicamentos.mostrarTodosMedicamentos(); // Opção para mostrar todos os medicamentos
                    break;
                case 3:
                    System.out.println("Escolheu Vender Medicamento.");
                    break;
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                    return; // Retorna ao menu principal
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
    

    private void mostrarMenuPrincipal() {
        System.out.println("---- MENU PRINCIPAL ----");
        System.out.println("1. Registrar Venda");
        System.out.println("2. Gerir Medicamentos");
        System.out.println("3. Relatorio de Vendas");
        System.out.println("4. Gerir Funcionarios");
        System.out.println("5. Gerir Clientes"); 
        System.out.println("8. Obter número total de vendas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

        private void mostrarSubMenuMedicamentos() {
            System.out.println("------ GESTAO DE MEDICAMENTOS------");
            System.out.println("1. Cadastrar Novo Medicamento");
            System.out.println("2. Mostrar Todos os Medicamentos");
            System.out.println("3. Vender Medicamento");
            System.out.println("4. Mostrar relat�rio de medicamentos");
            System.out.println("0. Voltar para o Menu Principal");
            System.out.print("Escolha uma opcao: ");
        }

    private int receberOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private int receberOpcaoSubMenu() {
        while (true) {
            int opcao = scanner.nextInt();
            if (opcao >= 0 && opcao <= 3) {
                return opcao;
            } else {
                System.out.println("Opcao inválida. Escolha novamente.");
            }
        }
    }
}
