package expensecounter.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import expensecounter.domain.Expense;
import expensecounter.domain.User;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author erepo
 */
public class ExpenseTest {

    Expense exp1;

    @Before
    public void setUp() {
        exp1 = new Expense(1, "kissa", "10", null);
    }

    @Test
    public void equalWhenSameId() {
        Expense exp2 = new Expense(1, "kissa", "0", null);
        assertTrue(exp1.equals(exp2));
    }

    @Test
    public void notEqualWhenDifferentId() {
        Expense exp2 = new Expense(20, "kissa", "0", null);

        assertFalse(exp1.equals(exp2));
    }

    @Test
    public void getCostRight() {
        String cost = exp1.getCost();

        assertEquals("10", cost);
    }

    @Test
    public void getIdRight() {

        int id = exp1.getId();
        assertEquals(1, id);
    }

    @Test
    public void getProductRight() {
        String kissa = exp1.getProduct();

        assertEquals("kissa", kissa);
    }

    @Test
    public void idIsSetRight() {
        exp1.setId(12);
        assertEquals(12, exp1.getId());
    }

    @Test
    public void productIsSetRight() {
        exp1.setProduct("maito");

        assertEquals("maito", exp1.getProduct());

    }

    @Test
    public void costIsSetRight() {
        exp1.setCost("100");

        assertEquals("100", exp1.getCost());
    }

    @Test
    public void getCostIntReturnsInt() {
        int cost = exp1.getCostInt();

        assertEquals(10, cost);

    }

    @Test
    public void userIsNull() {

        assertEquals(null, exp1.getUser());
    }

    @Test
    public void toStringReturnsRight() {
        assertEquals("kissa, 10", exp1.toString());
    }

}
