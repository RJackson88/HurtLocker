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
    public void getPatternTest() {
        String expected = "[applesAPPLES]{6}";
        String actual = this.regex.getPattern("Apples");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
}
