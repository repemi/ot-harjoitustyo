/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import budgetapp.domain.Expense;
import budgetapp.domain.ExpenseCounterService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erepo
 */
public class ExpenseCounterServiceTest {

    public ExpenseCounterServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Scanner reader = new Scanner(System.in);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  @Test
  public void addExpenseRight(){
      Expense expense = new Expense("kissa", 10);
      ArrayList <Expense> list = new ArrayList<>();
      list.add(expense);
      assertEquals("[Meno: kissa, Hinta: 10]", list.toString());
  }
  
  @Test
  public void clearListIsClear() {
      ArrayList<Expense> list = new ArrayList<>();
      ArrayList<Expense> empty = new ArrayList<>();
      list.add(new Expense("kissa", 10));
      list.add(new Expense("koira", 40));
      
      list.clear();
      assertEquals(empty, list);
      
  }

}
