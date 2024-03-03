package br.com.alura.modelos;

public class Titulo {
    private String nome;
    private int duracao;
    private int dataLancamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(int dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Titulo(String nome, int duracao, int dataLancamento) {
        this.nome = nome;
        this.duracao = duracao;
        this.dataLancamento = dataLancamento;
    }
}
