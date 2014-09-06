import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    static double calculateDistance(String input) {
        int i=0;
        int j=0;  
        double distance=0;
        int[] points = new int[4];
       
        String[] num = input.split("\\[(,)]");

        System.out.println("input:"+Arrays.toString(num));
        
        /*  
        System.out.println("arr:"+Arrays.toString(points)); 
        double distance = Math.sqrt(
              Math.pow((points[0] - points[2]),2)  
            + Math.pow((points[1] - points[3]),2));

        */
        return distance;
        
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

