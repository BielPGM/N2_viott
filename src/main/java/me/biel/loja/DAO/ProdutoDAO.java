package me.biel.loja.DAO;

import me.biel.loja.bean.Produto;
import me.biel.loja.exceptions.PedidoNotFound;
import me.biel.loja.exceptions.ProdutoNotFound;
import me.biel.loja.persistencia.Banco;

import java.sql.SQLException;
import java.util.Collection;

public class ProdutoDAO implements DAO <Produto> {

    private java.sql.PreparedStatement pst;

    @Override
    public boolean insere(Produto obj) throws SQLException {
        String sql = "INSERT INTO Produto (quantidade, preco, nome_produto) VALUES (?, ?, ?)";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        pst.setInt(1, obj.getQuantidade());
        pst.setDouble(2, obj.getPreco());
        pst.setString(3, obj.getNome_produto());

        int res = pst.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean remove(Produto obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean altera(Produto obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto buscaID(Produto obj) throws SQLException, ProdutoNotFound {
        String sql = "SELECT * FROM Produto "
                + "WHERE id = ?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        pst.setInt(1, obj.getId());

        java.sql.ResultSet rs = pst.executeQuery();

        Produto produto;
        if(rs.next()) {
            produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setNome_produto(rs.getString("nome_produto"));
        }
        else {
            produto = null;
        }

        Banco.desconectar();

        if (produto == null)
            throw new ProdutoNotFound("Produto with ID (" + obj.getId() + ") not found!", null);

        return produto;
    }

    @Override
    public Collection<Produto> lista(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
