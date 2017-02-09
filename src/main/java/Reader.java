import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rickjackson on 2/9/17.
 */
public class Reader {
    private Main main;
    private BufferedReader br;
    public String file;
    
    public Reader() {
        this.main = new Main();
        openStream();
    }
    
    public void openStream() {
        try {
            this.file = main.readRawDataToString();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String nextCharacter(Integer current) {
        return this.file.substring(current, current + 1);
    }
    
    public String nextWord(Integer start, Integer end) {
        return this.file.substring(start, end);
    }
}
