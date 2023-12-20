public class Medicamento {
    private String nome;
    private int quantidade;
    private double preco;
    private String descricao;
    private String tipo;



    public Medicamento(String nome, int quantidade, double preco, String descricao, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.descricao = descricao;
        this.tipo = tipo;
        this.stock = stock;
    }


    public void vender(int quantidadeAVender) {
        if (quantidadeAVender <= quantidade && quantidadeAVender > 0) {
            quantidade -= quantidadeAVender;
            System.out.println(quantidadeAVender + " unidades de " + nome + " vendidas.");
        } else {
            System.out.println("Quantidade inválida para venda.");
        }
    }

    public void cadastroMedicamento (){
        
    }
}
