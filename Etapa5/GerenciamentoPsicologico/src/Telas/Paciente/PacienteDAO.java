/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas.Paciente;

import Telas.Atendimento.AtendimentoClass;
import Telas.ConexaoJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author erick
 */
public class PacienteDAO {
          //Cadastrando no banco de dados ===> INSERT -> 'C'rud
    public static boolean cadastrar(PacienteClass c) throws SQLException {
        try {
            //Conexão com o banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            //Instrução SQL que será executada
            String sql = "INSERT INTO Paciente(Nome,Idade,CPF,RG,Cidade,Nacionalidade,Bairro,Nome_Mae,Nome_Pai,Sexo,Data_emissao,Data_expiracao,ativo_inativo,Celular,email) VALUES (?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?);";

            //Usar a string e transformar em SQL usando PreparedStatement
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            //define query para mandar para bd do mysql 
            
            query.setString(1,c.getNome());
            query.setInt(2,c.getIdade());
            query.setString(3,c.getCPF());
            query.setString(4,c.getRG());
            query.setString(5,c.getCidade());
            query.setString(6,c.getNacionalidade());
            query.setString(7,c.getBairro());
            query.setString(8,c.getNomeMae());
            query.setString(9,c.getNomePai());
            query.setString(10,c.getSexo());

 LocalDateTime data = c.getDataEmissao();
java.sql.Timestamp dataLancamentoSQL = java.sql.Timestamp.valueOf(data);
LocalDateTime data2 = c.getDataExpiracao();
java.sql.Timestamp dataLancamentoSQL2 = java.sql.Timestamp.valueOf(data2);

            query.setTimestamp(11, dataLancamentoSQL);
            query.setTimestamp(12, dataLancamentoSQL2);
            query.setBoolean(13,c.getAtivo());
            query.setString(14,c.getCelular());
            query.setString(15,c.getEmail());
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

//    //Buscar/Listagem de dados do banco ==> SELECT -> c'R'ud
//   public static List<PacienteClass> listarTodos(String filtroNome) {
//    // Declaração da variável lista que será retornada
//    List<PacienteClass> lista = new ArrayList<>();
//
//    try {
//        // Conectar ao banco
//        ConexaoJDBC conexao = new ConexaoJDBC();
//        conexao.conectar();
//
//        // Instrução SQL
//        String sql;
//        if (filtroNome.isEmpty()) {
//            sql = "SELECT * FROM Paciente";
//        } else {
//            sql = "SELECT * FROM Paciente WHERE Nome LIKE ?";
//        }
//
//        PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
//
//        // Se filtroDescricao não estiver vazio, configuramos o parâmetro
//        if (!filtroNome.isEmpty()) {
//            consulta.setString(1, "%" + filtroNome + "%");
//        }
//
//        // Executar a instrução SQL e pegar os resultados
//        ResultSet resposta = consulta.executeQuery();
//
//        while (resposta.next()) {
//            // Cria uma nova instância de AtendimentoClass
//            PacienteClass c = new PacienteClass();
//            
//            // Armazenar as informações utilizando métodos set para cada atributo
//            c.setId(resposta.getInt("idPaciente"));
//            c.setNome(resposta.getString("Nome"));
//            c.setIdade(resposta.getInt("Idade"));
//            c.setCPF(resposta.getString("CPF"));
//            c.setRG(resposta.getString("RG"));
//            c.setCidade(resposta.getString("Cidade"));
//            c.setNacionalidade(resposta.getString("Nacionalidade"));
//            c.setBairro(resposta.getString("Bairro"));
//            c.setNomeMae(resposta.getString("NomeMae"));
//            c.setNomePai(resposta.getString("NomePai"));
//            c.setSexo(resposta.getString("Sexo"));
//            java.sql.Date dataSQL = resposta.getDate("Data_emissao");
//LocalDate dataEmissao = dataSQL.toLocalDate();
//c.setDataEmissao(dataEmissao);
//java.sql.Date dataSQL2 = resposta.getDate("Data_expiracao");
//LocalDate dataExpericao = dataSQL2.toLocalDate();
//c.setDataEmissao(dataExpericao);
//            c.setAtivo(resposta.getBoolean("ativo_inativo"));
//            c.setCelular(resposta.getString("Celular"));
//            c.setEmail(resposta.getString("email"));
//            // Adiciona o objeto AtendimentoClass à lista
//            lista.add(c);
//        }
//
//        // Desconectar do banco
//        conexao.desconectar();
//    } catch (SQLException e) {
//        System.out.println("Erro ao listar os registros do banco de dados!");
//        e.printStackTrace(); // Isso ajudará a identificar a causa do erro
//    }
//
//    return lista;
//}
//
//
//        //Buscar especificamente por ID
// 
//      public  PacienteClass listarUmId(Integer ID) {
//    PacienteClass c = null;
//
//    try {
//        // Conectar ao banco
//        ConexaoJDBC conexao = new ConexaoJDBC();
//        conexao.conectar();
//
//        // Instrução SQL
//        String sql = "SELECT * FROM Paciente WHERE idPaciente = ?";
//        PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
//        consulta.setInt(1, ID);
//
//        // Executar a instrução SQL e pegar os resultados
//        ResultSet resposta = consulta.executeQuery();
//
//        if (resposta.next()) {
//                //cria nova intância
//                 c = new PacienteClass();
//                //armazendo as informações usando get e set ,para poder mandar depois para mysql
//                 c.setId(resposta.getInt("idPaciente"));
//            c.setNome(resposta.getString("Nome"));
//            c.setIdade(resposta.getInt("Idade"));
//            c.setCPF(resposta.getString("CPF"));
//            c.setRG(resposta.getString("RG"));
//            c.setCidade(resposta.getString("Cidade"));
//            c.setNacionalidade(resposta.getString("Nacionalidade"));
//            c.setBairro(resposta.getString("Bairro"));
//            c.setNomeMae(resposta.getString("NomeMae"));
//            c.setNomePai(resposta.getString("NomePai"));
//            c.setSexo(resposta.getString("Sexo"));
//            java.sql.Date dataSQL = resposta.getDate("Data_emissao");
//LocalDate dataEmissao = dataSQL.toLocalDate();
//c.setDataEmissao(dataEmissao);
//java.sql.Date dataSQL2 = resposta.getDate("Data_expiracao");
//LocalDate dataExpericao = dataSQL2.toLocalDate();
//c.setDataEmissao(dataExpericao);
//            c.setAtivo(resposta.getBoolean("ativo_inativo"));
//            c.setCelular(resposta.getString("Celular"));
//            c.setEmail(resposta.getString("email"));
//        }
//
//        // Desconectar do banco
//        conexao.desconectar();
//    } catch (SQLException e) {
//        System.out.println("Erro ao listar os registros do banco de dados!");
//        System.out.println(e);
//    }
//    return c;
//}
//
//  
//
//    //Atualizar os dados/informações de uma linha do banco ===> UPDATE -> cr'U'd
//    public static boolean atualizar(PacienteClass c) {
//        try {
//            ConexaoJDBC conexao = new ConexaoJDBC();
//            conexao.conectar();
//
//            //Instrução SQL
//            String sql = "UPDATE Paciente SET Nome?,Idade?,CPF?,RG?,Cidade?,Nacionalidade?,Bairro?,Nome_Mae?,Nome_Pai?,Sexo?,Data_emissao?,Data_expiracao?,ativo_inativo?,Celular?,email? WHERE idPaciente=?;";
//            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
//
//            //Passar as informações do objeto para a consulta
//consulta.setString(1,c.getNome());
//            consulta.setInt(2,c.getIdade());
//            consulta.setString(3,c.getCPF());
//            consulta.setString(4,c.getRG());
//            consulta.setString(5,c.getCidade());
//            consulta.setString(6,c.getNacionalidade());
//            consulta.setString(7,c.getBairro());
//            consulta.setString(8,c.getNomeMae());
//            consulta.setString(9,c.getNomePai());
//           consulta.setString(10,c.getSexo());
//LocalDate data = c.getDataExpiracao();
//LocalDate data2 = c.getDataEmissao();
//
//java.sql.Date dataSQL = java.sql.Date.valueOf(data);
//java.sql.Date dataSQL2 = java.sql.Date.valueOf(data2);
//           consulta.setDate(11, dataSQL2);
//            consulta.setDate(12, dataSQL);
//           consulta.setBoolean(13,c.getAtivo());
//            consulta.setString(14, c.getCelular());
//           consulta.setString(15,c.getEmail());
//
//            //Executar a instrução
//            consulta.execute();
//
//            //Desconectar do Banco
//            conexao.desconectar();
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Erro ao buscar o registro do banco de dados");
//            return false;
//        }
//    }
//
//    //Deletar dados do banco ==> DELETE -> cru'D'
//    public static boolean excluir(int id) {
//        try {
//            //Conectar ao banco
//            ConexaoJDBC conexao = new ConexaoJDBC();
//            conexao.conectar();
//
//            //Instrução SQL
//            String sql = "DELETE FROM Paciente WHERE idPaciente=?;";
//            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
//
//            //Passar Informações do objeto para a consulta
//            consulta.setInt(1, id);
//
//            //Executa a instrução SQL
//            consulta.execute();
//
//            //Desconectar do banco
//            conexao.desconectar();
//            return true;
//        } catch (SQLException s) {
//            System.out.println("Erro ao deletar registro no banco de dados!");
//            return false;
//        }
//    }
}
