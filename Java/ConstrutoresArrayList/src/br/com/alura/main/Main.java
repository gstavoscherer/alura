package br.com.alura.main;

import br.com.alura.modelos.Produtos;
import br.com.alura.modelos.ProdutosPereciveis;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Produtos carne = new Produtos("Carne", 25);
        carne.setQuantidade(50);
        Produtos feijao = new Produtos("Feijao", 15);
        feijao.setQuantidade(20);
        Produtos arroz = new Produtos("Arroz", 15);
        arroz.setQuantidade(10);
        ProdutosPereciveis bolo = new ProdutosPereciveis("Bolo", 30, 15);
        ArrayList<Produtos> lista = new ArrayList<>();
        lista.add(carne);
        lista.add(feijao);
        lista.add(arroz);
        System.out.println("Primeiro item da lista: " + lista.get(0).getNome());
        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println(carne.toString());
        System.out.println("Data de validade do " + bolo.getNome() + " é de " + bolo.getData() + " dias.");
    }

}
