/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.orientacaoobjetos;

/**
 *
 * @author erick
 */
public class OrientacaoObjetos {
   private String nome;
   private String poder;
   private String tipo_arma;
   private int forca;
   private int agilidade;
   private int estamina;
   
   OrientacaoObjetos(){
       this.nome ="";
       this.poder = "";
       this.tipo_arma ="";
       this.forca = 0;
       this.agilidade = 0;
       this.estamina = 0; 
   }
   OrientacaoObjetos(String nome){
   
        this.nome = nome; 
         this.poder = "";
       this.tipo_arma ="";
       this.forca = 0;
       this.agilidade = 0;
       this.estamina = 0; 
   }
   }
      OrientacaoObjetos(String nome, String poder, String tipo_arma,
              int forca, int agilidade, int estamina){
       this.nome =nome;
       this.poder = poder;
       this.tipo_arma = tipo_arma;
       this.forca = forca;
       this.agilidade = agilidade;
       this.estamina = estamina; 
   }
   public void correr(){
       System.out.println("Corra");
   } 
   public void atacar(){
       System.out.println("Atacar!");
   }
   public void setNome(String nome){
       this.nome = nome;
   } 
    public String getNome(){
        return this.nome;
    }
    public static void main(String[] args) {
    OrientacaoObjetos personagem = new OrientacaoObjetos();
    personagem.setNome("erick");
        
        
        
    }
     
}
