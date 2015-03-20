package task3;

import com.cp.task3.ParallelCounter;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        double result = 0;
        try {
            result = counter.count(5, 7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertFalse(result == 0);
        System.out.println("RESULT: " + result);
    }
}
