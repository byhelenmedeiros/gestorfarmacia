

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

    listaMedicamentos.add(new Medicamento("Paracetamol", 100, LocalDate.parse("01/01/2023", formatter), "Analgésico", 10.5, "Comprimido"));
    listaMedicamentos.add(new Medicamento("Ibuprofeno", 50, LocalDate.parse("01/01/2023", formatter), "Anti-inflamatório", 15.75, "Comprimido"));
    listaMedicamentos.add(new Medicamento("Dipirona", 75, LocalDate.parse("01/01/2023", formatter), "Analgésico", 8.2, "Gotas"));


    public GerirMedicamentos(MenuController menuController) {
        this.listaMedicamentos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.menuController = menuController; 
    }

    public void exibirSubMenuMedicamentos() {
        int opcao;

        do {
            mostrarSubMenuMedicamentos();
            opcao = receberOpcaoSubMenu();

            switch (opcao) {
                case 1:
                    cadastroMedicamento();
                    break;
                case 2:
                    mostrarTodosMedicamentos();
                    break;
                case 3:
                    realizarVenda();
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                    return;
                default:
                    System.out.println("OpÃ§Ã£o invÃ¡lida. Escolha novamente.");
            }
        } while (opcao != 0);
    }

    /**
     * 
     */
    public void cadastroMedicamento() {
        boolean continuarCadastro = true;

        while (continuarCadastro) {
            System.out.println("------Cadastro de novos medicamentos------");
                System.out.println("Nome do Medicamento: ");
                    String nome = scanner.nextLine();
            System.out.println("Quantidade: ");
                int quantidade = Integer.parseInt(scanner.nextLine());
            System.out.println("Data de Validade (dd/MM/yyyy): ");
                String dataValidadeStr = scanner.nextLine();
                    LocalDate dataValidade = LocalDate.parse(dataValidadeStr, formatter);
            System.out.println("Descrição do medicamento: ");
            String descricao = scanner.nextLine();
            System.out.println("Preço: ");
                double preco = Double.parseDouble(scanner.nextLine());
            System.out.println("Tipo de medicamento: ");
                String tipo = scanner.nextLine();
    
            Medicamento novoMedicamento = new Medicamento(nome, quantidade, dataValidade, descricao, preco, tipo);
            listaMedicamentos.add(novoMedicamento);
    
            System.out.println("Medicamento cadastrado com sucesso! Pretende cadastrar novo medicamento ?");
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
                    System.out.println("Escolha inválida, encerrando cadastro de medicamentos!");
                    continuarCadastro = false;
                    break;
            }
        }
    }

    public void mostrarTodosMedicamentos() {
        if (listaMedicamentos.isEmpty()) {
            System.out.println("Não há medicamentos cadastrados.");
        } else {
            System.out.println("Detalhes de todos os medicamentos cadastrados:");
            for (Medicamento medicamento : listaMedicamentos) {
                System.out.println("ID: " + medicamento.getId()); 
                System.out.println("Nome: " + medicamento.getNome());
                System.out.println("Quantidade em Estoque: " + medicamento.getQuantidade());
                System.out.println("Data de Validade: " + medicamento.getDataValidade().format(formatter));
                System.out.println("Descrição: " + medicamento.getDescricao());
                System.out.println("Preço: ?" + medicamento.getPreco()); 
                System.out.println("Tipo: " + medicamento.getTipo());
                System.out.println("--------------------------------------");
            }
        }
    }

    /**
     * @param medicamento
     * @param quantidadeAVender
     */
    public void vender(Medicamento medicamento, int quantidadeAVender) {
        if (quantidadeAVender <= medicamento.getQuantidade() && quantidadeAVender > 0) {
            medicamento.setQuantidade(medicamento.getQuantidade() - quantidadeAVender);
            System.out.println(quantidadeAVender + " unidades de " + medicamento.getNome() + " vendidas.");
        } else {
            System.out.println("Quantidade inválida para venda.");
        }
    }

    public void mostrarListaVenda() {
        if (listaMedicamentos.isEmpty()) {
            System.out.println("NÃO HÁ MEDICAMENTOS CADASTRADOS.");
        } else {
            System.out.println("Lista de Medicamentos Disponíveis para Venda:");
            for (int i = 0; i < listaMedicamentos.size(); i++) {
                Medicamento medicamento = listaMedicamentos.get(i);
                System.out.println((i + 1) + ". " + medicamento.getNome() + " - Quantidade: " + medicamento.getQuantidade());
            }
        }
    }
    
    
    
    public void registrarVenda(UUID idMedicamento, int quantidadeAVender) {
        Medicamento medicamentoParaVenda = null;
        for (Medicamento medicamento : listaMedicamentos) {
            if (medicamento.getId().equals(idMedicamento)) {
                medicamentoParaVenda = medicamento;
                break;
            }
        }
    
        if (medicamentoParaVenda != null) {
            vender(medicamentoParaVenda, quantidadeAVender);
        } else {
            System.out.println("MEDICAMENTO NÃO ENCONTRADO.");
        }
    }
    
    public void gerarRelatorio() {
        System.out.println("Relatório de Medicamentos:\n");
        for (Medicamento medicamento : listaMedicamentos) {
            System.out.println("Nome: " + medicamento.getNome());
            System.out.println("Quantidade: " + medicamento.getQuantidade());
            System.out.println("Preço: " + medicamento.getPreco());
            System.out.println("------------------------------------");
        }
    }

}
