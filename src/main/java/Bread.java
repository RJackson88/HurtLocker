import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickjackson on 2/8/17.
 */
public class Bread {
    private Map<String, Integer> prices;
    private Integer breadSeen;
    
    public Bread() {
        this.prices = new HashMap<String, Integer>();
        this.breadSeen = 0;
    }
    
    public Integer getBreadSeen() {
        return this.breadSeen;
    }
    
    public void incrementBreadSeen() {
        this.breadSeen++;
    }
}
