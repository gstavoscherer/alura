package br.com.alura.main;

import br.com.alura.exceptions.ExcecaoSenhaInvalida;
import br.com.alura.modelo.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("-------------------");
            System.out.println("--Criando Usuário--");
            System.out.println("Digite o nome: ");
            var nome = scanner.nextLine();
            System.out.println("Digite a idade: ");
            int idade = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o usuario: ");
            var usuario = scanner.nextLine();
            System.out.println("Digite a senha: ");
            var senha = scanner.nextLine();
            Usuario user = new Usuario(nome, idade, usuario, senha);
            System.out.println("Usuario criado com sucesso");
        } catch (ExcecaoSenhaInvalida e){
            System.out.println(e.getMessage());
        }
    }
}
