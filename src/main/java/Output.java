import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by rickjackson on 2/8/17.
 */
public class Output {
    private ItemList itemList;
    private Map<String, List<Double>> priceMap;
    private Map<String, Map<Double, Integer>> freqMap;
    private Integer errors;
    
    public Output(Map<String, List<Double>> priceMap, Map<String,
            Map<Double, Integer>> freqMap, Integer errors) {
        this.priceMap = priceMap;
        this.freqMap = freqMap;
        this.errors = errors;
        this.itemList = new ItemList();
    }
    
    public void printToScreen() {
        System.out.println(buildAllItemOutputs());
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

    public String buildAllItemOutputs() {
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
        sb.append(this.errors.toString());
        sb.append(time(this.errors.toString()));
        return sb.toString();
    }
    
//    public String buildErrorOutput() {
//        StringBuilder sb = new StringBuilder("Errors");
//        sb.append("               seen: ");
//        sb.append(this.itemList.getErrorsSeen().toString());
//        sb.append(time(this.itemList.getErrorsSeen().toString()));
//        return sb.toString();
//    }

    public String buildPricesOutput(String item) {
        StringBuilder sb = new StringBuilder();

        for (double price : this.priceMap.get(item)) {
            sb.append("Price:");
            sb.append(alignPriceRight(price));
            sb.append(centerColumn());
            sb.append("seen: ");
            sb.append(this.freqMap.get(item).get(price));
            sb.append(time(this.freqMap.get(item).get(price).toString()));
            
            if (this.priceMap.get(item).indexOf(price) % 2 == 0) {
                sb.append(divideLine());
            } else {
                sb.append("\n");
            }
            
            if (this.priceMap.get(item).size() % 2 != 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
//    public String buildPricesOutput(String item) {
//        StringBuilder sb = new StringBuilder();
//
//        for (double price : this.itemList.prices.get(item)) {
//            sb.append("Price:");
//            sb.append(alignPriceRight(price));
//            sb.append(centerColumn());
//            sb.append("seen: ");
//            sb.append(getTotalTimesSeen(item));
//            sb.append(time(getTotalTimesSeen(item)));
//            sb.append(lastLineBreak(Integer.valueOf(getTotalTimesSeen(item))));
//        }
//
//        return sb.toString();
//    }

    public int singleItemPriceTotal(String item) {
        return this.itemList.prices.get(item).size();
    }

    public String getTotalTimesSeen(String item) {
        int seen = 0;

        for (double d : this.priceMap.get(item)) {
            seen += this.freqMap.get(item).get(d);
        }

        return Integer.toString(seen);
    }
    
//    public String getTotalTimesSeen(String item) {
//        int seen = 0;
//
//        for (double d : this.itemList.prices.get(item)) {
//            seen += this.itemList.frequencies.get(item).get(d);
//        }
//
//        return Integer.toString(seen);
//    }

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
        return "-------------" + centerColumn() + "-------------\n";
    }
//
//    public static String stringBuilder(String existing, String append) {
//        StringBuilder sb = new StringBuilder(existing);
//        sb.append(append);
//        return sb.toString();
//    }
//
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
