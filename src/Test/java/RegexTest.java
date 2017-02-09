import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/9/17.
 */
public class RegexTest {
    private Regex regex;
    
    @Before
    public void setup() {
        this.regex = new Regex();
    }
    
    @Test
    public void getKeyPatternTest() {
        String expected = "[pricePRICE1]{5}";
        String actual = this.regex.getKeyPattern("Price");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getValuePatternTest() {
        String expected = "[applesAPPLES$]{6}";
        String actual = this.regex.getValuePattern("Apples");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isMatchTest() {
        boolean expected = true;
        boolean actual = this.regex.isMatch("Co0kIe$", this.regex.getValuePattern
                ("Cookies"));
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isMatchDateTest() {
        boolean expected = true;
        boolean actual = this.regex.isMatch("02/09/2017", this.regex
                .getValuePattern("Date"));
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isNotError() {
        boolean expected = false;
        boolean actual = this.regex.isNotError("*");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void nextIndexTest() {
        Integer expected = 4;
        Integer actual = this.regex.nextIndex("name:", "[:;@^*%]{1}");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void nextSeparatorTest() {
        Integer expected = 8;
        Integer actual = this.regex.nextSeparatorIndex("0;1/kdla##");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void nextKeyTest() {
        Integer expected = 5;
        Integer actual = this.regex.nextKeyIndex("0;1/knamea##");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void nextDeliminatorTest() {
        Integer expected = 4;
        Integer actual = this.regex.nextDeliminatorIndex("name;food");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void nextValueTest() {
        Integer expected = 4;
        Integer actual = this.regex.nextValueIndex("0;1/C00KIES##");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getNextKeyTest() {
        String expected = "Name";
        String actual = this.regex.getNextKey("Type;nAme", 5);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getNextValueTest() {
        String expected = "Cookies";
        String actual = this.regex.getNextValue(";7C00kiesk;", 2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
}
