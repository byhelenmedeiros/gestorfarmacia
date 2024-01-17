

import com.farmacia.controller.MenuController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao PharmaGest!");
        MenuController menuController = new MenuController();
        menuController.exibirMenuPrincipal();
    }
}
