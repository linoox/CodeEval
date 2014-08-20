import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

    // can return -1 if no major element exists.
    // range of input is [0,100]
    // this version took 1600ms which is
    // pathetic.. rewrite

    // TODO: hashmap implementation.
    
    static int findMajorElement(String[] numbersAsString) {

        int major=-1;
        int count=0;

        int len=numbersAsString.length;
        int[] numbers = new int[len];
        for (int j=0;j<len;j++ ) {
            numbers[j]=Integer.parseInt(numbersAsString[j].trim());
        }

        Arrays.sort(numbers);

        for (int i=1;i<numbers.length ;i++) {
            if(numbers[i]==numbers[i-1]) {
                count++;
            } else {
                count=0;
            }

            if(count >= numbers.length/2) 
                return numbers[i];
            
        }
        

        return major;
    }

	public static void main (String[] args) {

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                
                if (line.length() > 0) {
                    String[] numbers = line.split(",");
                    int major = findMajorElement(numbers);

                    if(major == -1) {
                        System.out.println("None");
                    } else {
                        System.out.println(major);
                    }
                    
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

