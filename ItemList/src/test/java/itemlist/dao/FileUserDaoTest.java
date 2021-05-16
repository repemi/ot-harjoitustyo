package itemlist.dao;

import itemlist.dao.FileUserDao;
import itemlist.dao.UserDao;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import itemlist.domain.User;

public class FileUserDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File userFile;
    UserDao dao;

    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");

        try ( FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("kattinen;katti\n");
        }

        dao = new FileUserDao(userFile.getAbsolutePath());
    }
    
    @Test
    public void rightAmountOfUsersInFile(){
        List<User>users = dao.getAll();
        assertEquals(1, users.size());
        
    }
    @Test
    public void rightNameAndUsernameInFile(){
        List<User>users = dao.getAll();
        User user = users.get(0);
        assertEquals("katti", user.getName());
        assertEquals("kattinen", user.getUsername());
    }
    
    @Test
    public void existingUserIsInTheFile(){
        User user = dao.findByUsername("kattinen");
        assertEquals("katti", user.getName());
        assertEquals("kattinen", user.getUsername());
    }
    
    @Test
    public void nonExsistingUserIsNotInTheFile(){
        User noUser = dao.findByUsername("pimu");
        assertEquals(null, noUser);
    }
    
    @Test
    public void userIsSavedRight() throws Exception{
        User newUser = new User("pipsa", "possu");
        dao.create(newUser);
        
        User user = dao.findByUsername("pipsa");
        assertEquals("possu", newUser.getName());
        assertEquals("pipsa", newUser.getUsername());
    }
    
    @After
    public void TearDown(){
        userFile.delete();
    }
}
