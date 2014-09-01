import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {


    /*
     * Returns the nth-fibonnaci number.
     */
    static int fibonacci (int number, int[] fib) {
        

        if (number == 0) return 0;
        if (number == 1) return 1;

        if(fib[number] != 0) 
            return fib[number];

        int result = fibonacci(number-1, fib) + fibonacci(number-2, fib);
        fib[number]=result;

        return result;

    }

	public static void main (String[] args) {
        int[] fib = new int[50];
        Arrays.fill(fib,0);

        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {
                    
                    System.out.println(fibonacci(Integer.parseInt((lineArray[0])),fib));

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
	}
}

