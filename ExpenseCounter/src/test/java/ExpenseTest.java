/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import expensecounter.domain.Expense;
import expensecounter.domain.User;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author erepo
 */
public class ExpenseTest {
    

     @Test
     public void equalWhenSameId() {
         Expense exp1 = new Expense(1, "kissa", 0, null);
         Expense exp2 = new Expense(1, "kissa", 0, null);
         assertTrue(exp1.equals(exp2));
     }
     
     @Test 
     public void notEqualWhenDifferentId() {
         Expense exp1 = new Expense(1, "kissa", 0, null);
         Expense exp2 = new Expense(20, "kissa", 0, null);
         
         assertFalse(exp1.equals(exp2));
     }
     
     @Test
     public void getCostRight(){
         Expense exp = new Expense(0, "kissa", 10, null);
         int cost = exp.getCost();
         
         assertEquals(10, cost);
     }
     
     @Test
     public void getIdRight(){
         Expense exp = new Expense(1, "kissa", 0, null);
         int id = exp.getId();
         assertEquals(1, id);
     }
     
     @Test
     public void getProductRight(){
         Expense exp = new Expense("kissa", null);
         String kissa = exp.getProduct();
         
         assertEquals("kissa", kissa);
     }
     
    
}
