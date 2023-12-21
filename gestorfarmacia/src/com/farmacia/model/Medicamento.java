import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Medicamento {
    private String nome;
    private int quantidade;
    private LocalDate dataValidade;
    private String descricao;
    private double preco;
    private String tipo;

    public Medicamento(String nome, int quantidade, LocalDate dataValidade, String descricao, double preco, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
            } else {
                System.out.println("Opção inválida.");
                // opcap resposta inválida
            }
        } else {
            System.out.println("A data de validade do medicamento está OK.");
        }
    }
}
