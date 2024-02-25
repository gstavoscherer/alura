package br.com.alura.aluno.modelo;

public class Aluno {
    private String nome;
    private double nota;
    private double somaDasNotas = 0;
    private int totalDeNotas = 0;
    private double mediaDasNotas;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void avalia(double nota){
        somaDasNotas = somaDasNotas + nota;
        totalDeNotas++;
    }
    public void exibeStatus(){
        System.out.println("******************");
        System.out.println("Nome:" + getNome());
        System.out.println("Média: " + somaDasNotas / totalDeNotas);
        System.out.println("Total de notas: " + totalDeNotas);
        System.out.println("******************");
    }

}
