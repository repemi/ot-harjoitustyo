/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetApp.domain;

/**
 *
 * @author erepo
 */
public class Expense {
    
   private String meno;
   private int summa;
   
   public Expense( String meno, int summa){
       this.meno = meno;
       this.summa = summa;
   }
   
   public void setMeno(String meno){
      
   }
   
   public void setSumma(String summa){
       
   }
   
   public String getMeno(){
       return this.meno;
   }
   
   public int getSumma(){
       return this.summa;
   }
   
   @Override
   public String toString(){
       return "Meno: " + meno + ", " + "Hinta: " + summa;
   }
    
}
