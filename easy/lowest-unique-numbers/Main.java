import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class Main {

    static int lowestUniqueNumber(String[] numbers) {

        int lowest=10; // given that max is 9.
        int winner=0;
        int position=0;
        int inputLength=numbers.length;

        Map<Integer, Integer> numCount = new LinkedHashMap<Integer, Integer>();
        for(int i=0; i<inputLength;i++) {
            int num = Integer.parseInt(numbers[i]);
            if(numCount.containsKey(num)) {
                int count = numCount.get(num);
                numCount.put(num, count+1);
            } else {
                numCount.put(num, 1);
            }
        }

        //System.out.println(numCount);

        for (int j=0;j<inputLength ; j++) {
            int curr = Integer.parseInt(numbers[j]);
            int count = numCount.get(curr);

            if (count == 1) {
                if(lowest > curr) {
                    lowest = curr;
                    winner = j+1; // adjusting for 1 based indexing.
                }
            }
        }

        return winner;
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {

                    System.out.println(lowestUniqueNumber(lineArray));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

