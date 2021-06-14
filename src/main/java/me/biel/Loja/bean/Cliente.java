package me.biel.Loja.bean;




public class Cliente {

    private int Numero_cliente;
    private String nome;

    public Cliente() {
    }

    public Cliente(int Numero_cliente, String nome) {
        this.Numero_cliente = Numero_cliente;
        this.nome = nome;
    }

    //equals() e hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.Numero_cliente;
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
        final Cliente other = (Cliente) obj;
        if (this.Numero_cliente != other.Numero_cliente) {
            return false;
        }
        return true;
    }

    //toString()
    @Override    
    public String toString() {
        return nome;
    }

    //getters e setters
    public int getCodProprietario() {
        return Numero_cliente;
    }

    public void setCodProprietario(int codProprietario) {
        this.Numero_cliente = codProprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

        
}
