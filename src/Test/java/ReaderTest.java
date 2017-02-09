import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/9/17.
 */
public class ReaderTest {
    private Reader reader;
    
    @Before
    public void setup() {
        this.reader = new Reader();
    }
    
    @Test
    public void nextCharacterTest() {
        String expected = "n";
        String actual = this.reader.nextCharacter(0);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void nextWordTest() {
        String expected = "naMe:";
        String actual = this.reader.nextWord(0, 5);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
}
