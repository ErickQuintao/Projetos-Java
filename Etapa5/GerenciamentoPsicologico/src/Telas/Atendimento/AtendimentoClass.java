/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas.Atendimento;

import java.time.LocalDateTime;

/**
 *
 * @author erick
 */
public class AtendimentoClass {
      Integer id;
     LocalDateTime HorarioIncial;
     LocalDateTime HorarioFinal;
     Double Valor;
     Double Desconto;
     Double ValorTotal;
     String MetodoPag;
     String Status;
     String Convenio;
     String Descricao;
     
 AtendimentoClass(Integer id,LocalDateTime HorarioIncial,
     LocalDateTime HorarioFinal,
     Double Valor,
     Double Desconto,
     Double ValorTotal,
     String MetodoPag,
     String Status,
     String Convenio,
     String Descricao) {
        this.id =id;
        this.HorarioIncial =HorarioIncial;
        this.HorarioFinal =HorarioFinal;
        this.Valor = Valor;
        this.Desconto = Desconto;
        this.ValorTotal = ValorTotal;
        this.MetodoPag = MetodoPag;
        this.Status = Status;
        this.Convenio =Convenio;
        this.Descricao = Descricao;
    }

    AtendimentoClass() {
       
    }
  public Integer getId() {
        return id;
    }

  public void setId(Integer id) {
        this.id = id;
    }
  public  LocalDateTime getHorarioInicial(){
      return HorarioIncial;
  }
  public void setHorarioInicial(LocalDateTime HorarioIncial) {
        this.HorarioIncial = HorarioIncial;
    }
   public  LocalDateTime getHorarioFinal(){
      return HorarioFinal;
  }
  public void setHorarioFinal(LocalDateTime HorarioFinal) {
        this.HorarioFinal = HorarioFinal;
    }
  public Double getValor(){
      return Valor;
  }
  public void setValor(Double Valor){
      this.Valor = Valor;
  }
  public Double getDesconto(){
      return Desconto;
  }
  public void setDesconto(Double Desconto){
      this.Desconto = Desconto;
  }
  public Double getValorTotal(){
  return ValorTotal;
  }
  public void setValorTotal(Double ValorTotal){
      this.ValorTotal =ValorTotal;
  }
  public String getMetodoPag(){
      return MetodoPag;
  }
  public void setMetodoPag(String MetodoPag){
      this.MetodoPag =MetodoPag;
  }
  public String getStatus(){
      return Status;
  }
  public void setStatus(String Status){
      this.Status=Status;
  }
  public String getConvenio(){
      return Convenio;
  }
  public void setConvenio(String Convenio){
      this.Convenio=Convenio;
  }
  public String getDescricao(){
      return Descricao;
  }
  public void setDescricao(String Descricao){
      this.Descricao=Descricao;
  }
}
