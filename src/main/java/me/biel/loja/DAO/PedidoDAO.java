package me.biel.loja.DAO;

import me.biel.loja.bean.Cliente;
import me.biel.loja.bean.Pedido;
import me.biel.loja.bean.Produto;
import me.biel.loja.exceptions.ClienteNotFound;
import me.biel.loja.exceptions.PedidoNotFound;
import me.biel.loja.exceptions.ProdutoNotFound;
import me.biel.loja.persistencia.Banco;

import java.sql.SQLException;
import java.util.Collection;

public class PedidoDAO implements DAO<Pedido> {
    private java.sql.PreparedStatement pst;

    @Override
    public boolean insere(Pedido obj) throws SQLException {
        String sql = "INSERT INTO Pedido (id_cliente, id_produto, quantidade, data) VALUES (?, ?, ?, ?)";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        pst.setInt(1, obj.getClient().getId());
        pst.setInt(2, obj.getProduto().getId());
        pst.setInt(3, obj.getQuantidade());
        pst.setTimestamp(4, obj.getData());

        int res = pst.executeUpdate();

        Banco.desconectar();

        return res != 0;
    }

    @Override
    public boolean remove(Pedido obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean altera(Pedido obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pedido buscaID(Pedido obj) throws SQLException, PedidoNotFound {
        String sql = "SELECT * FROM Pedido WHERE id = ?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        pst.setInt(1, obj.getId());

        java.sql.ResultSet rs = pst.executeQuery();

        Pedido pedido = null;
        if(rs.next()) {
            try {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente = clienteDAO.buscaID(cliente);


                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                produto = produtoDAO.buscaID(produto);

                pedido = new Pedido(cliente);
                pedido.setId(rs.getInt("id"));
                pedido.setClient(cliente);
                pedido.setProduto(produto);
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setData(rs.getTimestamp("data"));
            } catch (ClienteNotFound | ProdutoNotFound e) {
                e.printStackTrace();
            }
        }

        Banco.desconectar();

        if (pedido == null)
            throw new PedidoNotFound("Pedido with ID (" + obj.getId() + ") not found!", null);

        return pedido;
    }

    @Override
    public Collection<Pedido> lista(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
