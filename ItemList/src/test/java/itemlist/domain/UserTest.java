/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemlist.domain;

import itemlist.domain.User;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author erepo
 */
public class UserTest {

    User u1;

    @Before
    public void setUp() {
        u1 = new User("kattinen", "katti");
    }

    @Test
    public void equalWhenSameUsername() {
        User u2 = new User("kattinen", "katti");

        assertTrue(u1.equals(u2));
    }

    @Test
    public void isNotSameWhenDifferentUsername() {
        User u2 = new User("pipsa", "possunen");

        assertFalse(u1.equals(u2));
    }

    @Test
    public void returnsNameRight() {
        String name = u1.getName();

        assertEquals("katti", name);
    }

    @Test
    public void returnsUsernameRight() {
        String username = u1.getUsername();

        assertEquals("kattinen", username);
    }

    @Test
    public void IsnotSameWhenDifferentType() {
        Object o = new Object();

        assertFalse(u1.equals(o));
    }

}
