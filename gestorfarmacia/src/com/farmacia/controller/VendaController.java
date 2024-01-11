import com.farmacia.model.Cliente;
import com.farmacia.model.Medicamento;
import java.util.Scanner;

public class VendaController {
    private GerirMedicamentos gerirMedicamentos;
    private GerirClientes gerirClientes;
    private Sessao sessao; 

    public VendaController(GerirMedicamentos gerirMedicamentos, GerirClientes gerirClientes) {
        this.gerirMedicamentos = gerirMedicamentos;
        this.gerirClientes = gerirClientes;
        this.sessao = sessao; // Injeta a instância de Sessao

    }

    public void realizarVenda() {
        sessao.setClienteAtual(clienteAtual);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o NIF do cliente (ou deixe em branco para cadastrar um novo): ");
        String nifCliente = scanner.nextLine();

        Cliente cliente = gerirClientes.buscarClientePorNIF(nifCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");

            // Pergunta se deseja cadastrar um novo cliente
            System.out.print("Deseja cadastrar um novo cliente? (S/N): ");
            String opcaoCadastro = scanner.nextLine();

            if (opcaoCadastro.equalsIgnoreCase("S")) {
                gerirClientes.cadastroCliente();
                cliente = gerirClientes.buscarClientePorNIF(nifCliente); // Recarrega o cliente após o cadastro
                System.out.println("Novo cliente cadastrado com sucesso.");
            } else {
                System.out.println("Venda cancelada.");
                scanner.close();
                return;
                
                
            }
            
        } 

     

        System.out.println("\nCliente encontrado:");
        System.out.println("Nome: " + cliente.getNomeCompleto());
        System.out.println("NIF: " + cliente.getNif());

        System.out.println("\nMedicamentos Disponíveis para Venda:");
        mostrarListaMedicamentos();

        System.out.print("\nDigite o número do medicamento para venda (ou 0 para cancelar): ");
        int opcaoVenda;
        try {
            opcaoVenda = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida. Venda cancelada.");
                scanner.close();
            return;
        }

        if (opcaoVenda >= 1 && opcaoVenda <= gerirMedicamentos.listaMedicamentos.size()) {
            Medicamento med = gerirMedicamentos.listaMedicamentos.get(opcaoVenda - 1);

            System.out.println("\nMedicamento selecionado: " + med.getNome());
            System.out.println("Quantidade em Estoque: " + med.getQuantidade());

            System.out.print("\nDeseja efetuar a venda deste medicamento para o cliente? (S/N): ");
            String opcaoVendaMedicamento = scanner.nextLine();

            if (opcaoVendaMedicamento.equalsIgnoreCase("S")) {
                // Lógica para concluir a venda
                System.out.println("Venda concluída para o cliente " + cliente.getNome() + ".");
                // ...
            } else {
                System.out.println("Venda cancelada.");
            }
        } else if (opcaoVenda == 0) {
            System.out.println("Venda cancelada.");
        } else {
            System.out.println("Opção inválida. Venda cancelada.");
             scanner.close();
        }
        

        
    }

    private void mostrarListaMedicamentos() {
        int numeroMedicamento = 1;
        for (Medicamento med : gerirMedicamentos.listaMedicamentos) {
            System.out.println(numeroMedicamento + ". " + med.getNome());
            numeroMedicamento++;
        }
    }

    Cliente clienteAtual = sessao.getClienteAtual();
    
}



