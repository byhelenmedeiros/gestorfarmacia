import com.farmacia.model.Cliente;
import com.farmacia.model.Medicamento;
import com.farmacia.model.Sessao;

import java.util.Scanner;

public class VendaController {
    private GerirMedicamentos gerirMedicamentos;
    private GerirClientes gerirClientes;
    private Sessao sessao;

    public VendaController(GerirMedicamentos gerirMedicamentos, GerirClientes gerirClientes, Sessao sessao) {
        this.gerirMedicamentos = gerirMedicamentos;
        this.gerirClientes = gerirClientes;
        this.sessao = sessao;
    }

    public void realizarVenda() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o NIF do cliente (ou deixe em branco para cadastrar um novo): ");
            String nifCliente = scanner.nextLine();

            Cliente cliente = gerirClientes.buscarClientePorNIF(nifCliente);

            if (cliente == null) {
                System.out.println("Cliente nao encontrado.");
                if (cadastrarNovoCliente(scanner)) {
                    cliente = gerirClientes.cadastroCliente();
                    System.out.println("Novo cliente cadastrado com sucesso.");
                } else {
                    System.out.println("Venda cancelada.");
                    return;
                }
            }

            System.out.println("\nCliente encontrado:");
            System.out.println("Nome: " + cliente.getNomeCompleto());
            System.out.println("NIF: " + cliente.getNif());

            mostrarListaMedicamentos();

            System.out.print("\nDigite o numero do medicamento para venda (ou 0 para cancelar): ");
            int opcaoVenda;

            try {
                opcaoVenda = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida. Venda cancelada.");
                return;
            }

            if (opcaoVenda >= 1 && opcaoVenda <= gerirMedicamentos.listaMedicamentos.size()) {
                Medicamento med = gerirMedicamentos.listaMedicamentos.get(opcaoVenda - 1);

                System.out.println("\nMedicamento selecionado: " + med.getNome());
                System.out.println("Quantidade em Estoque: " + med.getQuantidade());

                System.out.print("\nDeseja efetuar a venda deste medicamento para o cliente? (S/N): ");
                String opcaoVendaMedicamento = scanner.nextLine();

                if (opcaoVendaMedicamento.equalsIgnoreCase("S")) {
                    processarVenda(scanner, cliente, med);
                } else {
                    System.out.println("Venda cancelada.");
                }
            } else if (opcaoVenda == 0) {
                System.out.println("Venda cancelada.");
            } else {
                System.out.println("Opcao invalida. Venda cancelada.");
            }
        }
    }

    private boolean cadastrarNovoCliente(Scanner scanner) {
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
