import java.text.DecimalFormat;

/**
 * Created by rickjackson on 2/8/17.
 */
public class Output {
    private RegexMatch regex;
    
    public Output() {
        this.regex = new RegexMatch();
    }
    
    public void printToScreen(String input) {
        System.out.println(buildAllItemOutputs(input));
    }
    
    public String buildAllItemOutputs(String input) {
        this.regex.findAllItems(input);
        StringBuilder sb = new StringBuilder();
        sb.append(buildSingleItemOutput("Milk"));
        sb.append(buildSingleItemOutput("Bread"));
        sb.append(buildSingleItemOutput("Cookies"));
        sb.append(buildSingleItemOutput("Apples"));
        sb.append(buildErrorOutput());
        return sb.toString();
    }
    
    public String buildErrorOutput() {
        StringBuilder sb = new StringBuilder("Errors");
        sb.append("               seen: ");
        sb.append(this.regex.getErrors().toString());
        sb.append(time(this.regex.getErrors().toString()));
        return sb.toString();
    }
    
    public String buildSingleItemOutput(String item) {
        String times = getTotalTimesSeen(item);
        
        StringBuilder sb = new StringBuilder("name:");
        sb.append(alignNameRight(item));
        sb.append(centerColumn());
        sb.append("seen: ");
        sb.append(times);
        sb.append(time(times));
        sb.append("=============        =============\n");
        sb.append(buildPricesOutput(item));
        return sb.toString();
    }
    
    public String buildPricesOutput(String item) {
        StringBuilder sb = new StringBuilder();
        
        for (double price : this.regex.prices.get(item)) {
            sb.append("Price:");
            sb.append(alignPriceRight(price));
            sb.append(centerColumn());
            sb.append("seen: ");
            sb.append(getTotalTimesSeen(item));
            sb.append(time(getTotalTimesSeen(item)));
            sb.append(lastLineBreak(Integer.valueOf(getTotalTimesSeen(item))));
        }
        
        return sb.toString();
    }
    
    public int singleItemPriceTotal(String item) {
        return this.regex.prices.get(item).size();
    }
    
    public String getTotalTimesSeen(String item) {
        int seen = 0;
        
        for (double d : this.regex.prices.get(item)) {
            seen += this.regex.frequencies.get(item).get(d);
        }
        
        return Integer.toString(seen);
    }
    
    public static String alignNameRight(String str) {
        return String.format("%1$8s", str);
    }
    
    public static String alignPriceRight(double price) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String str = df.format(price);
        return String.format("%1$7s", str);
    }
    
    public static String centerColumn() {
        return "        ";
    }
    
    public static String divideLine() {
        return "-------------" + centerColumn() + "-------------\n\n";
    }
    
    public static String stringBuilder(String existing, String append) {
        StringBuilder sb = new StringBuilder(existing);
        sb.append(append);
        return sb.toString();
    }
    
    public static String time(String times) {
        if (Integer.valueOf(times) == 1) {
            return " time \n";
        } else {
            return " times\n";
        }
    }
    
    public static String lastLineBreak(int times) {
        if (times % 2 == 0) {
            return "\n";
        } else {
            return divideLine();
        }
    }
}
