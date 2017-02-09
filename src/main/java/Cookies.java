import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickjackson on 2/8/17.
 */
public class Cookies {
    private Map<String, String> prices;
    private Integer cookiesSeen;
    
    public Cookies() {
        this.prices = new HashMap<String, String>();
        this.cookiesSeen = 0;
    }
    
    public Integer getCookiesSeen() {
        return this.cookiesSeen;
    }
    
    public void incrementCookiesSeen() {
        this.cookiesSeen++;
    }
}
