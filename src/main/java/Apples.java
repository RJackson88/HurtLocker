import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickjackson on 2/8/17.
 */
public class Apples {
    private Map<String, Integer> prices;
    private Integer applesSeen;
    
    public Apples() {
        this.prices = new HashMap<String, Integer>();
        this.applesSeen = 0;
    }
    
    public Integer getApplesSeen() {
        return this.applesSeen;
    }
    
    public void incrementApplesSeen() {
        this.applesSeen++;
    }
}
