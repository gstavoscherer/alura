package br.com.alura.exceptions;

public class ErroConsultaGithubException extends RuntimeException{
    private String mensagem;
    public ErroConsultaGithubException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
