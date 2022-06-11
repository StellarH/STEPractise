package cell2_2;

public class OS {
    
    static short Border_X, Border_Y;
        
    static {

        String os = System.getProperty("os.name");

        if (os.substring(0,7).equals("Windows")) {
            Border_X = 16;
            Border_Y = 39;
        }else if (os.equals("Linux")) {
            Border_X = 0;
            Border_Y = 30;
        }

    }
}