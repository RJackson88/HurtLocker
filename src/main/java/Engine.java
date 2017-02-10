import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickjackson on 2/9/17.
 */
public class Engine {
    private ItemList itemList;
    private Regex regex;
    private Output output;
    private List<String> checks;
    private Integer check;
    private Integer previousCheck;
    
    public Engine() {
        this.itemList = new ItemList();
        this.regex = new Regex();
        this.checks = new ArrayList<String>();
        this.check = 1;
        this.previousCheck = 1;
    }
    
    public void constructChecks() {
        this.checks.add("Error");
        this.checks.add("Key");
        this.checks.add("KeyValueDelim");
        this.checks.add("Value");
        this.checks.add("KeyValuePairDelim");
        this.checks.add("End");
    }
    
    public void run(String input) {
        String file = input;
        Integer index = 0;
        String regex = "";
        String item = "";
        Double price = 0.00;
        String holder = "";
        
        while (this.check != 5) {
            file = file.substring(index);
            regex = this.regex.getKeyPattern("Name");
            
            // Check name key
            if (this.regex.isMatch(file, regex)) {
                index += "Name".length();
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index = this.regex.nextDeliminatorIndex(file);
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("KeyValueDelim");
            
            // Check key-value deliminator
            if (this.regex.isMatch(file, regex)) {
                index++;
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
//                index++;
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getValuePattern(
                    this.regex.getNextValue(file, index));
            
            // Check name value
            if (this.regex.isMatch(file, regex)) {
                item = this.regex.getNextValue(file, index);
                index += item.length();
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index = this.regex.nextDeliminatorIndex(file);
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("KeyValueDelim");
    
            // Check key-value deliminator
            if (this.regex.isMatch(file, regex)) {
                index++;
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index++;
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("Price");
            
            // Check price key
            if (this.regex.isMatch(file, regex)) {
                index += "Price".length();
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index = this.regex.nextDeliminatorIndex(file);
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("KeyValueDelim");
    
            // Check key-value deliminator
            if (this.regex.isMatch(file, regex)) {
                index++;
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
//                index++;
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getPricePattern();
    
            // Check price value
            if (this.regex.isMatch(file, regex) &&
                    !item.equals("Error")) {
                holder = file.substring(index, this.regex
                        .nextDeliminatorIndex(file));
                try {
                    price = Double.valueOf(holder);
                } catch (NumberFormatException nfe) {
                    price = -1.00;
                    this.itemList.incrementErrors();
                }
                index += Double.toString(price).length();
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index = this.regex.nextDeliminatorIndex(file);
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("KeyValueDelim");
            
            if ((!item.equals("")) && (price != -1.00)) {
                this.itemList.addPrice(item, price);
            }
    
            // Check key-value deliminator
            if (this.regex.isMatch(file, regex)) {
                index++;
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index++;
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("Type");
    
            // Check type key
            if (this.regex.isMatch(file, regex)) {
                index += "Type".length();
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index = this.regex.nextDeliminatorIndex(file);
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("KeyValueDelim");
    
            // Check key-value deliminator
            if (this.regex.isMatch(file, regex)) {
                index++;
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index++;
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getValuePattern(
                    this.regex.getNextValue(file, index));
    
            // Check food value
            if (this.regex.isMatch(file, regex)) {
                index += "Food".length();
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index = this.regex.nextDeliminatorIndex(file);
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("KeyValueDelim");
    
            // Check key-value deliminator
            if (this.regex.isMatch(file, regex)) {
                index++;
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index++;
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("Expiration");
    
            // Check expiration key
            if (this.regex.isMatch(file, regex)) {
                index += "Expiration".length();
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index = this.regex.nextDeliminatorIndex(file);
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("KeyValueDelim");
    
            // Check key-value deliminator
            if (this.regex.isMatch(file, regex)) {
                index++;
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index++;
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getValuePattern(
                    this.regex.getNextValue(file, index));
    
            // Check expiration value
            if (this.regex.isMatch(file, regex)) {
                index += this.regex.nextSeparatorIndex(file);
                file = file.substring(index);
                index = 0;
            } else {
                this.itemList.incrementErrors();
                index = this.regex.nextSeparatorIndex(file);
                file = file.substring(index);
                index = 0;
            }
            regex = this.regex.getKeyPattern("KeyValuePairDelim");
    
            // Check key-value pair separator
            if (this.regex.nextDeliminatorIndex(file) == -1) {
                this.check = 5;
            } else {
                index += 2;
                file = file.substring(index);
                index = 0;
                item = "";
                price = -1.00;
                this.check = 1;
            }
        }
        this.output = new Output(this.itemList.prices,
                this.itemList.frequencies, this.itemList.getErrorsSeen());
        output.printToScreen();
    }
    
    public void switchCheck() {
        switch (this.check) {
            case 1:
                this.previousCheck++;
                this.check++;
                break;
            case 2:
                this.previousCheck++;
                this.check++;
                break;
            case 3:
                this.previousCheck++;
                this.check++;
                break;
            case 4:
                this.previousCheck++;
                this.check = 1;
                break;
            case 5:
                this.check = 5;
                this.previousCheck = 5;
                break;
            default:
                if (this.previousCheck >= 3) {
                    this.check = 1;
                    this.previousCheck = 1;
                } else {
                    this.previousCheck++;
                    this.check++;
                }
                break;
        }
    }
}
