package com.farmacia.model;

import java.time.LocalDate;

public class Cliente {
    private static int contadorClientes = 1;

    private int idCliente;
    private String nomeCompleto;
    private String nif;
    private String telefone;
    private String morada;
    private LocalDate dataNascimento;
    private String email;
    private String cartaoCliente;
    private int pontosFidelidade;

    public Cliente(String nomeCompleto, String nif, String telefone, String morada, LocalDate dataNascimento, String email, String cartaoCliente) {
        this.idCliente = contadorClientes++;
        this.nomeCompleto = nomeCompleto;
        this.nif = nif;
        this.telefone = telefone;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cartaoCliente = cartaoCliente;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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

    public String getCartaoCliente() {
        return cartaoCliente;
    }

    public void setCartaoCliente(String cartaoCliente) {
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