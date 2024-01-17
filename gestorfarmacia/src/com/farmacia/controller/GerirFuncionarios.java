import com.farmacia.model.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerirFuncionarios {
    private List<Funcionario> listaFuncionarios;
    private Scanner scanner;

    public GerirFuncionarios() {
        this.listaFuncionarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void cadastrarFuncionario() {
        System.out.println("------ Cadastro de Novo Funcionário ------");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, cargo, listaFuncionarios.size() + 1, false);
        listaFuncionarios.add(novoFuncionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }
}
