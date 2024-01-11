import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


import com.farmacia.model.Cliente;

public class GerirClientes {
    private ArrayList<Cliente> clientes;
    private Scanner scanner;
    private MenuController menuController;  

    public GerirClientes(MenuController menuController) {
        this.clientes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.menuController = menuController; 

        adicionarClienteExemplo("Mariana Silva", "299955874", "987654321", "Rua Silva Junior, 123", LocalDate.of(1980, 1, 1), "joao.silva@gmail.com", "1234567890");
        adicionarClienteExemplo("Maria Souza", "987654321", "914333546", "Avenida Principal, 456", LocalDate.of(1985, 5, 10), "maria.souza@gmail.com", "9876543210");
        
    }

    private void adicionarClienteExemplo(String nome, String nif, String telefone, String morada, LocalDate dataNascimento, String email, String cartaoCliente) {
        Cliente novoCliente = new Cliente(nome, nif, telefone, morada, dataNascimento, email, cartaoCliente);
        clientes.add(novoCliente);
    }

    private void mostrarSubMenuClientes() {
        System.out.println("---- MENU GERIR CLIENTES ----");
        System.out.println("1. Cadastrar novo cliente");
        System.out.println("2. Exibir lista de clientes");
        System.out.println("3. Buscar cliente pelo NIF");
        System.out.println("4. Alterar dados do cliente");
        System.out.println("0. Sair");
        System.out.print("Escolha uma op��o: ");
    }

    public void exibirSubMenuClientes() {
        int opcao;

        do {
            mostrarSubMenuClientes();
            opcao = receberOpcaoSubMenuClientes();

            switch (opcao) {
                case 1:
                    cadastroCliente();
                    break;
                case 2:
                    listarClientesResumido();
                    break;
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                    return;
                default:
                    System.out.println("Op��o inv�lida. Escolha novamente.");
            }
        } while (opcao != 0);
    }

    private int receberOpcaoSubMenuClientes() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um n�mero v�lido.");
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
            System.out.println("Cart�o de Cliente: " + cliente.getCartaoCliente());
            System.out.println("Pontos de Fidelidade: " + cliente.getPontosFidelidade());

            // Menu de op��es
            System.out.println("\nOp��es:");
            System.out.println("1 - Remover Cliente");
            System.out.println("2 - Atualizar Dados do Cliente");
            System.out.println("3 - Voltar ao Menu Principal");
            System.out.print("Escolha uma op��o: ");

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
                    System.out.println("Op��o inv�lida!");
            }
        } else {
            System.out.println("Cliente n�o encontrado.");
        }
    }

    private void removerCliente(Cliente cliente) {
        System.out.print("Tem certeza que deseja remover este cliente? (sim/nao): ");
        String confirmacao = scanner.nextLine().toLowerCase();

        if (confirmacao.equals("sim")) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Remo��o cancelada.");
        }
    }

    private void atualizarCliente(Cliente cliente) {
        System.out.println("Atualiza??o de dados do cliente:");

        // Exibir op??es de atualiza??o
        System.out.println("Escolha uma op??o para atualizar:");
        System.out.println("1. Nome");
        System.out.println("2. NIF");
        System.out.println("3. Telefone");
        System.out.println("4. Morada");
        System.out.println("5. Data de Nascimento");
        System.out.println("6. Email");
        System.out.println("7. Cart?o de Cliente");
        System.out.println("8. Pontos de Fidelidade");
        System.out.println("0. Sair");

        System.out.print("Escolha uma op??o: ");
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
                    System.out.println("Formato de NIF inv?lido. O NIF deve ter exatamente 9 d?gitos.");
                }
                break;
            case 3:
                System.out.print("Digite o novo telefone: ");
                String novoTelefone = scanner.nextLine();
                if (novoTelefone.matches("9\\d{8}")) {
                    cliente.setTelefone(novoTelefone);
                    System.out.println("Telefone atualizado com sucesso.");
                } else {
                    System.out.println("N?mero de telefone inv?lido. Deve ter 9 d?gitos e come?ar com 9.");
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
                    System.out.println("Formato de data inv?lido. Use o formato dd/MM/yyyy.");
                }
                break;
            case 6:
                System.out.print("Digite o novo email: ");
                String novoEmail = scanner.nextLine();
                cliente.setEmail(novoEmail);
                System.out.println("Email atualizado com sucesso.");
                break;
            case 7:
                System.out.print("Digite o novo cart?o de cliente: ");
                String novoCartaoCliente = scanner.nextLine();
                cliente.setCartaoCliente(novoCartaoCliente);
                System.out.println("Cart?o de cliente atualizado com sucesso.");
                break;
            case 8:
                System.out.print("Digite os novos pontos de fidelidade: ");
                int novosPontosFidelidade = scanner.nextInt();
                cliente.setPontosFidelidade(novosPontosFidelidade);
                System.out.println("Pontos de fidelidade atualizados com sucesso.");
                break;
            case 0:
                System.out.println("Saindo da atualiza??o.");
                break;
            default:
                System.out.println("Op??o inv?lida.");
        }

        System.out.println("Dados atualizados com sucesso:");
        visualizarDetalhesCliente(cliente);
    }

    private Cliente encontrarClientePorNIF(String nifCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNif().equals(nifCliente)) {
                return cliente;
            }
        }
        return null;
    }

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente cadastroCliente() {
        System.out.println("Cadastro de novo cliente...");

        System.out.print("Nome completo: ");
        String nomeCompleto = scanner.nextLine();

        System.out.print("NIF: ");
        String nif = scanner.nextLine();

        if (!validarFormatoNIF(nif)) {
            System.out.println("Formato de NIF inv�lido. O NIF deve ter exatamente 9 d�gitos.");
            return null;
        }

        System.out.print("Telefone (9 d�gitos, come�ando com 9): ");
        String telefone = scanner.nextLine();
        if (!telefone.matches("9\\d{8}")) {
            System.out.println("N�mero de telefone inv�lido. Deve ter 9 d�gitos e come�ar com 9.");
            return null;
        }

        System.out.print("Morada: ");
        String morada = scanner.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Cart�o de cliente: ");
        String cartaoCliente = scanner.nextLine();

        Cliente novoCliente = new Cliente(nomeCompleto, nif, telefone, morada, dataNascimento, email, cartaoCliente);

        clientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso.");

        return novoCliente;
    }
    

    private boolean validarFormatoNIF(String nif) {
        // Verifica se o NIF tem  9 d�gitos
        return nif.matches("\\d{9}");
    }

    private void mostrarTodosClientes() {
        System.out.println("---- LISTA DE CLIENTES ----");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + " - " + cliente.getNif() + " " + cliente.getNomeCompleto());
        }
    }
}
