import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/8/17.
 */
public class BreadTest {
    private Bread bread;
    
    @Before
    public void setup() {
        this.bread = new Bread();
    }
    
    @Test
    public void getBreadSeenTest() {
        Integer expected = 0;
        Integer actual = this.bread.getBreadSeen();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
}
