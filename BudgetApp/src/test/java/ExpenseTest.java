/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import budgetapp.domain.Expense;
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
public class ExpenseTest {

    public ExpenseTest() {
    }

    @BeforeClass
    public static void setUpClass() {

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void constructorSetParametersRight() {

        Expense expense = new Expense("kissa", 10);

        String ans = expense.toString();
        assertEquals("Meno: kissa, Hinta: 10", ans);
    }

    @Test
    public void getMenoRetunsRight() {
        Expense expense = new Expense("kissa", 10);
        String ans = expense.getMeno();
        assertEquals("kissa", ans);

    }

    @Test
    public void getSummaRetunsRight() {
        Expense expense = new Expense("kissa", 10);
        int ans = expense.getSumma();
        assertEquals(10, ans);

    }

}
