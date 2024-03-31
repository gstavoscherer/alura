package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String titulo);

    List<Serie> findByAtoresContainingIgnoreCase(String nomeAtor);
    List<Serie> findByGenero(Categoria categoria);
    @Query("select s from Serie s where s.totalTemporadas <= ?1 and s.avaliacao >= ?2")
    List<Serie> seriesPorTemporadaEAvaliacao(int totalTemporadas, double avaliacao );

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %?1%")
    List<Episodio> episodiosPorTrecho(String trecho);
    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = ?1 ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> topEpisodiosPorSerie(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = ?1 AND YEAR(e.dataLancamento) >= ?2 ORDER BY e.dataLancamento")
    List<Episodio> episodiosPorSerieEAno(Serie serie, int ano);
}
