public class Medicamento {
    private String nome;
    private int quantidade;
    private double preco;
    private String descricao;
    private String tipo;
    private String stock;



    public class GerirMedicamentos{
        private List<Medicamento> ListaMedicamentos;
        
        public GerirMedicamentos(){
            this.listaMedicamentos = new ArrayList<>();
        
        }    


    public void cadastroMedicamento(){
        Scanner 

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
