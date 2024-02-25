import br.com.alura.aluno.modelo.Aluno;

public class Main {
    public static void main(String[] args) {
        Aluno gabriel1 = new Aluno();
        gabriel1.setNome("Gabriel");
        gabriel1.avalia(8);
        gabriel1.avalia(10);
        gabriel1.exibeStatus();



    }
}
