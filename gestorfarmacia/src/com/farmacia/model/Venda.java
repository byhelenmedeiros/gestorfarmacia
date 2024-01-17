package com.farmacia.model;

import java.time.LocalDateTime;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<Medicamento> medicamentosVendidos;
    private LocalDateTime dataHora;
    private double valorTotal;
    private String formaPagamento;

    public Venda(Cliente cliente, List<Medicamento> medicamentosVendidos, double valorTotal, String formaPagamento) {
        this.cliente = cliente;
        this.medicamentosVendidos = medicamentosVendidos;
        this.dataHora = LocalDateTime.now();
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Medicamento> getMedicamentosVendidos() {
        return medicamentosVendidos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
