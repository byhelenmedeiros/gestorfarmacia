import java.util.Scanner;
import com.farmacia.model.Cliente;
import com.farmacia.model.Medicamento;

public class VendaController {
    private GerirMedicamentos gerirMedicamentos;
    private GerirClientes gerirClientes;
    private Scanner scanner;

    public VendaController(GerirMedicamentos gerirMedicamentos, GerirClientes gerirClientes, Scanner scanner) {
        this.gerirMedicamentos = gerirMedicamentos;
        this.gerirClientes = gerirClientes;
        this.scanner = scanner;
    }

    public void realizarVenda() {
        System.out.print("Digite o NIF do cliente (ou deixe em branco para cadastrar um novo): ");
        int nifCliente;
        try {
            nifCliente = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("NIF inválido. Venda cancelada.");
            return;
        }

        Cliente cliente = gerirClientes.buscarClientePorNIF(nifCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            if (cadastrarNovoCliente()) {
                cliente = gerirClientes.cadastrarCliente();
                System.out.println("Novo cliente cadastrado com sucesso.");
            } else {
                System.out.println("Venda cancelada.");
                return;
            }
        }
    
    }
    private boolean cadastrarNovoCliente() {
        System.out.print("Deseja cadastrar um novo cliente? (S/N): ");
        String opcaoCadastro = scanner.nextLine();
        return opcaoCadastro.equalsIgnoreCase("S");
    }


    private void mostrarListaMedicamentos() {
        System.out.println("\nMedicamentos Disponiveis para Venda:");
        int numeroMedicamento = 1;
        for (Medicamento med : gerirMedicamentos.listaMedicamentos) {
            System.out.println(numeroMedicamento + ". " + med.getNome());
            numeroMedicamento++;
        }
    }

    private void processarVenda(Scanner scanner, Cliente cliente, Medicamento medicamento) {
        double precoTotal = medicamento.getPreco();
        System.out.println("\nPreco total da venda: ?" + precoTotal);

        System.out.print("Forma de pagamento (Multibanco/Dinheiro): ");
        String formaPagamento = scanner.nextLine();

        if (formaPagamento.equalsIgnoreCase("Dinheiro")) {
            System.out.print("Digite o valor em dinheiro: ");
            double valorPago;
            try {
                valorPago = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Venda cancelada.");
                return;
            }

            if (valorPago < precoTotal) {
                System.out.println("Valor menor que o do medicamento. Venda cancelada.");
            } else {
                double troco = valorPago - precoTotal;
                System.out.println("Venda concluida para o cliente " + cliente.getNome() + ".");
                System.out.println("Troco: ?" + troco);

            }
        } else if (formaPagamento.equalsIgnoreCase("Multibanco")) {
            System.out.println("Insira o cartao no leitor.");
            System.out.println("Compra concluida.");

                    } else {
            System.out.println("Forma de pagamento invalida. Venda cancelada.");
        }
    }
}
