package br.com.alura.main;

import br.com.alura.exceptions.ErroConsultaGithubException;
import br.com.alura.modelos.Usuario;
import br.com.alura.modelos.UsuarioGIT;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome de usuário que deseja buscar no GITHUB: ");
        String busca = scanner.nextLine();
        var endereco = "https://api.github.com/users/" + busca;

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            String json = response.body();
            Gson gson = new Gson();
            UsuarioGIT user = gson.fromJson(json, UsuarioGIT.class);

            Usuario gustavo = new Usuario(user);

            System.out.println(gustavo);
        } catch (ErroConsultaGithubException | NumberFormatException e){
            System.out.println("Digite um user válido");
        }
    }
}
