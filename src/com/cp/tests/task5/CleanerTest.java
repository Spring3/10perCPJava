package task5;

import com.cp.Main;
import com.cp.task5.Cleaner;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by user on 22.03.2015.
 */
public class CleanerTest {

    private Cleaner cleaner;

    @Before
    public void init(){
        cleaner = new Cleaner();
    }

    @Test
    public void cleanTest(){
        File file = new File("resources/src.java");
        cleaner.cleanFile(file);

    }
}
