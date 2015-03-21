package task3;

import com.cp.task3.ParallelCounter;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * Created by user on 20.03.2015.
 */
public class ParallelCounterTest {

    private ParallelCounter counter;

    @Before
    public void init(){
        counter = new ParallelCounter();
    }

    @Test
    public void countTest(){
        double result = counter.count(5, 7);
        Assert.assertFalse(result == 0);
        System.out.println("TASK 3 RESULT: " + result);
        double anotherResult = counter.count(5, 4);
        Assert.assertTrue(result == anotherResult);
    }

    @Test
    public void countFileTest(){
        double result = 0;
        File srcFile = new File("task3");
        if (!srcFile.exists()){
            createFile(srcFile);
        }
        try {
            result = counter.count(new FileInputStream(srcFile));
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        Assert.assertTrue(0 != result);
    }

    @Test
    public void countThreadPoolTest(){
        double result = counter.countThreadPool(20, 10);

        Assert.assertTrue(0 != result);
        System.out.println("TASK 3 RESULT WITH CUSTOM THREAD POOL: " + result);

        double anotherResult = counter.countThreadPool(20, 5);
        Assert.assertTrue(0 != result);
        Assert.assertTrue(result == anotherResult);
        System.out.println("TASK 3 ANOTHER RESULT WITH CUSTOM THREAD POOL: " + result);
    }

    private void createFile(File file){
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            Random rand = new Random();
            writer.write(rand.nextInt(21) + " " + rand.nextInt(21));
            writer.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
