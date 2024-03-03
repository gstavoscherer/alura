package br.com.alura.main;
import br.com.alura.exception.ExcecaoCriada;
import br.com.alura.modelos.Calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        try {
            Calculadora calculadora = new Calculadora();
            System.out.println("Digite o primeiro número: ");
            calc.setNum(scanner.nextInt());
            System.out.println("Digite o segundo número: ");
            calc.setNum2(scanner.nextInt());
            System.out.println(calc.divisao(calc.getNum(), calc.getNum2()));
        } catch (ExcecaoCriada e){
            System.out.println(e.getMessage());

        }
    }
}
