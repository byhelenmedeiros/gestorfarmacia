package com.farmacia;

import com.farmacia.controller.MenuController;
import com.farmacia.model.Medicamento;

public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.exibirMenuPrincipal();
    }
}
