/**
 * Created by rickjackson on 2/8/17.
 */
public class App {
    
    public static void main(String[] args) {
        Main main = new Main();
        Output out = new Output();
        
        try {
            out.printToScreen(main.readRawDataToString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
