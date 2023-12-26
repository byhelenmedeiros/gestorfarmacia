package com.farmacia.controller;

import java.util.Scanner;

public class MenuController {
    private Scanner scanner;
    private GerirMedicamentos gerirMedicamentos;

    public MenuController() {
        this.scanner = new Scanner(System.in);
        this.gerirMedicamentos = new GerirMedicamentos(this); // Passando a referência do MenuController
    }
    public void exibirMenuPrincipal() {
        int opcao;

        do {
            mostrarMenuPrincipal();
            opcao = receberOpcao();

            switch (opcao) {
                case 1:
                        gerirMedicamentos.realizarVendaMedicamento();
                    System.out.println("Escolheu Registrar Venda.");
                    break;
                case 2:
                    exibirMenuMedicamentos(); // Opção para gerir medicamentos
                    break;
                case 3:
                    // Lógica para Relatório de Vendas
                    System.out.println("Escolheu Relatório de Vendas.");
                    break;
                case 8:
                    // Lógica para Obter número total de vendas
                    System.out.println("Escolheu Obter número total de vendas.");
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("Saindo.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

     private void exibirMenuMedicamentos() {
        int opcao;
    
        do {
            mostrarSubMenuMedicamentos();
            opcao = receberOpcaoSubMenu();
    
            switch (opcao) {
                case 1:
                    gerirMedicamentos.cadastroMedicamento(); // Opção para cadastrar medicamento
                    break;
                case 2:
                    gerirMedicamentos.mostrarTodosMedicamentos(); // Opção para mostrar todos os medicamentos
                    break;
                case 3:
                     gerirMedicamentos.realizarVendaMedicamento();
                    System.out.println("Escolheu Vender Medicamento.");
                    break;
                case 0:
                    System.out.println("Voltando para o Menu Principal.");
                    return; // Retorna ao menu principal
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 0);
    }
    
    

    private void mostrarMenuPrincipal() {
        System.out.println("---- Menu de Administracao ----");
        System.out.println("1. Registrar Venda");
        System.out.println("2. Gerir Medicamentos");
        System.out.println("3. Relatório de Vendas");
        System.out.println("8. Obter número total de vendas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

        private void mostrarSubMenuMedicamentos() {
            System.out.println("------ GESTAO DE MEDICAMENTOS------");
            System.out.println("1. Cadastrar Novo Medicamento");
            System.out.println("2. Mostrar Todos os Medicamentos");
            System.out.println("3. Vender Medicamento");
            System.out.println("0. Voltar para o Menu Principal");
            System.out.print("Escolha uma opção: ");
        }

    private int receberOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private int receberOpcaoSubMenu() {
        while (true) {
            int opcao = scanner.nextInt();
            if (opcao >= 0 && opcao <= 3) {
                return opcao;
            } else {
                System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }
}
