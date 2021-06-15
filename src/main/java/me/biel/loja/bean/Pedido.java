package me.biel.loja.bean;

import java.sql.Timestamp;

public class Pedido {

    private int id;
    private int quantidade;
    private Timestamp data;

    private Cliente client;
    private Produto produto;

    public Pedido() {
    }

    public Pedido(Cliente client) {
        this.client = client;
    }

    public Pedido(Produto produto) {
        this.produto = produto;
    }

    public Pedido(Cliente client, Produto produto) {
        this.client = client;
        this.produto = produto;
    }

    public Pedido(int id, int quantidade, Timestamp data, Cliente client, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.data = data;
        this.client = client;
        this.produto = produto;
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

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
