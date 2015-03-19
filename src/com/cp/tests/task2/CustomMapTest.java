package task2;

import com.cp.task2.CustomMap;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by user on 19.03.2015.
 */
public class CustomMapTest {

    private CustomMap<Integer, String> map;

    @Before
    public void inti(){
        map = new CustomMap<>(LocalDateTime.now());
    }

    @Test
    public void sizeTest(){
        Assert.assertEquals(0, map.size());
        Assert.assertEquals("Hello", map.put(1, "Hello"));
        Assert.assertEquals("world", map.put(2, "world"));
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void isEmptyTest(){
        Assert.assertTrue(map.isEmpty());
        Assert.assertEquals("hello", map.put(1, "hello"));
        Assert.assertFalse(map.isEmpty());
        Assert.assertEquals("hello", map.remove(1));
        Assert.assertTrue(map.isEmpty());
    }

    @Test
    public void containsKeyTest(){
        Assert.assertFalse(map.containsKey(1));
        Assert.assertEquals("hello", map.put(2, "hello"));
        Assert.assertEquals("world", map.put(3, "world"));
        Assert.assertFalse(map.containsKey(1));
        Assert.assertTrue(map.containsKey(2));
        Assert.assertEquals("!", map.put(1, "!"));
        Assert.assertTrue(map.containsKey(1));
    }

    @Test
    public void containsValueTest(){
        Assert.assertFalse(map.containsValue("hello"));
        Assert.assertEquals("hello", map.put(1, "hello"));
        Assert.assertTrue(map.containsValue("hello"));
        Assert.assertEquals("world", map.put(2, "world"));
        Assert.assertEquals("map", map.put(3, "map"));
        Assert.assertEquals("hello", map.remove(1));
        Assert.assertFalse(map.containsValue("hello"));
    }

    @Test
    public void getTest(){
        Assert.assertEquals(null, map.get(1));
        Assert.assertEquals("hello", map.put(1, "hello"));
        Assert.assertEquals("world", map.put(2, "world"));
        Assert.assertEquals("lol", map.put(3, "lol"));
        Assert.assertEquals("world", map.get(2));
        Assert.assertEquals("lol", map.get(3));
        Assert.assertEquals("hello", map.get(1));
    }

    @Test
    public void putTest(){
        Assert.assertEquals("hello", map.put(1, "hello"));
        Assert.assertEquals("world", map.put(2, "world"));
        Assert.assertEquals("test", map.put(1, "test"));
        Assert.assertEquals("lol", map.put(20, "lol"));
        Assert.assertEquals(3, map.size());
    }

    @Test
    public void removeTest(){
        Assert.assertEquals(null, map.remove(1));
        Assert.assertEquals("hello", map.put(1, "hello"));
        Assert.assertEquals("world", map.put(2, "world"));
        Assert.assertEquals("lol", map.put(5, "lol"));
        Assert.assertEquals(null, map.remove(4));
        Assert.assertEquals("world", map.remove(2));
        Assert.assertEquals("lol", map.remove(5));
        Assert.assertEquals(null, map.remove(null));
    }

    @Test
    public void clearTest(){
        Assert.assertEquals(0, map.size());
        Assert.assertEquals("Hello", map.put(1, "Hello"));
        Assert.assertEquals("World", map.put(2, "World"));
        Assert.assertEquals("Cat", map.put(3, "Cat"));
        Assert.assertEquals("Does", map.put(4, "Does"));
        Assert.assertEquals("Meow", map.put(5, "Meow"));
        Assert.assertEquals(5, map.size());
        map.clear();
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void getKeyTest(){
        Assert.assertEquals(null, map.getKey("hello"));
        Assert.assertEquals("World", map.put(3, "World"));
        Assert.assertEquals("Cat goes meow", map.put(1, "Cat goes meow"));
        Assert.assertEquals(Integer.valueOf(3), map.getKey("World"));
        Assert.assertEquals(null, map.put(5, null));
        Assert.assertEquals(null, map.getKey(null));
    }

    @Test
    public void replaceTest(){
        Assert.assertEquals("hello", map.put(1, "hello"));
        Assert.assertEquals("world", map.put(2, "world"));
        Assert.assertEquals("Cats", map.put(3, "Cats"));
        Assert.assertEquals("world", map.get(2));
        Assert.assertTrue(map.replace(2, "Replaced"));
        Assert.assertEquals("Replaced", map.get(2));
    }

    @Test
    public void mapTest(){
        Assert.assertEquals("hello", map.put(1, "hello"));
        Assert.assertEquals("world", map.put(2, "world"));
        Assert.assertEquals("Cats", map.put(3, "Cats"));
        Assert.assertEquals("can", map.put(4, "can"));
        Assert.assertEquals("kill", map.put(5, "kill"));
        Assert.assertTrue(map.replace(4, "can't"));
        Assert.assertEquals(5, map.size());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.setCleaningDate(LocalDateTime.now());
        Assert.assertEquals(0, map.size());
    }


}
