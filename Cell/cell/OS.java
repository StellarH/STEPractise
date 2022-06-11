package cell;

public class OS {
    
    static short Border_X, Border_Y;
        
    static {

        String os = System.getProperty("os.name");

        if (os.substring(0,7).equals("Windows")) {
            Border_X = 6;
            Border_Y = 29;
        }else if (os.equals("Linux")) {
            Border_X = 0;
            Border_Y = 30;
        }

    }
}