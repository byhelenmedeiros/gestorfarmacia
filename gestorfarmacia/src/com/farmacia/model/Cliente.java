package com.farmacia.model;

import java.time.LocalDate;

public class Cliente {
    private static int contadorClientes = 1;

    private int idCliente;
    private String nomeCompleto;
    private int nif;
    private int telefone;
    private String morada;
    private LocalDate dataNascimento;
    private String email;
    private int cartaoCliente;
    private int pontosFidelidade;

    public Cliente(String nomeCompleto, int nif, int telefone2, String morada, LocalDate dataNascimento, String email, int cartaoCliente2) {
        this.idCliente = contadorClientes++;
        this.nomeCompleto = nomeCompleto;
        this.nif = nif;
        this.telefone = telefone2;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cartaoCliente = cartaoCliente2;
        this.pontosFidelidade = 0;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate novaDataNascimento) {
        this.dataNascimento = novaDataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCartaoCliente() {
        return cartaoCliente;
    }

    public void setCartaoCliente(int cartaoCliente) {
        this.cartaoCliente = cartaoCliente;
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void setPontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }

    public String getNome() {
        return null;
    }
}