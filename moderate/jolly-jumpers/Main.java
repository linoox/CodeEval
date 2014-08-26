import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    final static int MAX_NUMBER = 3000;

    static String isJollyJumper(int[] numbers) {
        int len = numbers.length-1;
        boolean[] sequenceTracker = new boolean[MAX_NUMBER];
        Arrays.fill(sequenceTracker, Boolean.FALSE);

        for (int i=1; i<len; i++) {
            int diff = Math.abs(numbers[i]-numbers[i+1]);
            sequenceTracker[diff] = true;
        }

        int limit = Math.min(MAX_NUMBER, len);
        
        for (int j=1;j<limit;j++) {
            if (!sequenceTracker[j]) {
                return "Not jolly";
            } 
        }

        return "Jolly";
        
    }

    public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                int len = lineArray.length;
                int[] numbers = new int[len];
                if (len > 0) {

                    for (int i=0; i< len ;i++ ) {
                        numbers[i] =  Integer.parseInt(lineArray[i]);
                    }
                    
                        System.out.println(isJollyJumper(numbers));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}

