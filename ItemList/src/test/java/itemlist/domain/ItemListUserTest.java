package itemlist.domain;



import itemlist.domain.User;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ItemListUserTest {
    
    FakeItemDao itemDao;
    FakeUserDao userDao;
    ItemList itemList;
    
    @Before
    public void setUp(){
        itemDao = new FakeItemDao();
        userDao = new FakeUserDao();
        itemList = new ItemList(itemDao, userDao);
    }
    
    @Test
    public void createdUserCanLogIn(){
        boolean result = itemList.login("pipsa");
        assertTrue(result);
    }
    
    @Test
    public void userWithoutUsernameCantLogIn(){
        boolean result = itemList.login("noname");
        assertFalse(result);
    }
    
    @Test
    public void userCanLogOut(){
        itemList.login("pipsa");
        itemList.logout();
        assertEquals(null, itemList.getLoggedUser());
    }
    
    @Test
    public void UsersCanNotHaveSameUName(){
        boolean result = itemList.createUser("pipsa", "maija maijanen");
        assertFalse(result);
    }
    
    

}

