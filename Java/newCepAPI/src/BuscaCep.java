import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {
    public Endereco consultarCep(String busca){
        try{
            var endereco = "https://viacep.com.br/ws/"+busca+"/json/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = resposta.body();

            return new GsonBuilder().setPrettyPrinting().create().fromJson(json, Endereco.class);
        }
        catch(Exception e){
            System.out.println("Erro" + e.getMessage());
        }
        return null;
    }
}
