
package me.biel.ma4_2005_lojaveiculo;

import java.sql.SQLException;

/**
 *
 * @author Viotti
 */
public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Testanto conexão com Banco de Dados");
        
        //para mariaDB
        //String url = "jdbc:mariadb://localhost:3306/Loja";
        
        //para MySQL
        //String url = "jdbc:mysql://localhost:3306/Loja";
        
        //Para SQL Server
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Loja";
        //String url = "jdbc:sqlserver://localhost:1433;databaseName=Loja;integratedSecurity=true";
        
        //variavel para conexao
        java.sql.Connection conexao;
        
        try {
            //conectar, informar URL, Usuario e Senha
            conexao = java.sql.DriverManager.getConnection(url, "sa", "123456");
            
            System.out.println("Conectado");
            System.out.println("Fechando...");
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex.getMessage());
        }
        
    }
}
