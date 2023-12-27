package com.farmacia.model;

public class Funcionario {
    private String nome;
    private String cargo;
    private int numerodefuncionario;
    private boolean permissaoAdmin;
    
    public Funcionario(String nome, String cargo, int numerodefuncionario, boolean permissaoAdmin) {
        this.nome = nome;
        this.cargo = cargo;
        this.numerodefuncionario = numerodefuncionario;
        this.permissaoAdmin = permissaoAdmin;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getnumerodefuncionario() {
        return numerodefuncionario;
    }

    public void setId(int numerodefuncionario) {
        this.numerodefuncionario = numerodefuncionario;
    }

    public boolean isPermissaoAdmin() {
        return permissaoAdmin;
    }

    public void setPermissaoAdmin(boolean permissaoAdmin) {
        this.permissaoAdmin = permissaoAdmin;
    }
}








