package me.biel.loja.bean;


public class Produto {

    private int id;
    private int quantidade;
    private double preco;
    private String nome_produto;

    public Produto() {
    }

    public Produto(int id, int quantidade, double preco, String nome_produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
        this.nome_produto = nome_produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }
}
