package com.farmacia.controller;

import java.util.Scanner;

public class MenuController {
    private Scanner scanner;

    public MenuController() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuPrincipal() {
        int opcao;

        do {
            mostrarMenuPrincipal();
            opcao = receberOpcao();
            realizarAcao(opcao);
        } while (opcao != 0);
        
        scanner.close();
    }
    
    public void GerirMedicamentos() {
        int opcao;

        do {
            mostrarSubMenuMedicamentos();
            opcao = receberOpcao();
            realizarAcaoMedicamentos(opcao);
        } while (opcao != 0);
    }

               private void mostrarSubMenuMedicamentos() {
        System.out.println("---- GERIR MEDICAMENTOS ----");
        System.out.println("1. Cadastrar Novo Medicamento");
        System.out.println("2. Mostrar Todos os Medicamentos");
        System.out.println("3. Vender Medicamento");
        System.out.println("0. Voltar para o Menu Principal");
        System.out.print("Escolha uma opcao: ");
    }

       private void realizarAcaoMedicamentos(int opcao) {
            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu Cadastrar Novo Medicamento.");
                    cadastroMedicamento(); 
                    break;
                case 2:
                    System.out.println("Você escolheu Mostrar Todos os Medicamentos:");
                    mostrarTodosMedicamentos();
                    break;
                case 3:
                    System.out.println("Você escolheu Vender Medicamento.");
                    venderMedicamento();
                    break;
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                     exibirMenuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
}
        
        private LocalDate dataValidade;

        public Medicamento(LocalDate dataValidade) {
            this.dataValidade = dataValidade;
        }

           public void validarDataDeValidade() {
        LocalDate hoje = LocalDate.now();
        long diasAteVencimento = ChronoUnit.DAYS.between(hoje, dataValidade);

        if (diasAteVencimento <= 1 && diasAteVencimento >= 0) {
            System.out.println("Atenção: O medicamento está prestes a vencer em menos de 24 horas!");
            System.out.println("Deseja remover o medicamento do estoque? (Sim/Não)");

            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("Sim")) {
                System.out.println("Medicamento removido do estoque.");
            } else if (resposta.equalsIgnoreCase("Não")) {
                System.out.println("Medicamento mantido no estoque.");
            } else {
                System.out.println("Opção inválida.");
                // Lógica para lidar com uma resposta inválida
            }
        } else if (diasAteVencimento < 0) {
            System.out.println("Atenção: O medicamento está vencido!");
            System.out.println("Deseja remover o medicamento do estoque? (Sim/Não)");

            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("Sim")) {
                // Remover o medicamento do estoque
                System.out.println("Medicamento removido do estoque.");
                //remoção do estoque
            } else if (resposta.equalsIgnoreCase("Não")) {
                System.out.println("Medicamento mantido no estoque.");
                // Você pode adicionar outras ações caso o usuário decida manter o medicamento no estoque
            } else {
                System.out.println("Opção inválida.");
                // opcap resposta inválida
            }
        } else {
            System.out.println("A data de validade do medicamento está OK.");
        }
    }


    private void mostrarMenuPrincipal() {
        System.out.println("---- Menu de Administracao ----");
        System.out.println("1. Registar Venda");
        System.out.println("2. Gerir Medicamentos");
        
        System.out.println("---- Relatório de Vendas ----");
        System.out.println("8. Obter o numero total de vendas");
        System.out.println("9. Mostrar todos os Medicamento")
        
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
    }
    
    private int receberOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private void realizarAcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Você escolheu Registrar Venda.");
                break;
            case 2: 
                System.out.println("------ GESTAO DE MEDICAMENTOS------");  
                    mostrarSubMenuMedicamentos(); 
                break;
            case 8:
                System.out.println("Você escolheu Obter o número total de vendas.");
                break;
            case 0:
                System.out.println("Saindo.");
                break;
           

            default:
                System.out.println("Opção inválida. Escolha novamente.");
                   
        }
    }
}
