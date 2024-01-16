import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerirFinanceiro {
    private double saldo;
    private List<String> historico;

    public GerirFinanceiro() {
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void registrarDespesa(double valor, String descricao) {
        if (valor > 0) {
            saldo -= valor;
            historico.add("Despesa: -" + valor + " (" + descricao + ")");
        } else {
            System.out.println("Valor da despesa inválido.");
        }
    }

    public void registrarReceita(double valor, String descricao) {
        if (valor > 0) {
            saldo += valor;
            historico.add("Receita: +" + valor + " (" + descricao + ")");
        } else {
            System.out.println("Valor da receita inválido.");
        }
    }

    public void imprimirHistorico() {
        System.out.println("---- HISTÓRICO FINANCEIRO ----");
        for (String evento : historico) {
            System.out.println(evento);
        }
        System.out.println("Saldo atual: " + saldo);
        System.out.println("-------------------------------");
    }

    public void exibirSubMenuFinanceiro() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            mostrarSubMenuFinanceiro();
            opcao = receberOpcao();

            switch (opcao) {
                case 1:
                    registrarDespesaDoSubMenu();
                    break;
                case 2:
                    registrarReceitaDoSubMenu();
                    break;
                case 3:
                    imprimirHistorico();
                    break;
                case 0:
                    System.out.println("Saindo do menu financeiro.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void mostrarSubMenuFinanceiro() {
        System.out.println("---- GERIR FINANCEIRO ----");
        System.out.println("1. Registrar Despesa");
        System.out.println("2. Registrar Receita");
        System.out.println("3. Imprimir Histórico Financeiro");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private int receberOpcao() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void registrarDespesaDoSubMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o valor da despesa: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha
        System.out.print("Informe a descrição da despesa: ");
        String descricao = scanner.nextLine();

        registrarDespesa(valor, descricao);
        System.out.println("Despesa registrada com sucesso.");
    }

    private void registrarReceitaDoSubMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o valor da receita: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha
        System.out.print("Informe a descrição da receita: ");
        String descricao = scanner.nextLine();

        registrarReceita(valor, descricao);
        System.out.println("Receita registrada com sucesso.");
    }
}
