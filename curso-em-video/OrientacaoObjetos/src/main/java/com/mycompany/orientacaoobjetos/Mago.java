/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orientacaoobjetos;

/**
 *
 * @author erick
 */
public class Mago extends OrientacaoObjetos {
   private String livro; 

   public Mago(String livro){
    super("erick");    
    this.livro ="Dark book";
    setEstamina(100);
}
   @Override
   public void atacar(){
       System.out.println("Pronuncia a magia e ataque!");
   }
   
   @Override
   public void setEstamina(int estamina){
       super.setEstamina(estamina);
   }
}