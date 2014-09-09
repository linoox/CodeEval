import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    /*
     * looks quite kludgy with all those casts.
     * another way to get fractional part would be %1
     * and get int part by subtracting fractional part.
     * - TODO.
     */
    static void sexagesimalAngles(String input) {

        double angle = Double.parseDouble(input);
        long intPart = (long) angle;
        double fractionPart = angle - intPart;
        
        long minutes = (long)(fractionPart*60);
        long seconds = (long) ((fractionPart*60)%1*60);

        System.out.printf("%d.%02d'%02d\"\n",intPart,minutes,seconds);

    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    sexagesimalAngles(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

