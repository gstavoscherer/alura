import java.util.ArrayList;
import java.util.Scanner;
import br.com.alura.modelos.Conta;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta cliente = new Conta(1,"Gustavo Scherer", "Conta Corrente");
        Conta cliente2 = new Conta(2,"Arthur Roque", "Conta Poupança");
        Conta cliente3 = new Conta(3,"Marcos Brancalhão", "Conta Corrente");

        cliente.setSaldo(0);
        cliente2.setSaldo(0);
        cliente3.setSaldo(0);

        ArrayList<Conta> listadeclientes = new ArrayList<>();
        listadeclientes.add(cliente);
        listadeclientes.add(cliente2);
        listadeclientes.add(cliente3);

        int choice01 = 0;
        while(choice01 != 4){
            System.out.println("Operações:");
            System.out.println("1-Exibir lista de contas");
            System.out.println("2-Consultar conta");
            System.out.println("3-Selecionar conta");
            System.out.println("4-Sair");

            System.out.println("Escolha a opção desejada:");
            choice01 = scanner.nextInt();

            switch(choice01){
                case 1:
                    System.out.println("-------------------------------");
                    System.out.println("        Lista de contas        ");
                    for (int i = 0; i < listadeclientes.size(); i++) {
                        System.out.println(listadeclientes.get(i));
                    }
                    System.out.println("-------------------------------");
                    break;
                case 2:
                    System.out.println("Escolha o ID do cliente desejado:");
                    int choice02 = scanner.nextInt();

                    boolean clienteEncontrado = false;

                    for (Conta conta : listadeclientes) {
                        if (conta.getId() == choice02) {
                            System.out.println("-------------------------------");
                            System.out.println("ID: " + conta.getId());
                            System.out.println("Nome do cliente: " + conta.getNome());
                            System.out.println("Saldo: R$" + String.format("%.2f", conta.getSaldo())); // Formatando saldo com duas casas decimais
                            System.out.println("Tipo de conta: " + conta.getTipoDeConta());
                            System.out.println("-------------------------------");
                            clienteEncontrado = true;
                            break;
                        }
                    }

                    if (!clienteEncontrado) {
                        System.out.println("ID inválido. Por favor, digite um ID válido.");
                    }
                    break;

                case 3:
                    System.out.println("Escolha o ID do cliente desejado:");
                    int choice03 = scanner.nextInt();

                    boolean clienteEncontrado2 = false;

                    for (int i = 0; i < listadeclientes.size(); i++) {
                        if (listadeclientes.get(i).getId() == choice03) {
                            int escolha = 0;
                            while (escolha !=4) {
                                System.out.println("Conta de ID "+listadeclientes.get(i).getId()+ " sobre posse de " + listadeclientes.get(i).getNome());
                                System.out.println("Operações:\n");
                                System.out.println("1- Consultar valores");
                                System.out.println("2- Receber valor");
                                System.out.println("3- Transferir valor");
                                System.out.println("4- Voltar");

                                System.out.println("Escolha a opção desejada:");
                                escolha = scanner.nextInt();

                                switch(escolha){
                                    case 1:
                                        System.out.println("*******************************");
                                        System.out.println("Nome: " + listadeclientes.get(i).getNome());
                                        System.out.println("Tipo de conta: " + listadeclientes.get(i).getTipoDeConta());
                                        System.out.println("Saldo: R$" + listadeclientes.get(i).getSaldo());
                                        System.out.println("*******************************");
                                        break;
                                    case 2:
                                        System.out.println("Escolha o valor que deseja receber:");
                                        int valorAReceber = scanner.nextInt();

                                        listadeclientes.get(i).setSaldo(listadeclientes.get(i).getSaldo()+valorAReceber);

                                        System.out.println("Saldo atualizado para R$" + listadeclientes.get(i).getSaldo());

                                        break;
                                    case 3:
                                        System.out.println("Escolha o valor que deseja transferir:");
                                        double valorATransferir = scanner.nextInt();

                                        if (valorATransferir > listadeclientes.get(i).getSaldo()){
                                            System.out.println("É impossível transferir mais do que o saldo");
                                        } else {
                                            listadeclientes.get(i).setSaldo(listadeclientes.get(i).getSaldo()-valorATransferir);


                                        }
                                        break;
                                    case 4:
                                        System.out.println("Voltando...");
                                        break;
                                    default:
                                        System.out.println("Opção inválida!");
                                        break;
                                }

                            }
                            clienteEncontrado2 = true;
                            break;
                        }
                    }
                    if (!clienteEncontrado2) {
                        System.out.println("ID inválido. Por favor, digite um ID válido.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo da aplicação");
                    break;
            }
        }
    }
}