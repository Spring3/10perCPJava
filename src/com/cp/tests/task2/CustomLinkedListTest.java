package task2;

import com.cp.task2.CustomLinkedList;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Created by user on 16.03.2015.
 */
public class CustomLinkedListTest {

    private CustomLinkedList<String> linkedList;

    @Before
    public void init(){
        linkedList = new CustomLinkedList<>();
    }

    @Test
    public void addTest(){
        Assert.assertTrue(linkedList.add("Hello"));
        Assert.assertTrue(linkedList.add("World"));
        Assert.assertTrue(linkedList.add("TestPhrase"));
    }

    @Test(expected = NoSuchElementException.class)
    public void getFirstTest(){
        String testPhrase = "Test phrase 1";
        String testPhrase2 = "Test phrase 2";
        linkedList.getFirst();
        linkedList.add(testPhrase);
        Assert.assertEquals(linkedList.getFirst(), linkedList.getLast());
        linkedList.add(testPhrase2);
        Assert.assertEquals(linkedList.getFirst(), testPhrase);
        Assert.assertThat(testPhrase2, IsNot.not(IsEqual.equalTo(linkedList.getFirst())));
    }

    @Test
    public void getLastTest(){
        String test1 = "Test phrase 1";
        String test2 = "Test phrase 2";
        String test3 = "Test phrase 3";
        linkedList.add(test1);
        Assert.assertEquals(linkedList.getLast(), linkedList.getFirst());
        Assert.assertEquals(linkedList.getLast(), test1);
        linkedList.add(test2);
        Assert.assertEquals(linkedList.getLast(), test2);
        Assert.assertThat(test1, IsNot.not(IsEqual.equalTo(linkedList.getLast())));
        linkedList.add(test3);
        Assert.assertEquals(linkedList.getLast(), test3);
        Assert.assertThat(test2, IsNot.not(IsEqual.equalTo(linkedList.getLast())));
    }

    @Test
    public void containsTest(){
        String testPhrase1 = "Test phrase 1";
        String testPhrase2 = "Test phrase 2";
        Assert.assertFalse(linkedList.contains(null));
        Assert.assertFalse(linkedList.contains(testPhrase1));
        linkedList.add(testPhrase1);
        Assert.assertTrue(linkedList.contains(testPhrase1));
        Assert.assertFalse(linkedList.contains(testPhrase2));
        linkedList.add(testPhrase2);
        Assert.assertTrue(linkedList.contains(testPhrase2));

    }

    @Test
    public void sizeTest(){

    }
}
