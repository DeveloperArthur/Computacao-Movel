package com.example.contatos2;

public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private int foto;

    public Contato(int id, String nome, String telefone, int foto) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.foto = foto;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
