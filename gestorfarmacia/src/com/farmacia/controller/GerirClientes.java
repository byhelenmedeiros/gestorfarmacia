import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.farmacia.model.Cliente;



public class GerirClientes {
    private static List<Cliente> clientes;
    private Scanner scanner;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    

    public GerirClientes(MenuController menuController) {
        GerirClientes.clientes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }


    private void mostrarSubMenuClientes() {
        System.out.println("---- MENU GERIR CLIENTES ----");
        System.out.println("1. Cadastrar novo cliente");
        System.out.println("2. Exibir lista de clientes resumida");
        System.out.println("3. Exibir lista de clientes detalhada");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void exibirSubMenuClientes() {
        int opcao;

        do {
            mostrarSubMenuClientes();
            opcao = receberOpcaoSubMenuClientes();

            switch (opcao) {
                case 1:
                    cadastrarEExibirCliente();
                    break;
                case 2:
                    listarClientesResumido();
                    break;
                case 3:
                    listarClientesDetalhado();
                    break;
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                    break;
                default:
                    System.out.println("OPCAO INVALIDA. Escolha novamente.");
            }
        } while (opcao != 0);
    }

    private int receberOpcaoSubMenuClientes() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um numero valido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void cadastrarEExibirCliente() {
        Cliente novoCliente = cadastrarCliente();
        System.out.println("Cliente cadastrado com sucesso:");
        visualizarDetalhesCliente(novoCliente);
    }

    Cliente cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
           String nome = scanner.nextLine();
        
           System.out.print("Digite o NIF do cliente: ");
            int nif = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o telefone do cliente: ");
            int telefone = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite a morada do cliente: ");
            String morada = scanner.nextLine();
        System.out.print("Digite a data de nascimento do cliente (dd/MM/yyyy): ");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        System.out.print("Digite o email do cliente: ");
            String email = scanner.nextLine();
        System.out.print("Digite o cartão de cliente do cliente: ");
            int cartaoCliente = scanner.nextInt();

        Cliente novoCliente = new Cliente(nome, nif, telefone, morada, dataNascimento, email, cartaoCliente);
        clientes.add(novoCliente);

        return novoCliente;  // Retornando o novo cliente
    }

    private void listarClientesResumido() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + " - " + cliente.getNif() + " " + cliente.getNomeCompleto());
        }
    }

    private void listarClientesDetalhado() {
        for (Cliente cliente : clientes) {
            visualizarDetalhesCliente(cliente);
            System.out.println("----------------------");
        }
    }

    private void visualizarDetalhesCliente(Cliente cliente) {
        System.out.println("Detalhes do Cliente:");
        System.out.println("Nome: " + cliente.getNomeCompleto());
        System.out.println("NIF: " + cliente.getNif());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Morada: " + cliente.getMorada());
        System.out.println("Data de Nascimento: " + cliente.getDataNascimento().format(formatter));
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Cartão de Cliente: " + cliente.getCartaoCliente());
        System.out.println("Pontos de Fidelidade: " + cliente.getPontosFidelidade());
    }

    public static void getClientes() {
        if (clientes == null) {
            return;
        }
    }
    public Cliente buscarClientePorNIF(int nifCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNif() == nifCliente) {
                return cliente;
            }
        }
        return null;
    }
    
    

}

