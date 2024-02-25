import br.com.alura.screenmatch.modelos.Filme;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("Meu Malvado Favorito 4");
        meuFilme.setAnoDeLancamento(2024);
        meuFilme.setDuracao(180);
        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
       // System.out.println(meuFilme.somaDasAvaliacoes);
       // System.out.println(meuFilme.totalDeAvaliacoes);
       // System.out.println(meuFilme.pegaMedia());
        meuFilme.getTotalDeAvaliacoes();

    }
}
