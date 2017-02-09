import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rickjackson on 2/9/17.
 */
public class ItemList {
    public List<String> items;
    public Map<String, List<Double>> prices;
    public Map<String, Map<Double, Integer>> frequencies;
    public Integer errors;
    
    public ItemList() {
        this.errors = 0;
        constructItemsList();
        constructPricesAndFrequenciesMaps();
    }
    
    public Integer getErrorsSeen() {
        return this.errors;
    }
    
    public void incrementErrors() {
        this.errors++;
    }
    
    public void constructItemsList() {
        this.items = new ArrayList<String>(4);
        this.items.add("Milk");
        this.items.add("Bread");
        this.items.add("Cookies");
        this.items.add("Apples");
    }
    
    public void constructPricesAndFrequenciesMaps() {
        this.prices = new HashMap<String, List<Double>>();
        this.frequencies = new HashMap<String, Map<Double, Integer>>();
        
        for (String i : this.items) {
            this.prices.put(i, new ArrayList<Double>());
            this.frequencies.put(i, new HashMap<Double, Integer>());
        }
    }
    
    public void addPrice(String item, Double price) {
        if (!this.prices.get(item).contains(price)) {
            this.prices.get(item).add(price);
            this.frequencies.get(item).put(price, 1);
        } else {
            incrementFrequency(item, price);
        }
    }
    
    public Integer getPriceFrequency(String item, Double price) {
        return this.frequencies.get(item).get(price);
    }
    
    public void incrementFrequency(String item, Double price) {
        int freq = getPriceFrequency(item, price);
        this.frequencies.get(item).put(price, freq + 1);
    }
    
    public Integer getItemTimesSeen(String item) {
        Integer seen = 0;
        
        for (Double price : this.prices.get(item)) {
            seen += getPriceFrequency(item, price);
        }
        return seen;
    }
}
