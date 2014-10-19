import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    static String dataRecovery(String[] jumbledSentence, int[] hints) {

        // missing number by formula
        int sum=0;
        int hintsLength=hints.length;
        for (int i=0;i<hintsLength;i++ ) {
              sum+=hints[i];
        }

        int missingNumber = (hintsLength+1)*(hintsLength+2)/2 - sum;

        String[] orderedWords = new String[jumbledSentence.length];

        int i=0;
        for (i=0;i<jumbledSentence.length-1;i++) {
            orderedWords[hints[i]-1] = jumbledSentence[i];
        }

        orderedWords[missingNumber-1]=jumbledSentence[i];
        //System.out.println(Arrays.toString(orderedWords));

        String result="";
        for (int j=0;j<orderedWords.length;j++) {
            if(j>0)
                result+=" ";
            result+=orderedWords[j];
        }
       
        //System.out.println(result);
        return result;
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                String[] jumbledSentence = lineArray[0].split("\\s");
                String[] strHints = lineArray[1].split("\\s");
                int[] hints = new int[strHints.length];
                for (int i=0;i<strHints.length;i++ ) {
                    hints[i] = Integer.parseInt(strHints[i]);
                }

                if (lineArray.length > 0) {

                    String solvedSentence = dataRecovery(jumbledSentence,hints);
                    System.out.println(solvedSentence);
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

