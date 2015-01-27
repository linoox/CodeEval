import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private final static String DELIMITERS="[\\s();,]";

    public static boolean isPointInCircle(double[] input) {

        double centreX=input[0];
        double centreY=input[1];
        double radius=input[2];
        double pointX=input[3];
        double pointY=input[4];

        // distanc between centre and point > radius = point lies outside.
        double actualRadius = Math.sqrt((pointX-centreX)*(pointX-centreX)+(pointY-centreY)*(pointY-centreY));

        if(actualRadius > radius) {
            return false;
        } else {
            return true;
        }

    }

	public static void main (String[] args) throws IOException{

        Scanner s = null;
        double[] input = new double[5];
        

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                int i=0;
                s = new Scanner(line);
                s.useDelimiter(DELIMITERS);
                                
                while (s.hasNext()) {
                    if(s.hasNextDouble()) {
                        input[i] = s.nextDouble();
                        i++;
                    } else {
                        s.next();    
                    }
                    
                }    
                System.out.println(isPointInCircle(input));

            } 
        }    finally {
            if (s != null) {
                s.close();
            }
        }

	}
}

