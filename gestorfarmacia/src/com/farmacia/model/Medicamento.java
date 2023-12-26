package com.farmacia.model;

import java.time.LocalDate;
import java.util.UUID;


public class Medicamento {
        private UUID id;
        private String nome;
        private int quantidade;
        private LocalDate dataValidade;
        private String descricao;
        private double preco;
        private String tipo;
        

    public Medicamento(String nome, int quantidade, LocalDate dataValidade, String descricao, double preco, String tipo) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }
    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    }

