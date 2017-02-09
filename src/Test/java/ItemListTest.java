import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/9/17.
 */
public class ItemListTest {
    private ItemList list;
    
    @Before
    public void setup() {
        this.list = new ItemList();
        this.list.addPrice("Apples", 1.00);
        this.list.addPrice("Apples", 1.50);
        this.list.addPrice("Apples", 1.00);
    }
    
    @Test
    public void getErrorsSeenTest() {
        int expected = 0;
        int actual = this.list.getErrorsSeen();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void addPriceTest() {
        this.list.addPrice("Apples", 0.50);
        int expected = 1;
        int actual = this.list.frequencies.get("Apples").get(0.50);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void getPriceFrequencyTest() {
        int expected = 2;
        int actual = this.list.getPriceFrequency("Apples", 1.00);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void getItemTimesSeenTest() {
        int expected = 3;
        int actual = this.list.getItemTimesSeen("Apples");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
}
