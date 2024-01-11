import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Saldo atual: ?" + saldo);
        System.out.println("-------------------------------");
    }
}
