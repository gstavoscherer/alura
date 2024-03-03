package br.com.alura.main;

import br.com.alura.modelos.Endereco;
import br.com.alura.modelos.EnderecoCEP;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Endereco> lista = new ArrayList<>();
        String busca = "";

        while(!busca.equalsIgnoreCase("sair")){

            System.out.println("Digite o número do CEP");
            busca = scanner.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            try{

                var busca2 = "https://viacep.com.br/ws/"+busca+"/json/";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(busca2)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String resposta = response.body();

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                EnderecoCEP enderecoCep = gson.fromJson(resposta, EnderecoCEP.class);
                Endereco endereco = new Endereco(enderecoCep);
                System.out.println("Adicionado");

                lista.add(endereco);

                FileWriter write = new FileWriter("cep.json");
                write.write(gson.toJson(lista));
                write.close();

            }   catch(Exception e){
                System.out.println("Ocorreu um erro: ");
                System.out.println(e.getMessage());
            }
        }
    }
}
