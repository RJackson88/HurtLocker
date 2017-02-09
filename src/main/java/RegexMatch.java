import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rickjackson on 2/8/17.
 */
public class RegexMatch {
    public List<String> items;
    public Map<String, List<Double>> prices;
    public Map<String, Map<Double, Integer>> frequencies;
    public Integer errors;
    public String keyValuePairDeliminator;
    public String keyValueDeliminator;
    public String nameMatcher;
    public String priceMatcher;
    public String milkMatcher;
    public String breadMatcher;
    public String cookiesMatcher;
    public String applesMatcher;
    public String nameItemMatcher;
    public String priceValueMatcher;
    
    public RegexMatch() {
        this.items = new ArrayList<String>();
        this.prices = new HashMap<String, List<Double>>();
        this.frequencies = new HashMap<String, Map<Double, Integer>>();
        this.errors = 0;
        this.keyValuePairDeliminator = "([#]{2}({1}))";
        this.keyValueDeliminator = "([:;@^*%]{1,})";
        this.nameMatcher = "(([nameNAME]{4}){1,})";
        this.priceMatcher = "[pricePRICE]{5}";
        this.milkMatcher = "[milkMILK]{4}";
        this.breadMatcher = "[breadBREAD]{5}";
        this.cookiesMatcher = "[cookiesCOOKIES0]{7}";
        this.applesMatcher = "([applesAPPLES]{6})";
        this.nameItemMatcher = "";
        this.priceValueMatcher = "";
    }
    
    public void findAllItems(String input) {
        findSingleItemValues("Apples", this.applesMatcher, input);
        findSingleItemValues("Bread", this.breadMatcher, input);
        findSingleItemValues("Cookies", this.cookiesMatcher, input);
        findSingleItemValues("Milk", this.milkMatcher, input);
    }
    
    public boolean isRegexMatch(String string, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        return m.matches();
    }
    
    public String buildString(String key, String value) {
        StringBuilder sb = new StringBuilder(key);
        sb.append(this.keyValueDeliminator);
        sb.append(value);
        sb.append(this.keyValueDeliminator);
        return sb.toString();
    }
    
    public void findSingleItemValues(String item, String matcher,
            String input) {
        int start = 0;
        int end = 0;
        String sub = "";
        this.items.add(item);
        this.prices.put(item, new ArrayList<Double>());
        
        Pattern p = Pattern.compile(this.nameMatcher);
        Matcher m = p.matcher(input);
        
//        while (m.find() && !m.hitEnd()) {
//            sub = input.substring(m.start(), m.end() + 1);
        while (m.find() && !m.hitEnd()) {
            sub = input.substring(m.start() + 5, m.end() + 1 + item.length());
            System.out.println(sub);
            
            Pattern kvp = Pattern.compile(matcher);
            Matcher kvm = kvp.matcher(sub);
            
//            Pattern kvp = Pattern.compile(buildString(this.nameMatcher,
//                                                     matcher));
//            Matcher kvm = kvp.matcher(sub);
//            StringBuilder sb = new StringBuilder(kvp.toString());
//            sb.append(this.keyValueDeliminator);
//            Pattern next = Pattern.compile(sb.toString());
//            Matcher nextm = next.matcher(sub);
//
//            if (kvm.matches() && (!nextm.matches())) {
            if (kvm.matches()) {
//                addToSets(input, kvm.end() + 1, item);
                addToSets(input, m.end() + 14, item);
            } else {
                System.out.println(this.errors++);
            }
        }
    }
    
    public void addToSets(String string, int begin, String item) {
        String sub = string.substring(begin, begin + 4);
//        System.out.println(sub);
        Pattern p = Pattern.compile("(\\d{1}).(\\d{2})");
        Matcher m = p.matcher(sub);
        double d;
        
        if (m.matches()) {
            d = Double.valueOf(sub);
            addItems(item, d);
        }
    }
    
    public void addItems(String item, double d) {
        if (this.prices.get(item).contains(d)) {
            int freq = this.frequencies.get(item).get(d) + 1;
            this.frequencies.get(item).put(d, freq);
        } else {
            this.prices.put(item, new ArrayList<Double>());
            this.prices.get(item).add(d);
            this.frequencies.put(item, new HashMap<Double, Integer>());
            this.frequencies.get(item).put(d, 1);
        }
    }
    
    public Integer getErrors() {
        return this.errors;
    }
}
