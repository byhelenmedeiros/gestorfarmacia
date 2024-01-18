

import java.util.UUID;
import com.farmacia.model.Medicamento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GerirMedicamentos {
    List<Medicamento> listaMedicamentos;
    private Scanner scanner;
    private DateTimeFormatter formatter;
    private MenuController menuController;
    private VendaController vendaController;  


    public GerirMedicamentos(MenuController menuController) {
        this.listaMedicamentos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.menuController = menuController;
        this.vendaController = vendaController;
    }

    public void exibirSubMenuMedicamentos() {
        int opcao;

        mostrarMenu();

        do {
            opcao = receberOpcaoSubMenu();

            switch (opcao) {
                case 1:
                    cadastroMedicamento();
                    break;
                case 2:
                    mostrarTodosMedicamentos();
                    break;
                case 3:
                    vendaController.realizarVenda();                     break;
                case 4:
                    gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 0);

    }

    private void mostrarMenu() {
        System.out.println("------ GERIR MEDICAMENTOS ------");
        System.out.println("1. Cadastrar Medicamento");
        System.out.println("2. Mostrar Todos os Medicamentos");
        System.out.println("3. Realizar Venda");
        System.out.println("4. Gerar Relatorio");
        System.out.println("0. Voltar para o Menu Principal");
        System.out.print("Escolha uma opcao: ");
    }

    private int receberOpcaoSubMenu() {
        while (true) {
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= 0 && opcao <= 4) {
                    return opcao;
                } else {
                    System.out.println("OPCAO INVALIDA  Escolha novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um numero valido.");
            }
        }
    }

    public void cadastroMedicamento() {
        boolean continuarCadastro = true;

        while (continuarCadastro) {
            System.out.println("------Cadastro de novos medicamentos------");
            System.out.print("Nome do Medicamento: ");
            String nome = scanner.nextLine();
            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            System.out.print("Data de Validade (dd/MM/yyyy): ");
            String dataValidadeStr = scanner.nextLine();
            LocalDate dataValidade = LocalDate.parse(dataValidadeStr, formatter);
            System.out.print("Descricao do medicamento: ");
            String descricao = scanner.nextLine();
            System.out.print("Preco: ");
            double preco = Double.parseDouble(scanner.nextLine());
            System.out.print("Tipo de medicamento: ");
            String tipo = scanner.nextLine();

            Medicamento novoMedicamento = new Medicamento(nome, quantidade, dataValidade, descricao, preco, tipo);
            listaMedicamentos.add(novoMedicamento);

            System.out.println("Medicamento cadastrado com sucesso! Deseja cadastrar outro medicamento?");
            System.out.println("1 - Nao");
            System.out.println("2 - Sim, continuar cadastro de medicamentos");
            System.out.println("3 - Voltar para menu principal");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    continuarCadastro = false;
                    break;
                case 2:
                    continuarCadastro = true;
                    break;
                case 3:
                    menuController.exibirMenuPrincipal(); // Chama o menu principal
                    return;
                default:
                    System.out.println("Escolha invvlida, encerrando cadastro de medicamentos!");
                    continuarCadastro = false;
                    break;
            }
        }
    }

    public void mostrarTodosMedicamentos() {
        if (listaMedicamentos.isEmpty()) {
            System.out.println("Nao tem medicamentos cadastrados.");
        } else {
            System.out.println("Detalhes de todos os medicamentos cadastrados:");
            for (Medicamento medicamento : listaMedicamentos) {
                System.out.println("ID: " + medicamento.getId());
                System.out.println("Nome: " + medicamento.getNome());
                System.out.println("Quantidade em Estoque: " + medicamento.getQuantidade());
                System.out.println("Data de Validade: " + medicamento.getDataValidade().format(formatter));
                System.out.println("Descricao: " + medicamento.getDescricao());
                System.out.println("Preco: ?" + medicamento.getPreco());
                System.out.println("Tipo: " + medicamento.getTipo());
                System.out.println("--------------------------------------");
            }
        }
    }

    public void gerarRelatorio() {
        System.out.println("Relatorio de Medicamentos:\n");
        for (Medicamento medicamento : listaMedicamentos) {
            System.out.println("Nome: " + medicamento.getNome());
            System.out.println("Quantidade: " + medicamento.getQuantidade());
            System.out.println("Preco: " + medicamento.getPreco());
            System.out.println("------------------------------------");
        }
    }
}