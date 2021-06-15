package me.biel.loja.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    public static String database, user, pass, server;
    public static int port;

    public static java.sql.Connection conexao = null;

    static {
        //mysql e mariaDB
        database = "Loja";
        user = "root";
        pass = "";
        server = "localhost";
        port = 3306;
    }
    
    //métodos
    public static void conectar() throws SQLException
    {
        String url = "jdbc:mysql://" + server + ":" + port + "/" + database;

        conexao = DriverManager.getConnection(url, user, pass);
    }
    
    public static void desconectar() throws SQLException {
        conexao.close();
    }
    
    public static java.sql.Connection obterConexao() throws SQLException {
        if(conexao == null)
            throw new SQLException("Conexão está fechada..");
        else
            return conexao;
    }
}
