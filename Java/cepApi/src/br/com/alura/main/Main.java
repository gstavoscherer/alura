package br.com.alura.main;

import br.com.alura.modelos.EnderecoCEP;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do CEP");
        var busca = scanner.nextInt();
        var endereco = "https://viacep.com.br/ws/"+busca+"/json/";
        try{

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String resposta = response.body();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            EnderecoCEP enderecoCep = gson.fromJson(resposta, EnderecoCEP.class);
            System.out.println(enderecoCep);

        }   catch(Exception e){
            System.out.println("Ocorreu um erro: ");
            System.out.println(e.getMessage());
        }
    }
}
