/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author erick
 */
public class ConexaoJDBC {
      
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }
    
     public void conectar() {
        try {
            //pega o arquivo de conexão do bd, que anexei no proj
            Class.forName("com.mysql.cj.jdbc.Driver");
            //pega info necessarias para acessar seu mysql
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/gereciamento_psicologa", "root", "quintao2006");
            System.out.println("SUCESSO DE CONEXÂO!");
        } catch (ClassNotFoundException e) {
            System.out.println("Falha ao carregar a classe de conexão. Classe não encontrada!");
        } catch (SQLException e) {
            System.out.println("Falha ao conectar com o banco. Erro de SQL.");
        }
    }
    
    public void desconectar() {
        try {
            //se conexao nao for nada e nao tiver fechado ,o if executa e fecha a porta
            if(conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("DESCONECTADO COM SUCESSO!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar");
        }
    }

}
