import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {


    // todo: not a good thing to have casts in program.
    // (int) distance
    static int calculateDistance(String input) {
        int numPoints=4;
        int[] points = new int[numPoints];
        String delims = "[\\(,\\)\\s]+";
        String[] strParts = input.split(delims);
        
        for (int i=1;i<=numPoints;i++) {
            points[i-1] = Integer.parseInt(input.split(delims)[i]);    
        }

        // System.out.println("points:"+Arrays.toString(points));
        
        double distance = Math.sqrt(
              Math.pow((points[0] - points[2]),2)  
            + Math.pow((points[1] - points[3]),2));

        return (int)distance;
        
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {

                    System.out.println(calculateDistance(line));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

