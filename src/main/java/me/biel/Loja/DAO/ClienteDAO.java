/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.biel.Loja.DAO;

import me.biel.Loja.bean.Cliente;
import me.biel.Loja.persistencia.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class ClienteDAO implements DAO<Cliente> {


    private java.sql.PreparedStatement pst;
    

    private java.sql.ResultSet rs;
    

    private Cliente cliente;
    
    @Override
    public boolean insere(Cliente obj) throws SQLException {
        String sql = "INSERT INTO Proprietario (codProprietario, nome) " +
                " VALUES (?, ?)";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando INSERT
        pst.setInt(1, obj.getCodProprietario());
        pst.setString(2, obj.getNome());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
        
    }

    @Override
    public boolean remove(Cliente obj) throws SQLException {
        String sql = "DELETE FROM Proprietario WHERE codProprietario = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando DELETE
        pst.setInt(1, obj.getCodProprietario());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean altera(Cliente obj) throws SQLException {
        String sql = "UPDATE Proprietario SET Nome = ? "
                + "WHERE codProprietario = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setInt(2, obj.getCodProprietario());
        pst.setString(1, obj.getNome());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public Cliente buscaID(Cliente obj) throws SQLException {
        String sql = "SELECT * FROM Proprietario "
                + "WHERE codProprietario = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setInt(1, obj.getCodProprietario());
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            //mover os dados do resultSet para o objeto proprietário
            cliente = new Cliente();
            cliente.setCodProprietario(rs.getInt("codProprietario"));
            cliente.setNome(rs.getString("Nome"));
        }
        else {
            //não encontrou o registro solicitado
            cliente = null;
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return cliente;

    }

    @Override
    public Collection<Cliente> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Cliente> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Proprietario ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //Varre todo o resultado da consulta e coloca cada registro dentro
        //de um objeto e coloca o objeto dentro da coleção
        while(rs.next()) {
            //criar o objeto
            cliente = new Cliente();
            //mover os dados do resultSet para o objeto proprietário
            cliente.setCodProprietario(rs.getInt("codProprietario"));
            cliente.setNome(rs.getString("Nome"));
            //move o objeto para a coleção
            lista.add(cliente);
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return lista;
        
    }
    
}
