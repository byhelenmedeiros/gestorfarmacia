
import com.farmacia.controller.GerirMedicamentos;
import com.farmacia.controller.MenuController;

public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.exibirMenuPrincipal();

        GerirMedicamentos gerirMedicamentos = new GerirMedicamentos();
        gerirMedicamentos.cadastroMedicamento();
    }
}
