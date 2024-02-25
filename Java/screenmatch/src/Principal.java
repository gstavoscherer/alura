import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
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

        Filme meuFilme2 = new Filme();
        meuFilme2.setDuracao(200);
        meuFilme2.setNome("Avatar");
        meuFilme2.setAnoDeLancamento(2023);

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        lost.exibeFichaTecnica();

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(meuFilme2);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

    }
}
