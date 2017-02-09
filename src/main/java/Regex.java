import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rickjackson on 2/9/17.
 */
public class Regex {
    public Map<String, String> keyPatterns;
    public Map<String, String> valuePatterns;
    
    public Regex() {
        constructPatterns();
    }
    
    public void constructPatterns() {
        this.keyPatterns = new HashMap<String, String>();
        this.valuePatterns = new HashMap<String, String>();
        this.keyPatterns.put("KeyValuePairDelim", "[#]{2}");
        this.keyPatterns.put("KeyValueDelim", "[:;@^*%]{1}");
        this.keyPatterns.put("Name", "[nameNAME]{4}");
        this.keyPatterns.put("Price", "[pricePRICE1]{5}");
        this.keyPatterns.put("Type", "[typeTYPE]{4}");
        this.keyPatterns.put("Expiration", "[expirationEXPIRATION01]{10}");
        this.valuePatterns.put("Error", "[:;@^*%]{2,}");
        this.valuePatterns.put("Food", "[foodFOOD0]{4}");
        this.valuePatterns.put("Date", "(1[0-2]|0[1-9]{1}|[1-9]{1})([/-]{1})"
                + "(3[01]|[12][0-9]|0[1-9]|[0-9]{1})([/-]{1})"
                + "([0-9]{2}|[0-9]{4})");
        this.valuePatterns.put("Milk", "[milkMILK1]{4}");
        this.valuePatterns.put("Bread", "[breadBREAD]{5}");
        this.valuePatterns.put("Cookies", "[cookiesCOOKIES0$]{7}");
        this.valuePatterns.put("Apples", "[applesAPPLES$]{6}");
    }
    
    public String getKeyPattern(String key) {
        return this.keyPatterns.get(key);
    }
    
    public String getValuePattern(String key) {
        return this.valuePatterns.get(key);
    }
    
    public Matcher getMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
    
    public boolean isMatch(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }
    
    public boolean isNotError(String input) {
        return !isMatch(input, this.getKeyPattern("KeyValueDelim"));
    }
    
    public Integer nextIndex(String input, String regex) {
        Matcher m = getMatcher(input, regex);
        return m.find() ? m.start() : -1;
    }
    
    public Integer nextSeparatorIndex(String input) {
        return nextIndex(input, this.getKeyPattern("KeyValuePairDelim"));
    }
    
    public Integer nextKeyIndex(String input) {
        int next = 0;
        
        next = Math.max(next, nextIndex(input,
                this.getKeyPattern("KeyValueDelim")));
        next = Math.max(next, nextIndex(input,
                this.getKeyPattern("Name")));
        next = Math.max(next, nextIndex(input,
                this.getKeyPattern("Price")));
        next = Math.max(next, nextIndex(input,
                this.getKeyPattern("Type")));
        next = Math.max(next, nextIndex(input,
                this.getKeyPattern("Expiration")));
        return next;
    }
    
    public Integer nextDeliminatorIndex(String input) {
        return nextIndex(input, this.getKeyPattern("KeyValueDelim"));
    }
    
    public Integer nextValueIndex(String input) {
        int next = 0;
        
        next = Math.max(next, nextIndex(input,
                this.getKeyPattern("KeyValueDelim")));
        next = Math.max(next, nextIndex(input,
                this.getValuePattern("Food")));
        next = Math.max(next, nextIndex(input,
                this.getValuePattern("Milk")));
        next = Math.max(next, nextIndex(input,
                this.getValuePattern("Bread")));
        next = Math.max(next, nextIndex(input,
                this.getValuePattern("Cookies")));
        next = Math.max(next, nextIndex(input,
                this.getValuePattern("Apples")));
        return next;
    }
    
    public String getNextKey(String input, Integer index) {
        if (index == nextIndex(input, this.getKeyPattern("Name"))) {
            return "Name";
        } else if (index == nextIndex(input, this.getKeyPattern("Price"))) {
            return "Price";
        } else if (index == nextIndex(input, this.getKeyPattern("Type"))) {
            return "Type";
        } else if (index == nextIndex(input, this.getKeyPattern
                ("Expiration"))) {
            return "Expiration";
        } else {
            return "Error";
        }
    }
    
    public String getNextValue(String input, Integer index) {
        if (index == nextIndex(input, this.getValuePattern("Food"))) {
            return "Food";
        } else if (index == nextIndex(input, this.getValuePattern("Bread"))) {
            return "Bread";
        } else if (index == nextIndex(input, this.getValuePattern("Cookies"))) {
            return "Cookies";
        } else if (index == nextIndex(input, this.getValuePattern("Milk"))) {
            return "Milk";
        } else if (index == nextIndex(input, this.getValuePattern("Apples"))){
            return "Apples";
        } else if (index == nextIndex(input, this.getValuePattern("Date"))) {
            return "Date";
        } else {
            return "Error";
        }
    }
}
