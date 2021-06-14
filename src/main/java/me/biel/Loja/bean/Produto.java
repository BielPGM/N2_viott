package me.biel.Loja.bean;

import java.util.Objects;


public class Produto {

    private String placa;
    private String modelo;
    private double valor;

    //composição !!!!
    private Cliente cliente;

    //composição
    public Produto(Cliente cliente) {
        this.cliente = cliente;
    }

    //getters e setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getProprietario() {
        return cliente;
    }

    public void setProprietario(Cliente cliente) {
        this.cliente = cliente;
    }
        
    //equals e hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.placa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return placa + " - " + cliente;
    }
    
    
}
