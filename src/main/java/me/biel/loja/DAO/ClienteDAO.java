package me.biel.loja.DAO;

import me.biel.loja.bean.Cliente;
import me.biel.loja.exceptions.ClienteNotFound;
import me.biel.loja.persistencia.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ClienteDAO implements DAO<Cliente> {
    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;

    private Cliente cliente;
    
    @Override
    public boolean insere(Cliente obj) throws SQLException
    {
        String sql = "INSERT INTO Client (nome, sobrenome, endereco, cep) " +
                " VALUES (?, ?, ?, ?)";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getSobrenome());
        pst.setString(3, obj.getEndereco());
        pst.setInt(4, obj.getCep());

        int res = pst.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean remove(Cliente obj) throws SQLException
    {
        String sql = "DELETE FROM Cliente WHERE id = ?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        pst.setInt(1, obj.getId());

        int res = pst.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean altera(Cliente obj) throws SQLException
    {
        String sql = "UPDATE Cliente SET nome = ?, sobrenome = ?, endereco = ?, cep = ? WHERE id = ?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getSobrenome());
        pst.setString(3, obj.getEndereco());
        pst.setInt(4, obj.getCep());
        pst.setInt(5, obj.getId());

        int res = pst.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public Cliente buscaID(Cliente obj) throws SQLException, ClienteNotFound {
        String sql = "SELECT * FROM Cliente WHERE id = ?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        pst.setInt(1, obj.getId());

        rs = pst.executeQuery();

        if(rs.next())
        {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setSobrenome(rs.getString("sobrenome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setCep(rs.getInt("cep"));
        }
        else
        {
            cliente = null;
        }

        Banco.desconectar();

        if (cliente == null)
            throw new ClienteNotFound("Cliente with ID (" + obj.getId() + ") not found!", null);

        return cliente;
    }

    @Override
    public Collection<Cliente> lista(String criterio) throws SQLException
    {
        ArrayList<Cliente> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Cliente ";

        if(criterio != null && criterio.length() > 0)
            sql += " WHERE " + criterio;

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        rs = pst.executeQuery();

        while(rs.next())
        {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setSobrenome(rs.getString("sobrenome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setCep(rs.getInt("cep"));
            lista.add(cliente);
        }

        Banco.desconectar();

        return lista;
    }
    
}
