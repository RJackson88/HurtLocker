/**
 * Created by rickjackson on 2/8/17.
 */
public class App {
    
    public static void main(String[] args) {
        Main main = new Main();
        Engine engine = new Engine();
        Reader reader = new Reader();
        Output out = new Output();
        
        try {
            engine.run(main.readRawDataToString());
            out.printToScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
