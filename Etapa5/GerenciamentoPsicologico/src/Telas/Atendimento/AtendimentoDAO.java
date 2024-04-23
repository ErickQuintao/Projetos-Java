/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas.Atendimento;

import Telas.ConexaoJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import Telas.Atendimento.AtendimentoClass;
import javax.lang.model.util.Types;
/**
 *
 * @author erick
 */
public class AtendimentoDAO {
      //Cadastrando no banco de dados ===> INSERT -> 'C'rud
    public static boolean cadastrar(AtendimentoClass c) throws SQLException {
        try {
            //Conexão com o banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            //Instrução SQL que será executada
            String sql = "INSERT INTO Atendimento (horarioInicio, horarioFim, Valor,Desconto,ValorTotal,MetodoDePagamento,status,Convenio,Descricao) VALUES (?, ?, ?,?,?,?,?,?,?);";

            //Usar a string e transformar em SQL usando PreparedStatement
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            //define query para mandar para bd do mysql 
LocalDateTime data = c.getHorarioInicial();
java.sql.Timestamp dataLancamentoSQL = java.sql.Timestamp.valueOf(data);
LocalDateTime data2 = c.getHorarioFinal();
java.sql.Timestamp dataLancamentoSQL2 = java.sql.Timestamp.valueOf(data2);

            query.setTimestamp(1, dataLancamentoSQL);
            query.setTimestamp(2, dataLancamentoSQL2);
            query.setDouble(3, c.getValor());
            query.setDouble(4, c.getDesconto());
            query.setDouble(5, c.getValorTotal());
            query.setString(6, c.getMetodoPag());
            query.setString(7, c.getStatus());
            query.setString(8, c.getConvenio());
            query.setString(9, c.getDescricao());
            //Executar a instrução SQL
            query.execute();

            //Desconectar do banco
            conexao.desconectar();
            return true;
        } catch (SQLException se) {
            System.out.println(se);
            System.out.println("Erro ao cadastrar registro no banco de dados");
            return false;
        }
    }

    //Buscar/Listagem de dados do banco ==> SELECT -> c'R'ud
   public static List<AtendimentoClass> listarTodos(String filtroDescricao) {
    // Declaração da variável lista que será retornada
    List<AtendimentoClass> lista = new ArrayList<>();

    try {
        // Conectar ao banco
        ConexaoJDBC conexao = new ConexaoJDBC();
        conexao.conectar();

        // Instrução SQL
        String sql;
        if (filtroDescricao.isEmpty()) {
            sql = "SELECT * FROM atendimento";
        } else {
            sql = "SELECT * FROM atendimento WHERE Descricao LIKE ?";
        }

        PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

        // Se filtroDescricao não estiver vazio, configuramos o parâmetro
        if (!filtroDescricao.isEmpty()) {
            consulta.setString(1, "%" + filtroDescricao + "%");
        }

        // Executar a instrução SQL e pegar os resultados
        ResultSet resposta = consulta.executeQuery();

        while (resposta.next()) {
            // Cria uma nova instância de AtendimentoClass
            AtendimentoClass c = new AtendimentoClass();
            
            // Armazenar as informações utilizando métodos set para cada atributo
            c.setId(resposta.getInt("idAtendimento"));
            c.setHorarioInicial(resposta.getTimestamp("horarioInicio").toLocalDateTime());
            c.setHorarioFinal(resposta.getTimestamp("horarioFim").toLocalDateTime());
            c.setValor(resposta.getDouble("Valor"));
            c.setDesconto(resposta.getDouble("Desconto"));
            c.setValorTotal(resposta.getDouble("ValorTotal"));
            c.setMetodoPag(resposta.getString("MetodoDePagamento"));
            c.setStatus(resposta.getString("status"));
            c.setConvenio(resposta.getString("Convenio"));
            c.setDescricao(resposta.getString("Descricao"));
            
            // Adiciona o objeto AtendimentoClass à lista
            lista.add(c);
        }

        // Desconectar do banco
        conexao.desconectar();
    } catch (SQLException e) {
        System.out.println("Erro ao listar os registros do banco de dados!");
        e.printStackTrace(); // Isso ajudará a identificar a causa do erro
    }

    return lista;
}


