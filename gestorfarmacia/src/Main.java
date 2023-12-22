
import com.farmacia.controller.MenuController;
import com.farmacia.controller.GerirMedicamentos;


public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.exibirMenuPrincipal();

        GerirMedicamentos gerirMedicamentos = new GerirMedicamentos();
        gerirMedicamentos.cadastroMedicamento();
    }
}