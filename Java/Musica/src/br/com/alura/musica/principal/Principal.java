package br.com.alura.musica.principal;

import br.com.alura.musica.modelos.MinhasPreferidas;
import br.com.alura.musica.modelos.Musica;
import br.com.alura.musica.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Musica m1 = new Musica();
        m1.setTitulo("Get him back");
        m1.setArtista("Olivia Rodrigo");

        for (int i = 0; i < 3000; i++) {
            m1.reproduz();
        }
        for (int i = 0; i < 50; i++) {
            m1.curte();
        }
        Podcast p1 = new Podcast();
        p1.setTitulo("Flow Podcast");
        p1.setHost("Monark");

        for (int i = 0; i < 5000; i++) {
            p1.reproduz();
        }
        for (int i = 0; i < 100; i++) {
            p1.curte();
        }
        MinhasPreferidas mp1 = new MinhasPreferidas();
        mp1.inclui(m1);
        mp1.inclui(p1);
    }
}
