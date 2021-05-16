package itemlist.dao;

import itemlist.dao.ItemDao;
import java.io.File;
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

    @AfterClass
    public static void tearDown() {
        //userFile.delete();
    }

}