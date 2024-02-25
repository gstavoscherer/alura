package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal = 0;
    public int getTempoTotal() {
        return this.tempoTotal;
    }

//    public void inclui(Filme f){
//        this.tempoTotal += f.getDuracao();
//    }
//    public void inclui(Serie f){
//        this.tempoTotal += f.getDuracao();
//    }
    public void inclui(Titulo t){
        this.tempoTotal += t.getDuracao();
    }
}
