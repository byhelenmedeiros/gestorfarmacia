import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.Scanner;


import com.farmacia.model.Cliente;
import com.farmacia.*;

public class GerirClientes {
    private ArrayList<Cliente> clientes;
    private Scanner scanner;

    public  GerirClientes() {
        this.clientes = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // Exemplo de cliente 
        Cliente exemploCliente = new Cliente("João Silva", "123456789", "987654321", "Rua Exemplo, 123", "01/01/1980", "joao.silva@email.com", "1234567890");
        clientes.add(exemploCliente);
    }

    public int exibirSubMenuClientes() {
        int opcao;

        do {
            mostrarTodosClientes();
            opcao = exibirSubMenuClientes();

            switch (opcao) {
                case 1:
                    cadastroCliente();
                    break;
                case 2:
                    mostrarTodosClientes();
                    break;
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                    return;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 0);
    }

    public GerirClientes(MenuController menuController) {
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorNIF(String nif) {
        for (Cliente cliente : clientes) {
            if (cliente.getNif().equals(nif)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarClientesResumido() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + " - " + cliente.getNif() + " " + cliente.getNomeCompleto());
        }
    }

    public void visualizarDetalhesCliente(int idCliente) {
        Cliente cliente = encontrarClientePorID(idCliente);

        if (cliente != null) {
            System.out.println("Detalhes do Cliente:");
            System.out.println("Nome: " + cliente.getNomeCompleto());
            System.out.println("NIF: " + cliente.getNif());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Morada: " + cliente.getMorada());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Cartão de Cliente: " + cliente.getCartaoCliente());
            System.out.println("Pontos de Fidelidade: " + cliente.getPontosFidelidade());

            // Menu de opções
            System.out.println("\nOpções:");
            System.out.println("1 - Remover Cliente");
            System.out.println("2 - Atualizar Dados do Cliente");
            System.out.println("3 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    removerCliente(cliente);
                    break;
                case 2:
                    atualizarCliente(cliente);
                    break;
                case 3:
                   Controller.exibirMenuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

   

  
    private void removerCliente(Cliente cliente) {
        System.out.print("Tem certeza que deseja remover este cliente? (sim/nao): ");
        String confirmacao = scanner.nextLine().toLowerCase();

        if (confirmacao.equals("sim")) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Remoção cancelada.");
        }
    }

    private void atualizarCliente(Cliente cliente) {
    

        System.out.println("Atualização de dados do cliente...");
      
    }

    private Cliente encontrarClientePorID(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente cadastroCliente() {
    }

    public void mostrarTodosClientes() {
    }
}
