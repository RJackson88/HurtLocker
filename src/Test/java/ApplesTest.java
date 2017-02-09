import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/8/17.
 */
public class ApplesTest {
    private Apples apples;
    
    @Before
    public void setup() {
        this.apples = new Apples();
    }
    
    @Test
    public void getApplesSeenTest() {
        Integer expected = 0;
        Integer actual = this.apples.getApplesSeen();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
}
