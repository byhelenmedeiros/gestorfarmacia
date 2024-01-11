package com.farmacia.model;


public class Sessao {
        private Cliente clienteAtual;
        private Medicamento medicamentoSelecionado;
    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }
}
