import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class GerirMedicamentos{
        private List<Medicamento> ListaMedicamentos;
        
        public GerirMedicamentos(){
            this.listaMedicamentos = new ArrayList<>();
        
        }    


    public void cadastroMedicamento(){
        Scanner Teclado = new Scanner(System.in);

            System.out.println("------Cadastro de novos medicamentos------");
            System.out.println("Nome do Medicamento: ");
                String nome = Scanner.nextLine();
            System.out.println("Quantidade: ")
                int quantidade = Scanner.nextLine();
            System.out.println("Descrição do medicamento: ")
                String descricao = Scanner.nextLine();
            System.out.println("Preço: ");
                double preco = Scanner.nextLine();  
            System.out.println("Tipo de medicamento: ");
                String tipo = Scanner.nextLine();


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
