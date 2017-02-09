import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickjackson on 2/9/17.
 */
public class Regex {
    public Map<String, String> patterns;
    
    public Regex() {
        constructPatterns();
    }
    
    public void constructPatterns() {
        this.patterns = new HashMap<String, String>();
        this.patterns.put("KeyValuePairDelim", "[#]{2}");
        this.patterns.put("KeyValueDelim", "[:;@^*%]{1}");
        this.patterns.put("Name", "[nameNAME]{4}");
        this.patterns.put("Price", "[pricePRICE]{5}");
        this.patterns.put("Error", "[:;@^*%]{2,}");
        this.patterns.put("Milk", "[milkMILK]{4}");
        this.patterns.put("Bread", "[breadBREAD]{5}");
        this.patterns.put("Cookies", "[cookiesCOOKIES0]{7}");
        this.patterns.put("Apples", "[applesAPPLES]{6}");
    }
    
    public String getPattern(String key) {
        return this.patterns.get(key);
    }
}
