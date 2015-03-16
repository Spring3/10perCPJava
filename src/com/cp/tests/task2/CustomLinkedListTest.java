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
        Assert.assertTrue(linkedList.add(null));
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
        String str1 = "string 1";
        String str2 = "String 2";
        String str3 = "String 3";
        String str4 = "String 4";
        Assert.assertEquals(0, linkedList.size());
        linkedList.add(str1);
        Assert.assertEquals(1, linkedList.size());
        linkedList.add(str2);
        Assert.assertEquals(2, linkedList.size());
        linkedList.add(str3);
        Assert.assertEquals(3, linkedList.size());
        linkedList.add(str4);
        Assert.assertEquals(4, linkedList.size());
    }

    @Test
    public void clearTest(){
        linkedList.add("hello");
        linkedList.add("world");
        Assert.assertEquals(2, linkedList.size());
        linkedList.clear();
        Assert.assertEquals(0, linkedList.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstTest(){
        //NoSuchElementException
        linkedList.removeFirst();
        linkedList.add("hello");
        Assert.assertTrue(linkedList.removeFirst());
        Assert.assertEquals(0, linkedList.size());
        linkedList.add("java");
        linkedList.add("<3");
        Assert.assertTrue(linkedList.removeFirst());
        Assert.assertEquals("<3", linkedList.getFirst());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastTest(){
        //NoSuckElementException
        linkedList.removeLast();
        linkedList.add("hello");
        linkedList.add("world");
        Assert.assertTrue(linkedList.removeLast());
        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals("hello", linkedList.getLast());
    }

    @Test
    public void addFirstTest(){
        linkedList.addFirst("hello");
        linkedList.addFirst("world");
        linkedList.addFirst("ta-da!");
        Assert.assertEquals("ta-da!", linkedList.getFirst());
        linkedList.addFirst(null);
        Assert.assertEquals(null, linkedList.getFirst());
    }

    @Test
    public void addLastTest(){
        linkedList.addLast("hello");
        linkedList.addLast("world");
        Assert.assertEquals("world", linkedList.getLast());
    }

    @Test
    public void addByIndexTest(){
        Assert.assertTrue(linkedList.add(5, "hello"));
        Assert.assertEquals(7, linkedList.size());
        Assert.assertEquals(null, linkedList.getFirst());
        Assert.assertTrue(linkedList.add(0, "world"));
        Assert.assertEquals("world", linkedList.getFirst());
        Assert.assertEquals(8, linkedList.size());
        Assert.assertTrue(linkedList.add(4, "test"));
        Assert.assertEquals(9, linkedList.size());
    }

    @Test
    public void getTest(){
        Assert.assertTrue(linkedList.add("Hello"));
        Assert.assertTrue(linkedList.add("World"));
        Assert.assertTrue(linkedList.add(5, "test"));
        Assert.assertEquals("World", linkedList.get(1));
        Assert.assertEquals("test", linkedList.get(5));
    }
}
