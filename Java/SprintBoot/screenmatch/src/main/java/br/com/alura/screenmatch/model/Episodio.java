package br.com.alura.screenmatch.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
@Entity
@Table(name = "episodios")
public class Episodio {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;
    @ManyToOne
    private Serie serie;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodios) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodios.titulo();
        this.numeroEpisodio = dadosEpisodios.numeroEpisodio();
        try{
            this.avaliacao = Double.valueOf(dadosEpisodios.avaliacao());
        } catch ( NumberFormatException e) {
            this.avaliacao = 0.0;
        }
        try{
            this.dataLancamento = LocalDate.parse(dadosEpisodios.dataLancamento());
        } catch ( DateTimeParseException e){
            this.dataLancamento = null;
        }
    }

    public Episodio() {}

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
