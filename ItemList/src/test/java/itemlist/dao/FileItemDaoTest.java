package itemlist.dao;

import itemlist.dao.ItemDao;
import itemlist.domain.FakeUserDao;
import itemlist.domain.Item;
import itemlist.domain.User;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author erepo
 */
public class FileItemDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File userFile;
    ItemDao dao;

    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");
        UserDao userDao = new FakeUserDao();
        userDao.create(new User("pipsa", "possu"));

        try ( FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("1;housut;false;pipsa\n");
            file.write("2;paita;false;pipsan\n");
        }

        dao = new FileItemDao(userFile.getAbsolutePath(), userDao);

    }

    @Test
    public void itemsSizeMatchesOnTheList() {
        List<Item> items = dao.getAll();
        assertEquals(2, items.size());
    }

    @Test
    public void itemIsEqualOnTheList() {
        List<Item> items = dao.getAll();
        String test = items.get(0).getProduct();
        assertEquals("housut", test);
    }

    @Test
    public void userIsSameOnTheList() {
        List<Item> items = dao.getAll();

        assertEquals("pipsa", items.get(0).getUser().getUsername());
    }

    @After
    public void tearDown() {
        userFile.delete();
    }

}
