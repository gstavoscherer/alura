import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("Meu Malvado Favorito 4");
        meuFilme.setAnoDeLancamento(2024);
        meuFilme.setDuracao(180);
        meuFilme.avalia(8);
        meuFilme.avalia(6);
        meuFilme.avalia(10);
        meuFilme.exibeFichaTecnica();

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        lost.exibeFichaTecnica();

    }
}
