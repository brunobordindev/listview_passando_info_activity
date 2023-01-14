package com.example.listview_passandoinformacoesactivity;

public class User {

    private int id;
    private String nome;
    private String sobrenome;
    private int idade;
    private String email;

    public User(String nome, String sobrenome, int idade, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " "+ sobrenome +"\n"+ "Idade: " + idade + "\n" + "E-mail: " + email + "\n" + "Id: " + id;
    }
}
