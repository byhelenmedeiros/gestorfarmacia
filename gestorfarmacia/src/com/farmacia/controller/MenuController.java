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

    private void gerirMedicamentos() {
        int opcao;

        do {
            mostrarSubMenuMedicamentos();
            opcao = receberOpcaoSubMenu();
            realizarAcaoMedicamentos(opcao);
        } while (opcao != 0);
    }

    public void venderMedicamento() {
        // Lógica para vender um medicamento
    }

    public void mostrarTodosMedicamentos() {
        // Lógica para mostrar todos os medicamentos
    }

    public void cadastroMedicamento() {
        // Lógica para cadastrar um medicamento
    }

    private void mostrarSubMenuMedicamentos() {
        System.out.println("------ GESTAO DE MEDICAMENTOS------");
        System.out.println("1. Cadastrar Novo Medicamento");
        System.out.println("2. Mostrar Todos os Medicamentos");
        System.out.println("3. Vender Medicamento");
        System.out.println("0. Voltar para o Menu Principal");
        System.out.print("Escolha uma opcao: ");
    }

    private void realizarAcaoMedicamentos(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Escolheu Cadastrar Novo Medicamento.");
                    cadastroMedicamento();
                break;
            case 2:
                System.out.println("Escolheu Mostrar Todos os Medicamentos:");
                mostrarTodosMedicamentos();
                break;
            case 3:
                System.out.println("Escolheu Vender Medicamento.");
                venderMedicamento();
                break;
            case 0:
                System.out.println("Voltando para o Menu Principal.");
                break;
            default:
                System.out.println("Opção inválida. Escolha novamente.");
        }
    }

    private void mostrarMenuPrincipal() {
        System.out.println("---- Menu de Administracao ----");
        System.out.println("1. Registar Venda");
        System.out.println("2. Gerir Medicamentos");
        System.out.println("3. Relatório de Vendas");
        System.out.println("8. Obter o número total de vendas");
        System.out.println("9. Mostrar todos os Medicamento");
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

    private void realizarAcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Escolheu Registrar Venda.");
                break;
            case 2:
                System.out.println("Escolheu Gerir medicamentos");
                gerirMedicamentos();
                break;
            case 8:
                System.out.println("Escolheu Obter o número total de vendas.");
                break;
            case 0:
                System.out.println("Saindo.");
                break;
            default:
                System.out.println("Opção inválida. Escolha novamente.");
        }
    }
}
