import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/8/17.
 */
public class CookiesTest {
    private Cookies cookies;
    
    @Before
    public void setup() {
        this.cookies = new Cookies();
    }
    
    @Test
    public void getCookiesSeenTest() {
        Integer expected = 0;
        Integer actual = this.cookies.getCookiesSeen();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
}
