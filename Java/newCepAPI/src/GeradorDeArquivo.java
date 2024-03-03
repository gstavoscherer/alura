import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {
    public void gerar(List<Endereco> lista) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter write = new FileWriter("cep.json");
        write.write(gson.toJson(lista));
        write.close();;
    }
}
