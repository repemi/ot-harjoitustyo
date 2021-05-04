package expensecounter.dao;

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
public class FileExpenseDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File userFile;
    ExpenseDao dao;

    @AfterClass
    public static void tearDown() {
        //userFile.delete();
    }

}