        //Buscar especificamente por ID
 
      public  AtendimentoClass listarUmId(Integer ID) {
    AtendimentoClass c = null;

    try {
        // Conectar ao banco
        ConexaoJDBC conexao = new ConexaoJDBC();
        conexao.conectar();

        // Instrução SQL
        String sql = "SELECT * FROM atendimento WHERE idAtendimento = ?";
        PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
        consulta.setInt(1, ID);

        // Executar a instrução SQL e pegar os resultados
        ResultSet resposta = consulta.executeQuery();

        if (resposta.next()) {
                //cria nova intância
                 c = new AtendimentoClass();
                //armazendo as informações usando get e set ,para poder mandar depois para mysql
                           c.setHorarioInicial(resposta.getTimestamp("horarioInicio").toLocalDateTime());
            c.setHorarioFinal(resposta.getTimestamp("horarioFim").toLocalDateTime());
                c.setValor(resposta.getDouble("Valor"));
                c.setDesconto(resposta.getDouble("Desconto"));
                c.setValorTotal(resposta.getDouble("ValorTotal"));
                c.setMetodoPag(resposta.getString("MetodoDePagamento"));
                c.setStatus(resposta.getString("status"));
                c.setConvenio(resposta.getString("Convenio"));
                c.setDescricao(resposta.getString("Descricao"));
        }

        // Desconectar do banco
        conexao.desconectar();
    } catch (SQLException e) {
        System.out.println("Erro ao listar os registros do banco de dados!");
        System.out.println(e);
    }
    return c;
}

  

    //Atualizar os dados/informações de uma linha do banco ===> UPDATE -> cr'U'd
public static boolean atualizar(AtendimentoClass c,int id) {
    try {
        ConexaoJDBC conexao = new ConexaoJDBC();
        conexao.conectar();

        //Instrução SQL
        String sql = "UPDATE atendimento SET horarioInicio=?, horarioFim=?, Valor=?, Desconto=?, ValorTotal=?, MetodoDePagamento=?, status=?, Convenio=?, Descricao=? WHERE idAtendimento=?;";
        PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

        //Passar as informações do objeto para a consulta
        LocalDateTime data = c.getHorarioInicial();
        java.sql.Timestamp dataLancamentoSQL = java.sql.Timestamp.valueOf(data);
        LocalDateTime data2 = c.getHorarioFinal();
        java.sql.Timestamp dataLancamentoSQL2 = java.sql.Timestamp.valueOf(data2);

        consulta.setTimestamp(1, dataLancamentoSQL);
        consulta.setTimestamp(2, dataLancamentoSQL2);
        consulta.setDouble(3, c.getValor());
        consulta.setDouble(4, c.getDesconto());
        consulta.setDouble(5, c.getValorTotal());
        consulta.setString(6, c.getMetodoPag());
        consulta.setString(7, c.getStatus());
        consulta.setString(8, c.getConvenio());
        consulta.setString(9, c.getDescricao());
        consulta.setInt(10, id); // Supondo que getIdAtendimento retorne o ID do atendimento a ser atualizado

        //Executar a instrução
        consulta.executeUpdate();

        //Desconectar do Banco
        conexao.desconectar();
        return true;
    } catch (SQLException e) {
        System.out.println("Erro ao buscar o registro do banco de dados");
        System.out.println(e);
        return false;
    }
}

    //Deletar dados do banco ==> DELETE -> cru'D'
    public static boolean excluir(int id) {
        try {
            //Conectar ao banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            //Instrução SQL
            String sql = "DELETE FROM atendimento WHERE idAtendimento=?;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            //Passar Informações do objeto para a consulta
            consulta.setInt(1, id);

            //Executa a instrução SQL
            consulta.execute();

            //Desconectar do banco
            conexao.desconectar();
            return true;
        } catch (SQLException s) {
            System.out.println("Erro ao deletar registro no banco de dados!");
            return false;
        }
    }
}
