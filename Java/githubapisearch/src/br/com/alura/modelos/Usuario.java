package br.com.alura.modelos;

import com.google.gson.annotations.SerializedName;

public class Usuario {
    private String nome;
    private int id;
    private String user;
    private int anoCriado;

    public Usuario(UsuarioGIT user){
        this.nome = user.name();
        this.id = Integer.parseInt(user.id());
        this.user = user.user();
        this.anoCriado = Integer.parseInt(user.created_at().substring(0,4));
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", user='" + user + '\'' +
                ", anoCriado=" + anoCriado +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getAnoCriado() {
        return anoCriado;
    }

    public void setAnoCriado(int anoCriado) {
        this.anoCriado = anoCriado;
    }
}
