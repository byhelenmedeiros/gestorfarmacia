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
    
    private void mostrarMenuPrincipal() {
        System.out.println("---- Menu de Administração ----");
        System.out.println("1. Registar Venda");
        // ... outras opções do menu
        
        System.out.println("---- Menu Estatísticas ----");
        System.out.println("8. Obter o número total de vendas");
        // ... outras opções do menu
        
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
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
                // Chame o método para registrar a venda
                break;
            case 8:
                System.out.println("Você escolheu Obter o número total de vendas.");
                // Chame o método para obter o número total de vendas
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Escolha novamente.");
        }
    }
}
