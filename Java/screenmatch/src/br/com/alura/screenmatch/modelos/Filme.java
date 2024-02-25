package br.com.alura.screenmatch.modelos;

public class Filme extends Titulo{
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void exibeFichaTecnica() {
        System.out.println("***************************************");
        System.out.println("Nome do filme:" + getNome());
        System.out.println("Ano de lançamento:" + getAnoDeLancamento());
        System.out.println("Duracao: " + getDuracao() + " minutos");
        System.out.println("Quantidade de avaliações: " + getTotalDeAvaliacoes());
        System.out.println("Média das avaliações: " + getSomaDasAvaliacoes() / getTotalDeAvaliacoes());
        System.out.println("***************************************");
    }
}
