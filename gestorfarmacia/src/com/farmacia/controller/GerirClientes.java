import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.farmacia.model.Cliente;

public class GerirClientes {
    private ArrayList<Cliente> clientes;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public GerirClientes() {
        this.clientes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Exemplo de cliente
        Cliente exemploCliente = new Cliente("João Silva", "123456789", "987654321", "Rua Exemplo, 123", "01/01/1980", "joao.silva@email.com", "1234567890");
        clientes.add(exemploCliente);
    }

    public void exibirSubMenuClientes() {
        int opcao;

        do {
            mostrarTodosClientes();
            opcao = receberOpcaoSubMenuClientes();

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

    private int receberOpcaoSubMenuClientes() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
        }
        return scanner.nextInt();
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

    public void visualizarDetalhesCliente(String nifCliente) {
        Cliente cliente = encontrarClientePorNIF(nifCliente);

        if (cliente != null) {
            System.out.println("Detalhes do Cliente:");
            System.out.println("Nome: " + cliente.getNomeCompleto());
            System.out.println("NIF: " + cliente.getNif());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Morada: " + cliente.getMorada());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento().format(formatter));
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
                    System.out.println("Voltando ao Menu Principal.");
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
        System.out.println("Atualização de dados do cliente:");

        // Exibir opções de atualização
        System.out.println("Escolha uma opção para atualizar:");
        System.out.println("1. Nome");
        System.out.println("2. NIF");
        System.out.println("3. Telefone");
        System.out.println("4. Morada");
        System.out.println("5. Data de Nascimento");
        System.out.println("6. Email");
        System.out.println("7. Cartão de Cliente");
        System.out.println("8. Pontos de Fidelidade");
        System.out.println("0. Sair");

        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (escolha) {
            case 1:
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                cliente.setNomeCompleto(novoNome);
                System.out.println("Nome atualizado com sucesso.");
                break;
            case 2:
                System.out.print("Digite o novo NIF: ");
                String novoNIF = scanner.nextLine();
                if (validarFormatoNIF(novoNIF)) {
                    cliente.setNif(novoNIF);
                    System.out.println("NIF atualizado com sucesso.");
                } else {
                    System.out.println("Formato de NIF inválido. O NIF deve ter exatamente 9 dígitos.");
                }
                break;
            case 3:
                System.out.print("Digite o novo telefone: ");
                String novoTelefone = scanner.nextLine();
                if (novoTelefone.matches("9\\d{8}")) {
                    cliente.setTelefone(novoTelefone);
                    System.out.println("Telefone atualizado com sucesso.");
                } else {
                    System.out.println("Número de telefone inválido. Deve ter 9 dígitos e começar com 9.");
                }
                break;
            case 4:
                System.out.print("Digite a nova morada: ");
                String novaMorada = scanner.nextLine();
                cliente.setMorada(novaMorada);
                System.out.println("Morada atualizada com sucesso.");
                break;
            case 5:
                System.out.print("Digite a nova data de nascimento (dd/MM/yyyy): ");
                String novaDataNascimentoStr = scanner.nextLine();
                try {
                    LocalDate novaDataNascimento = LocalDate.parse(novaDataNascimentoStr, formatter);
                    cliente.setDataNascimento(novaDataNascimento);
                    System.out.println("Data de nascimento atualizada com sucesso.");
                } catch (Exception e) {
                    System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
                }
                break;
            case 6:
                System.out.print("Digite o novo email: ");
                String novoEmail = scanner.nextLine();
                cliente.setEmail(novoEmail);
                System.out.println("Email atualizado com sucesso.");
                break;
            case 7:
                System.out.print("Digite o novo cartão de cliente: ");
                String novoCartaoCliente = scanner.nextLine();
                cliente.setCartaoCliente(novoCartaoCliente);
                System.out.println("Cartão de cliente atualizado com sucesso.");
                break;
            case 8:
                System.out.print("Digite os novos pontos de fidelidade: ");
                int novosPontosFidelidade = scanner.nextInt();
                cliente.setPontosFidelidade(novosPontosFidelidade);
                System.out.println("Pontos de fidelidade atualizados com sucesso.");
                break;
            case 0:
                System.out.println("Saindo da atualização.");
                break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.println("Dados atualizados com sucesso:");
        exibirDetalhesCliente(cliente);
    }

    private Cliente encontrarClientePorNIF(String nifCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNif().equals(nifCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente cadastroCliente() {
        System.out.println("Cadastro de novo cliente...");

        System.out.print("Nome completo: ");
        String nomeCompleto = scanner.nextLine();

        System.out.print("NIF: ");
        String nif = scanner.nextLine();

        if (!validarFormatoNIF(nif)) {
            System.out.println("Formato de NIF inválido. O NIF deve ter exatamente 9 dígitos.");
            return null;
        }

        System.out.print("Telefone (9 dígitos, começando com 9): ");
        String telefone = scanner.nextLine();

        if (!telefone.matches("9\\d{8}")) {
            System.out.println("Número de telefone inválido. Deve ter 9 dígitos e começar com 9.");
            return null;
        }

        System.out.print("Morada: ");
        String morada = scanner.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        try {
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
            // Restante da lógica de cadastro...
            Cliente novoCliente = new Cliente(nomeCompleto, nif, telefone, morada, dataNascimento, null, null);
            clientes.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso.");
            return novoCliente;
        } catch (Exception e) {
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
            return null;
        }
    }

    private boolean validarFormatoNIF(String nif) {
        // Verifica se o NIF tem  9 dígitos
        return nif.matches("\\d{9}");
    }

    private void mostrarTodosClientes() {
        System.out.println("---- LISTA DE CLIENTES ----");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + " - " + cliente.getNif() + " " + cliente.getNomeCompleto());
        }
    }
}
