import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    //todo: partially correct

    static int guessTheNumber(String[] input) {
        final String YAY = "Yay!";
        final String UPPER = "Upper";
        final String LOWER = "Lower";

        int upperBound = Integer.parseInt(input[0]);
        int lowerBound = 0;
        String[] mastersAnswers = Arrays.copyOfRange(input,1,input.length);
        
        
        int predictedNumber=(lowerBound+upperBound)/2;

        for (int i=0;i<mastersAnswers.length;i++) {
            //System.out.println("PR:"+predictedNumber+" -> "+mastersAnswers[i]);
            //System.out.println("LB:"+lowerBound+" | UB:" + upperBound);
            
            if(mastersAnswers[i].equals(YAY)) {
                return predictedNumber;
            } else if (mastersAnswers[i].equals(LOWER)) {
                upperBound=predictedNumber-1;
                int sum=lowerBound+upperBound;
                if(sum%2==1) {
                    sum=sum+1;
                }
                predictedNumber=(sum)/2;
            } else { 
                lowerBound=predictedNumber+1;
                int sum=lowerBound+upperBound;
                if(sum%2==1) {
                    sum=sum+1;
                }
                predictedNumber=(sum)/2;
            }
            
        }


        return predictedNumber;
    }


	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    System.out.println(guessTheNumber(lineArray));
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

