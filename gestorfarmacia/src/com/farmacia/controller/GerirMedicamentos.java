package com.farmacia.controller;

import com.farmacia.model.Medicamento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerirMedicamentos {
    private List<Medicamento> listaMedicamentos;
    private Scanner scanner;
    private DateTimeFormatter formatter;
    private MenuController menuController; 

    public GerirMedicamentos(MenuController menuController) {
        this.listaMedicamentos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.menuController = menuController; // Inicialização da variável menuController
    }

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
            System.out.println("1 - Não");
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
                    return; // Retorna após exibir o menu principal
                default:
                    System.out.println("Escolha inválida, encerrando cadastro de medicamentos!");
                    continuarCadastro = false;
                    break;
            }
        }
    }

    public void vender(Medicamento medicamento, int quantidadeAVender) {
        if (quantidadeAVender <= medicamento.getQuantidade() && quantidadeAVender > 0) {
            medicamento.setQuantidade(medicamento.getQuantidade() - quantidadeAVender);
            System.out.println(quantidadeAVender + " unidades de " + medicamento.getNome() + " vendidas.");
        } else {
            System.out.println("Quantidade inválida para venda.");
        }
    }

    public void mostrarTodosMedicamentos() {
        if (listaMedicamentos.isEmpty()) {
            System.out.println("Não há medicamentos cadastrados.");
        } else {
            System.out.println("Detalhes de todos os medicamentos:");
            for (Medicamento medicamento : listaMedicamentos) {
                System.out.println("Nome do medicamento: " + medicamento.getNome());
                System.out.println("Quantidade em estoque: " + medicamento.getQuantidade());
                System.out.println("Data de validade: " + medicamento.getDataValidade().format(formatter));
                System.out.println("Preço: " + medicamento.getPreco());
                System.out.println("Descrição do medicamento: " + medicamento.getDescricao());
                System.out.println("Tipo de medicamento: " + medicamento.getTipo());
                System.out.println("---------------");
            }
        }
    }
}
