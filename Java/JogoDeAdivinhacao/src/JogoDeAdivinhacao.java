import java.util.Random;
import java.util.Scanner;

public class JogoDeAdivinhacao {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean acertou = false;
        System.out.println("Jogo de Adivinhação: Acerte o número de 1 a 100");

        int x = new Random().nextInt(100);

        for (int i = 0; i < 5; i++) {
            if(!acertou){
                System.out.println("Digite o número: ");
                int num = scanner.nextInt();
                if (num == x) {
                    System.out.println("Você acertou, parabéns!!");
                    acertou = true;
                } else if (num > x) {
                    System.out.println("O número é menor do que foi digitado");
                } else {
                    System.out.println("O número é maior do que foi digitado");
                }
            }
        }
        if (!acertou){
            System.out.println("Acabaram as tentativas :(");
            System.out.println("O número era: " + x );
        }
        scanner.close();
    }
}
