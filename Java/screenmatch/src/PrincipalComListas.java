import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.sql.Array;
import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme favorito = new Filme("Matrix", 1999);
        favorito.avalia(8);
        Filme outro = new Filme("John Wick", 2014);
        outro.avalia(10);
        Filme filme1 = new Filme("Meu Malvado Favorito 4", 2024);
        filme1.avalia(4);
        Serie serie = new Serie("La Casa de Papel", 2017);
        serie.avalia(6);
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(favorito);
        lista.add(outro);
        lista.add(filme1);
        lista.add(serie);
        System.out.println("Tamanho da lista: " + lista.size());
        for (Titulo item: lista){
            if(item instanceof Filme filme && filme.getClassificacao() > 2 ) {
                System.out.println("Nome do filme: "+ filme.getNome() + " e classificação do filme: "+filme.getClassificacao());
            }

        }
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        
    }
}
