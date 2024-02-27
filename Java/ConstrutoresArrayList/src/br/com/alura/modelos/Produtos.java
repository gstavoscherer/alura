package br.com.alura.modelos;

public class Produtos {
    private String nome;
    private int quantidade;
    private double preco;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produtos(String nome, double preco) {
        this.setNome(nome);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Nome do produto: " + getNome() + "\nQuantidade do produto: " + getQuantidade() + "\nPreço do produto: " + getPreco() ;
    }
}
