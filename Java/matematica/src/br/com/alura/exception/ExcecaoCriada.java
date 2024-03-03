package br.com.alura.exception;

public class ExcecaoCriada extends ArithmeticException{
    private String mensagem;
    public ExcecaoCriada(String mensagem){
        this.mensagem = mensagem;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
