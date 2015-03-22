package task4;

import com.cp.task4.PhoneParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by user on 21.03.2015.
 */
public class PhoneParserTest {

    private static PhoneParser parser;

    @Before
    public void init(){
        parser = new PhoneParser();
    }

    @Test
    public void matchesTest(){
        Assert.assertTrue(parser.matches("55 55 555"));
        Assert.assertTrue(parser.matches("2 (913) 648 82 64"));
        Assert.assertTrue(parser.matches("+1 123 45 67"));
        Assert.assertTrue(parser.matches("+1 1234 12-34-56"));
        File file = new File("phoneNumbers");
        try {
            parser.matches(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void createNewFile(File file){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("111 11 54");
            writer.newLine();
            writer.write("8 (913) 648 82 64");
            writer.newLine();
            writer.write("+1 1234 12-34-56");
            writer.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
