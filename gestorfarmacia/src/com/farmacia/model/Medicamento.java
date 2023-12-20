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
                boolean continuarCadastro = true;

         while (continuarCadastro) {
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

        Medicamento novoMedicamento = new Medicamento(nome, quantidade, descricao, preco, tipo);
        listaMedicamentos.add(novoMedicamento);
                System.out.println("Medicamento cadastrado com sucesso! Pretende cadastrar novo medicamento ?");
                System.out.println("1 - Não");
                System.out.println("2 - Sim, continuar cadastro de medicamentos");
                System.out.println("3 - Voltar para menu");
        
        int escolha = scanner.nextLine();

            switch(escolha){
                case 1:
                    continuarCadastro = false;
                    break;
                case 2;
                    continuarCadastro = true;
                    break 
                case 3:
                    mostrarMenuPrincipal()  
                    break;
                default:
                    System.out.println("Escolha inválida, encerrando cadasntro de medicamentos!");
                    continuarCadastro = false;
                    break;

            }

        scanner.close();
    }
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
