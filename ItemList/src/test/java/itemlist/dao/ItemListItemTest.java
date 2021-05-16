/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemlist.dao;

import itemlist.domain.FakeItemDao;
import itemlist.domain.FakeUserDao;
import itemlist.domain.Item;
import itemlist.domain.ItemList;
import itemlist.domain.User;
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
public class ItemListItemTest {

    FakeUserDao userDao;
    FakeItemDao itemDao;
    ItemList itemList;

    @Before
    public void setUp() throws Exception {
        userDao = new FakeUserDao();
        itemDao = new FakeItemDao();
        itemList = new ItemList(itemDao, userDao);
        User user1 = new User("pipsa", "possu");
        User user2 = new User("katti", "kattinen");

        userDao.create(user1);
        userDao.create(user2);
        itemDao.create(new Item(1, "housut", false, user1));
        itemList = new ItemList(itemDao, userDao);
        itemList.login("pipsa");

    }

    

}
