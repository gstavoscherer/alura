package br.com.alura.modelos;

public class Conta{
    private String nome;
    private double saldo;
    private String tipoDeConta;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(String tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public Conta(int id, String nome, String tipoDeConta){
        this.setId(id);
        this.setNome(nome);
        this.setTipoDeConta(tipoDeConta);
    }

    @Override
    public String toString() {
        return "******************************\n" +
                "ID da conta: " + getId()+ "\n" +
                "Nome do usuário da conta: " + getNome()+"\n"
                +"******************************\n";
    }
}
