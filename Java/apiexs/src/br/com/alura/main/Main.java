package br.com.alura.main;

import br.com.alura.modelos.Titulo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Titulo> titulos = new ArrayList<>();
        Titulo titulo = new Titulo("Matrix", 180, 1999);
        Titulo titulo2 = new Titulo("Pipipi", 123, 2123);
        Titulo titulo3 = new Titulo("Popopo", 111, 2012);
        titulos.add(titulo);
        titulos.add(titulo2);
        titulos.add(titulo3);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter arquivo = new FileWriter("arquivo.json");
        arquivo.write(gson.toJson(titulos));
        arquivo.close();
    }
}
