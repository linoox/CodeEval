import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class Main {

    static boolean isHappy(int number) {
        int originalNumber = number;
        List<Integer> seenNumbers = new ArrayList<Integer>();
        int sum = 0;
        while (true) {
        
            while (number != 0) {
                
                int digit = number % 10;
                sum += digit * digit;
                number/=10;
            }
            
            if (sum == 1)
                return true;

            if(seenNumbers.contains(sum)) {
                return false;
            } else {
                seenNumbers.add(sum);
            }

            // if(sum == originalNumber) return false; <-- doesnt always come back to original number.
            number=sum;
            sum=0;
        }
    }



	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {

                    System.out.println(isHappy(Integer.parseInt(line)) ? 1:0);
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

