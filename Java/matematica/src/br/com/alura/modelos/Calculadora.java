package br.com.alura.modelos;

import br.com.alura.exception.ExcecaoCriada;

public class Calculadora {
    private double num;
    private double num2;
    public double getNum2() {
        return num2;
    }
    public void setNum2(double num2) {
        this.num2 = num2;
    }
    public double getNum() {
        return num;
    }
    public void setNum(double num) {
        this.num = num;
    }

    public double divisao(double num, double num2) {
        if (getNum2()==0) {
            throw new ExcecaoCriada("Não é possivel dividir por 0");
        }
        return num / num2;
    }
}
