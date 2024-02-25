import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int saldo = 0;
        int escolha = 0;

        System.out.println("*******************************");
        System.out.println("Nome: Gustavo André Scherer");
        System.out.println("Tipo de conta: Corrente");
        System.out.println("Saldo: R$" + saldo);
        System.out.println("*******************************");




         while (escolha !=4) {
             System.out.println("Operações:\n");
             System.out.println("1- Consultar valores");
             System.out.println("2- Receber valor");
             System.out.println("3- Transferir valor");
             System.out.println("4- Encerrar aplicação");

             System.out.println("Escolha a opção desejada:");
             escolha = scanner.nextInt();

             switch(escolha){
                 case 1:
                     System.out.println("*******************************");
                     System.out.println("Nome: Gustavo André Scherer");
                     System.out.println("Tipo de conta: Corrente");
                     System.out.println("Saldo: R$" + saldo);
                     System.out.println("*******************************");
                 break;
                 case 2:
                     System.out.println("Escolha o valor que deseja receber:");
                     int valorAReceber = scanner.nextInt();

                     saldo += valorAReceber;

                     System.out.println("Saldo atualizado para R$" + saldo);

                 break;
                 case 3:
                     System.out.println("Escolha o valor que deseja transferir:");
                     int valorATransferir = scanner.nextInt();

                     if (valorATransferir > saldo){
                         System.out.println("É impossível transferir mais do que o saldo");
                     } else {
                         saldo -= valorATransferir;
                         System.out.println("Saldo atualizado para R$" + saldo);
                     }
                 break;
                 case 4:
                     System.out.println("Encerrando aplicação");
                 break;
                 default:
                     System.out.println("Opção inválida!");
                 break;
             }

         }
    }
}