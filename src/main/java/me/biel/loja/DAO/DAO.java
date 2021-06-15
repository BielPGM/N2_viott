/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.biel.loja.DAO;

import me.biel.loja.exceptions.ClienteNotFound;
import me.biel.loja.exceptions.PedidoNotFound;
import me.biel.loja.exceptions.ProdutoNotFound;

import java.sql.SQLException;
import java.util.Collection;

public interface DAO <BEAN> {
    public boolean insere(BEAN obj) throws SQLException;
    public boolean remove(BEAN obj) throws SQLException;
    public boolean altera(BEAN obj) throws SQLException;
    public BEAN buscaID(BEAN obj) throws SQLException, ClienteNotFound, PedidoNotFound, ProdutoNotFound;
    public Collection<BEAN> lista(String criterio) throws SQLException;
}
