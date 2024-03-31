package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.*;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private List<DadosSerie> dadosSeries = new ArrayList<>();
    private Optional<Serie> serieBusca;


    private SerieRepository repositorio;
    private List<Serie> series = new ArrayList<>();

    public Principal(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar séries buscadas
                    4 - Buscar série por título
                    5 - Buscar séries por ator
                    6 - Top 5 Séries
                    7 - Buscar séries por categoria
                    8 - Filtrar séries por temporada e avaliação        
                    9 - Filtrar Episodios por trecho   
                    10- Top 5 Episódios de uma série       
                    11- Episodios a partir de uma data                  
                    0 - Sair                                 
                    """;

            System.out.println(menu);

            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeries();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriesPorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7:
                    buscarSeriesPorCategoria();
                    break;
                case 8:
                    buscarSeriesPorTemporadaEAvaliacao();
                    break;
                    case 9:
                        filtrarEpisodiosPorTrecho();
                        break;
                case 10:
                    buscarTop5EpisodiosDeUmaSerie();
                    break;
                case 11:
                    buscarEpisodiosAPartirDeData();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                }
            }
        }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        //dadosSeries.add(dados);

        repositorio.save(new Serie(dados));
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie(){
        listarSeries();
        System.out.println("Escolha uma série pelo nome");
        var nomeSerie = leitura.nextLine();

        Optional<Serie> serie = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

        if(serie.isPresent()) {

            var serieEncontrada = serie.get();
            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());

            serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);
        } else {
            System.out.println("Série não encontrada!");
        }
    }

    private void listarSeries(){
        series = repositorio.findAll();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(s -> System.out.println(s.getGenero() + ", nome: " +s.getTitulo() + " avaliação: " + s.getAvaliacao()));
    }
    private void buscarSeriePorTitulo() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        serieBusca = repositorio.findByTituloContainingIgnoreCase(nomeSerie);
        if(serieBusca.isPresent()){
            System.out.println(serieBusca.get());
        } else {
            System.out.println("Série não encontrada!");
        }
    }
    private void buscarSeriesPorAtor(){
        System.out.println("Qual o nome para buscar?");
        var nomeAtor = leitura.nextLine();
        List<Serie> seriesEncontradas = repositorio.findByAtoresContainingIgnoreCase(nomeAtor);
        System.out.println("Séries em que " + nomeAtor + " trabalhou");
        seriesEncontradas.forEach(s -> System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
    }
    private void buscarTop5Series(){
        List<Serie> top5 = repositorio.findAll().stream()
                .sorted(Comparator.comparing(Serie::getAvaliacao).reversed())
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Top 5 séries");
        top5.forEach(s -> System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
    }
    private void buscarSeriesPorCategoria(){
        System.out.println("Qual categoria deseja buscar?");
        var categoria = leitura.nextLine();
        Categoria categoriaEnum = Categoria.fromPortugues(categoria);
        List<Serie> seriesEncontradas = repositorio.findByGenero(categoriaEnum);
        System.out.println("Séries da categoria " + categoria);
        seriesEncontradas.forEach(s -> System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
    }
    private void buscarSeriesPorTemporadaEAvaliacao(){
        System.out.println("Digite o número de temporadas");
        var temporadas = leitura.nextInt();
        System.out.println("Digite a avaliação");
        var avaliacao = leitura.nextDouble();
        List<Serie> seriesEncontradas = repositorio.seriesPorTemporadaEAvaliacao(temporadas, avaliacao);
        System.out.println("Séries com " + temporadas + " temporadas e avaliação maior ou igual a " + avaliacao);
        seriesEncontradas.forEach(s -> System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
    }
    private void filtrarEpisodiosPorTrecho(){
        System.out.println("Digite o trecho para busca");
        var trecho = leitura.nextLine();
        List<Episodio> episodios = repositorio.episodiosPorTrecho(trecho);
        episodios.forEach(
                e -> System.out.printf(
                        "Série: %s, Episódio: %s, Temporada: %d, Avaliação: %.2f\n",
                        e.getSerie().getTitulo(), e.getTitulo(), e.getTemporada(), e.getAvaliacao()
                ));
    }
    private void buscarTop5EpisodiosDeUmaSerie() {
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            List<Episodio> topEpisodios = repositorio.topEpisodiosPorSerie(serie);
            topEpisodios.forEach(
                    e -> System.out.printf(
                            "Série: %s, Episódio: %s, Temporada: %d, Avaliação: %.2f\n",
                            e.getSerie().getTitulo(), e.getTitulo(), e.getTemporada(), e.getAvaliacao()
                    ));

        }
    }
    private void buscarEpisodiosAPartirDeData(){
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            System.out.println("Digite o ano limite de lançamento");
            var anoLancamento = leitura.nextInt();
            List<Episodio> episodiosAno = repositorio.episodiosPorSerieEAno(serie, anoLancamento);
            episodiosAno.forEach(e -> System.out.println(
                   "Data: "+ e.getDataLancamento() + ", Episódio: " + e.getTitulo() + ", Temporada: " + e.getTemporada() + ", Avaliação: " + e.getAvaliacao()
            ));

        } else {
            System.out.println("Série não encontrada!");
        }
    }
}

