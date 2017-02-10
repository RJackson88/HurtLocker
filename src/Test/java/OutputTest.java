import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/8/17.
 */
public class OutputTest {
    private Output out;
    private ItemList itemList;
    
    @Before
    public void setup() {
        itemList = new ItemList();
        out = new Output(itemList.prices, itemList.frequencies,
                itemList.getErrorsSeen());
    }
    
    @Test
    public void alignNameRightTest() {
        String expected = "name:  Apples";
        String actual = "name:" + out.alignNameRight("Apples");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void alignPriceRightTest() {
        String expected = "   2.00";
        String actual = out.alignPriceRight(2.00);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void centerColumnTest() {
        String expected = "        ";
        String actual = out.centerColumn();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void divideLineTest() {
        String expected = "-------------";
        String actual = out.divideLine();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void lastLineBreak() {
        String expected = "-------------";
        String actual = out.lastLineBreak(1);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
}
