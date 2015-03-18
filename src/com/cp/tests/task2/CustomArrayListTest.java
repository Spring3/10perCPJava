package task2;

import com.cp.task2.CustomArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created by user on 18.03.2015.
 */
public class CustomArrayListTest {

    @Before
    public void init(){
        arrayList = new CustomArrayList<>(LocalDateTime.now());
    }

    private CustomArrayList<Integer> arrayList;

    @Test
    public void sizeTest(){
        Assert.assertEquals(0, arrayList.size());
        Assert.assertTrue(arrayList.add(30));
        Assert.assertTrue(arrayList.add(5));
        Assert.assertEquals(2, arrayList.size());
    }

    @Test
    public void isEmptyTest(){
        Assert.assertTrue(arrayList.isEmpty());
        Assert.assertTrue(arrayList.add(2));
        Assert.assertFalse(arrayList.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void containsTest(){
        Assert.assertFalse(arrayList.contains(1));
        Assert.assertTrue(arrayList.add(5));
        Assert.assertTrue(arrayList.contains(5));
    }

    @Test
    public void indexOfTest(){
        Assert.assertEquals(-1, arrayList.indexOf(10));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(2));
        Assert.assertTrue(arrayList.add(3));
        Assert.assertTrue(arrayList.add(4));
        Assert.assertTrue(arrayList.add(5));
        Assert.assertTrue(arrayList.add(4));
        Assert.assertEquals(3, arrayList.indexOf(4));
        Assert.assertEquals(0, arrayList.indexOf(1));
        Assert.assertEquals(4, arrayList.indexOf(5));
    }

    @Test
    public void lastIndexOfTest(){
        Assert.assertEquals(-1, arrayList.lastIndexOf(5));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(3));
        Assert.assertTrue(arrayList.add(2));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(5));
        Assert.assertTrue(arrayList.add(3));
        Assert.assertTrue(arrayList.add(7));
        Assert.assertEquals(5, arrayList.lastIndexOf(3));
        Assert.assertEquals(3, arrayList.lastIndexOf(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getTest(){
        arrayList.get(5);
        arrayList.get(-2);
        Assert.assertTrue(arrayList.add(2));
        Assert.assertTrue(arrayList.add(4));
        Assert.assertTrue(arrayList.add(5));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(2));
        Assert.assertEquals(Integer.valueOf(5), arrayList.get(2));
        Assert.assertEquals(Integer.valueOf(1), arrayList.get(3));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(4));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(0));
    }

    @Test
    public void setTest(){
        arrayList.set(5, 6);
        Assert.assertTrue(arrayList.set(0, 5));
        Assert.assertTrue(arrayList.add(3));
        Assert.assertEquals(Integer.valueOf(5), arrayList.get(0));
        Assert.assertEquals(0, arrayList.indexOf(5));
    }

    @Test
    public void addTest(){
        Assert.assertTrue(arrayList.add(5));
        Assert.assertTrue(arrayList.add(3));
        Assert.assertTrue(arrayList.add(null));
        Assert.assertTrue(arrayList.add(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addByIndex(){
        arrayList.add(20, 1);
        Assert.assertTrue(arrayList.add(0,5));
        Assert.assertTrue(arrayList.add(1,2));
        Assert.assertTrue(arrayList.add(0,8));
        Assert.assertEquals(Integer.valueOf(8), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(5), arrayList.get(1));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(2));
    }

    @Test
    public void removeTest(){
        Assert.assertTrue(arrayList.add(2));
        Assert.assertTrue(arrayList.add(4));
        Assert.assertTrue(arrayList.add(2));
        Assert.assertTrue(arrayList.add(5));
        Assert.assertTrue(arrayList.remove(Integer.valueOf(2)));
        Assert.assertEquals(Integer.valueOf(4), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(1));
        Assert.assertEquals(3, arrayList.size());
    }

    @Test
    public void removeByIndexTest(){
        Assert.assertTrue(arrayList.add(2));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(4));
        Assert.assertTrue(arrayList.add(2));
        Assert.assertTrue(arrayList.add(5));
        Assert.assertTrue(arrayList.add(2));
        Assert.assertEquals(6, arrayList.size());
        Assert.assertTrue(arrayList.remove(2));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(2));
        Assert.assertEquals(5, arrayList.size());
    }

    @Test
    public void clearTest(){
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertTrue(arrayList.add(1));
        Assert.assertEquals(6, arrayList.size());
        arrayList.clear();
        Assert.assertEquals(0, arrayList.size());
    }


}
