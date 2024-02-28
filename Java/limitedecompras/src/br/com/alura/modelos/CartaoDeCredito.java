package br.com.alura.modelos;
import java.util.ArrayList;

public class CartaoDeCredito {
    private double limite;
    private double saldo;
    private ArrayList<Compra> compras;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public boolean lancaCompra(Compra compra) {
        if(this.saldo > compra.getValor()){
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        }

        return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }
}