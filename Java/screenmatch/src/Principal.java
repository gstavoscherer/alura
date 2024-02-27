import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroDeRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme favorito = new Filme("Matrix", 1999);
        favorito.setDuracao(135);
        favorito.setIncluidoNoPlano(true);
        favorito.avalia(8);
        favorito.avalia(10);

        Filme outro = new Filme("John Wick", 2014);
        outro.setDuracao(101);
        outro.setIncluidoNoPlano(true);
        outro.avalia(2);
        outro.avalia(5);
        outro.avalia(1);

        Serie serie = new Serie("La Casa de Papel", 2017);
        serie.setIncluidoNoPlano(true);
        serie.setAtiva(true);
        serie.setTemporadas(5);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(45);
        serie.avalia(3);
        serie.avalia(9);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(favorito);
        calculadora.inclui(outro);
        calculadora.inclui(serie);

        System.out.println("Tempo total: " + calculadora.getTempoTotal());

        FiltroDeRecomendacao filtro = new FiltroDeRecomendacao();
        filtro.filtra(favorito);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalDeVisualizacoes(50);
        filtro.filtra(episodio);

        ArrayList<Filme> lista = new ArrayList<>();
        lista.add(favorito);
        lista.add(outro);
        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Primeiro filme: " + lista.get(0).getNome());
        System.out.println(lista);


    }
}
