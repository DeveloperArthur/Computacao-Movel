package com.example.chamadapersonalizada.entities;

public class Aluno {
    private int id;
    private String nome;
    private String foto;

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Aluno(int id, String nome, String foto) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
    }
}
