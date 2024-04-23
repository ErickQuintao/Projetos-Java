
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


/**
 *
 * @author erick
 */
public class PacienteClass {
    Integer id;
    String nome;
    Integer idade;
    String cpf;
    String rg;
    String cidade;
    String Nacionalidade;
    String Bairro;
    String nomeMae;
    String nomePai;
    String sexo;
   LocalDateTime dataEmissao;
    LocalDateTime dataExpiracao;
    boolean ativo;
    String celular;
    String email;
    PacienteClass(){
    }
      public Integer getId() {
        return id;
    }

  public void setId(Integer id) {
        this.id = id;
    }
    public String getNome(){
      return nome;
  }
  public void setNome(String nome){
  this.nome = nome;
  }
  public Integer getIdade(){
      return idade;
  }
  public void setIdade(int idade){
      this.idade = idade;
  }
  public String getCPF(){
      return cpf;
  }
  public void setCPF(String cpf){
  this.cpf = cpf;
  }
  public String getRG(){
      return rg;
  }
  public void setRG(String rg){
      this.rg=rg;
  }
  public String getCidade(){
      return cidade;
  }
  public void setCidade(String cidade){
      this.cidade=cidade;
  }
  public String getNacionalidade(){
      return Nacionalidade;
  }
  public void setNacionalidade(String Nacionalidade){
      this.Nacionalidade = Nacionalidade;
  }
  public  String getBairro(){
      return Bairro;
  }
  public void setBairro(String Bairro){
  this.Bairro =Bairro;
  }
  public String getNomeMae(){
      return nomeMae;
  }
  public void setNomeMae(String nomeMae){
      this.nomeMae=nomeMae;
  }
    public String getNomePai(){
      return nomePai;
  }
  public void setNomePai(String nomePai){
      this.nomePai=nomePai;
  }
  public String getSexo(){
      return sexo;
  }
  public void setSexo(String sexo){
   this.sexo=sexo;
  }
  public LocalDateTime getDataEmissao(){
      return dataEmissao;
  }
  public void setDataEmissao(LocalDateTime dateEmisao){
      this.dataEmissao=dataEmissao;
  }
  public LocalDateTime getDataExpiracao(){
      return dataExpiracao;
  }
  public void setDataExpiracao(LocalDateTime dataExpiracao){
      this.dataExpiracao=dataExpiracao;
  }
  public boolean getAtivo(){
          return ativo;
          }
  public void setAtivo(boolean ativo){
      this.ativo=ativo;
  }
  public String getCelular(){
      return celular;
  }
  public void setCelular(String celular){
      this.celular=celular;
  }
  public String getEmail(){
      return email;
  }
  public void setEmail(String email){
  this.email =email;
  }
  
  
}
