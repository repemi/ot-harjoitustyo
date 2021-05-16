package itemlist.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import itemlist.domain.Item;
import itemlist.domain.User;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author erepo
 */
public class ItemTest {

    Item item;

    @Before
    public void setUp() {
        item = new Item(1, "housut", true, null);
    }

    @Test
    public void equalWhenSameId() {
        Item item2 = new Item(1, "housut", true, null);
        assertTrue(item.equals(item2));
    }

    @Test
    public void notEqualWhenDifferentId() {
        Item item2 = new Item(20, "housut", true, null);

        assertFalse(item.equals(item2));
    }

    @Test
    public void getIdRight() {

        int id = item.getId();
        assertEquals(1, id);
    }

    @Test
    public void getProductRight() {
        String housut = item.getProduct();

        assertEquals("housut", housut);
    }

    @Test
    public void idIsSetRight() {
        item.setId(12);
        assertEquals(12, item.getId());
    }

    @Test
    public void productIsSetRight() {
        item.setProduct("maito");

        assertEquals("maito", item.getProduct());

    }

    @Test
    public void userIsNull() {

        assertEquals(null, item.getUser());
    }
    
    @Test
    public void isCheckReturnsTrue(){
        
        assertTrue(item.isCheck());
    }
    
    @Test
    public void setCheckChangesStatusToTrue(){
        Item item2 = new Item(0, "", false, null);
        item2.setCheck();
        assertTrue(item.isCheck());
    }
    
    @Test
    public void DifferentTypesReturnsFalse() {
        Object o = new Object();
        assertFalse(item.equals(o));
    }

}

