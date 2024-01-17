package com.farmacia.model;

public class Sessao {
    private Cliente clienteAtual;
    private Medicamento medicamentoSelecionado;

    // Construtor padrão
    public Sessao() {
    }

    // Construtor com cliente inicial
    public Sessao(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }

    public Medicamento getMedicamentoSelecionado() {
        return medicamentoSelecionado;
    }

    public void setMedicamentoSelecionado(Medicamento medicamentoSelecionado) {
        this.medicamentoSelecionado = medicamentoSelecionado;
    }
}
