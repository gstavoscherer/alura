package br.com.alura.modelo;

import br.com.alura.exceptions.ExcecaoSenhaInvalida;

public class Usuario {
    private String nome;
    private int idade;
    private String usuario;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws ExcecaoSenhaInvalida {
        if (senha.length() <= 8){
            throw new ExcecaoSenhaInvalida("Sua senha deve ter mais de 8 dígitos");
        }
        this.senha = senha;
    }

    public Usuario(String nome, int idade, String usuario, String senha) throws ExcecaoSenhaInvalida {
        this.nome = nome;
        this.idade = idade;
        this.usuario = usuario;
        if (senha.length() <= 8){
            throw new ExcecaoSenhaInvalida("Sua senha deve ter mais de 8 dígitos");
        }
        this.senha = senha;
    }
}
