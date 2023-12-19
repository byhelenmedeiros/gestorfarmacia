public class Medicamento {
    private String nome;
    private int quantidade;

    public Medicamento(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }


    public void vender(int quantidadeAVender) {
        if (quantidadeAVender <= quantidade && quantidadeAVender > 0) {
            quantidade -= quantidadeAVender;
            System.out.println(quantidadeAVender + " unidades de " + nome + " vendidas.");
        } else {
            System.out.println("Quantidade inválida para venda.");
        }
    }
}
