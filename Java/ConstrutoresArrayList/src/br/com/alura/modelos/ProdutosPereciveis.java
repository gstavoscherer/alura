package br.com.alura.modelos;

public class ProdutosPereciveis extends Produtos{
    int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ProdutosPereciveis(String nome, double preco, int dataValidade) {
        super(nome, preco);
        this.data = dataValidade;
    }

}
