import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/8/17.
 */
public class RegexMatchTest {
    private RegexMatch regex;
    
    @Before
    public void setup() {
        regex = new RegexMatch();
    }
    
    @Test
    public void isRegexMatchForKeyValuePairDeliminatorTest() {
        boolean expected = true;
        boolean actual = regex.isRegexMatch("##",
                                            regex.keyValuePairDeliminator);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isRegexMatchForKeyValueDeliminatorTest() {
        boolean expected = true;
        boolean actual = regex.isRegexMatch(";:;",
                                            regex.keyValueDeliminator);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isRegexMatchForNameTest() {
        boolean expected = true;
        boolean actual = regex.isRegexMatch("NaMe", regex.nameMatcher);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isRegexMatchForPriceTest() {
        boolean expected = true;
        boolean actual = regex.isRegexMatch("pRIce", regex.priceMatcher);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isRegexMatchForMilkTest() {
        boolean expected = true;
        boolean actual = regex.isRegexMatch("mILK", regex.milkMatcher);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isRegexMatchForBreadTest() {
        boolean expected = false;
        boolean actual = regex.isRegexMatch("breaX", regex.breadMatcher);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isRegexMatchForCookiesTest() {
        boolean expected = true;
        boolean actual = regex.isRegexMatch("c00kies",
                                            regex.cookiesMatcher);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void isRegexMatchForApplesTest() {
        boolean expected = false;
        boolean actual = regex.isRegexMatch("a8pples",
                                            regex.applesMatcher);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void buildStringTest() {
        String expected = "([nameNAME]{4}({1}))([:;@^*%]{1,})"
                + "[applesAPPLES]{6}([:;@^*%]{1,})";
        String actual = regex.buildString(regex.nameMatcher,
                                           regex.applesMatcher);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
}
