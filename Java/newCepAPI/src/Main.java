import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String busca = "";
        List<Endereco> lista = new ArrayList<>();
        GeradorDeArquivo gerador = new GeradorDeArquivo();

        while(!busca.equalsIgnoreCase("sair")){

            BuscaCep buscar = new BuscaCep();


            System.out.println("Digite o CEP que deseja localizar: ");
            busca = scanner.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            lista.add(buscar.consultarCep(busca));
        }
        try{
            gerador.gerar(lista);
        } catch(Exception e){
            System.out.println("Erro");
        }
    }
}
