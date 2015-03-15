package task1;

import com.cp.task1.Shuffler;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * Created by user on 15.03.2015.
 */
public class ShufflerTest {

    private Integer[] singleDimArray;
    private Integer[][] doubleDimArray;
    private Integer[] wrongArray;

    @Before
    public void reFillArrays(){
        System.out.println("TASK 1 TEST");
        singleDimArray = new Integer[20];
        doubleDimArray = new Integer[5][5];
        wrongArray = new Integer[2];
        fillSingleDimArray(singleDimArray);
        filleDoubleDimArray(doubleDimArray);
        fillSingleDimArray(wrongArray);
    }

    @Test
    public void shuffleTest(){
        Shuffler<Integer> shuffler = new Shuffler<>();
        //initializing arrays

        Integer[] defaultStateSingleDimArray = new Integer[singleDimArray.length];
        for (int i = 0 ; i < singleDimArray.length; i ++){
            defaultStateSingleDimArray[i] = singleDimArray[i];
        }
        Integer[][] defaultStateDoubleDimArray = new Integer[doubleDimArray.length][doubleDimArray[0].length];
        for (int i = 0 ; i < doubleDimArray.length; i ++){
            for (int j = 0; j < doubleDimArray[0].length; j ++){
                defaultStateDoubleDimArray[i][j] = doubleDimArray[i][j];
            }
        }

        Integer[] defaultStateWrongArray = new Integer[wrongArray.length];
        for (int i = 0; i < wrongArray.length; i ++){
            defaultStateWrongArray[i] = wrongArray[i];
        }
        shuffler.shuffle(singleDimArray);
        shuffler.shuffle(doubleDimArray);
        shuffler.shuffle(wrongArray);

        Assert.assertNotNull(singleDimArray);
        Assert.assertThat(singleDimArray, IsNot.not(IsEqual.equalTo(defaultStateSingleDimArray)));

        Assert.assertNotNull(doubleDimArray);
        Assert.assertThat(doubleDimArray, IsNot.not(IsEqual.equalTo(defaultStateDoubleDimArray)));

        Assert.assertNotNull(wrongArray);
        Assert.assertThat(wrongArray, Is.is(IsEqual.equalTo(defaultStateWrongArray)));



    }

    private void fillSingleDimArray(Integer[] arrayToFill){
        Random rand = new Random();
        for(int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = rand.nextInt(Integer.MAX_VALUE);
        }
    }

    private void filleDoubleDimArray(Integer[][] arrayToFill){
        Random rand = new Random();
        for (int i = 0; i < arrayToFill.length; i ++){
            for (int j = 0; j < arrayToFill[0].length; j ++){
                arrayToFill[i][j] = rand.nextInt(Integer.MAX_VALUE);
            }
        }
    }
}
