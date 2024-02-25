package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Serie extends Titulo implements Classificavel {
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodio;

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }
    public void exibeFichaTecnica(){
        System.out.println("***************************************");
        System.out.println("Nome do filme:" + getNome());
        System.out.println("Ano de lançamento:" + getAnoDeLancamento());
        System.out.println("Temporadas:" + getTemporadas());
        System.out.println("Duração total: " + getDuracao());
        System.out.println("***************************************");
    }

    @Override
    public int getDuracao() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;

    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}
