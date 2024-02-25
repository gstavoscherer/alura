import br.com.alura.modelos.Cachorro;
import br.com.alura.modelos.Gato;

public class Main {
    public static void main(String[] args) {
        Gato gato1 = new Gato();
        gato1.arranharMoveis();
        gato1.emitirSom();

        Cachorro cachorro1 = new Cachorro();
        cachorro1.emitirSom();
        cachorro1.abanarRabo();
    }
}
