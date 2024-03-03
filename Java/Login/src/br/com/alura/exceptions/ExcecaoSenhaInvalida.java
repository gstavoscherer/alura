package br.com.alura.exceptions;

public class ExcecaoSenhaInvalida extends Exception{
    private String mensagem;
    public ExcecaoSenhaInvalida(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
